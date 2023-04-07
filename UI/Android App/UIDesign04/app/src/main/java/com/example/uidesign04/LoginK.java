package com.example.uidesign04;

import android.app.AlertDialog;

import java.util.Iterator;
import java.util.Scanner;


public class LoginK {

	public String anmelden(String benutzername, String passwort) {


		String berechtigungNormal = "normal";
		String berechtigungAdmin = "admin";

		String[] SachNamen = SachbearbeiterEK.gibAlleNamen();
		for (Iterator<SachbearbeiterEK> it = SachbearbeiterEK.sachbearbeiter.iterator(); it.hasNext(); ) {
			SachbearbeiterEK temp = it.next();
			System.out.println(temp.getBenutzername() + "temp");
			System.out.println(benutzername + "parameter");
			System.out.println("HUHUHUHUHUHUHU " + temp.getBenutzername());
			if (benutzername.equals(temp.getBenutzername())) {

				SachbearbeiterEK kopie = SachbearbeiterEK.gib(benutzername);
				if (kopie.getPasswort().equals(passwort)) {

					if (kopie.gibBerechetigung().equals("normal")) {

						return berechtigungNormal;
					} else if (kopie.gibBerechetigung().equals("admin")) {
						return berechtigungAdmin;
					}
				} else {
					System.out.println("Passwort ist falsch: ");
					return "false";
				}
			} else {
				System.out.println("Benutzername nicht vorhanden");
				return "false";

			}

		}
		return "false";


	}

	public String kontrollAnmelden(String benutzername, String passwort)throws NullPointerException {

		String name = benutzername;
		String pass = passwort;
		SachbearbeiterEK kopie = SachbearbeiterEK.gib(benutzername);

		String berechtigungNormal = "normal";
		String berechtigungAdmin = "admin";

		try {
			if (!(name.equals("") && pass.equals(""))) {
				System.out.println("Step1");
				if (name.equals(kopie.getBenutzername())) {//Exception "SachbearbeiterEK"
					System.out.println("Step3");
					if (kopie.getPasswort().equals(pass)) {
						System.out.println("geschafft");
						System.out.println("Benutzername: " + name + " Passwort: " + pass);

						if (kopie.gibBerechetigung().equals("normal")) {

							return berechtigungNormal;
						} else if (kopie.gibBerechetigung().equals("admin")) {
							return berechtigungAdmin;
						}

					} else {
						System.out.println("Passwort ist falsch");
						return "false";
					}
				} else {
					System.out.println("Name ist Falsch");
					return "false";
				}
			} else {

				return "false";
			}
		}
		catch (NullPointerException n){
			return "false";
		}
		return "false";
	}



	
	 
	
	public String[] gibSachbearbeiterEKNamen() {
		// TODO - implement LoginK.gibSachbearbeiterNamen
		throw new UnsupportedOperationException();
	}

	public void gibSachbearbeiter() {
		// TODO - implement LoginK.gibSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void schreibeSachbearbeiter() {
		// TODO - implement LoginK.schreibeSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public SachbearbeiterEK erzeugeSachbearbeiter() {
		// TODO - implement LoginK.erzeugeSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void loescheSachbearbeiter() {
		// TODO - implement LoginK.loescheSachbearbeiter
		throw new UnsupportedOperationException();
	}

}