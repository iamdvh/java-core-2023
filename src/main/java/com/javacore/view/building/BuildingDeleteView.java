package com.javacore.view.building;

import com.javacore.controller.BuildingController;

public class BuildingDeleteView {
public static void main(String[] args) {
	Long id = (long) 8;
	BuildingController buildingController = new BuildingController();
	buildingController.delete(id);
}
}
