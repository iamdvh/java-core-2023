package com.javacore.service.imp;

import java.util.ArrayList;
import java.util.List;

import com.javacore.converter.BuildingConverter;
import com.javacore.model.dto.BuildingDTO;
import com.javacore.model.input.BuildingSearchInput;
import com.javacore.model.output.BuildingOutput;
import com.javacore.repository.BuildingRepository;
import com.javacore.repository.entity.BuildingEntity;
import com.javacore.repository.impl.BuildingRepositoryImp;
import com.javacore.service.BuildingService;

public class BuildingServiceImp implements BuildingService{
	BuildingRepository buildingRepository = new BuildingRepositoryImp();
	BuildingConverter buildingConverter = new BuildingConverter();
	@Override
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingSearchInput) {
		// TODO Auto-generated method stub
		List<BuildingOutput> buildingOutputs = new ArrayList<>();
		List<BuildingEntity> buildingEntity =  buildingRepository.findBuilding(buildingSearchInput.getFloorArea(), buildingSearchInput.getName(), buildingSearchInput.getStreet(),
				buildingSearchInput.getDistrictId(), buildingSearchInput.getWard());
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
		return null;
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
}      
