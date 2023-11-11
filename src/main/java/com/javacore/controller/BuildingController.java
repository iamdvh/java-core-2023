package com.javacore.controller;

import java.util.List;

import com.javacore.input.BuildingSearchInput;
import com.javacore.output.BuildingOutput;
import com.javacore.service.BuildingService;
import com.javacore.service.imp.BuildingServiceImp;

public class BuildingController {
	private BuildingService buildingService = new BuildingServiceImp();
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingSearch) {
	    List<BuildingOutput> results =	buildingService.findBuilding(buildingSearch);
		return results;
	}
}
