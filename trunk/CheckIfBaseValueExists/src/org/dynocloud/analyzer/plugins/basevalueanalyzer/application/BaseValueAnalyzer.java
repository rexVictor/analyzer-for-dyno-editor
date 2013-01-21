package org.dynocloud.analyzer.plugins.basevalueanalyzer.application;

import javax.swing.JLabel;

import org.dynocloud.analyzer.core.plugin.api.DYNOEventAPI;
import org.dynocloud.analyzer.core.plugin.api.DYNOEventListener;
import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.domain.elements.MayBeBase;
import org.dynocloud.analyzer.domain.elements.RootElement;

public class BaseValueAnalyzer implements DYNOEventListener{

	@Override
	public void documentOpened(DYNOEventAPI event) {
		ShapeResolver resolver = event.getShapeResolver();
		boolean baseValueExists = false;
		for (RootElement element : resolver){
			if (element instanceof MayBeBase)
				if (((MayBeBase) element).isBaseValue()) {
					baseValueExists = true;
					break;
				}
		}
		JLabel label = new JLabel();
		if (baseValueExists){
			label.setText("There is a base value set!");
		}
		else{
			label.setText("There is no base value set!");
		}
		event.getGUIComponent().add(label);
		//System.out.println("Plugin: "+event.getShapeResolver());		
	}

}
