package org.dynocloud.analyzer.importer.json.application.parser;

import java.util.Map;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.Division;
import org.dynocloud.analyzer.domain.elements.RootElement;

class DivisionParser extends AbstractAreaParser{
	
	static{
		DivisionParser parser = new DivisionParser();
		register(StencilTypes.DIVISION, parser);
		register(StencilTypes.DIVISION_GROUP, parser);
	}
	
	private DivisionParser(){
		
	}
	
	@Override
	public void parseMap(Map<String, Object> map, RootElement element, ShapeResolver resolver){
		if (element instanceof Division){
			super.parseMap(map, element, resolver);
			@SuppressWarnings("unchecked")
			Map<String, Object> properties = (Map<String, Object>) map.get(JSONConsts.PROPERTIES);
			Boolean toSet = null;
			try{
				toSet = (Boolean) properties.get(JSONConsts.SCALABLE);			
			}
			catch (ClassCastException e){
				
			}
			boolean scalable = false;
			if (toSet != null)
				scalable = toSet;
			((Division) element).setScalable(scalable);
		}
		
	}

}
