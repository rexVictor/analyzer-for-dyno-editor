package org.dynocloud.analyzer.importer.json.application.parser;

public class ParticipantParser extends AbstractNodeParser{
	
	static{
		AbstractParser.register("participant", new ParticipantParser());
	}
	
	private ParticipantParser(){
		
	}

}
