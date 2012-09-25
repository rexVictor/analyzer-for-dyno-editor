package org.dynocloud.analyzer.application;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarController{
	
	private final JMenuBar menubar = new JMenuBar();
	
	private final Map<String, JMenu> menus = new HashMap<String, JMenu>();

	public MenuBarController() {
		super();
	}
	
	public void addMenuItem(ActionListener listener, String menuName, String targetName){
		JMenu menu = menus.get(menuName);
		if (menu == null){
			menu = new JMenu(menuName);
			menus.put(menuName, menu);
			menubar.add(menu);
		}
		JMenuItem item = new JMenuItem(targetName);
		item.addActionListener(listener);
		menu.add(item);
	}
	
	public JMenuBar getMenuBar(){
		return menubar;
	}


		
	
	

}
