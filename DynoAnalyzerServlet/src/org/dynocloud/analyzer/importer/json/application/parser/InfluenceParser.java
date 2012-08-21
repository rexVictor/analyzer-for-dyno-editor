package org.dynocloud.analyzer.importer.json.application.parser;

class InfluenceParser extends AbstractEdgeParser{
	
	static{
		AbstractParser.register(StencilTypes.INFLUENCE, new InfluenceParser());
	}
	
	private InfluenceParser(){
		
	}

}
