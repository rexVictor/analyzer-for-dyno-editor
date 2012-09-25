package org.dynocloud.analyzer.importer.json.application.parser;

class GatewayParser extends AbstractNodeParser{
	
	static{
		AbstractParser.register(StencilTypes.GATEWAY, new GatewayParser());
	}
	
	private GatewayParser(){
		
	}

}
