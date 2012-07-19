package org.dynocloud.analyzer.domain;

public class Influence extends AbstractEdge{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1709553921542390755L;
	
	@Override
	void setTarget(AbstractNode target){
		if (target.isControllable())
			throw new IllegalArgumentException("The control area must not be influenced!");
		if (target.getLocation() instanceof NoiseArea)
			throw new IllegalArgumentException("The noise area must not be influenced!");
		super.setTarget(target);
	}
	

}
