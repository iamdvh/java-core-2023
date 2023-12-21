package com.javacore.repository;

import java.util.List;

import com.javacore.repository.entity.BuildingEntity;

public interface BuildingRepository extends JdbcRespository<BuildingEntity>{
	List<BuildingEntity> findBuilding(Integer floorArea, String name, String street, String district, String ward);
//	void insert(BuildingEntity buildingEntity, String rentArea);
}
