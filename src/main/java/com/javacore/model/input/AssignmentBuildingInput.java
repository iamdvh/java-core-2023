package com.javacore.model.input;

public class AssignmentBuildingInput {
	private Long buildingId;
	private Long[] staffToAdd;
	private Long[] staffToDelete;
	public Long getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
	public Long[] getStaffToAdd() {
		return staffToAdd;
	}
	public void setStaffToAdd(Long[] staffToAdd) {
		this.staffToAdd = staffToAdd;
	}
	public Long[] getStaffToDelete() {
		return staffToDelete;
	}
	public void setStaffToDelete(Long[] staffToDelete) {
		this.staffToDelete = staffToDelete;
	}
}
