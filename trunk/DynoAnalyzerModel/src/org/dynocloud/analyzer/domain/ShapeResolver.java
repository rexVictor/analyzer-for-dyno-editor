package org.dynocloud.analyzer.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.dynocloud.analyzer.domain.elements.AbstractArea;
import org.dynocloud.analyzer.domain.elements.AbstractEdge;
import org.dynocloud.analyzer.domain.elements.AbstractNode;
import org.dynocloud.analyzer.domain.elements.Connector;
import org.dynocloud.analyzer.domain.elements.MayBeBase;
import org.dynocloud.analyzer.domain.elements.Nester;
import org.dynocloud.analyzer.domain.elements.RootElement;

public class ShapeResolver implements Iterable<RootElement>, Serializable, Cloneable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6348882860271257042L;
	
	private final Map<String, RootElement> elements = new HashMap<String, RootElement>();
	
	public void addElement(RootElement element){
		elements.put(element.getResourceId(), element);
	}
	
	public RootElement getElement(String resourceID){
		return elements.get(resourceID);
	}
	
	@Override
	public String toString(){
		return elements.toString();
	}

	@Override
	public Iterator<RootElement> iterator() {
		return elements.values().iterator();
	}
	
	public void removeElement(RootElement element){
		elements.remove(element.getResourceId());
	}
	
	@Override
	public ShapeResolver clone(){
		ShapeResolver resolver = this;
		ShapeResolver cloneResolver = new ShapeResolver();
		for (RootElement element : resolver){
			cloneResolver.addElement(element.clone());
		}
		List<AbstractNode> nodes = new LinkedList<AbstractNode>();
		List<AbstractArea> areas = new LinkedList<AbstractArea>();
		List<AbstractEdge> edges = new LinkedList<AbstractEdge>();
		for (RootElement element : cloneResolver){
			if (element instanceof AbstractNode)
				nodes.add((AbstractNode) element);
			if (element instanceof AbstractArea){
				areas.add((AbstractArea) element);
			}
			if (element instanceof AbstractEdge)
				edges.add((AbstractEdge) element);
		}
		for (AbstractArea cloneArea : areas){
			String resourceID = cloneArea.getResourceId();
			AbstractArea originalArea = (AbstractArea) resolver.getElement(resourceID);
			AbstractArea originalParentArea = originalArea.getParent();
			if (originalParentArea != null){
				AbstractArea cloneParentArea = (AbstractArea) cloneResolver.getElement(originalParentArea.getResourceId());
				Nester.addChildArea(cloneParentArea, cloneArea);
			}
		}
		
		for (AbstractNode cloneNode : nodes){
			String resourceID = cloneNode.getResourceId();
			AbstractNode originalNode = (AbstractNode) resolver.getElement(resourceID);
			AbstractArea originalArea = originalNode.getLocation();
			AbstractArea cloneArea = (AbstractArea) cloneResolver.getElement(originalArea.getResourceId());
			Nester.addChildNode(cloneArea, cloneNode);
			if (cloneNode instanceof MayBeBase){
				MayBeBase cloneBase = (MayBeBase) cloneNode;
				MayBeBase originalBase = (MayBeBase) resolver.getElement(resourceID);
				cloneBase.setBaseValue(originalBase.isBaseValue());
			}
		}
		for(AbstractEdge cloneEdge : edges){
			String resourceID = cloneEdge.getResourceId();
			AbstractEdge originalEdge = (AbstractEdge) resolver.getElement(resourceID);
			AbstractNode originalTarget = originalEdge.getTarget();
			AbstractNode originalSource = originalEdge.getSource();
			String targetResourceID = originalTarget.getResourceId();
			String sourceResourceID = originalSource.getResourceId();
			AbstractNode cloneTarget = (AbstractNode) cloneResolver.getElement(targetResourceID);
			AbstractNode cloneSource = (AbstractNode) cloneResolver.getElement(sourceResourceID);
			Connector.connect(cloneSource, cloneEdge, cloneTarget);
		}
		return cloneResolver;
	}

}
