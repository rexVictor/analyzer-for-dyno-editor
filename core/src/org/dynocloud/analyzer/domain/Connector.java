package org.dynocloud.analyzer.domain;

public class Connector {
	
	public static void connect(AbstractNode source, AbstractEdge edge, AbstractNode target){
		connect(source, edge);
		connect(edge, target);
	}
	
	public static void connect(AbstractNode source, AbstractEdge edge){
		source.addOutgoing(edge);
		edge.setSource(source);
	}
	
	public static void connect(AbstractEdge edge, AbstractNode target){
		edge.setTarget(target);
		target.addIncoming(edge);
	}

}
