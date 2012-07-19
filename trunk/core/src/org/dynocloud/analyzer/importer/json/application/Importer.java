package org.dynocloud.analyzer.importer.json.application;

import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.dynocloud.analyzer.domain.NoiseArea;
import org.dynocloud.analyzer.importer.json.application.parser.AbstractParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Importer {
	
	private List<Map<String, Object>> protoShapes = new LinkedList<>();
	
	private final JsonToClassMapper classes = new JsonToClassMapper();
	
	private NoiseArea area = new NoiseArea();
	
	public NoiseArea importJson(Path path) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> canvas = mapper.readValue(path.toFile(), new TypeReference<Map<String, Object>>() {});
		String stencil = AbstractParser.getStencil(canvas);
		System.out.println(stencil);
		AbstractParser parser = AbstractParser.getParser(stencil);
		NoiseArea area = new NoiseArea();
		parser.parseMap(canvas, area);
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private String getStencilId(Map<String, Object> protoShape){
		return ((Map<String, String>) protoShape.get("stencil")).get("id");
	}
	
	
	
	private void parse(){
		
	}

}
