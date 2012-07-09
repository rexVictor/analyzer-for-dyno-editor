package org.dynocloud.analyzer.domain;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractNode extends RootElement{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -884029029649876764L;

	private Location location;
	
	private boolean controllable;
	
	private boolean controlled;
	
	private List<AbstractEdge> outgoing = new LinkedList<>();
	
	private List<AbstractEdge> incoming = new LinkedList<>();
	
	protected AbstractNode(){
		
	}

	public Location getLocation() {
		return location;
	}

	public boolean isControllable() {
		return controllable;
	}

	public boolean isControlled() {
		return controlled;
	}

	public void setLocation(Location location) {
		this.location = location;
		this.controllable = Location.CONTROL_AREA.equals(location);
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
	
	
	
	
	
	
	
	
	
		
	

	
	
	

}
