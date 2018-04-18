package com.timeline.support.mybatis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zmd on 2017/8/25.
 */
public class PageRequest {

  // current starts with 0.
  private int current;
  private int pageSize;
  /**
   * 查询条件设置优先whereSql， 没有则根据 param 组合。
   * whereSql: "xx is null or xx like '%'"
   * param: column_name: value
   * orderBy: column_name, isAsc
   */
  private String whereSql;
  private Map<String, Object> param;
  private Map<String, Boolean> orderBy = new HashMap<>();

  private Class<?> entityClass;

  public int getOffset() {
    if (current > 0) {
      return pageSize * current;
    }
    return 0;
  }

  public void addOrderBy(String column, boolean asc) {
    orderBy.put(column, asc);
  }

  public int getCurrent() {
    return current;
  }

  public void setCurrent(final int current) {
    this.current = current;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(final int pageSize) {
    this.pageSize = pageSize;
  }

  public String getWhereSql() {
    return whereSql;
  }

  public void setWhereSql(final String whereSql) {
    this.whereSql = whereSql;
  }

  public Map<String, Object> getParam() {
    return param;
  }

  public void setParam(final Map<String, Object> param) {
    this.param = param;
  }

  public Map<String, Boolean> getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(final Map<String, Boolean> orderBy) {
    this.orderBy = orderBy;
  }

  public Class<?> getEntityClass() {
    return entityClass;
  }

  public void setEntityClass(final Class<?> entityClass) {
    this.entityClass = entityClass;
  }
}
