package org.dynocloud.analyzer.domain;

import java.util.HashMap;
import java.util.Map;

public enum ShapeType {
	
	AREA, NODE, EDGE;
	
	private static final Map<String, ShapeType> stringMap;
	
	static{
		stringMap = new HashMap<>();
		stringMap.put("areaType", AREA);
		stringMap.put("elementType", NODE);
		stringMap.put("arrowType", EDGE);
	}
	
	public static ShapeType keyToType(String string){
		return stringMap.get(string);
	}

}
