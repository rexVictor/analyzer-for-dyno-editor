package org.dynocloud.analyzer.importer.json.application.parser;

import java.util.HashMap;
import java.util.Map;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.RootElement;


public abstract class AbstractParser {
	
	private static final Map<String, AbstractParser> registeredParsers = new HashMap<String, AbstractParser>();
	
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
			Class.forName(InfluenceParser.class.getName());
			Class.forName(TransactionParser.class.getName());
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
	
	public abstract void parseMap(Map<String, Object> map, RootElement element, ShapeResolver resolver);
	
	@SuppressWarnings("unchecked")
	public static String getStencil(Map<String, Object> map){
		String id = (String) ((Map<String, Object>) map.get(JSONConsts.STENCIL)).get(JSONConsts.ID);
		if (JSONConsts.EDGE_TYPE.equals(id)){
			id = ((Map<String, String>) map.get(JSONConsts.PROPERTIES)).get(JSONConsts.NAME);			
		}
		return id;
		
	}
	
	
	
	

}
