package org.dynocloud.analyzer.importer.json.application.parser;

public class InfluenceAreaParser extends AbstractAreaParser{
	
	static{
		AbstractParser.register("influenceArea", new InfluenceAreaParser());
	}
	
	private InfluenceAreaParser(){
		
	}

}
