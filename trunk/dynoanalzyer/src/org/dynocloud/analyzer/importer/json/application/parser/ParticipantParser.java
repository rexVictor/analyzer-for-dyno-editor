package org.dynocloud.analyzer.importer.json.application.parser;

import java.util.Map;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.MayBeBase;
import org.dynocloud.analyzer.domain.elements.Participant;
import org.dynocloud.analyzer.domain.elements.ParticipantGroup;
import org.dynocloud.analyzer.domain.elements.RootElement;

class ParticipantParser extends AbstractNodeParser{
	
	static{
		ParticipantParser parser = new ParticipantParser();
		register(StencilTypes.PARTICIPANT, parser);
		register(StencilTypes.PARTICIPANT_GROUP, parser);
	}
	
	@Override
	public void parseMap(Map<String, Object> map, RootElement root, ShapeResolver resolver){
		if (root instanceof ParticipantGroup || root instanceof Participant){
			super.parseMap(map, root, resolver);
			MayBeBaseParser parser = new MayBeBaseParser();
			parser.parse((MayBeBase) root, map);
		}	
	}
	
	private ParticipantParser(){
		
	}

}
