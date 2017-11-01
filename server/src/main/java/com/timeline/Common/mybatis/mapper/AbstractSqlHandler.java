package com.timeline.Common.mybatis.mapper;

import java.util.Collection;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.timeline.Common.mybatis.JsonUtil;
import com.timeline.Common.mybatis.Util;
import com.timeline.Common.mybatis.plugin.pagination.page.Page;

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

	@Override
	public void handlePage(@SuppressWarnings("rawtypes") Page page) {
		throw new UnsupportedOperationException("不支持集合或数组类型！");
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public String getSql() {
		if (params != null) {
			if (Util.isPrimitive(params)) {
				handlePremitive(params);
			} else if (params instanceof Map) {
				handleComplex((Map<String, Object>) params);
			} else if (params instanceof Page) {
				handlePage((Page) params);
			} else if (params instanceof Collection) {
				handleCollection((Collection<Object>) params);
			} else {
				handleComplex((Map<String, Object>) JsonUtil
						.toMap(JsonUtil.toJsonString(params)));
			}
		}
		return sql.toString();
	}

}
