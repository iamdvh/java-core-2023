package com.javacore.view.building;

import java.util.List;

import com.javacore.controller.BuildingController;
import com.javacore.model.input.BuildingSearchInput;
import com.javacore.model.output.BuildingOutput;

public class FindBuildingView {
	public static void main(String[] args) {
		String name = null;
		Integer floorArea = null;
		String districtCode = null;
		String ward = null;
		String street = null;
		Integer numberOfBasement = null;
		String direction = null;
		String level = null;
		Integer rentAreaFrom = null;
		Integer rentAreaTo = null;
		Integer rentPriceFrom = null;
		Integer rentPriceTo = null;
		String managerName = null;
		String managerPhone = null;
		Long staff = 3l;
		String type = null;
		BuildingSearchInput buildingSearchInput = new BuildingSearchInput();
		buildingSearchInput.setName(name);
		buildingSearchInput.setFloorArea(floorArea);
		buildingSearchInput.setDistrictCode(districtCode);
		buildingSearchInput.setWard(ward);
		buildingSearchInput.setStreet(street);
		buildingSearchInput.setNumberOfBasement(numberOfBasement);
		buildingSearchInput.setDirection(direction);
		buildingSearchInput.setLevel(level);
		buildingSearchInput.setRentAreaFrom(rentAreaFrom);
		buildingSearchInput.setRentAreaTo(rentAreaTo);
		buildingSearchInput.setRentPriceFrom(rentPriceFrom);
		buildingSearchInput.setRentPriceTo(rentPriceTo);
		buildingSearchInput.setManagerName(managerName);
		buildingSearchInput.setManagerPhone(managerPhone);
		buildingSearchInput.setStaff(staff);
		buildingSearchInput.setType(type);
		BuildingController buildingController = new BuildingController();
		List<BuildingOutput> buildings = buildingController.findBuilding(buildingSearchInput);
		for (BuildingOutput building : buildings) {
			System.out.println("Name: " + building.getName());
			System.out.println("Address : " + building.getAddress());
			System.out.println("Manager name: " + building.getManagerName());
			System.out.println("Manager phone: "+building.getManagerPhone());
			System.out.println("Floor area  : " + building.getFloorArea());
			System.out.println("Rent area: " + building.getRenArea());
			System.out.println("Rent price : " + building.getRentPrice());
			System.out.println("Type: " + building.getType());
			System.out.println("---------------------------------");
		}
	}
}
