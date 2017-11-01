package com.timeline.Common.mybatis.plugin.pagination;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @author wenlongchen
 * @since Nov 1, 2016
 */
public class ExtSqlSource implements SqlSource {
  BoundSql boundSql;

  protected ExtSqlSource(BoundSql boundSql) {
    this.boundSql = boundSql;
  }

  @Override
  public BoundSql getBoundSql(Object parameterObject) {
    return boundSql;
  }

}

