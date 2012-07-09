package org.dynocloud.analyzer.domain;

import java.io.Serializable;

public abstract class RootElement implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7415350946023460825L;

	private String name;
	
	private String id;
	
	protected RootElement() {
		super();
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	
	
	
	

}
