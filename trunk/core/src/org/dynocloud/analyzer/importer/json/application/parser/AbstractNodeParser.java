package org.dynocloud.analyzer.importer.json.application.parser;

import java.util.Map;

import org.dynocloud.analyzer.domain.AbstractNode;
import org.dynocloud.analyzer.domain.RootElement;

public abstract class AbstractNodeParser extends RootElementParser{
	
	protected AbstractNodeParser(){
		
	}
	
	@Override
	public void parseMap(Map<String, Object> map, RootElement root){
		if (root instanceof AbstractNode){
			@SuppressWarnings("unchecked")
			Map<String, Object> properties = (Map<String, Object>) map.get("properties");
			Object controlledAsObject = properties.remove("controlled");
			boolean controlled = false;
			if (controlledAsObject instanceof Boolean)
				controlled = (boolean) controlledAsObject;
			((AbstractNode) root).setControlled(controlled);
		}
	}

}
