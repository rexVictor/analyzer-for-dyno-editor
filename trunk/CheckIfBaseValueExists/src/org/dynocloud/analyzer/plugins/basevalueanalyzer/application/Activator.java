package org.dynocloud.analyzer.plugins.basevalueanalyzer.application;

import org.dynocloud.analyzer.core.plugin.api.ActivatorAPI;
import org.dynocloud.analyzer.core.plugin.api.ManagerAPI;

public class Activator implements ActivatorAPI{

	@Override
	public void setManager(ManagerAPI manager) {
		manager.registerDYNOEventListener(new BaseValueAnalyzer());		
	}

}
