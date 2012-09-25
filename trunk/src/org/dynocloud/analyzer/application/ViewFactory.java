package org.dynocloud.analyzer.application;

import javax.swing.JFrame;

import org.dynocloud.analyzer.gui.MainFrame;

public class ViewFactory {
	
	
	
	public ViewFactory(){
		
	}
	
	public MainFrame buildFrame(GeneralController generalController){
		MenuBarController controller = new MenuBarController();
		new OpenMenuItem(controller, generalController);
		MainFrame frame = new MainFrame(controller.getMenuBar());
		frame.getFrame().setSize(500, 100);
		frame.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getFrame().setVisible(true);
		return frame;
	}
	
	
}
