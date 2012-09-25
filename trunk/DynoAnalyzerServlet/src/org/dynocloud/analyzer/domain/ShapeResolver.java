package org.dynocloud.analyzer.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dynocloud.analyzer.domain.elements.RootElement;

public class ShapeResolver implements Iterable<RootElement>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6348882860271257042L;
	
	private final Map<String, RootElement> elements = new HashMap<String, RootElement>();
	
	public void addElement(RootElement element){
		elements.put(element.getResourceId(), element);
		
	}
	
	public RootElement getElement(String resourceID){
		return elements.get(resourceID);
	}
	
	@Override
	public String toString(){
		return elements.toString();
	}

	public Iterator<RootElement> iterator() {
		return elements.values().iterator();		
	}

}
