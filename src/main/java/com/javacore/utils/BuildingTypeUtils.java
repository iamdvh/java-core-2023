package com.javacore.utils;

public class BuildingTypeUtils {
	public static String convertCodeToName(String value){
		if(value.equals("TANG_TRET")) {
			return "Tầng trệt";
		}
		else if (value.equals("NGUYEN_CAN")) {
			return "Nguyên căn";
		}else if (value.equals("NOI_THAT")) {
			return "Nội thất";
		}
		return "";
	}
}
	