package com.javacore.enums;

public enum BuildingEnum {
	TANG_TRET("Tầng trệt"),
	NGUYEN_CAN("Nguyên căn"),
	NOI_THAT("Nội thất");
	private final String BuildingName;
	private BuildingEnum(String BuildingType) {
		this.BuildingName = BuildingType;
	}
	public String getBuildingName() {
		return BuildingName;
	}
}
