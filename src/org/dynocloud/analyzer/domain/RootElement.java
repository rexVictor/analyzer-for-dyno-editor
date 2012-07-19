package org.dynocloud.analyzer.domain;

import java.io.Serializable;

public abstract class RootElement implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7415350946023460825L;

	private String name;
	
	private String id;
	
	private String resourceId;
	
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

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(": ");
		sb.append(name);
		sb.append("\n\t");
		sb.append("resourceID"+"\t:\t"+resourceId+"\n\t");
		sb.append("id"+"\t:\t"+id);
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	
	

}
