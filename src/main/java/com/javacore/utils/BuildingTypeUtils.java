package com.javacore.utils;

import com.javacore.constant.BuildingConstant;

public class BuildingTypeUtils {
	public static String allTypes(String value){
		switch (value) {
		case BuildingConstant.TANG_TRET_CODE:
			return BuildingConstant.TANG_TRET_NAME;
		case BuildingConstant.NGUYEN_CAN_CODE:
			return BuildingConstant.NGUYEN_CAN_NAME;
		case BuildingConstant.NOI_THAT_CODE:
			return BuildingConstant.NOI_THAT_NAME;
		default:
			return "";
		}
	}
}
	