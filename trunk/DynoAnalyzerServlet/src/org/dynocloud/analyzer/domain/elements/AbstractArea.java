package org.dynocloud.analyzer.domain.elements;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractArea extends RootElement{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6464584279936770835L;
	
	private AbstractArea parent;
	
	private List<AbstractArea> childAreas = new LinkedList<AbstractArea>();
	
	private List<AbstractNode> childNodes = new LinkedList<AbstractNode>();
	
	protected AbstractArea(){
		
	}
	
	void setParent(AbstractArea parent){
		this.parent = parent;
	}
	
	void addChildArea(AbstractArea area){
		childAreas.add(area);
	}
	
	void addNode(AbstractNode node){
		childNodes.add(node);
	}
	
	void removeChildArea(AbstractArea area){
		childAreas.remove(area);
	}
	
	void removeNode(AbstractNode node){
		childNodes.remove(node);
	}

	public AbstractArea getParent() {
		return parent;
	}

	public List<AbstractArea> getChildAreas() {
		return childAreas;
	}

	public List<AbstractNode> getChildNodes() {
		return childNodes;
	}
	
	
	
	
	
	

}
