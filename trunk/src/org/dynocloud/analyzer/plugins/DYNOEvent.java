package org.dynocloud.analyzer.plugins;

import java.awt.Component;
import java.awt.Container;

import org.dynocloud.analyzer.core.plugin.api.DYNOEventAPI;
import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.NoiseArea;
import org.jgrapht.DirectedGraph;

public class DYNOEvent implements DYNOEventAPI{
	
	private final ShapeResolver shapeResolver;
	
	private final NoiseArea area;
	
	private final DirectedGraph<String, String> graph;
	
	private final DirectedGraph<String, String> graphWithoutGateways;
	
	private final Container component;
	
	

	public DYNOEvent(ShapeResolver shapeResolver, NoiseArea area,
			DirectedGraph<String, String> graph,
			DirectedGraph<String, String> graphWithoutGateways, Container component) {
		super();
		this.shapeResolver = shapeResolver;
		this.area = area;
		this.graph = graph;
		this.graphWithoutGateways = graphWithoutGateways;
		this.component = component;
	}

	@Override
	public ShapeResolver getShapeResolver() {
		return shapeResolver;
	}

	@Override
	public NoiseArea getNoiseArea() {
		return area;
	}

	@Override
	public DirectedGraph<String, String> getGraph() {
		return graph;
	}

	@Override
	public DirectedGraph<String, String> getGraphWithoutGateways() {
		return graphWithoutGateways;
	}

	@Override
	public Container getGUIComponent() {
		return component;
	}
	
	

}
