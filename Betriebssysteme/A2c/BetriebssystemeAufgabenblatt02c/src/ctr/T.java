package ctr;

class T extends Thread {
	private static int counter = 0;
	T() {
		start();
	}

	public void run() {
		//System.out.println("THREADRUN:" + Thread.currentThread());
		T.main(null);
	}

	public static void main(String[] argv) {
		new T();
		counter++;
		System.out.println(counter);
		//counter--;
	}
}