import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JButton;

public class LoginK {

	public String anmelden(String benutzername, String passwort) {

		
		String berechtigungNormal = "normal";
		String berechtigungAdmin = "admin";
		
			String[] SachNamen = SachbearbeiterEK.gibAlleNamen();
		for (Iterator<SachbearbeiterEK> it = SachbearbeiterEK.sachbearbeiter.iterator(); it.hasNext();) {
			SachbearbeiterEK temp= it.next();
			System.out.println(temp.getBenutzername() + "temp");
			System.out.println(benutzername + "parameter");
			if(benutzername.equals(temp.getBenutzername())) {

				SachbearbeiterEK kopie = SachbearbeiterEK.gib(benutzername);
			if(kopie.getPasswort().equals(passwort)) {

				if(kopie.gibBerechetigung().equals("normal")) {
					
					return berechtigungNormal;
				}
				else if(kopie.gibBerechetigung().equals("admin")) {
					return berechtigungAdmin;
				}
			}
			else {
				
				System.out.println("Passwort ist falsch: ");
				
			}
			}
			else {
				System.out.println("Benutzername nicht vorhanden");
				
				
			}
			
		}
		return null;


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