package org.dynocloud.analyzer.plugins;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.AbstractArea;
import org.dynocloud.analyzer.domain.elements.AbstractNode;
import org.dynocloud.analyzer.domain.elements.ControlArea;
import org.dynocloud.analyzer.domain.elements.MayBeBase;
import org.dynocloud.analyzer.domain.elements.NoiseArea;
import org.dynocloud.analyzer.domain.elements.RootElement;

public class AnalyzerEvent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3392206646027249279L;
	
	private final ShapeResolver resolver = null;;
	
	/*private final DirectedGraph<String, String>graph;*/
	
	/*private final DirectedGraph<String, String> gatewayFreeGraph;*/
	
	
	public static boolean isElementInControlArea(AbstractNode node){
		AbstractArea location = null;
		while (!((location = node.getLocation()) instanceof NoiseArea)){
			if (location instanceof ControlArea) return true;
		}
		return false;
	}
	
	{
		try {
			ObjectInputStream stream = new ObjectInputStream(null);
			AnalyzerEvent event = (AnalyzerEvent) stream.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
