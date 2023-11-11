package com.javacore.utils;

import java.util.HashMap;
import java.util.Map;

import com.javacore.constant.SystemConstant;

public class BuildingTypeUtils {
	public static Map<String, String> getType(){
		Map<String, String> map = new HashMap<String, String>();
		map.put(SystemConstant.TANG_TRET, "Tầng Trệt");
		map.put(SystemConstant.NGUYEN_CAN, "Nguyên căn");
		map.put(SystemConstant.NOI_THAT, "Nội thất");
		return map;
	}
}
