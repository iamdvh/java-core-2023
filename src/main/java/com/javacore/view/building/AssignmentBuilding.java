package com.javacore.view.building;

import com.javacore.controller.BuildingController;
import com.javacore.model.input.AssignmentBuildingInput;

public class AssignmentBuilding {
	public static void main(String[] args) {
		Long buildingid = 4L;
		Long[] staff = {4L,2L};
		AssignmentBuildingInput assignmentBuildingInput = new AssignmentBuildingInput();
		assignmentBuildingInput.setBuildingId(buildingid);
		assignmentBuildingInput.setStaffId(staff);
		BuildingController buildingController = new BuildingController();
		buildingController.assignmentBuilding(assignmentBuildingInput);
	}
}
