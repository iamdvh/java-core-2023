package com.javacore.dao;

public interface BasicRespository<T> {
	public void findAll();
	public void insert(T t);
}
