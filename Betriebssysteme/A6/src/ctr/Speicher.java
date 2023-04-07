package ctr;

import java.util.LinkedList;


class Speicher extends LinkedList<String> { 
	
	private int schreiberThreadAnzahl;
	private int leserThreadAnzahl;
	
	
	void writeLine(String zeile) {
		schreiberRein();
		try {
			Thread.sleep((int)(Math.random()*2000));
			this.add(zeile);
		}
		catch(InterruptedException e) {
			System.out.println(e);
		}
		schreiberRaus();
	} 
	

	String readLine(int zeilenNummer) {
		try {
			Thread.sleep((int)(Math.random()*2000));
		}
		catch(InterruptedException e) {
			System.out.println(e);
		}
		return this.get(zeilenNummer);	
	}
	
	synchronized void schreiberRein() {
		schreiberThreadAnzahl++;
		System.out.println("Anzahl der Schreiber: " + schreiberThreadAnzahl);
	}
	

	synchronized void schreiberRaus() {
		schreiberThreadAnzahl--;
		System.out.println("Anzahl der Schreiber: " + schreiberThreadAnzahl);

	}
	

	synchronized void leserRein() {
		leserThreadAnzahl++;
		System.out.println("Anzahl der Leser: " + leserThreadAnzahl);
	}

	
	synchronized void leserRaus() {
		leserThreadAnzahl--;
		System.out.println("Anzahl der Leser: " + leserThreadAnzahl);
	}
	
	
}