package ctr;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class Leser extends Thread {

	public Speicher speicherLeser;
	public ReentrantReadWriteLock.ReadLock lockLeser;

	Leser(Speicher speicher, ReentrantReadWriteLock.ReadLock lock) {
		this.lockLeser = lock;
		this.speicherLeser = speicher;
	}

	public void run() {

		for (int y = 0; y < 8; y++) {
			lockLeser.lock();
			speicherLeser.leserRein();
			if (speicherLeser.readLine(y) != null) {
				System.out.println("Leser Ausgabe: " + speicherLeser.readLine(y));
			}
			speicherLeser.leserRaus();
			lockLeser.unlock();

		}

	}
}
