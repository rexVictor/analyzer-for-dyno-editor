package org.dynocloud.analyzer.domain;

public abstract class AbstractEdge extends RootElement{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2186226493934256626L;

	private boolean controllableSource;
	
	private boolean controllableTarget;
	
	private AbstractNode source;
	
	private AbstractNode target;

	public boolean isControllableSource() {
		return controllableSource;
	}

	public boolean isControllableTarget() {
		return controllableTarget;
	}

	public AbstractNode getSource() {
		return source;
	}

	void setSource(AbstractNode source) {
		this.source = source;
		controllableSource = source.isControllable();
	}

	public AbstractNode getTarget() {
		return target;
	}

	void setTarget(AbstractNode target) {
		this.target = target;
		controllableTarget = target.isControllable();		
	}
	
	

}
