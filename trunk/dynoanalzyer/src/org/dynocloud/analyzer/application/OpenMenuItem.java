package org.dynocloud.analyzer.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;



public class OpenMenuItem implements ActionListener{
	
	private final JFileChooser chooser = new JFileChooser(new File("/home/rex_victor/workspace/tests/testcases"));
	
	private final GeneralController controller;

	
	public OpenMenuItem(MenuBarController controller, GeneralController generalController){
		controller.addMenuItem(this, "File", "Open...");
		this.controller = generalController;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		chooser.showOpenDialog(null);
		File file = chooser.getSelectedFile();
		controller.open(file); 
	}
	
	

}
