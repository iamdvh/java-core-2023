package com.javacore.enums;

public enum BuildingTypeEnum {
	TANG_TRET("Tầng trệt"), NGUYEN_CAN("Nguyên căn"), NOI_THAT("Nội thất");
	private String value;
	private BuildingTypeEnum(String value) {
		this.value = value;
	}
	public String getType() {
		return value;
	}

}
