package com.javacore.controller;

import java.util.List;

import com.javacore.model.dto.BuildingDTO;
import com.javacore.model.input.BuildingSearchInput;
import com.javacore.model.output.BuildingOutput;
import com.javacore.service.BuildingService;
import com.javacore.service.imp.BuildingServiceImp;

public class BuildingController {
	private BuildingService buildingService = new BuildingServiceImp();
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingSearch) {
	    List<BuildingOutput> results =	buildingService.findBuilding(buildingSearch);
		return results;
	}
	public void save(BuildingDTO buildingDto) {
//		buildingService.insert(buildingDto);
	};
	public List<BuildingOutput> findAll(){
		return buildingService.findAll();
	}
	public BuildingDTO findById(Long id){
		return buildingService.findById(id);
	}
	public void insert(BuildingDTO buildingDTO){
		buildingService.insert(buildingDTO);
	}
	public void delete(Long id) {
		buildingService.delete(id);
	}
}
