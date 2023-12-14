package com.javacore.view;

import java.util.List;
import java.util.Scanner;

import com.javacore.controller.BuildingController;
import com.javacore.input.BuildingSearchInput;
import com.javacore.output.BuildingOutput;

public class BuildingListView {
	public static void main(String[] args) {
		String name = null;
		Integer floorArea = null;
		String street = null;
		String district = null;
		String ward = null;
		BuildingSearchInput buildingSearch = new BuildingSearchInput();
		buildingSearch.setName(name);
		buildingSearch.setFloorArea(floorArea);
		;
		buildingSearch.setStreet(street);
		buildingSearch.setDistrict(district);
		buildingSearch.setWard(ward);
		BuildingController buildingController = new BuildingController();
		List<BuildingOutput> buildings = buildingController.findBuilding(buildingSearch);
		for (BuildingOutput item : buildings) {
			System.out.println("Name: " + item.getName());
			System.out.println("Address: " + item.getAddress());
			System.out.println("Type: " + item.getType());
			System.out.println("---------------------------------");
		}
	}
}
