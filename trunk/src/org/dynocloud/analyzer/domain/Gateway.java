package org.dynocloud.analyzer.domain;

public class Gateway extends AbstractNode{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1277585172304518743L;
	
	@Override
	public void setLocation(Location location){
		if (!Location.INFLUENCE_AREA.equals(location))
			throw new IllegalArgumentException("Gateways can only be in the influence Area!");
		super.setLocation(location);
	}

}
