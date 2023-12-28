package com.javacore.service.imp;

import java.util.ArrayList;
import java.util.List;

import com.javacore.converter.BuildingConverter;
import com.javacore.model.dto.BuildingDTO;
import com.javacore.model.input.AssignmentBuildingInput;
import com.javacore.model.input.BuildingSearchInput;
import com.javacore.model.output.BuildingOutput;
import com.javacore.repository.AssignmentBuilding;
import com.javacore.repository.BuildingRepository;
import com.javacore.repository.DistrictRepository;
import com.javacore.repository.entity.AssignmentBuildingEntity;
import com.javacore.repository.entity.BuildingEntity;
import com.javacore.repository.entity.DistrictEntity;
import com.javacore.repository.impl.AssignmentBuildingImpl;
import com.javacore.repository.impl.BuildingRepositoryImp;
import com.javacore.repository.impl.DistrictRepositoryImpl;
import com.javacore.service.BuildingService;
import com.javacore.utils.StringUtils;

public class BuildingServiceImp implements BuildingService{
	DistrictRepository districtRepository = new DistrictRepositoryImpl();
	BuildingRepository buildingRepository = new BuildingRepositoryImp();
	BuildingConverter buildingConverter = new BuildingConverter();
	AssignmentBuilding assignmentBuilding = new AssignmentBuildingImpl();
	@Override
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingSearchInput) {
		List<BuildingOutput> buildingOutputs = new ArrayList<>();
		Long districtId = null;
		if(!StringUtils.isNullOrEmpty(buildingSearchInput.getDistrictCode())) {
			 List<DistrictEntity> district = districtRepository.findDistrict(null,buildingSearchInput.getDistrictCode());
			 for (DistrictEntity districtEntity : district) {
				 districtId = districtEntity.getId();
			}
			 if(districtId == null) {
				 districtId = -1L;
			 }
		}
		// type
		String types = null;
		if(!StringUtils.isNullOrEmpty(buildingSearchInput.getType())) {
			List<String> type = new ArrayList<String>();
			for (String item : buildingSearchInput.getType().split(",")) {
				type.add("'"+item+"'");
			}
			types = String.join(",", type);
		}
		List<BuildingEntity> buildingEntity =  buildingRepository.findBuilding(buildingSearchInput.getFloorArea(), buildingSearchInput.getName(), buildingSearchInput.getStreet(),
				districtId, buildingSearchInput.getWard(), 
				buildingSearchInput.getNumberOfBasement(), buildingSearchInput.getDirection(), buildingSearchInput.getLevel(),
				buildingSearchInput.getRentAreaFrom(), buildingSearchInput.getRentAreaTo(),
				buildingSearchInput.getRentPriceFrom(), buildingSearchInput.getRentPriceTo(), types, buildingSearchInput.getManagerName(),
				buildingSearchInput.getManagerPhone(), buildingSearchInput.getStaff());
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
		for (Long item : assignmentBuildingInput.getStaffId()) {
			AssignmentBuildingEntity assignmentBuildingEntity = buildingConverter.convertASMBEToABI(assignmentBuildingInput, item);
			assignmentBuilding.insert(assignmentBuildingEntity);
		}
	}
	@Override
	public void assignmentBuildingEdit(AssignmentBuildingInput assignmentBuildingInput, Long[] newStaffs) {
		boolean[] check = new boolean[newStaffs.length];
		int count=0;
		for (Long oldStaff : assignmentBuildingInput.getStaffId()) {
			AssignmentBuildingEntity assignmentBuildingEntity= buildingConverter.convertASMBEToABI(assignmentBuildingInput, oldStaff);
			List<AssignmentBuildingEntity> assignmentBuildingEntities = assignmentBuilding.findAssignmentBuilding(assignmentBuildingEntity.getBuildingId(), oldStaff);
			Long id = null;
			for (AssignmentBuildingEntity item : assignmentBuildingEntities) {
				id = item.getId();
			}
			for (Long newstaff : newStaffs) {
				if(check[count] == false) {					
					assignmentBuildingEntity.setId(id);
					assignmentBuildingEntity.setStaffId(newstaff);
					assignmentBuilding.update(assignmentBuildingEntity);
					check[count] = true;
					break;
				}
				count++;
			}
		}
	}
}      
