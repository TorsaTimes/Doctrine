package ctr;

public class A {
	private int wert;
	private static Object o = new Object();

	public int getWert() {
		return wert;
	}

	public A(int startWert) {
		wert = startWert;
	}

	public  void tausche(A a) {
		synchronized (o) {

			int h = wert;

			wert = a.wert;

			a.wert = h;

		}
	}
}
