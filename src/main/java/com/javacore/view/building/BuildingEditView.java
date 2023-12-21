package com.javacore.view.building;

import com.javacore.controller.BuildingController;
import com.javacore.model.dto.BuildingDTO;

public class BuildingEditView {
	public static void main(String[] args) {
		Long id = (long) 8;
		String name = "Building 14";
		Integer floorArea = 29;
		String street = null;
		String ward = null;
		Long districtId = (long) 1;
		Integer rentPrice = 500;
		BuildingDTO buildingDTO = new BuildingDTO();
		buildingDTO.setId(id);
		buildingDTO.setName(name);
		buildingDTO.setFloorArea(floorArea);
		buildingDTO.setRentPrice(rentPrice);
		buildingDTO.setDistrictId(districtId);
		BuildingController buildingController = new BuildingController();
		buildingController.insert(buildingDTO);
	}
}
