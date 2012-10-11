package org.dynocloud.analyzer.application;

import java.awt.Container;
import java.io.File;

import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.gui.MainFrame;
import org.dynocloud.analyzer.importer.json.application.Importer;
import org.dynocloud.analyzer.plugins.DYNOEvent;
import org.dynocloud.analyzer.plugins.Manager;
import org.jgrapht.DirectedGraph;

public class GeneralController {
	
	private final MainFrame mainFrame;
	
	private final Importer importer = new Importer();
	
	private final Manager manager;
	
	public GeneralController(Manager manager){
		this.manager = manager;	
		ViewFactory factory = new ViewFactory();
		mainFrame = factory.buildFrame(this);
	}
	
	
	
	public void open(File file){
		try{
			ShapeResolver resolver = importer.importJson(file);
			ShapeResolver resolverWithoutGateways = resolver.clone();
			importer.removeGatewaysFrom(resolverWithoutGateways);
			DirectedGraph<String, String> graph = importer.buildGraph(resolver);
			DirectedGraph<String, String> graphWithoutGateways = importer.buildGraph(resolverWithoutGateways);
			DocumentController controller = new DocumentController();
			Container component = controller.getView();
			mainFrame.addTab("Titel einfügen", component);
			DYNOEvent dynoEvent = new DYNOEvent(resolver, resolverWithoutGateways, graph, graphWithoutGateways, component);
			manager.documentOpened(dynoEvent);
		}
		catch (Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args){
		new GeneralController(null);
	}

}
