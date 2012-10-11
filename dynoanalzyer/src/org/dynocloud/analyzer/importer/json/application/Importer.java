package org.dynocloud.analyzer.importer.json.application;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.AbstractEdge;
import org.dynocloud.analyzer.domain.elements.AbstractNode;
import org.dynocloud.analyzer.domain.elements.Connector;
import org.dynocloud.analyzer.domain.elements.Gateway;
import org.dynocloud.analyzer.domain.elements.Influence;
import org.dynocloud.analyzer.domain.elements.NoiseArea;
import org.dynocloud.analyzer.domain.elements.RootElement;
import org.dynocloud.analyzer.importer.json.application.parser.AbstractParser;
import org.dynocloud.analyzer.importer.json.application.parser.DummySubstitutor;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Importer {
	
	private static int id = 0;
	
	public ShapeResolver importJson(File file) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> canvas = mapper.readValue(file, new TypeReference<Map<String, Object>>() {});
		return parse(canvas);
	}
	
	public ShapeResolver importJson(String string) throws JsonParseException, JsonMappingException, IOException{
		Calendar calendar = Calendar.getInstance();
		long begin = calendar.getTimeInMillis();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> canvas = mapper.readValue(string, new TypeReference<Map<String, Object>>() {});
		long end = calendar.getTimeInMillis();
		System.out.println(end-begin);
		
		return parse(canvas);
	}
	
	public DirectedGraph<String, String> buildGraph(ShapeResolver resolver){
		DirectedGraph<String, String> graph = new DefaultDirectedGraph<String, String>(String.class);
		for (RootElement element: resolver){
			if (element instanceof AbstractNode){
				graph.addVertex(element.getResourceId());
			}				
		}
		for (RootElement element: resolver){
			if (element instanceof AbstractEdge){
				AbstractEdge edge = (AbstractEdge) element;
				graph.addEdge(edge.getSource().getResourceId(), edge.getTarget().getResourceId(), edge.getResourceId());
			}
		}
		return graph;
	}
	
	public void removeGatewaysFrom(ShapeResolver resolver){
		List<Gateway> gateways = new LinkedList<Gateway>();
		for (RootElement element : resolver){
			if(element instanceof Gateway){
				gateways.add((Gateway) element);				
			}
		}
		for (Gateway gateway : gateways){
			resolver.removeElement(gateway);
			List<AbstractEdge> incomings = gateway.getIncoming();
			AbstractEdge outgoing = gateway.getOutgoing().get(0);
			AbstractNode target = outgoing.getTarget();
			resolver.removeElement(outgoing);
			List<AbstractNode> sources = new LinkedList<AbstractNode>();
			for (AbstractEdge edge : incomings){
				sources.add(edge.getSource());
				resolver.removeElement(edge);
			}
			incomings = new LinkedList<AbstractEdge>(incomings);
			for (AbstractEdge edge : incomings){
				Connector.unconnect(edge.getSource(), edge, edge.getTarget());
			}
			Connector.unconnect(gateway, outgoing, target);
			for (AbstractNode node : sources){
				Influence influence = new Influence();
				influence.setResourceId(id+"");
				resolver.addElement(influence);
				id++;
				Connector.connect(node, influence, target);
			}
		}
	}
	
	private ShapeResolver parse(Map<String, Object> canvas){
		String stencil = AbstractParser.getStencil(canvas);
		AbstractParser parser = AbstractParser.getParser(stencil);
		NoiseArea area = new NoiseArea();
		ShapeResolver resolver = new ShapeResolver();
		parser.parseMap(canvas, area, resolver);
		DummySubstitutor substitutor = new DummySubstitutor();
		substitutor.subsituteDummies(resolver);
		return resolver;
	}
}
