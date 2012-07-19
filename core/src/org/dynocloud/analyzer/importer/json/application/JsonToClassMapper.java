package org.dynocloud.analyzer.importer.json.application;

import java.util.HashMap;
import java.util.Map;

import org.dynocloud.analyzer.domain.Activity;
import org.dynocloud.analyzer.domain.ActivityGroup;
import org.dynocloud.analyzer.domain.ControlArea;
import org.dynocloud.analyzer.domain.Division;
import org.dynocloud.analyzer.domain.Gateway;
import org.dynocloud.analyzer.domain.InfluenceArea;
import org.dynocloud.analyzer.domain.NoiseArea;
import org.dynocloud.analyzer.domain.Participant;
import org.dynocloud.analyzer.domain.ParticipantGroup;
import org.dynocloud.analyzer.domain.RootElement;

public class JsonToClassMapper {
	
	private final Map<String, Class<? extends RootElement>> map = new HashMap<>();
	
	{
		map.put("noiseArea", NoiseArea.class);
		map.put("influenceArea",InfluenceArea.class);
		map.put("controlArea", ControlArea.class);
		map.put("participant", Participant.class);
		map.put("participantGroup", ParticipantGroup.class);
		map.put("activity", Activity.class);
		map.put("activityGroup", ActivityGroup.class);
		map.put("division", Division.class);
		map.put("gateway", Gateway.class);
		map.put("superArrow", null); //TODO sich hier was ausdenken
		//TODO divisionGroup
	}
	
	public Class<? extends RootElement> getClass(String stencil){
		return map.get(stencil);
	}

}
