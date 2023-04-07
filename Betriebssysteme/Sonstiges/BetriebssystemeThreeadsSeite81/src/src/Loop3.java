package src;

public class Loop3 extends Thread {

	public
	Loop3(String name) {
	super(name);
	}

	public void run() { 
	for(int i = 1;i<=100;i++){
	System.out.println(getName() + " (" + i + ")");
	
	}
	}

	public static void main(String[] args) {
//		Loop3 t1 =
//				new Loop3("Thread 1");
//				Loop3 t2 =
//				new Loop3("Thread 2");
//				Loop3 t3 =
//				new Loop3("Thread 3");
//				t1.start();
//				t2.start();
//				t3.start();
		
		
		Prozess p1 = new Prozess(200,20);
		p1.prozessDurchlaufen(0.5, 20);
		

	}

}
