package org.dynocloud.analyzer.application;

import org.dynocloud.analyzer.plugins.Manager;

import edu.kit.dynocloud.graph.centrality.plugins.Activator;

public class Main {
	
	public static void main(String[] args){
		Manager manager = new Manager();
		Activator activator = new Activator();
		activator.setManager(manager);
		new GeneralController(manager);
	}

}
