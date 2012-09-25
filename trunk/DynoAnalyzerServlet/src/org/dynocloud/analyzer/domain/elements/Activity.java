package org.dynocloud.analyzer.domain.elements;

public class Activity extends AbstractNode implements MayBeBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3627435446137942020L;
	
	private boolean baseValue; 
	
	public Activity(){
		
	}

	
	public boolean isBaseValue() {
		return baseValue;
	}
	
	
	
	public void setBaseValue(boolean baseValue) {
		this.baseValue = baseValue;
	}

}
