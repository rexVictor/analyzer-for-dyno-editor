package org.dynocloud.analyzer.application;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.AbstractEdge;
import org.dynocloud.analyzer.domain.elements.AbstractNode;
import org.dynocloud.analyzer.domain.elements.RootElement;
import org.dynocloud.analyzer.importer.json.application.Importer;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class JSONAnalyzing {

	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException{
		Importer importer = new Importer();
		File path = new File("testcases/testcase3.json");
		ShapeResolver resolver = importer.importJson(path);
		for (RootElement element : resolver){
			if (element instanceof AbstractNode){
				System.out.println(element.getClass().getSimpleName()+": "+element.getName());
				List<AbstractEdge> outgoing = ((AbstractNode) element).getOutgoing();
				System.out.print("\t"+"is source of connection with: ");
				for (AbstractEdge edge : outgoing){
					System.out.print(edge.getTarget().getName()+", ");
				}
				System.out.println();
			}
		}
		for (RootElement element : resolver){
			if (element instanceof AbstractNode){
				System.out.println(element.getClass().getSimpleName()+": "+element.getName());
				List<AbstractEdge> incoming = ((AbstractNode) element).getIncoming();
				System.out.print("\t"+"is target of connection with: ");
				for (AbstractEdge edge : incoming){
					System.out.print(edge.getSource().getName()+", ");
				}
				System.out.println();
			}
		}
		
		for (RootElement element : resolver){
			if (element instanceof AbstractEdge){
				AbstractEdge edge = (AbstractEdge) element;
				System.out.println(edge.getClass().getSimpleName()+" connects: "+edge.getSource().getName()+" and "+edge.getTarget().getName());
			}
		}
	}
	
	
}
