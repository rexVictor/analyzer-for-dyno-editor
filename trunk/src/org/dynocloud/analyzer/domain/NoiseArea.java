package org.dynocloud.analyzer.domain;

import java.util.List;

public class NoiseArea extends AbstractArea{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7582843274295745374L;
	
	@Override
	public void setParent(AbstractArea area){
		throw new UnsupportedOperationException("The noise area cannot have a parent!");
	}
	
	@Override
	public void addNode(AbstractNode node){
		if (!(node instanceof Participant)){
			throw new IllegalArgumentException("You can only put participants in the noise Area!");
		}
		super.addNode(node);
	}
	
	@Override
	public void addChildArea(AbstractArea area){
		if (!(area instanceof InfluenceArea))
			throw new IllegalArgumentException("The child area of the noise area must be the influence Area!");
		List<AbstractArea> childAreas = getChildAreas();
		if (!(childAreas.isEmpty())) childAreas.remove(0);
		super.addChildArea(area);		
	}
	
	public InfluenceArea getInfluenceArea(){
		return (InfluenceArea) getChildAreas().get(0);
	}

}
