package org.dynocloud.analyzer.importer.json.application.parser;

class InfluenceAreaParser extends AbstractAreaParser{
	
	static{
		AbstractParser.register(StencilTypes.INFLUENCE_AREA, new InfluenceAreaParser());
	}
	
	private InfluenceAreaParser(){
		
	}

}
