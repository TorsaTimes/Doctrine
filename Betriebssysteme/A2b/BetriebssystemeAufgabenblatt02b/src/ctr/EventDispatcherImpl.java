package ctr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EventDispatcherImpl implements EventDispatcher {

	private ArrayList<ActionListener> liste = new ArrayList<ActionListener>();
	
	@Override
	public void addActionListener(ActionListener al) {
		liste.add(al);
		
	}

	@Override
	public void processActionEvent(ActionEvent ae) {
		for(ActionListener a : liste) {
			new Thread(){//b.4
				public void run() {//b.4
					synchronized(a){//b.6
					a.actionPerformed(ae);
					}//b.6
				}//b.4
				}.start();//b.4
			}
	}

	
	
	
	
}
