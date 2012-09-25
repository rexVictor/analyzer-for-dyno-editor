package org.dynocloud.analyzer.importer.json.application.parser;

import java.util.List;
import java.util.Map;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.AbstractArea;
import org.dynocloud.analyzer.domain.elements.AbstractEdge;
import org.dynocloud.analyzer.domain.elements.AbstractNode;
import org.dynocloud.analyzer.domain.elements.Nester;
import org.dynocloud.analyzer.domain.elements.RootElement;
import org.dynocloud.analyzer.importer.json.application.JsonToClassMapper;

import static org.dynocloud.analyzer.importer.json.application.parser.JSONConsts.*;

abstract class AbstractAreaParser extends RootElementParser{
	
	private final JsonToClassMapper mapper = new JsonToClassMapper();
	
	protected AbstractAreaParser(){
		
	}
	
	@Override
	public void parseMap(Map<String, Object> map, RootElement element, ShapeResolver resolver){
		if (element instanceof AbstractArea){
			super.parseMap(map, element, resolver);
			AbstractArea area = (AbstractArea) element;
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> children = (List<Map<String, Object>>) map.remove(CHILD_SHAPES);
			for (Map<String, Object> child : children){
				String stencil = AbstractParser.getStencil(child);
				Class<? extends RootElement> clazz = mapper.getClass(stencil);
				if (clazz == null) {
					System.err.println("No Class for "+stencil+" found!");
					continue;
				}
				try {
					RootElement childElement = clazz.newInstance();
					AbstractParser parser = AbstractParser.getParser(stencil);
					if (parser == null) {
						System.err.println("No Parser for "+stencil+" registered");
						continue;
					}
					parser.parseMap(child, childElement, resolver);
					if (childElement instanceof AbstractNode) {
						AbstractNode node = (AbstractNode) childElement;
						Nester.addChildNode(area, node);						
					}
					if (childElement instanceof AbstractArea){
						AbstractArea childArea = (AbstractArea) childElement;
						Nester.addChildArea(area, childArea);
					}
					if (childElement instanceof AbstractEdge) {
						//Vielleicht kommt hier noch was rein.
					}
				} catch (InstantiationException e) {
					throw new RuntimeException(e);
				}
				catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			}
			
			
			
		}
	}

}
