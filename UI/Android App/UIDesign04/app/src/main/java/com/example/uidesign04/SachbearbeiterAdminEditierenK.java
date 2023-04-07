package com.example.uidesign04;

public class SachbearbeiterAdminEditierenK {

	
	public void berechtigungaendern(String benutzername,String berechtigung) {
		
		if(SachbearbeiterEK.gib(benutzername).getBenutzername().equals(benutzername)) {
			
			SachbearbeiterEK.gib(benutzername).setBerechtigung(berechtigung);
			System.out.println("Die Berechtigung des Benutzers " + benutzername + " wurde ge�ndert");
			System.out.println("Die neue Berechtigung ist nun " + "[" +berechtigung+"]");
			return;
		}
		
		System.out.println("Die Benutzer eingabe war falsch!!!");

		
	}
	
	
	
	
	
	
	public String[] gibAlleSachbearbeiterNamen() {
		// TODO - implement SachbearbeiterAdminEditierenlK.gibAlleSachbearbeiterNamen
		throw new UnsupportedOperationException();
	}

	public void gibSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminEditierenlK.gibSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void schreibeSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminEditierenlK.schreibeSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public SachbearbeiterEK erzeugeSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminEditierenlK.erzeugeSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void loescheSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminEditierenlK.loescheSachbearbeiter
		throw new UnsupportedOperationException();
	}

}