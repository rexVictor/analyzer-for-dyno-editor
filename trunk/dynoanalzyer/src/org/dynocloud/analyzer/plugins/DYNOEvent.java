package org.dynocloud.analyzer.plugins;

import java.awt.Container;

import org.dynocloud.analyzer.core.plugin.api.DYNOEventAPI;
import org.dynocloud.analyzer.domain.ShapeResolver;
import org.jgrapht.DirectedGraph;

public class DYNOEvent implements DYNOEventAPI{
	
	private final ShapeResolver shapeResolver;
	
	private final DirectedGraph<String, String> graph;
	
	private final DirectedGraph<String, String> graphWithoutGateways;
	
	private final Container component;
	
	private final ShapeResolver shapeResolverWithoutGateways;
	
	

	public DYNOEvent(ShapeResolver shapeResolver, ShapeResolver shapeResolverWithoutGateways,
			DirectedGraph<String, String> graph,
			DirectedGraph<String, String> graphWithoutGateways, Container component) {
		super();
		this.shapeResolver = shapeResolver;
		this.shapeResolverWithoutGateways = shapeResolverWithoutGateways;
		this.graph = graph;
		this.graphWithoutGateways = graphWithoutGateways;
		this.component = component;
	}

	@Override
	public ShapeResolver getShapeResolver() {
		return shapeResolver;
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

	@Override
	public ShapeResolver getShapeResolverWithoutGateways() {
		return shapeResolverWithoutGateways;
	}
	
	

}
