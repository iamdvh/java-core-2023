package com.javacore.dao;

import com.javacore.dao.anhyeuem.BuildingAnhyeuEm;

public interface BuildingDAO {
	BuildingAnhyeuEm[] findBuilding(Integer floorArea, String name, String street, String district, String ward);
}
