package org.dynocloud.analyzer.gui;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainFrame {
	
	private final JPanel panel = new JPanel();
	
	private final JMenuBar menuBar;
	
	private final JTabbedPane tabbedPane = new JTabbedPane();
	
	private final JFrame frame = new JFrame();

	public MainFrame(JMenuBar menuBar) {
		super();
		this.menuBar = menuBar;
		frame.setJMenuBar(menuBar);
		frame.setContentPane(panel);
		panel.setLayout(new BorderLayout());
		panel.add(tabbedPane, BorderLayout.CENTER);
		
	}
	
	public void addTab(String title, Component component){
		tabbedPane.add(title, component);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	
	
	
	
	
	
	
	
	

}
