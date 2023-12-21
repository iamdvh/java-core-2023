package com.javacore.service;

import java.util.List;

import com.javacore.model.dto.BuildingDTO;
import com.javacore.model.input.BuildingSearchInput;
import com.javacore.model.output.BuildingOutput;

public interface BuildingService {
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingDTO);
	public List<BuildingOutput> findAll();
	public BuildingDTO findById(Long id);
	public void insert(BuildingDTO buildingDTO);
	public void delete(Long id);
}
