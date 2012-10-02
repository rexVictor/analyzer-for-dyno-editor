package org.dynocloud.analyzer.importer.json.application.parser;

class InfluenceAreaParser extends AbstractAreaParser{
	
	static{
		InfluenceAreaParser parser = new InfluenceAreaParser();
		AbstractParser.register(StencilTypes.INFLUENCE_AREA, parser);
		AbstractParser.register("InfluenceArea", parser);
	}
	
	private InfluenceAreaParser(){
		
	}

}
