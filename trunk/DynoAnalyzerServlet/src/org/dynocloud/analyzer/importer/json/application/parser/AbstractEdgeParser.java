package org.dynocloud.analyzer.importer.json.application.parser;

import java.util.Map;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.AbstractEdge;
import org.dynocloud.analyzer.domain.elements.Connector;
import org.dynocloud.analyzer.domain.elements.Influence;
import org.dynocloud.analyzer.domain.elements.RootElement;
import org.dynocloud.analyzer.domain.elements.Transaction;

class AbstractEdgeParser extends RootElementParser{
	
	protected AbstractEdgeParser(){
		
	}

	@Override
	public void parseMap(Map<String, Object> map, RootElement element, ShapeResolver resolver) {
		if (element instanceof AbstractEdge){
			super.parseMap(map, element, resolver);
			AbstractEdge edge = (AbstractEdge) element;
			@SuppressWarnings("unchecked")
			Map<String, String> target = (Map<String, String>) map.get(JSONConsts.TARGET);
			DummyNode node = null;
			if (edge instanceof Influence){
				node = new DummyNode(target.get(JSONConsts.RESOURCE_ID), false);
			}
			if (edge instanceof Transaction){
				node = new DummyNode(target.get(JSONConsts.RESOURCE_ID), true);
			}
			Connector.connect(edge, node);
			
		}
		
		
	}

}
