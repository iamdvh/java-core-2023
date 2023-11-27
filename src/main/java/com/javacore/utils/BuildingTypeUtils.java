package com.javacore.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javacore.constant.BuildingConstant;

public class BuildingTypeUtils {
	public static String getName(String value){
		Map<String, String> allTypes = new HashMap<String, String>();
		allTypes.put(BuildingConstant.TANG_TRET_CODE, BuildingConstant.TANG_TRET_NAME);
		allTypes.put(BuildingConstant.NGUYEN_CAN_CODE, BuildingConstant.NGUYEN_CAN_NAME);
		allTypes.put(BuildingConstant.NOI_THAT_CODE, BuildingConstant.NOI_THAT_NAME);
		List<String> convert = new ArrayList<String>();
		for (String item : value.split(", ")) {
			convert.add(allTypes.getOrDefault(item, ""));
		}
		return String.join(", ", convert);
	}
}
