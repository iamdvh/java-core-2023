package com.javacore.dao;

import java.util.List;

import com.javacore.dao.entity.CustomerEntity;
import com.javacore.input.CustomerSearchInput;

public interface CustomerDAO {
	public List<CustomerEntity> findAll();
	public void insert(CustomerEntity newCustomer);
}