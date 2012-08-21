package org.dynocloud.analyzer.importer.json.application.parser;

import java.util.Map;

import org.dynocloud.analyzer.domain.elements.MayBeBase;

class MayBeBaseParser {
	
	MayBeBaseParser() {
		
	}
	
	public void parse(MayBeBase base, Map<String, Object> protoElement){
		@SuppressWarnings("unchecked")
		Map<String,Object> properties = (Map<String, Object>) protoElement.get(JSONConsts.PROPERTIES);
		Boolean isbase = null;
		try{
			isbase = (Boolean) properties.get(JSONConsts.IS_BASE_VALUE);			
		}
		catch (ClassCastException e){
			
		}
		boolean basic = false;
		if (isbase != null)
			basic = isbase;
		base.setBaseValue(basic);
	}
	
	
	

}
