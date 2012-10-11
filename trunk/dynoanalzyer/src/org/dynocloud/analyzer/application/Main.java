package org.dynocloud.analyzer.application;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.dynocloud.analyzer.plugins.Manager;

import edu.kit.dynocloud.graph.centrality.plugins.Activator;

public class Main {
	public static void main(String[] args){
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Manager manager = new Manager();
		Activator activator = new Activator();
		activator.setManager(manager);
		new GeneralController(manager);
	}

}