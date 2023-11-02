package com.javacore.service.imp;

import com.javacore.dao.BuildingDAO;
import com.javacore.dao.imp.BuildingDAOImp;
import com.javacore.dto.BuildingDTO;
import com.javacore.service.BuildingService;
import com.javacore.service.emyeuanh.BuildingEmYeuAnh;

public class BuildingServiceImp implements BuildingService{
	BuildingDAO buildingDAO = new BuildingDAOImp();
	@Override
	public BuildingEmYeuAnh[] findBuilding(BuildingDTO buildingDTO) {
		// TODO Auto-generated method stub
		buildingDAO.findBuilding(buildingDTO.getFloorArea(), buildingDTO.getName(), buildingDTO.getStreet(),
				buildingDTO.getDistrict(), buildingDTO.getWard());
		return null;
	}

}
