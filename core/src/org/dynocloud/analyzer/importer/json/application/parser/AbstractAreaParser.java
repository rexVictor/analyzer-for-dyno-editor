package org.dynocloud.analyzer.importer.json.application.parser;

import java.util.List;
import java.util.Map;

import org.dynocloud.analyzer.domain.AbstractArea;
import org.dynocloud.analyzer.domain.AbstractEdge;
import org.dynocloud.analyzer.domain.AbstractNode;
import org.dynocloud.analyzer.domain.RootElement;
import org.dynocloud.analyzer.importer.json.application.JsonToClassMapper;

import static org.dynocloud.analyzer.importer.json.application.parser.JSONConsts.*;

public abstract class AbstractAreaParser extends RootElementParser{
	
	private final JsonToClassMapper mapper = new JsonToClassMapper();
	
	protected AbstractAreaParser(){
		
	}
	
	@Override
	public void parseMap(Map<String, Object> map, RootElement element){
		if (element instanceof AbstractArea){
			super.parseMap(map, element);
			AbstractArea area = (AbstractArea) element;
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> children = (List<Map<String, Object>>) map.remove(CHILD_SHAPES);
			for (Map<String, Object> child : children){
				String stencil = AbstractParser.getStencil(child);
				Class<? extends RootElement> clazz = mapper.getClass(stencil);
				if (clazz == null) {
					System.out.println(stencil);
					System.out.println("Class not registered!");
					continue;
				}
				try {
					RootElement childElement = clazz.newInstance();
					AbstractParser parser = AbstractParser.getParser(stencil);
					if (parser == null) {
						System.out.println(stencil);
						System.out.println("No Parser registered");
						continue;
					}
					parser.parseMap(child, childElement);
					if (childElement instanceof AbstractNode) {
						AbstractNode node = (AbstractNode) childElement;
						area.addNode(node);
						node.setLocation(area);						
					}
					if (childElement instanceof AbstractArea){
						AbstractArea childArea = (AbstractArea) childElement;
						area.addChildArea(childArea);
						childArea.setParent(area);						
					}
					if (childElement instanceof AbstractEdge) {
						System.out.println("Abstract Edge lass dir was einfallen!");
					}
				} catch (InstantiationException | IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			}
			
			
			
		}
	}

}
