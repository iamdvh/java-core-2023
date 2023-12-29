package com.javacore.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.javacore.converter.BuildingConverter;
import com.javacore.model.dto.BuildingDTO;
import com.javacore.model.input.AssignmentBuildingInput;
import com.javacore.model.output.BuildingOutput;
import com.javacore.repository.AssignmentBuilding;
import com.javacore.repository.BuildingRepository;
import com.javacore.repository.DistrictRepository;
import com.javacore.repository.entity.AssignmentBuildingEntity;
import com.javacore.repository.entity.BuildingEntity;
import com.javacore.repository.impl.AssignmentBuildingImpl;
import com.javacore.repository.impl.BuildingRepositoryImp;
import com.javacore.repository.impl.DistrictRepositoryImpl;
import com.javacore.service.BuildingService;

public class BuildingServiceImp implements BuildingService{
	DistrictRepository districtRepository = new DistrictRepositoryImpl();
	BuildingRepository buildingRepository = new BuildingRepositoryImp();
	BuildingConverter buildingConverter = new BuildingConverter();
	AssignmentBuilding assignmentBuilding = new AssignmentBuildingImpl();
	@Override
	public List<BuildingOutput> findBuilding(Map<String, Object> buildingSearchInput) {
		List<BuildingOutput> buildingOutputs = new ArrayList<>();
		// type
		List<String> types = new ArrayList<>();
		if(buildingSearchInput.get("type") != null) {
			for (String type : (String[])  buildingSearchInput.get("type")) {
				types.add("'"+type+"'");
			}
		}
		List<BuildingEntity> buildingEntity =  buildingRepository.findBuilding(buildingSearchInput, types);
		for (BuildingEntity item : buildingEntity) {

			BuildingOutput buildingOutput = buildingConverter.convertBuildingEntityToBuildingOutput(item);
			
			buildingOutputs.add(buildingOutput);
		}
		return buildingOutputs;
	}
	@Override
	public List<BuildingOutput> findAll() {
		List<BuildingEntity> buildingEntity = buildingRepository.findAll();
		List<BuildingOutput> results = new ArrayList<>();
		for(BuildingEntity item : buildingEntity) {
			BuildingOutput buildingOutput = buildingConverter.convertBuildingEntityToBuildingOutput(item);
			results.add(buildingOutput);
		}
		return results;
	}
	@Override
	public BuildingDTO findById(Long id) {
		BuildingEntity result = buildingRepository.findById(id);
		BuildingDTO building = new BuildingDTO();
		building.setName(result.getName());
		return building;
	}
	@Override
	public void insert(BuildingDTO buildingDTO) {
		if(buildingDTO.getId() == null) {
			BuildingEntity buildingEntity = buildingConverter.convertBuildingDtoToBuildingEntity(buildingDTO);
			buildingRepository.insert(buildingEntity);
		}else {
			BuildingEntity buildingEntity = buildingConverter.convertBuildingDtoToBuildingEntity(buildingDTO);
			buildingRepository.update(buildingEntity);
		}
		
	}
	@Override
	public void delete(Long id) {
		buildingRepository.delete(id);
	}
	@Override
	public void assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput) {
		if(assignmentBuildingInput.getStaffToDelete()!= null) {
			for (Long item : assignmentBuildingInput.getStaffToDelete()) {
				AssignmentBuildingEntity assignmentBuildingEntity = buildingConverter.convertASMBEToABI(assignmentBuildingInput, item);
				List<AssignmentBuildingEntity> assignmentBuildingEntities = assignmentBuilding.findAssignmentBuilding(assignmentBuildingEntity.getBuildingId(), item);
				for (AssignmentBuildingEntity itemDelete : assignmentBuildingEntities) {
					assignmentBuilding.delete(itemDelete.getId());
				}
			}
		}
		for (Long item : assignmentBuildingInput.getStaffToAdd()) {
			AssignmentBuildingEntity assignmentBuildingEntity = buildingConverter.convertASMBEToABI(assignmentBuildingInput, item);
			assignmentBuilding.insert(assignmentBuildingEntity);
		}
	}
}      
