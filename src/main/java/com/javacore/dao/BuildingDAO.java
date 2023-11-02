package com.javacore.dao;

import java.util.List;

import com.javacore.dao.anhyeuem.BuildingAnhyeuEm;

public interface BuildingDAO {
	List<BuildingAnhyeuEm> findBuilding(Integer floorArea, String name, String street, String district, String ward);
}
