package com.javacore.controller;

import java.util.List;
import java.util.Map;

import com.javacore.model.dto.BuildingDTO;
import com.javacore.model.input.AssignmentBuildingInput;
import com.javacore.model.output.BuildingOutput;
import com.javacore.service.BuildingService;
import com.javacore.service.imp.BuildingServiceImp;

public class BuildingController {
	private BuildingService buildingService = new BuildingServiceImp();
	public List<BuildingOutput> findBuilding(Map<String, Object> buildingSearchInput) {
	    List<BuildingOutput> results =	buildingService.findBuilding(buildingSearchInput);
		return results;
	}
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
	public void assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput) {
		buildingService.assignmentBuilding(assignmentBuildingInput);
	}
	public void assignmentBuildingEdit(AssignmentBuildingInput assignmentBuildingInput, Long[] newStaff) {
		buildingService.assignmentBuildingEdit(assignmentBuildingInput, newStaff);
	}
}
