package com.javacore.repository;

import java.util.List;
import java.util.Map;

import com.javacore.repository.entity.BuildingEntity;

public interface BuildingRepository extends JdbcRespository<BuildingEntity>{
//	List<BuildingEntity> findBuilding(Integer floorArea, String name, String street, String districtCode, String ward, 
//			Integer numberOfBasement, String direction, String level,
//			Integer rentAreaFrom, Integer rentAreaTo,Integer rentPriceFrom, Integer rentPriceTo,String type, 
//			String managerName, String managerPhone, Long staff);
	List<BuildingEntity> findBuilding(Map<String, Object> buildingSearchInput);
}
