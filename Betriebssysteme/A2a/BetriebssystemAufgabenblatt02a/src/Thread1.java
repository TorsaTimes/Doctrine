

public class Thread1 extends Thread {
	
	private Speicherzelle A;
	private Speicherzelle B;

	public Thread1(Speicherzelle A, Speicherzelle B) {
		this.A = A;
		this.B = B;
	}

	public void run() {

		System.out.println ("Thread1: Aufruf A.m1 (B)");
		A.swapWert(B);

	}

}
