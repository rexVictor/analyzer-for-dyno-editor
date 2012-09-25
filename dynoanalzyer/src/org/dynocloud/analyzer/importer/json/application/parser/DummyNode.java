package org.dynocloud.analyzer.importer.json.application.parser;

import org.dynocloud.analyzer.domain.elements.AbstractNode;
import org.dynocloud.analyzer.domain.elements.ControlArea;
import org.dynocloud.analyzer.domain.elements.InfluenceArea;
import org.dynocloud.analyzer.domain.elements.Nester;

class DummyNode extends AbstractNode{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7319127761035919014L;
	
	public DummyNode(String resourceID, boolean controllable){
		setResourceId(resourceID);
		if (controllable)
			Nester.addChildNode(new ControlArea(), this);
		else
			Nester.addChildNode(new InfluenceArea(), this);
	}

}
