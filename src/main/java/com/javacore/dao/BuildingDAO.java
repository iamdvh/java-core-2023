package com.javacore.dao;

import java.util.List;

import com.javacore.dao.entity.BuildingEntity;

public interface BuildingDAO extends BasicRespository<BuildingEntity>{
	List<BuildingEntity> findBuilding(Integer floorArea, String name, String street, String district, String ward);

//	void insert(BuildingEntity buildingEntity, String rentArea);
}
