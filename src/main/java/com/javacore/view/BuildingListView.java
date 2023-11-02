package com.javacore.view;

import com.javacore.controller.BuildingControler;
import com.javacore.dto.BuildingDTO;

public class BuildingListView {
	public static void main(String[] args) {
		Integer floorArea = null;
		String name = null;
		String street = null;
		String district = null;
		String ward = null;
		BuildingDTO buildingSearch = new BuildingDTO();
		buildingSearch.setName(name);
		buildingSearch.setStreet(street);
		buildingSearch.setDistrict(district);
		buildingSearch.setWard(ward);
		buildingSearch.setFloorArea(floorArea);
		BuildingControler buildingControler = new BuildingControler();
		BuildingDTO[] buildings = buildingControler.findBuilding(buildingSearch);
	}
}
