package org.dynocloud.analyzer.domain;

public class Participant extends AbstractNode implements MayBeBase{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7887986752642893375L;
	
	
	private boolean baseValue; 
	
	public Participant(){		
		
	}

	@Override
	public void setBaseValue(boolean baseValue) {
		this.baseValue = baseValue;
	}

	@Override
	public boolean isBaseValue() {
		return baseValue;
	}
	
	public static boolean isParticipant(RootElement element) {
		return element instanceof Participant;
	}

}
