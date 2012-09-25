package org.dynocloud.analyzer.core.plugin.api;

import java.awt.Container;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.NoiseArea;
import org.jgrapht.DirectedGraph;

public interface DYNOEventAPI {
	
	public NoiseArea getNoiseArea();
	
	public ShapeResolver getShapeResolver();
	
	public DirectedGraph<String, String> getGraph();
	
	public DirectedGraph<String, String> getGraphWithoutGateways();
	
	public Container getGUIComponent();

}
