package org.dynocloud.analyzer.core.plugin.api;

public interface ManagerAPI {
	
	public void registerDYNOEventListener(DYNOEventListener listener);
	
	public void unregisterDYNOEventListener(DYNOEventListener listener);

}
