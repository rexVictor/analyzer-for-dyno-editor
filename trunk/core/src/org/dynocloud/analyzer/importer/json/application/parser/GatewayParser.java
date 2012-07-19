package org.dynocloud.analyzer.importer.json.application.parser;

public class GatewayParser extends AbstractNodeParser{
	
	static{
		AbstractParser.register("gateway", new GatewayParser());
	}
	
	private GatewayParser(){
		
	}

}
