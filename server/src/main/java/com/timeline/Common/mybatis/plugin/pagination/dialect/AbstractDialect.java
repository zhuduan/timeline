package com.timeline.Common.mybatis.plugin.pagination.dialect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.timeline.Common.mybatis.plugin.pagination.page.Page;

/**
 * @author wenlongchen
 * @since Nov 1, 2016
 */
public abstract class AbstractDialect {
  
  public static final String DIALECT="dialect";

  private static final Pattern FROM_PATTERN =
      Pattern.compile("from[\\s\\S]+", Pattern.CASE_INSENSITIVE);
  
  private static final String COUNT_STRING = "select count(*) ";
  
  private static final Pattern GROUP_BY =
      Pattern.compile("\\sgroup\\sby\\s[^)]+$", Pattern.CASE_INSENSITIVE);

  @SuppressWarnings("rawtypes")
  public abstract String getPageSql(String originalSql, Page page);

  public static String getCountSql(String originalSql) {
    final Matcher m = GROUP_BY.matcher(originalSql);
    if (m.find()) {
      return "select count(1) from (" + originalSql + ") page";
    }
    final Matcher matcher = FROM_PATTERN.matcher(originalSql);
    matcher.find();
    return COUNT_STRING + matcher.group();
  }
}

