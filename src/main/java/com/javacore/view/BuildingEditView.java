package com.javacore.view;

import com.javacore.controller.BuildingController;
import com.javacore.dto.BuildingDTO;

public class BuildingEditView {
	public static void main(String[] args) {
				String name = "Building 8";
				Integer floorArea = 21;
				String street = null;
				String ward = null;
				String district = null;
				String rentArea = "21,22,900,100";
				BuildingDTO buildingDto = new BuildingDTO();
				buildingDto.setName(name);
				buildingDto.setFloorArea(floorArea);
				buildingDto.setStreet(street);
				buildingDto.setDistrict(district);
				buildingDto.setWard(ward);
				buildingDto.setRentArea(rentArea);
				BuildingController buildingController = new BuildingController();
				buildingController.save(buildingDto);
	}
}
