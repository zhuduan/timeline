package com.timeline.Common.mybatis.mapper;

import java.util.Collection;
import java.util.Map;

public interface SqlHandler {
  /**
   * <pre>
   * 处理基础类型，charsequence
   * </pre>
   * @param obj
   */
  void handlePremitive(Object obj);
  
  /**
   * <pre>
   * 处理复杂类型，包括map、符合object等
   * </pre>
   * @param obj
   */
  void handleComplex(Map<String,Object> obj);
  
  /**
   * <pre>
   * 处理集合 array类型
   * </pre>
   * @param collection
   */
  void handleCollection(Collection<Object> collection);
  
  
  /**
   * <pre>
   * 返回处理后的sql
   * </pre>
   * @return
   */
  String getSql();
}

