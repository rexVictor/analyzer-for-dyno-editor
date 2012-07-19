package org.dynocloud.analyzer.domain;

public class Division extends ControlArea implements IDivision{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8957016863790425405L;
	
	@Override
	public void setParent(AbstractArea area){
		if (!(area instanceof ControlArea)){
			throw new IllegalArgumentException("A Division must be placed inside the control area!");
		}
		super.setParent(area);
	}

}
