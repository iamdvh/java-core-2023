package com.javacore.converter;

import com.javacore.model.dto.BuildingDTO;
import com.javacore.model.output.BuildingOutput;
import com.javacore.repository.entity.BuildingEntity;
import com.javacore.utils.BuildingTypeUtils;

public class BuildingConverter {
	public BuildingOutput convertBuildingEntityToBuildingOutput(BuildingEntity buildingEntity) {
		BuildingOutput buildingOutput = new BuildingOutput();
		buildingOutput.setName(buildingEntity.getName());
		buildingOutput.setFloorArea(buildingEntity.getFloorArea());
		buildingOutput.setAddress(buildingEntity.getStreet()+" - " + buildingEntity.getWard() + " - " + buildingEntity.getDistrictId());
//		buildingOutput.setType(BuildingTypeUtils.getName(buildingEntity.getType()));
		return buildingOutput;
	}
	public BuildingEntity convertBuildingDtoToBuildingEntity(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setId(buildingDTO.getId());
		buildingEntity.setFloorArea(buildingDTO.getFloorArea());
		buildingEntity.setName(buildingDTO.getName());
		buildingEntity.setStreet(buildingDTO.getStreet());
		buildingEntity.setWard(buildingDTO.getWard());
		buildingEntity.setDistrictId(buildingDTO.getDistrictId());
		buildingEntity.setRentPrice(buildingDTO.getRentPrice());
//		buildingEntity.setDistrict(buildingDTO.getDistrict());
		return buildingEntity;
	}
}
