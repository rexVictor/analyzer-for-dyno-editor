package org.dynocloud.analyzer.plugins;

import java.io.Serializable;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.AbstractArea;
import org.dynocloud.analyzer.domain.elements.AbstractNode;
import org.dynocloud.analyzer.domain.elements.ControlArea;
import org.dynocloud.analyzer.domain.elements.NoiseArea;

public class AnalyzerEvent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3392206646027249279L;
	
	private final ShapeResolver resolver;
	
	/*private final DirectedGraph<String, String>graph;*/
	
	/*private final DirectedGraph<String, String> gatewayFreeGraph;*/
	
	
	
	public static boolean isElementInControlArea(AbstractNode node){
		AbstractArea location = null;
		while (!((location = node.getLocation()) instanceof NoiseArea)){
			if (location instanceof ControlArea) return true;
		}
		return false;
	}
	
	public AnalyzerEvent(ShapeResolver resolver) {
		super();
		this.resolver = resolver;
	}
	
	public ShapeResolver getShapeResolver(){
		return resolver;
	}

	
}
