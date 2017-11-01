package com.timeline.Common.mybatis.plugin.slowlog;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;


@Intercepts({
    @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
    @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
@Slf4j
public class SqlTraceInterceptor implements Interceptor {
  private static final long SLOW_SQL_TIME_LENGTH = 1000;

  public Object intercept(Invocation invocation) throws Throwable {
    Object[] args = invocation.getArgs();
    MappedStatement mappedStatement = (MappedStatement) args[0];
    Object parameter = null;
    if (args.length > 1) {
      parameter = args[1];
    }

    String sqlId = mappedStatement.getId();
    BoundSql boundSql = mappedStatement.getBoundSql(parameter);
    Configuration configuration = mappedStatement.getConfiguration();

    Object returnValue = null;
    boolean exceptionOccurred = false;
    final long start = System.currentTimeMillis();
    try {
      returnValue = invocation.proceed();
    } catch (Exception e) {
      exceptionOccurred = true;
      log.error("execute error!", e);
    } finally {
      final long end = System.currentTimeMillis();
      final long elapsedTime = end - start;
      if (elapsedTime > SLOW_SQL_TIME_LENGTH || exceptionOccurred) {
        log.warn(getSql(configuration, boundSql, sqlId, elapsedTime));
      }
    }

    return returnValue;
  }

  private static String getSql(Configuration configuration, BoundSql boundSql, String sqlId, long time) {
    String sql = showSql(configuration, boundSql);
    StringBuilder str = new StringBuilder(100);
    str.append(sqlId);
    str.append(":");
    str.append(sql);
    str.append(":");
    str.append(time);
    str.append("ms");
    return str.toString();
  }

  private static String showSql(Configuration configuration, BoundSql boundSql) {
    final Object parameterObject = boundSql.getParameterObject();
    final List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
    String sql = boundSql.getSql().replaceAll("[\\s]+", " ");
    if (parameterMappings.size() > 0 && parameterObject != null) {
      TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
      if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
        sql = sql.replaceFirst("\\?", getParameterValue(parameterObject));
      } else {
        MetaObject metaObject = configuration.newMetaObject(parameterObject);
        for (ParameterMapping parameterMapping : parameterMappings) {
          String propertyName = parameterMapping.getProperty();
          if (metaObject.hasGetter(propertyName)) {
            Object obj = metaObject.getValue(propertyName);
            sql = sql.replaceFirst("\\?", getParameterValue(obj));
          } else if (boundSql.hasAdditionalParameter(propertyName)) {
            Object obj = boundSql.getAdditionalParameter(propertyName);
            sql = sql.replaceFirst("\\?", getParameterValue(obj));
          }
        }
      }
    }

    return sql;
  }

  private static String getParameterValue(Object object) {
    String value;
    if (object instanceof String) {
      value = "'" + object.toString() + "'";
    } else if (object instanceof Date) {
      DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
      value = "'" + formatter.format(object) + "'";
    } else {
      if (object != null) {
        value = object.toString();
      } else {
        value = "";
      }
    }

    return value;
  }

  @Override
  public Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  @Override
  public void setProperties(Properties properties) {
    //empty
  }
}
