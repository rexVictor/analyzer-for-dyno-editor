package org.dynocloud.analyzer.importer.json.application.parser;

import java.util.HashMap;
import java.util.Map;

import org.dynocloud.analyzer.domain.NoiseArea;
import org.dynocloud.analyzer.domain.RootElement;


public abstract class AbstractParser {
	
	private static final Map<String, AbstractParser> registeredParsers = new HashMap<>();
	
	static{
		
		try {
			Class.forName(NoiseAreaParser.class.getName());
			Class.forName(ParticipantParser.class.getName());
			Class.forName(ActivityParser.class.getName());
			Class.forName(NoiseAreaParser.class.getName());
			Class.forName(InfluenceAreaParser.class.getName());
			Class.forName(ControlAreaParser.class.getName());
			Class.forName(ParticipantParser.class.getName());
			Class.forName(GatewayParser.class.getName());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void register(String key, AbstractParser parser){
		registeredParsers.put(key, parser);
	}
	
	public static AbstractParser getParser(String key){
		return registeredParsers.get(key);
	}
	
	protected AbstractParser(){
		
	}
	
	public abstract void parseMap(Map<String, Object> map, RootElement element);
	
	@SuppressWarnings("unchecked")
	public static String getStencil(Map<String, Object> map){
		return (String) ((Map<String, Object>) map.get("stencil")).get("id");
	}
	
	
	
	

}
