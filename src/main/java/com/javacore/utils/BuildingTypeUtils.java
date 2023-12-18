package com.javacore.utils;

import java.util.ArrayList;
import java.util.List;

public class BuildingTypeUtils {
	public static String getType(String value){
		List<String> newType = new ArrayList<String>();
		if(value!= null) {		
			for (String oldType : value.split(", ")) {
				if(oldType.equals("TANG_TRET")) {
					newType.add("Tầng trệt");
					continue;
				}
				else if (oldType.equals("NGUYEN_CAN")) {
					newType.add("Nguyên căn");
					continue;
				}else if (oldType.equals("NOI_THAT")) {
					newType.add("Nội thất");
					continue;
				}
				
			}
		}
		return String.join(", ", newType);
	}
}
	