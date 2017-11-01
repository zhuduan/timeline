package com.timeline.Common.mybatis.plugin.pagination.dialect;

import com.timeline.Common.mybatis.plugin.pagination.page.Page;

/**
 * @author wenlongchen
 * @since Nov 4, 2016
 */
public class OracleDialect extends AbstractDialect {
  
  @SuppressWarnings("rawtypes")
  @Override
  public String getPageSql(String originalSql, Page page) {
    long offset = (page.getCurrentPage() - 1) * page.getPageSize();

    String sql = "SELECT * FROM ( SELECT ccpage1.*, ROWNUM ccpageRN FROM (" + originalSql
        + genenrateOrderBy(page) + ") ccpage1 WHERE ROWNUM <= " + (offset + page.getPageSize())
        + " ) WHERE ccpageRN > " + offset;

    return sql;
  }

  @SuppressWarnings("rawtypes")
  private String genenrateOrderBy(Page page) {
    if (page.getSort() != null) {
      return " order by " + page.getSort();
    }
    return "";
  }
}

