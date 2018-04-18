package com.timeline.support.mybatis;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.stream.Collectors;

public class BaseProvider<T, PK> {

  public String insert(final T entity) {
    return PoMapperTool.getEntityPortray(entity.getClass()).getInsertSql();
  }

  public String insertSelective(final T entity) {
    EntityPortray portray = PoMapperTool.getEntityPortray(entity.getClass());

    SQL sql = new SQL().INSERT_INTO(portray.getTableName());
    portray.getColumns().stream().filter(column -> !column.isNull(entity))
        .forEach(column -> sql.VALUES(column.getColumnName(), column.getDefineStr()));
    return sql.toString();
  }


  public String updateByPK(T entity) {
    return PoMapperTool.getEntityPortray(entity.getClass()).getUpdateSql();
  }

  public String updateByPKSelective(T entity) {
    EntityPortray portray = PoMapperTool.getEntityPortray(entity.getClass());
    SQL sql = new SQL().UPDATE(portray.getTableName());
    portray.getColumns().stream().filter(column -> !column.isNull(entity))
        .forEach(column -> sql.SET(column.getSettingStr()));
    return sql.WHERE(portray.getPkConditionSql()).toString();
  }

  public String deleteByPK(@Param("pk") PK pk, Class<T> clazz) {
    EntityPortray portray = PoMapperTool.getEntityPortray(clazz);
    return new SQL()
        .DELETE_FROM(portray.getTableName())
        .WHERE(portray.getPkConditionWithParamSql())
        .toString();
  }

  public String selectByPK(@Param("pk") PK pk, Class<T> clazz) {
    EntityPortray portray = PoMapperTool.getEntityPortray(clazz);
    return new SQL()
        .SELECT(portray.getSelectResultSql())
        .FROM(portray.getTableName())
        .WHERE(portray.getPkConditionWithParamSql())
        .toString();
  }

  public String selectByParams(@Param("param") Map<String, Object> param, Map<String, Boolean> orderBy, Class<T> clazz) {
    EntityPortray portray = PoMapperTool.getEntityPortray(clazz);
    SQL sql = new SQL().SELECT(portray.getSelectResultSql())
                       .FROM(portray.getTableName());

    String str;
    if ((str = getWhereConditions(param, "param")) != null) {
      sql.WHERE(str);
    }
    if ((str = getOrderBys(orderBy)) != null) {
      sql.ORDER_BY(str);
    }
    return sql.toString();
  }

  public String selectCountBySql(String whereSql, Class<T> clazz) {
    EntityPortray portray = PoMapperTool.getEntityPortray(clazz);
    SQL sql = new SQL().SELECT("COUNT(1)")
                       .FROM(portray.getTableName());
    if (StringUtils.isNotEmpty(whereSql)) {
      sql.WHERE(whereSql);
    }
    return sql.toString();
  }

  public String selectCount(@Param("param") Map<String, Object> param, Class<T> clazz) {
    return this.selectCountBySql(getWhereConditions(param, "param"), clazz);
  }

  public String selectPage(@Param("request") PageRequest request) {
    EntityPortray portray = PoMapperTool.getEntityPortray(request.getEntityClass());

    StringBuilder builder = new StringBuilder()
        .append("SELECT ").append(portray.getSelectResultSql())
        .append(" FROM ").append(portray.getTableName());
    String str;
    if (StringUtils.isNotEmpty(request.getWhereSql())) {
      builder.append(" WHERE ").append(request.getWhereSql());
    } else if ((str = getWhereConditions(request.getParam(), "request.param")) != null) {
      builder.append(" WHERE ").append(str);
    }
    if ((str = getOrderBys(request.getOrderBy())) != null) {
      builder.append(" ORDER BY ").append(str);
    }
    return builder
        .append(" LIMIT ").append(request.getOffset()).append(",").append(request.getPageSize())
        .toString();
  }


  private String getWhereConditions(Map<String, Object> param, String path) {
    if (CollectionUtils.isEmpty(param)) {
      return null;
    }
    return param.keySet().stream().map(key ->
        String.format("%s = #{%s.%s}", key, path, key))
        .collect(Collectors.joining(" AND "));
  }
  private String getOrderBys(Map<String, Boolean> orderBy) {
    if (CollectionUtils.isEmpty(orderBy)) {
      return null;
    }
    return orderBy.entrySet().stream().map(entry -> String.format(" %s %s ", entry.getKey(), entry.getValue() ? "ASC" : "DESC"))
        .collect(Collectors.joining(", "));
  }

}
