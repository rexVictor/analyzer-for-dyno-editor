package org.dynocloud.analyzer.importer.json.application.parser;

import java.util.Map;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.Activity;
import org.dynocloud.analyzer.domain.elements.ActivityGroup;
import org.dynocloud.analyzer.domain.elements.MayBeBase;
import org.dynocloud.analyzer.domain.elements.RootElement;

class ActivityParser extends AbstractNodeParser{
	
	static{
		ActivityParser parser = new ActivityParser();
		register(StencilTypes.ACTIVITY, parser);
		register(StencilTypes.ACTIVITY_GROUP, parser);
	}
	
	@Override
	public void parseMap(Map<String, Object> map, RootElement element, ShapeResolver resolver){
		if (element instanceof Activity || element instanceof ActivityGroup){
			super.parseMap(map, element, resolver);
			MayBeBaseParser parser = new MayBeBaseParser();
			parser.parse((MayBeBase) element, map);
		}
	}
	
	private ActivityParser(){
		
	}
}
