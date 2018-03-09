package com.petgoes.mapper;

import java.util.List;

import com.petgoes.param.PageInfo;

public interface BasicMapper {
	
	<T> List<T> query(T param);
	<T> List<T> queryListByPage(T param,PageInfo page);
	<T> int insert(T param);
	<T> int delete(int id);
	<T> int update(T param);
	<T> T findById(int id);
}
