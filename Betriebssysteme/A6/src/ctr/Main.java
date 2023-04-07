package ctr;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

	public static void main(String[] args) {
		
		
		String[] text1 = {"text 1: Zeile 1", "text 1: Zeile 2"};
		String[] text2 = {"text 2: Zeile 1", "text 2: Zeile 2"};

		
		Speicher speicher1 = new Speicher();
		
		ReentrantReadWriteLock lock1 =  new ReentrantReadWriteLock();
		
		
		Schreiber schreiber1 = new Schreiber(speicher1, text1, 2, lock1.writeLock());
		Schreiber schreiber2 = new Schreiber(speicher1, text2, 2, lock1.writeLock());
		Leser leser1 = new Leser(speicher1, lock1.readLock());
		Leser leser2 = new Leser(speicher1, lock1.readLock());
		

		schreiber1.start();
		schreiber2.start();
		leser1.start();
		leser2.start();
		

	}

}
