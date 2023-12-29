package com.javacore.view.building;

import com.javacore.controller.BuildingController;
import com.javacore.model.input.AssignmentBuildingInput;

public class AssignmentBuilding {
	public static void main(String[] args) {
		Long buildingid = 4l;
		Long[] staffToAdd = {4l};
		Long[] staffToDelete = {3l, 2l};
		AssignmentBuildingInput assignmentBuildingInput = new AssignmentBuildingInput();
		assignmentBuildingInput.setBuildingId(buildingid);
		assignmentBuildingInput.setStaffToAdd(staffToAdd);
		assignmentBuildingInput.setStaffToDelete(staffToDelete);
		BuildingController buildingController = new BuildingController();
		buildingController.assignmentBuilding(assignmentBuildingInput);
	}
}
