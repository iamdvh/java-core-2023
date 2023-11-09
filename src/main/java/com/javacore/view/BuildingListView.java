package com.javacore.view;

import java.util.List;

import com.javacore.controller.BuildingControler;
import com.javacore.input.BuildingSearchInput;
import com.javacore.output.BuildingOutput;

public class BuildingListView {
	public static void main(String[] args) {
		Integer floorArea = null;
		String name = null;
		String street = null;
		String district = null;
		String ward = "Quận số 1";
		BuildingSearchInput buildingSearch = new BuildingSearchInput();
		buildingSearch.setName(name);
		buildingSearch.setStreet(street);
		buildingSearch.setDistrict(district);
		buildingSearch.setWard(ward);
		buildingSearch.setFloorArea(floorArea);
		BuildingControler buildingControler = new BuildingControler();
		List<BuildingOutput> buildings = buildingControler.findBuilding(buildingSearch);
		for (BuildingOutput buildingOutput : buildings) {
			System.out.println("Name: " + buildingOutput.getName());
			System.out.println("FloorArea: " + buildingOutput.getFloorArea());
			System.out.println("Address: " + buildingOutput.getAddress());
			System.out.println("-----------------------------------------------");
		}
	}
}
