package org.dynocloud.analyzer.domain.elements;

import org.dynocloud.analyzer.domain.ShapeResolver;

public class CloneFactory {
	
	public void clone(ShapeResolver resolver){
		ShapeResolver cloneResolver = new ShapeResolver();
		for (RootElement element : resolver){
			cloneResolver.addElement(element.clone());
		}
		for (RootElement element : cloneResolver){
			if (element instanceof AbstractNode){
				AbstractNode cloneNode = (AbstractNode) element;
				String resourceID = cloneNode.getResourceId();
				AbstractNode originalNode = (AbstractNode) resolver.getElement(resourceID);
				AbstractArea originalArea = originalNode.getLocation();
				AbstractArea cloneArea = (AbstractArea) cloneResolver.getElement(originalArea.getResourceId());
				Nester.addChildNode(cloneArea, cloneNode);
			}
			if (element instanceof AbstractArea){
				AbstractArea cloneArea = (AbstractArea) element;
				String resourceID = cloneArea.getResourceId();
				AbstractArea originalArea = (AbstractArea) resolver.getElement(resourceID);
				AbstractArea originalParentArea = originalArea.getParent();
				AbstractArea cloneParentArea = (AbstractArea) cloneResolver.getElement(originalParentArea.getResourceId());
				Nester.addChildArea(cloneParentArea, cloneArea);
			}
			if (element instanceof AbstractEdge){
				AbstractEdge cloneEdge = (AbstractEdge) element;
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
			if (element instanceof MayBeBase){
				MayBeBase cloneBase = (MayBeBase) element;
				String resourceID = element.getResourceId();
				MayBeBase originalBase = (MayBeBase) resolver.getElement(resourceID);
				cloneBase.setBaseValue(originalBase.isBaseValue());
			}
		}
	}

}
