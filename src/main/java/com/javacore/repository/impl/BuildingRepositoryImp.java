package com.javacore.repository.impl;

import java.util.List;

import com.javacore.constant.SystemConstant;
import com.javacore.repository.BuildingRepository;
import com.javacore.repository.entity.BuildingEntity;
import com.javacore.utils.StringUtils;

public class BuildingRepositoryImp extends SimpleRepository<BuildingEntity> implements BuildingRepository{

	@Override
	public List<BuildingEntity> findBuilding(Integer floorArea, String name, String street, Long districtid, String ward) {		
		StringBuilder query = new StringBuilder("select * from building "+SystemConstant.ONE_EQUAL_ONE+"");
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
		if(districtid!= null) {
			query.append(" and districtid like'%"+districtid+"%'");
		}
		if(!StringUtils.isNullOrEmpty(ward)) {
			query.append(" and ward like'%"+ward+"%'");
		}
		return findByCondition(query.toString());
		}

}
