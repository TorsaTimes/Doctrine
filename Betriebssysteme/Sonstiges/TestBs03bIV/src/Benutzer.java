import java.util.concurrent.Semaphore;//Semaphor == Schranke

class Benutzer implements Runnable {

	Semaphore s = new Semaphore(1);
	Drucker drucker;
	String dateiname;
	int anzahl;

	Benutzer(Drucker drucker, String dateiname, int anzahl) {
		this.drucker = drucker;
		this.dateiname = dateiname;
		this.anzahl = anzahl;
	}

	public void run() {
		
		try {
			s.acquire();//setzt die Schranke f�r den n�chsten Thread
	
		
		for (int i = 0; i < anzahl; i++) {

				drucker.druckeDatei(dateiname);	
				
		}
		s.release();//l�st die Schranke
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
