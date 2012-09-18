package org.dynocloud.analyzer.domain.elements;

public class ParticipantGroup extends AbstractNode implements MayBeBase{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7887986752642893375L;
	
	
	private boolean baseValue; 
	
	public ParticipantGroup(){		
		
	}

	@Override
	public void setBaseValue(boolean baseValue) {
		this.baseValue = baseValue;
	}

	@Override
	public boolean isBaseValue() {
		return baseValue;
	}
	
	
}
