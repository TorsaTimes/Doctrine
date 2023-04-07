package ctr;

public class Main {
private static A a0;
private static A a1;
public static void main(String[] args) {
	a0 = new A(0);
	a1 = new A(1);
	System.out.println(a0.getWert());
	System.out.println(a1.getWert());
	WertTausch t1 = new WertTausch(a0,a1);
	WertTausch t2 = new WertTausch(a0,a1);
	t1.start();
	t2.start();
	try {
		t1.join();//join () erlaubt es einem Thread (hier der main Thread) auf das Ende eines anderen Threads (hier
		//Thread t) zu warten
		//der main Thread pausiert in der join () Methode
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//new WertTausch(a0, a1).start(); // Thread X
	// WertTausch(a1, a0).start(); // Thread Y
			
	System.out.println("a0 =" + a0.getWert());
	System.out.println("a1 =" + a1.getWert());
}
}