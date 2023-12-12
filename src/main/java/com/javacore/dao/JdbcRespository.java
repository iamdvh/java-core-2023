package com.javacore.dao;

import java.util.List;

public interface JdbcRespository<T> {
	public List<T> findAll();
	public void insert(T t);
}
