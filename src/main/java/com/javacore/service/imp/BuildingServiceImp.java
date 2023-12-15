package com.javacore.service.imp;

import java.util.ArrayList;
import java.util.List;

import com.javacore.dao.BuildingDAO;
import com.javacore.dao.entity.BuildingEntity;
import com.javacore.dao.imp.BuildingDAOImp;
import com.javacore.input.BuildingSearchInput;
import com.javacore.output.BuildingOutput;
import com.javacore.service.BuildingService;
import com.javacore.utils.BuildingTypeUtils;

public class BuildingServiceImp implements BuildingService{
	BuildingDAO buildingDAO = new BuildingDAOImp();
	@Override
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingSearchInput) {
		// TODO Auto-generated method stub
		List<BuildingOutput> buildingOutputs = new ArrayList<>();
		List<BuildingEntity> buildingAnhYeuEm =  buildingDAO.findBuilding(buildingSearchInput.getFloorArea(), buildingSearchInput.getName(), buildingSearchInput.getStreet(),
				buildingSearchInput.getDistrict(), buildingSearchInput.getWard());
		for (BuildingEntity item : buildingAnhYeuEm) {
			BuildingOutput buildingOutput = new BuildingOutput();
			buildingOutput.setName(item.getName());
			buildingOutput.setFloorArea(item.getFloorArea());
			buildingOutput.setAddress(item.getStreet()+" - " + item.getWard()+" - " + item.getDistrict());
			buildingOutput.setType(BuildingTypeUtils.getType(item.getType()));
			buildingOutputs.add(buildingOutput);
		}
		return buildingOutputs;
	}
}
