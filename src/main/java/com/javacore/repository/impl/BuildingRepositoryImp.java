package com.javacore.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javacore.constant.SystemConstant;
import com.javacore.repository.BuildingRepository;
import com.javacore.repository.entity.BuildingEntity;
import com.javacore.utils.ConnectionUtils;
import com.javacore.utils.StringUtils;

public class BuildingRepositoryImp extends SimpleRepository<BuildingEntity> implements BuildingRepository{

	@Override
	public List<BuildingEntity> findBuilding(Integer floorArea, String name, String street, String district, String ward) {		
		StringBuilder query = new StringBuilder("select * from buildings "+SystemConstant.ONE_EQUAL_ONE+"");
		// Condition
		if(!StringUtils.isNullOrEmpty(name)) {
			query.append(" and name like'%"+name+"%'");
		}
		if(floorArea != null) {
			query.append(" and floorArea like'%"+floorArea+"%'");
		}
		if(!StringUtils.isNullOrEmpty(street)) {
			query.append(" and street like'%"+street+"%'");
		}
		if(!StringUtils.isNullOrEmpty(district)) {
			query.append(" and district like'%"+district+"%'");
		}
		if(!StringUtils.isNullOrEmpty(ward)) {
			query.append(" and ward like'%"+ward+"%'");
		}
		return findByCondition(query.toString());
		}
}
