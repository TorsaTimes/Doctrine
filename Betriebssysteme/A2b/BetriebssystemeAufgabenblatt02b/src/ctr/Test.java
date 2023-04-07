package ctr;

public class Test {

	public static void main(String[] args) {
		ActionListenerImpl1 a1 = new ActionListenerImpl1();
		ActionListenerImpl2 a2 = new ActionListenerImpl2();
		
		EventDispatcherImpl e = new EventDispatcherImpl();
		e.addActionListener(a1);
		e.addActionListener(a2);
		e.processActionEvent(null);
	}

}
