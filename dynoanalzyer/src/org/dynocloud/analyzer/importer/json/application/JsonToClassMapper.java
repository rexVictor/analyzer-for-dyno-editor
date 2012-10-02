package org.dynocloud.analyzer.importer.json.application;

import java.util.HashMap;
import java.util.Map;

import org.dynocloud.analyzer.domain.elements.Activity;
import org.dynocloud.analyzer.domain.elements.ActivityGroup;
import org.dynocloud.analyzer.domain.elements.ControlArea;
import org.dynocloud.analyzer.domain.elements.Division;
import org.dynocloud.analyzer.domain.elements.Gateway;
import org.dynocloud.analyzer.domain.elements.Influence;
import org.dynocloud.analyzer.domain.elements.InfluenceArea;
import org.dynocloud.analyzer.domain.elements.NoiseArea;
import org.dynocloud.analyzer.domain.elements.Participant;
import org.dynocloud.analyzer.domain.elements.ParticipantGroup;
import org.dynocloud.analyzer.domain.elements.RootElement;
import org.dynocloud.analyzer.domain.elements.Transaction;

public class JsonToClassMapper {
	
	private final Map<String, Class<? extends RootElement>> map = new HashMap<String, Class<? extends RootElement>>();
	
	{
		map.put("noiseArea", NoiseArea.class);
		map.put("influenceArea",InfluenceArea.class);
		map.put("InfluenceArea", InfluenceArea.class);
		map.put("controlArea", ControlArea.class);
		map.put("participant", Participant.class);
		map.put("participantGroup", ParticipantGroup.class);
		map.put("activity", Activity.class);
		map.put("activityGroup", ActivityGroup.class);
		map.put("division", Division.class);
		map.put("gateway", Gateway.class);
		map.put("Influence", Influence.class);
		map.put("Transaction", Transaction.class);
		//TODO divisionGroup
	}
	
	public Class<? extends RootElement> getClass(String stencil){
		return map.get(stencil);
	}

}
