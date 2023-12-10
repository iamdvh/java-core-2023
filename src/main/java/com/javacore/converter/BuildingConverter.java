package com.javacore.converter;

import com.javacore.dao.entity.BuildingEntity;
import com.javacore.dto.BuildingDTO;
import com.javacore.output.BuildingOutput;
import com.javacore.utils.BuildingTypeUtils;

public class BuildingConverter {
	public BuildingOutput convertBuildingEntityToBuildingOutput(BuildingEntity buildingEntity) {
		BuildingOutput buildingOutput = new BuildingOutput();
		buildingOutput.setName(buildingEntity.getName());
		buildingOutput.setFloorArea(buildingEntity.getFloorArea());
		buildingOutput.setAddress(buildingEntity.getStreet()+" - " + buildingEntity.getDistrict()+" - " + buildingEntity.getWard());
		buildingOutput.setType(BuildingTypeUtils.getName(buildingEntity.getType()));
		return buildingOutput;
	}
	public BuildingEntity convertBuildingDtoToBuildingEntity(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setFloorArea(buildingDTO.getFloorArea());
		buildingEntity.setName(buildingDTO.getName());
		buildingEntity.setStreet(buildingDTO.getStreet());
		buildingEntity.setWard(buildingDTO.getWard());
		buildingEntity.setDistrict(buildingDTO.getDistrict());
		return buildingEntity;
	}
}
