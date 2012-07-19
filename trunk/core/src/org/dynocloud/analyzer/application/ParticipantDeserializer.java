package org.dynocloud.analyzer.application;

import java.io.IOException;

import org.dynocloud.analyzer.domain.Participant;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class ParticipantDeserializer extends StdDeserializer<Participant>{
	
	public ParticipantDeserializer(){
		super(Participant.class);
	}

	@Override
	public Participant deserialize(JsonParser arg0, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		Participant participant = new Participant();
		
		// TODO Auto-generated method stub
		return null;
	}

}
