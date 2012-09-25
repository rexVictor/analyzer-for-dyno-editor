package org.dynocloud.analyzer.importer.json.application.parser;

class NoiseAreaParser extends AbstractAreaParser{
	
	static{
		AbstractParser.register(StencilTypes.NOISE_AREA, new NoiseAreaParser());
	}
	
	private NoiseAreaParser(){
		
	}

}
