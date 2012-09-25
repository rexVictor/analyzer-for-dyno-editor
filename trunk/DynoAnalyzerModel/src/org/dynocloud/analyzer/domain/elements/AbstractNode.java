package org.dynocloud.analyzer.domain.elements;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractNode extends RootElement{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -884029029649876764L;

	private AbstractArea location;
	
	private boolean controllable = true;
	
	private boolean controlled;
	
	private List<AbstractEdge> outgoing = new LinkedList<AbstractEdge>();
	
	private List<AbstractEdge> incoming = new LinkedList<AbstractEdge>();
	
	protected AbstractNode(){
		
	}

	public AbstractArea getLocation() {
		return location;
	}

	public boolean isControllable() {
		return controllable;
	}

	public boolean isControlled() {
		return controlled;
	}

	void setLocation(AbstractArea location) {
		if (this.location != null) {
			this.location.removeNode(this);
		}
		this.location = location;
	//	location.addNode(this);
		this.controllable = (location instanceof ControlArea);
	}

	public void setControlled(boolean controlled) {
		if (!controllable && controlled)
			throw new IllegalArgumentException(this.getClass().getSimpleName()+" shall be controlled though it is not controllable!");
		this.controlled = controlled;
	}
	
	public List<AbstractEdge> getIncoming(){
		return incoming;
	}
	
	public List<AbstractEdge> getOutgoing(){
		return outgoing;
	}
	
	void addIncoming(AbstractEdge edge){
		incoming.add(edge);
	}
	
	void addOutgoing(AbstractEdge edge){
		outgoing.add(edge);
	}
	
	void removeIncoming(AbstractEdge edge){
		incoming.remove(edge);
	}
	
	void removeOutgoing(AbstractEdge edge){
		outgoing.remove(edge);
	}
	
	@Override
	public String toString(){
		String proto = super.toString();
		StringBuilder sb = new StringBuilder(proto);
		sb.append("\n\tlocation"+"\t:\t"+location.getClass().getSimpleName()+"\n\t");
		sb.append("controlled"+"\t:\t"+controlled+"\n\t");
		sb.append("outgoing"+"\t:\t"+outgoing+"\n\t");
		sb.append("incoming"+"\t:\t"+incoming+"\n");	
		return sb.toString();
	}
	
	@Override
	public AbstractNode clone(){
		AbstractNode clone = (AbstractNode) super.clone();
		clone.outgoing = new LinkedList<AbstractEdge>();
		clone.incoming = new LinkedList<AbstractEdge>();
		clone.controllable = false;
		clone.controlled = false;
		clone.location = null;		
		return clone;
	}

}
