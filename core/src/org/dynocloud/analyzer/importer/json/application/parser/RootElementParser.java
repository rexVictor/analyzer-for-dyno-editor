package org.dynocloud.analyzer.importer.json.application.parser;

import java.util.Map;

import org.dynocloud.analyzer.domain.RootElement;

import static org.dynocloud.analyzer.importer.json.application.parser.JSONConsts.*;

public abstract class RootElementParser extends AbstractParser{
	
	protected RootElementParser(){
		
	}
	
	@Override
	public void parseMap(Map<String, Object> map, RootElement element){
		@SuppressWarnings("unchecked")
		Map<String, Object> properties = (Map<String, Object>) map.get(PROPERTIES);
		String name = (String) properties.remove(NAME);
		String id = (String) properties.remove(ID);
		String resourceID = (String) map.remove(RESOURCE_ID);
		element.setName(name);
		element.setId(id);
		element.setResourceId(resourceID);
	}

}
