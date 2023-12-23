package com.javacore.view.building;

import java.util.List;

import com.javacore.controller.BuildingController;
import com.javacore.model.input.BuildingSearchInput;
import com.javacore.model.output.BuildingOutput;

public class FindBuildingView {
	public static void main(String[] args) {
		String name = null;
		Integer floorArea = null;
		String street = null;
		String ward = null;
		Long districtId =1L;
		Integer rentPrice = null;
		BuildingSearchInput buildingInput = new BuildingSearchInput();
		buildingInput.setName(name);
		buildingInput.setFloorArea(floorArea);
		buildingInput.setRentPrice(rentPrice);
		buildingInput.setStreet(street);
		buildingInput.setWard(ward);
		buildingInput.setDistrictId(districtId);
		BuildingController buildingController = new BuildingController();
		List<BuildingOutput> buildings =  buildingController.findBuilding(buildingInput);
		for (BuildingOutput item : buildings) {
		      System.out.println("Name: " + item.getName());
		      System.out.println("Address: " + item.getAddress());
		      System.out.println("---------------------------------");
		    }
	}
}
