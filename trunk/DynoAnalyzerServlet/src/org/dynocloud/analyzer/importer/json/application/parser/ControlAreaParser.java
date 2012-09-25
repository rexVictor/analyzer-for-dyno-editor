package org.dynocloud.analyzer.importer.json.application.parser;

class ControlAreaParser extends AbstractAreaParser{
	
	static{
		register(StencilTypes.CONTROL_AREA, new ControlAreaParser());
		
	}
	
	private ControlAreaParser(){
		
	}

}
