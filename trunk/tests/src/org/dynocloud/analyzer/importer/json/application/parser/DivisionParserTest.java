package org.dynocloud.analyzer.importer.json.application.parser;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.AbstractNode;
import org.dynocloud.analyzer.domain.elements.Activity;
import org.dynocloud.analyzer.domain.elements.Division;
import org.dynocloud.analyzer.domain.elements.Participant;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DivisionParserTest {

	@Test
	public void testParseMap1() throws Throwable{
		File file = new File("testcases/divisions/testcase1.json");
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> protoDivision = mapper.readValue(file, new TypeReference<Map<String, Object>>(){});
		Division division = new Division();
		DivisionParser parser = (DivisionParser) AbstractParser.getParser("division");
		ShapeResolver resolver = new ShapeResolver();
		parser.parseMap(protoDivision, division, resolver);
		assertEquals("resourceId", division.getResourceId());
		assertEquals("DivisionName", division.getName());
		assertEquals(false, division.isScalable());
	}
	
	@Test
	public void testParseMap2() throws Throwable{
		File file = new File("testcases/divisions/testcase2.json");
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> protoDivision = mapper.readValue(file, new TypeReference<Map<String, Object>>(){});
		Division division = new Division();
		DivisionParser parser = (DivisionParser) AbstractParser.getParser("division");
		ShapeResolver resolver = new ShapeResolver();
		parser.parseMap(protoDivision, division, resolver);
		assertEquals("resID", division.getResourceId());
		assertEquals("some Name", division.getName());
		assertEquals(false, division.isScalable());
	}
	
	@Test
	public void testParseMap3() throws Throwable{
		File file = new File("testcases/divisions/testcase3.json");
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> protoDivision = mapper.readValue(file, new TypeReference<Map<String, Object>>(){});
		Division division = new Division();
		DivisionParser parser = (DivisionParser) AbstractParser.getParser("division");
		ShapeResolver resolver = new ShapeResolver();
		parser.parseMap(protoDivision, division, resolver);
		assertEquals("test-ID", division.getResourceId());
		assertEquals("TEST-NAME", division.getName());
		assertEquals(true, division.isScalable());
	}
	
	@Test
	public void testParseMap4() throws Throwable{
		File file = new File("testcases/divisions/testcase4.json");
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> protoDivision = mapper.readValue(file, new TypeReference<Map<String, Object>>(){});
		Division division = new Division();
		DivisionParser parser = (DivisionParser) AbstractParser.getParser("division");
		ShapeResolver resolver = new ShapeResolver();
		parser.parseMap(protoDivision, division, resolver);
		assertEquals("division", division.getResourceId());
		assertEquals("Division", division.getName());
		assertEquals(false, division.isScalable());
		List<AbstractNode> children = division.getChildNodes();
		assertEquals(2, children.size());
		AbstractNode first = children.get(0);
		AbstractNode second = children.get(1);
		assertTrue(first instanceof Activity);
		assertTrue(second instanceof Participant);
		
	}

}
