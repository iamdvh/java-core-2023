package com.javacore.service;

import java.util.List;

import com.javacore.dto.BuildingDTO;
import com.javacore.input.BuildingSearchInput;
import com.javacore.output.BuildingOutput;

public interface BuildingService {
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingDTO);
	public void insert(BuildingDTO buildingDto);
}
