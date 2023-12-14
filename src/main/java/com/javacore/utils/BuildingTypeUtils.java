package com.javacore.utils;

import java.util.ArrayList;
import java.util.List;

import com.javacore.enums.BuildingTypeEnum;

public class BuildingTypeUtils {
	public static String getType(String oldType){
		List<String> newType = new ArrayList<String>();
		if(oldType != null) {			
			for(String str : oldType.split(", ")) {
				newType.add(BuildingTypeEnum.valueOf(str).getType());
			}
		}
		return String.join(", ", newType);
	}
}
	