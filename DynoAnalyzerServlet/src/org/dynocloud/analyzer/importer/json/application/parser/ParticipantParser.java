package org.dynocloud.analyzer.importer.json.application.parser;

import java.util.Map;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.MayBeBase;
import org.dynocloud.analyzer.domain.elements.RootElement;

class ParticipantParser extends AbstractNodeParser{
	
	static{
		AbstractParser.register(StencilTypes.PARTICIPANT, new ParticipantParser());
	}
	
	@Override
	public void parseMap(Map<String, Object> map, RootElement root, ShapeResolver resolver){
		super.parseMap(map, root, resolver);
		MayBeBaseParser parser = new MayBeBaseParser();
		parser.parse((MayBeBase) root, map);
	}
	
	private ParticipantParser(){
		
	}

}
