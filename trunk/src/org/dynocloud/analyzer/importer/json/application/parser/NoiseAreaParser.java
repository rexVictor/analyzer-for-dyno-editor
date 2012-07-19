package org.dynocloud.analyzer.importer.json.application.parser;

public class NoiseAreaParser extends AbstractAreaParser{
	
	static{
		AbstractParser.register("noiseArea", new NoiseAreaParser());
	}
	
	private NoiseAreaParser(){
		
	}

}
