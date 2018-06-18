package com.el.calculator.util;

import java.util.HashMap;
import java.util.Map;

public class OperationMapper {
	
	private static Map<String, String> opMap;
	
	public static String get(String k) {
		return getMap().get(k);
	}
	
	public static Map<String, String> getMap(){
		if(opMap == null) {
			initMap();
		}
		return opMap;
	}
	
	private static void initMap() {
		opMap = new HashMap<String, String>();
		opMap.put("addition", "+");
		opMap.put("subtraction", "-");
		opMap.put("multiplication",  "*");
		opMap.put("division",  "/");
		opMap.put("exponent",  "^");
	}
}
