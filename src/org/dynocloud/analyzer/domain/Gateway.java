package org.dynocloud.analyzer.domain;

public class Gateway extends AbstractNode{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1277585172304518743L;
	
	@Override
	public void setLocation(AbstractArea location){
		if (!(location instanceof InfluenceArea))
			throw new IllegalArgumentException("Gateways can only be in the influence Area!");
		super.setLocation(location);
	}

}
