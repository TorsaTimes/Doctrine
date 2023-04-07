package com.example.uidesign04;

import java.util.Iterator;
import java.util.Scanner;

public class SachbearbeiterK {

	
	
	
	public SachbearbeiterEK controll(String benutzername, String passwort) {
		int anmeldeVersuche = 0;
		while(anmeldeVersuche != 3){
		anmeldeVersuche = anmeldeVersuche + 1;
			String[] SachNamen = SachbearbeiterEK.gibAlleNamen();
		for (Iterator<SachbearbeiterEK> it = SachbearbeiterEK.sachbearbeiter.iterator(); it.hasNext();) {
			SachbearbeiterEK temp= it.next();
			if(benutzername.equals(temp.getBenutzername())) {
				SachbearbeiterEK kopie = SachbearbeiterEK.gib(benutzername);
			if(kopie.getPasswort().equals(passwort)) {
				anmeldeVersuche = 3;
				System.out.println("Geschafft du affe");
				return kopie;
			}
			else {
				
				System.out.println("Passwort ist falsch: ");

			}
			}
			
		}
		System.out.println("Benutzername oder Passwort ist Falsch");
		System.out.println("Benutzername: ");
		Scanner bN = new Scanner(System.in);
		benutzername = bN.nextLine();
		
		System.out.println("Passwort: ");
		Scanner pW = new Scanner(System.in);
		passwort = pW.nextLine();
		
		}
		System.out.println("Keine Versuche mehr bitte Laden Sie die Seite Neu!");
		System.exit(0);
		return null;

	}
	
	
	
	
	public String[] gibSachbearbeiterName() {
		// TODO - implement SachbearbeiterK.gibSachbearbeiterName
		throw new UnsupportedOperationException();
	}

	public void gibSachbearbeiter() {
		// TODO - implement SachbearbeiterK.gibSachbearbeiter
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param kopie
	 */
	public void schreibeSachbearbeiter(SachbearbeiterEK kopie) {
		// TODO - implement SachbearbeiterK.schreibeSachbearbeiter
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public SachbearbeiterEK erzeugeSachbearbeiter(String name) {
		// TODO - implement SachbearbeiterK.erzeugeSachbearbeiter
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void loescheSachbearbeiter(String name) {
		// TODO - implement SachbearbeiterK.loescheSachbearbeiter
		throw new UnsupportedOperationException();
	}

}