public class Thread2 extends Thread {

	private Speicherzelle A;
	private Speicherzelle B;

	public Thread2(Speicherzelle A, Speicherzelle B) {
		this.A = A;
		this.B = B;
	}


	public void run() {

		System.out.println ("Thread2: Aufruf B.m1 (A)");
		A.swapWert(B);

	}

}
