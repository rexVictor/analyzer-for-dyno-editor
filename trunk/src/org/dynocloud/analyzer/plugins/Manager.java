package org.dynocloud.analyzer.plugins;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.dynocloud.analyzer.core.plugin.api.DYNOEventAPI;
import org.dynocloud.analyzer.core.plugin.api.DYNOEventListener;
import org.dynocloud.analyzer.core.plugin.api.ManagerAPI;

public class Manager implements ManagerAPI, DYNOEventListener{
	
	private final List<DYNOEventListener> listeners = new LinkedList<DYNOEventListener>();
	
	private final Lock lock = new ReentrantLock();

	@Override
	public void registerDYNOEventListener(DYNOEventListener listener) {
		lock.lock();		
		try{			
			listeners.add(listener);
		}
		finally{
			lock.unlock();
		}
		
	}

	@Override
	public void unregisterDYNOEventListener(DYNOEventListener listener) {
		lock.lock();
		try{
			listeners.remove(listener);
		}
		finally{
			lock.unlock();
		}
		
	}

	@Override
	public void documentOpened(DYNOEventAPI event) {
		lock.lock();
		try{
			for(DYNOEventListener listener : listeners){
				listener.documentOpened(event);
			}
		}
		finally{
			lock.unlock();
		}
		
	}

}
