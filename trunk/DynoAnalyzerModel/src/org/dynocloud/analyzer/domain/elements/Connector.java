package org.dynocloud.analyzer.domain.elements;

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
	
	public static void unconnect(AbstractNode source, AbstractEdge edge, AbstractNode target){
		unconnect(source, edge);
		unconnect(edge, target);
	}
	
	public static void unconnect(AbstractNode source, AbstractEdge edge){
		source.removeOutgoing(edge);
		edge.setSource(null);
	}
	
	public static void unconnect(AbstractEdge edge, AbstractNode target){
		edge.setTarget(null);
		target.removeIncoming(edge);
	}

}
