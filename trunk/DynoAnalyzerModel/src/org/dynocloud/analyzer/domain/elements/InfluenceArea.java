package org.dynocloud.analyzer.domain.elements;

import java.util.List;

public class InfluenceArea extends AbstractArea{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5725688365460172180L;
	
	@Override
	public void setParent(AbstractArea area){
		if (!(area instanceof NoiseArea))
			throw new IllegalArgumentException("The parent area of an influence area must be a noise area!");
		super.setParent(area);
	}
	
	@Override
	public void addChildArea(AbstractArea area){
		if (!(area instanceof ControlArea))
			throw new IllegalArgumentException("The child area of an influence area must be the control Area!");
		List<AbstractArea> childAreas = getChildAreas();
		if (!childAreas.isEmpty()) childAreas.remove(0);
		super.addChildArea(area);
	}
	
	@Override
	public void addNode(AbstractNode node){
		if (node instanceof Activity || node instanceof ActivityGroup)
			throw new IllegalArgumentException("An activity may not be in an influence Area!");
		super.addNode(node);
	}
	
	public ControlArea getControlArea(){
		return (ControlArea) getChildAreas().get(0);
	}

}
