package org.dynocloud.analyzer.importer.json.application.parser;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.Participant;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * This unit test checks, if name, resource id and base value attribute are correctly imported from a participant coded in JSON.
 * @author rex
 *
 */
public class ParticipantParserTest {

	@Test
	public void test1() throws JsonParseException, JsonMappingException, IOException {
		Path testcase = Paths.get("testcases", "participants","testcase1.json");
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> protoParticipant = mapper.readValue(testcase.toFile(), new TypeReference<Map<String, Object>>() {});
		Participant participant = new Participant();
		ParticipantParser parser = (ParticipantParser) AbstractParser.getParser("participant");
		ShapeResolver resolver = new ShapeResolver();
		parser.parseMap(protoParticipant, participant, resolver);
		assertEquals("Name", participant.getName());
		assertEquals("resourceId", participant.getResourceId());
		assertEquals(false, participant.isBaseValue());	
	}
	
	@Test
	public void test2() throws JsonParseException, JsonMappingException, IOException {
		Path testcase = Paths.get("testcases", "participants","testcase2.json");
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> protoParticipant = mapper.readValue(testcase.toFile(), new TypeReference<Map<String, Object>>() {});
		Participant participant = new Participant();
		ParticipantParser parser = (ParticipantParser) AbstractParser.getParser("participant");
		ShapeResolver resolver = new ShapeResolver();
		parser.parseMap(protoParticipant, participant, resolver);
		assertEquals("Participant", participant.getName());
		assertEquals("resource-id123", participant.getResourceId());
		assertEquals(true, participant.isBaseValue());	
	}
	
	@Test
	public void test3() throws JsonParseException, JsonMappingException, IOException {
		Path testcase = Paths.get("testcases", "participants","testcase3.json");
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> protoParticipant = mapper.readValue(testcase.toFile(), new TypeReference<Map<String, Object>>() {});
		Participant participant = new Participant();
		ParticipantParser parser = (ParticipantParser) AbstractParser.getParser("participant");
		ShapeResolver resolver = new ShapeResolver();
		parser.parseMap(protoParticipant, participant, resolver);
		assertEquals("Some Name", participant.getName());
		assertEquals("some!id", participant.getResourceId());
		assertEquals(false, participant.isBaseValue());	
	}

}
