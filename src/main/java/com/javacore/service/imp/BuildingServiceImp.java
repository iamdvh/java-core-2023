package com.javacore.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import com.javacore.controller.BuildingController;
import com.javacore.converter.BuildingConverter;
import com.javacore.dao.BuildingDAO;
import com.javacore.dao.entity.BuildingEntity;
import com.javacore.dao.imp.BuildingDAOImp;
import com.javacore.dto.BuildingDTO;
import com.javacore.input.BuildingSearchInput;
import com.javacore.output.BuildingOutput;
import com.javacore.service.BuildingService;
import com.javacore.utils.BuildingTypeUtils;
import com.mysql.cj.util.Util;

public class BuildingServiceImp implements BuildingService{
	BuildingDAO buildingDAO = new BuildingDAOImp();
	BuildingConverter buildingConverter = new BuildingConverter();
	@Override
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingSearchInput) {
		// TODO Auto-generated method stub
		List<BuildingOutput> buildingOutputs = new ArrayList<>();
		List<BuildingEntity> buildingEntity =  buildingDAO.findBuilding(buildingSearchInput.getFloorArea(), buildingSearchInput.getName(), buildingSearchInput.getStreet(),
				buildingSearchInput.getDistrict(), buildingSearchInput.getWard());
		for (BuildingEntity item : buildingEntity) {
			BuildingOutput buildingOutput = buildingConverter.convertBuildingEntityToBuildingOutput(item);
			buildingOutputs.add(buildingOutput);
		}
		return buildingOutputs;
	}
	@Override
	public void insert(BuildingDTO buildingDto) {
		if(buildingDto.getId() == null) {			
			BuildingEntity buildingEntity = buildingConverter.convertBuildingDtoToBuildingEntity(buildingDto);
				buildingDAO.insert(buildingEntity, buildingDto.getRentArea());
		}else {
			//update
		}
		
		
	}
}      
