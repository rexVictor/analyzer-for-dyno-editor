package org.dynocloud.analyzer.importer.json.application.parser;

import java.util.Map;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.Activity;
import org.dynocloud.analyzer.domain.elements.MayBeBase;
import org.dynocloud.analyzer.domain.elements.RootElement;

class ActivityParser extends AbstractNodeParser{
	
	static{
		register(StencilTypes.ACTIVITY, new ActivityParser());
	}
	
	@Override
	public void parseMap(Map<String, Object> map, RootElement element, ShapeResolver resolver){
		if (element instanceof Activity){
			super.parseMap(map, element, resolver);
			MayBeBaseParser parser = new MayBeBaseParser();
			parser.parse((MayBeBase) element, map);
		}
		
	}
	
	private ActivityParser(){
		
	}

}
