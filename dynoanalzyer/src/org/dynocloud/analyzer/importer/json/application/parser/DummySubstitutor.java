package org.dynocloud.analyzer.importer.json.application.parser;

import java.util.LinkedList;
import java.util.List;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.AbstractEdge;
import org.dynocloud.analyzer.domain.elements.AbstractNode;
import org.dynocloud.analyzer.domain.elements.Connector;
import org.dynocloud.analyzer.domain.elements.RootElement;

public class DummySubstitutor {
	
	public void subsituteDummies(ShapeResolver resolver){
		for (RootElement element : resolver){
			if (element instanceof AbstractNode){
				AbstractNode node = (AbstractNode) element;
				List<AbstractEdge> outgoing = new LinkedList<AbstractEdge>(node.getOutgoing());
				for (AbstractEdge edge : outgoing){
					if (edge instanceof DummyEdge){
						String resourceId = edge.getResourceId();
						Connector.unconnect(node, edge);
						AbstractEdge newEdge = (AbstractEdge) resolver.getElement(resourceId);
						Connector.connect(node, newEdge);						
					}
				}
				List<AbstractEdge> incoming = new LinkedList<AbstractEdge>(node.getIncoming());
				for (AbstractEdge edge : incoming){
					if (edge instanceof DummyEdge){
						String resourceId = edge.getResourceId();
						Connector.unconnect(edge, node);
						AbstractEdge newEdge = (AbstractEdge) resolver.getElement(resourceId);
						Connector.connect(newEdge, node);						
					}
				}
			}
			if (element instanceof AbstractEdge){
				AbstractEdge edge = (AbstractEdge) element;
				AbstractNode source = edge.getSource();
				if (source instanceof DummyNode){
					String resourceId = source.getResourceId();
					Connector.unconnect(source, edge);
					AbstractNode newSource = (AbstractNode) resolver.getElement(resourceId);
					Connector.connect(newSource, edge);
				}
				AbstractNode target = edge.getTarget();
				if (target instanceof DummyNode){
					String resourceId = target.getResourceId();
					Connector.unconnect(edge, target);
					AbstractNode newTarget = (AbstractNode) resolver.getElement(resourceId);
					Connector.connect(edge, newTarget);
				}
			}
		}
	}

}
