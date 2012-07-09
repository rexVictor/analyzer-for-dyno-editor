package org.dynocloud.analyzer.domain;

public class ActivityGroup extends AbstractNode implements MayBeBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3627435446137942020L;
	
	private boolean baseValue; 
	
	public ActivityGroup(){
		
	}

	@Override
	public boolean isBaseValue() {
		return baseValue;
	}
	
	
	
	@Override
	public void setBaseValue(boolean baseValue) {
		this.baseValue = baseValue;
	}

	public static boolean isActivity(RootElement element){
		return element instanceof Activity;
	}

}

