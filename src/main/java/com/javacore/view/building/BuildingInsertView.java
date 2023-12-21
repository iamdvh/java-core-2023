package com.javacore.view.building;

import com.javacore.controller.BuildingController;
import com.javacore.model.dto.BuildingDTO;

public class BuildingInsertView {
	public static void main(String[] args) {
		String name = "Building 13";
		Integer floorArea = 19;
		String street = null;
		String ward = null;
		Long districtId =(long) 1;
		Integer rentPrice =100;
		BuildingDTO buildingDTO = new BuildingDTO();
		buildingDTO.setName(name);
		buildingDTO.setFloorArea(floorArea);
		buildingDTO.setRentPrice(rentPrice);
		buildingDTO.setDistrictId(districtId);
		BuildingController buildingController = new BuildingController();
		buildingController.insert(buildingDTO);
	}
}
