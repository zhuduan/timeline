package com.timeline.support.mybatis;

import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by zmd on 2017/8/25.
 */
public abstract class PoMapperTool {

  private static Map<Class<?>, EntityPortray> entityMap = Maps.newConcurrentMap();

  public static final int MAX_BATCH_OPERATE_AMOUNT = 500;

  public static EntityPortray getEntityPortray(final Class<?> entity) {
    return entityMap.computeIfAbsent(entity, EntityPortray::new);
  }

  /**驼峰转下划线.*/
  public static String camelToUnderline(String camel) {
    if (null == camel || camel.isEmpty()) {
      return camel;
    }
    StringBuilder sb = new StringBuilder();
    sb.append(Character.toLowerCase(camel.charAt(0)));
    for (char c : camel.substring(1).toCharArray()) {
      if (Character.isUpperCase(c)) {
        sb.append("_").append(Character.toLowerCase(c));
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  public static <T> void handleOpInBatches(List<T> list, Consumer<List<T>> action) {
    if (null == list || list.isEmpty()) {
      return;
    }
    int size = list.size();
    int from = 0;
    while (from < size) {
      int to = Math.min(from + MAX_BATCH_OPERATE_AMOUNT, size);
      action.accept(list.subList(from, to));
      from = to;
    }

  }

}
