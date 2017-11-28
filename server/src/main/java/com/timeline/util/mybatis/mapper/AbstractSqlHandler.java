package com.timeline.util.mybatis.mapper;

import com.timeline.util.mybatis.JsonUtil;
import com.timeline.util.mybatis.Util;
import org.apache.ibatis.jdbc.SQL;

import java.util.Collection;
import java.util.Map;

public abstract class AbstractSqlHandler implements SqlHandler {

	protected SQL sql;
	private Object params;

	public AbstractSqlHandler(SQL sql, Object params) {
		this.sql = sql;
		this.params = params;
	}

	@Override
	public void handleCollection(Collection<Object> collection) {
		throw new UnsupportedOperationException("不支持集合或数组类型！");
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getSql() {
		if (params != null) {
			if (Util.isPrimitive(params)) {
				handlePremitive(params);
			} else if (params instanceof Map) {
				handleComplex((Map<String, Object>) params);
			}  else if (params instanceof Collection) {
				handleCollection((Collection<Object>) params);
			} else {
				handleComplex((Map<String, Object>) JsonUtil.toMap(JsonUtil.toJsonString(params)));
			}
		}
		return sql.toString();
	}

}
