package com.javacore.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javacore.constant.BuildingConstant;

public class BuildingTypeUtils {
	public static String getType(String oldType){
		List<String> newType = new ArrayList<String>();
		if(oldType != null) {			
			for (String item : oldType.split(", ")) {
				Map<String, String> mapType = unitBuildingType();
				String code = mapType.get(item);
				newType.add(code);
			}
		}
		return String.join(", ", newType);
	}
	public static Map<String, String> unitBuildingType(){
		Map<String, String> results = new HashMap<String, String>();
		results.put(BuildingConstant.TANG_TRET_CODE, BuildingConstant.TANG_TRET_NAME);
		results.put(BuildingConstant.NGUYEN_CAN_CODE, BuildingConstant.NGUYEN_CAN_NAME);
		results.put(BuildingConstant.NOI_THAT_CODE, BuildingConstant.NOI_THAT_NAME);
		return results;
	}
}
