package ctr;

class Benutzer implements Runnable {
	Drucker drucker;
	String dateiname;
	int anzahl;

	Benutzer(Drucker drucker, String dateiname, int anzahl) {
		this.drucker = drucker;
		this.dateiname = dateiname;
		this.anzahl = anzahl;
	}

	public void run() {
		for (int i = 0; i < anzahl; i++) {
			drucker.druckeDatei(dateiname);
			Thread.yield();//mit yield () kann man auf einen anderen Thread umschalten, d.h. der Scheduler gibt
			//einem andern Thread die CPU
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}