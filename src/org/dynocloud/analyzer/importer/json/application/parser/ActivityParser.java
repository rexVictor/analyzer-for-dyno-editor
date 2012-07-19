package org.dynocloud.analyzer.importer.json.application.parser;

public class ActivityParser extends AbstractNodeParser{
	
	static{
		register("activity", new ActivityParser());
	}
	
	private ActivityParser(){
		
	}

}
