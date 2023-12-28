package com.javacore.view.building;

import com.javacore.controller.BuildingController;
import com.javacore.model.input.AssignmentBuildingInput;

public class AssignmentBuildingEdit {
	public static void main(String[] args) {
		Long buildingid = 4L;
		Long[] oldStaff = {3l, 2l};
		Long[] newStaff = {4L, 3L};
		AssignmentBuildingInput assignmentBuildingInput = new AssignmentBuildingInput();
		assignmentBuildingInput.setBuildingId(buildingid);
		assignmentBuildingInput.setStaffId(oldStaff);
		BuildingController buildingController = new BuildingController();
		buildingController.assignmentBuildingEdit(assignmentBuildingInput, newStaff);
	}
}
