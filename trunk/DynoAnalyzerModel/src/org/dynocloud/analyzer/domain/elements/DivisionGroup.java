package org.dynocloud.analyzer.domain.elements;

public class DivisionGroup extends AbstractArea implements IDivision, ControlAreas{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8957016863790425405L;
	
	private boolean scalable;
	
	@Override
	public void setParent(AbstractArea area){
		if (!(area instanceof ControlAreas)){
			throw new IllegalArgumentException("A division must be placed inside a control area or division!");
		}
		super.setParent(area);
	}
	
	public void setScalable(boolean scalable){
		this.scalable = scalable;
	}
	
	public boolean isScalable(){
		return scalable;
	}


}
