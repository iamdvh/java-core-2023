package com.javacore.controller;

import com.javacore.dto.BuildingDTO;
import com.javacore.service.BuildingService;
import com.javacore.service.imp.BuildingServiceImp;

public class BuildingControler {
	private BuildingService buildingService = new BuildingServiceImp();
	public BuildingDTO[] findBuilding(BuildingDTO buildingSearch) {
		buildingService.findBuilding(buildingSearch);
		return null;
	}
}
