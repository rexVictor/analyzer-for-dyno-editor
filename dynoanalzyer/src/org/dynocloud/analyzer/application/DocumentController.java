package org.dynocloud.analyzer.application;

import java.awt.Component;
import java.awt.FlowLayout;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DocumentController {
	
	private final JPanel view = new JPanel();
	
	private final JScrollPane scrollPanel = new JScrollPane(view);
	
	private final Lock lock = new ReentrantLock();
	
	
	public DocumentController(){
		view.setLayout(new FlowLayout());
	}
	
	public void addComponent(Component component){
		lock.lock();
		try{
			view.add(component);
		}
		finally{
			lock.unlock();
		}
	}
	
	public JScrollPane getJScrollPane(){
		return scrollPanel;
	}
	
	public JPanel getView(){
		return view;
	}

}
