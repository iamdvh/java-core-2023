package com.javacore.enums;

public enum BuildingTypeEnum {
	TANG_TRET("Tầng trệt"), NGUYEN_CAN("Nguyên căn"), NOI_THAT("Nội thất");
	private String type;
	private BuildingTypeEnum(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}

}
