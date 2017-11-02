package com.timeline.util.mybatis.mapper;

public interface Mapper <K, V>{

	K selectByID(V v);
	
	int updateByID(K k);
}
