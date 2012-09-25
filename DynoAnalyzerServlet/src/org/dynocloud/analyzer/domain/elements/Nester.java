package org.dynocloud.analyzer.domain.elements;

public class Nester {
	
	public static void addChildArea(AbstractArea parent, AbstractArea child){
		parent.addChildArea(child);
		child.setParent(parent);
	}
	
	public static void addChildNode(AbstractArea parent, AbstractNode node){
		parent.addNode(node);
		node.setLocation(parent);
	}

}
