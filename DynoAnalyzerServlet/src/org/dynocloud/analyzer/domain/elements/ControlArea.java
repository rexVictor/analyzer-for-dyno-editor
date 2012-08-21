package org.dynocloud.analyzer.domain.elements;

public class ControlArea extends AbstractArea{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7280861099576967154L;
	
	@Override
	public void setParent(AbstractArea area){
		if (!(area instanceof InfluenceArea))
			throw new IllegalArgumentException("The parent area of a control area must be an influence area!");
		super.setParent(area);
	}
	
	@Override
	public void addChildArea(AbstractArea area){
		if (!(area instanceof IDivision))
			throw new IllegalArgumentException("The child area of a control area must be a division or a division group!");
		super.addChildArea(area);
	}
	
	@Override
	public void addNode(AbstractNode node){
		if (node instanceof Gateway)
			throw new IllegalArgumentException("A gateway cannot be in the control Area!");
		super.addNode(node);
	}

}
