package org.dynocloud.analyzer.domain;

public class Transaction extends AbstractEdge{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2298922540133695097L;
	
	@Override
	void setTarget(AbstractNode target){
		if (!target.isControllable()) 
			throw new IllegalArgumentException("The target of a transaction must be in the control area!");
		super.setTarget(target);
	}
	
	@Override
	void setSource(AbstractNode source){
		if (source.getLocation() instanceof NoiseArea)
			throw new IllegalArgumentException("A transaction cannot be done from the noise area");
		if (source instanceof Gateway)
			throw new IllegalArgumentException("A transaction cannot be done by a gateway!");
		super.setSource(source);
	}

}
