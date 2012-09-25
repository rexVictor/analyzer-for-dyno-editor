package org.dynocloud.analyzer.importer.json.application.parser;

import java.util.List;
import java.util.Map;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.AbstractNode;
import org.dynocloud.analyzer.domain.elements.Connector;
import org.dynocloud.analyzer.domain.elements.RootElement;

abstract class AbstractNodeParser extends RootElementParser{
	
	protected AbstractNodeParser(){
		
	}
	
	@Override
	public void parseMap(Map<String, Object> map, RootElement root, ShapeResolver resolver){
		if (root instanceof AbstractNode){
			super.parseMap(map, root, resolver);
			AbstractNode node = (AbstractNode) root;
			
			/*
			 * Sets the controlled value.
			 */
			@SuppressWarnings("unchecked")
			Map<String, Object> properties = (Map<String, Object>) map.get(JSONConsts.PROPERTIES);
			Object controlledAsObject = properties.remove(JSONConsts.CONTROLLED);
			boolean controlled = false;
			if (controlledAsObject instanceof Boolean)
				controlled = (Boolean) controlledAsObject;
			node.setControlled(controlled);
			
			/*
			 * Sets the outgoing edges with dummy Elements.
			 */
			@SuppressWarnings("unchecked")
			List<Map<String, String>> outgoings = (List<Map<String, String>>) map.get(JSONConsts.OUTGOING);
			for (Map<String, String> outgoing : outgoings){
				Connector.connect(node, new DummyEdge(outgoing.get(JSONConsts.RESOURCE_ID)));				
			}
			
		}
	}

}
