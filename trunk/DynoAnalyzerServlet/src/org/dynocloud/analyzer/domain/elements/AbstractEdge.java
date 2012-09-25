package org.dynocloud.analyzer.domain.elements;

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
		if (source!=null){
			controllableSource = source.isControllable();
		}
		else
			controllableSource = false;
		
	}

	public AbstractNode getTarget() {
		return target;
	}

	void setTarget(AbstractNode target) {
		this.target = target;		
		if (target == null) {
			controllableTarget = false;
			return;
		}
		controllableTarget = target.isControllable();		
	}
	
	

}
