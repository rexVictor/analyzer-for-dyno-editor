package org.dynocloud.analyzer.importer.json.application.parser;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.Activity;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This unit test checks, if name, resource id and base value attribute are correctly imported from an activity coded in JSON.
 * @author rex
 *
 */

public class ActivityParserTest {

	@Test
	public void test1() throws JsonParseException, JsonMappingException, IOException {
		Path testcase = Paths.get("testcases", "activities","testcase1.json");
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> protoactivity = mapper.readValue(testcase.toFile(), new TypeReference<Map<String, Object>>() {});
		Activity activity = new Activity();
		ActivityParser parser = (ActivityParser) AbstractParser.getParser("activity");
		ShapeResolver resolver = new ShapeResolver();
		parser.parseMap(protoactivity, activity, resolver);
		assertEquals("Name", activity.getName());
		assertEquals("resourceId", activity.getResourceId());
		assertEquals(false, activity.isBaseValue());
	}
	
	@Test
	public void test2() throws JsonParseException, JsonMappingException, IOException {
		Path testcase = Paths.get("testcases", "activities","testcase2.json");
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> protoactivity = mapper.readValue(testcase.toFile(), new TypeReference<Map<String, Object>>() {});
		Activity activity = new Activity();
		ActivityParser parser = (ActivityParser) AbstractParser.getParser("activity");
		ShapeResolver resolver = new ShapeResolver();
		parser.parseMap(protoactivity, activity, resolver);
		assertEquals("Activity", activity.getName());
		assertEquals("resource-id123", activity.getResourceId());
		assertEquals(true, activity.isBaseValue());
	}
	
	@Test
	public void test3() throws JsonParseException, JsonMappingException, IOException {
		Path testcase = Paths.get("testcases", "activities","testcase3.json");
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> protoactivity = mapper.readValue(testcase.toFile(), new TypeReference<Map<String, Object>>() {});
		Activity activity = new Activity();
		ActivityParser parser = (ActivityParser) AbstractParser.getParser("activity");
		ShapeResolver resolver = new ShapeResolver();
		parser.parseMap(protoactivity, activity, resolver);
		assertEquals("Some Name", activity.getName());
		assertEquals("some!id", activity.getResourceId());
		assertEquals(false, activity.isBaseValue());
	}

}
