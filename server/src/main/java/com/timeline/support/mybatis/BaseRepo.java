package com.timeline.support.mybatis;

import org.springframework.util.CollectionUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public abstract class BaseRepo<T, PK> {

  protected abstract BaseMapper<T, PK> getBaseMapper();

  @SuppressWarnings("unchecked")
  protected Class<T> getEntityClazz() {
      Type genType = getClass().getGenericSuperclass();
      Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
      return (Class) params[0];
  }

  public int insert(T entity) {
    return getBaseMapper().insert(entity);
  }

  public int insertSelective(T entity) {
    return getBaseMapper().insertSelective(entity);
  }

  public int updateByPK(T entity) {
    return getBaseMapper().updateByPK(entity);
  }

  public int updateByPKSelective(T entity) {
    return getBaseMapper().updateByPKSelective(entity);
  }

  public int deleteByPK(PK pk) {
    return getBaseMapper().deleteByPK(pk, getEntityClazz());
  }

  public T selectByPK(PK pk) {
    return getBaseMapper().selectByPK(pk, getEntityClazz());
  }

  protected T selectOneByParam(Map<String, Object> param) {
    List<T> list = getBaseMapper().selectByParams(param, null, getEntityClazz());
    return CollectionUtils.isEmpty(list) ? null : list.get(0);
  }

  public List<T> selectAll() {
    return getBaseMapper().selectByParams(null, null, getEntityClazz());
  }

  public int selectCount(String whereSql) {
    return getBaseMapper().selectCountBySql(whereSql, getEntityClazz());
  }

  public int selectCount(Map<String, Object> param) {
    return getBaseMapper().selectCount(param, getEntityClazz());
  }

  public List<T> selectPage(PageRequest request) {
    request.setEntityClass(getEntityClazz());
    return getBaseMapper().selectPage(request);
  }
}
