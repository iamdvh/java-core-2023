package com.javacore.service;

import com.javacore.dto.BuildingDTO;
import com.javacore.service.emyeuanh.BuildingEmYeuAnh;

public interface BuildingService {
	public BuildingEmYeuAnh[] findBuilding(BuildingDTO buildingDTO);
}
