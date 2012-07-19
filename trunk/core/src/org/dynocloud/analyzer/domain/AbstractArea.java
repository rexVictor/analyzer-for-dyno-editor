package org.dynocloud.analyzer.domain;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractArea extends RootElement{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6464584279936770835L;
	
	private AbstractArea parent;
	
	private List<AbstractArea> childAreas = new LinkedList<>();
	
	private List<AbstractNode> childNodes = new LinkedList<>();
	
	protected AbstractArea(){
		
	}
	
	public void setParent(AbstractArea parent){
		this.parent = parent;
	}
	
	public void addChildArea(AbstractArea area){
		childAreas.add(area);
	}
	
	public void addNode(AbstractNode node){
		childNodes.add(node);
	}
	
	public void removeChildArea(AbstractArea area){
		childAreas.remove(area);
	}
	
	public void removeNode(AbstractNode node){
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
