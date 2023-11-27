package com.javacore.utils;

import com.javacore.constant.BuildingConstant;

public class BuildingTypeUtils {
	public static String allTypes(String value){
		if(value.equals(BuildingConstant.TANG_TRET_CODE)) {
			return BuildingConstant.TANG_TRET_NAME;
		}
		else if (value.equals(BuildingConstant.NGUYEN_CAN_CODE)) {
			return BuildingConstant.NGUYEN_CAN_NAME;
		}
		else{
			return BuildingConstant.NOI_THAT_NAME;
		}
	}
}
	