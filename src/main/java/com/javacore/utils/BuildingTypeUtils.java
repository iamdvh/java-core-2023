package com.javacore.utils;

public class BuildingTypeUtils {
	public static String convertCodeToName(String value){
		switch (value) {
		case "TANG_TRET":
			return "Tầng trệt";
		case "NGUYEN_CAN":
			return "Nguyên căn";
		case "NOI_THAT":
			return "Nội thất";
		default:
			return "";
		}
	}
}
	