package org.dynocloud.analyzer.core.plugin.api;

import java.awt.Container;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.jgrapht.DirectedGraph;

public interface DYNOEventAPI {
	
	public ShapeResolver getShapeResolver();
	
	public DirectedGraph<String, String> getGraph();
	
	public ShapeResolver getShapeResolverWithoutGateways();
	
	public DirectedGraph<String, String> getGraphWithoutGateways();
	
	public Container getGUIComponent();

}
