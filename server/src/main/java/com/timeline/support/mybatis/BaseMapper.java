package com.timeline.support.mybatis;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;
import java.util.Map;


public interface BaseMapper<T, PK> {

  @InsertProvider(type = BaseProvider.class, method = "insert")
  int insert(T entity);

  @InsertProvider(type = BaseProvider.class, method = "insertSelective")
  int insertSelective(T entity);

  @UpdateProvider(type = BaseProvider.class, method = "updateByPK")
  @Options
  int updateByPK(T entity);

  @UpdateProvider(type = BaseProvider.class, method = "updateByPKSelective")
  @Options
  int updateByPKSelective(T entity);

  @DeleteProvider(type = BaseProvider.class, method = "deleteByPK")
  @Options
  int deleteByPK(@Param("pk") PK pk, Class<T> clazz);

  @SelectProvider(type = BaseProvider.class, method = "selectByPK")
  @Options
  T selectByPK(@Param("pk") PK pk, Class<T> clazz);

  /**
   * param: key,value column_name, value
   * orderBy: key,value column_name, isAsc
   */
  @SelectProvider(type = BaseProvider.class, method = "selectByParams")
  @Options
  List<T> selectByParams(@Param("param") Map<String, Object> param, Map<String, Boolean> orderBy, Class<T> clazz);

  @SelectProvider(type = BaseProvider.class, method = "selectCountBySql") Integer selectCountBySql(String whereSql,
      Class<T> clazz);

  @SelectProvider(type = BaseProvider.class, method = "selectCountBySql") Integer selectCount(
      @Param("param") Map<String, Object> param, Class<T> clazz);

  @SelectProvider(type = BaseProvider.class, method = "selectPage") List<T> selectPage(
      @Param("request") PageRequest request);
}
