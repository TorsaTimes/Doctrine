public class SachbearbeiterEditierenK {


	public void benutzernamenaendern(String name1, String name2) {
		
		if(SachbearbeiterEK.gib(name1).getBenutzername().equals(name1)) {
			
			SachbearbeiterEK.gib(name1).setBenutzername(name2);
			SachbearbeiterEK.druckAlleNamen();
			SachbearbeiterEditierenAAS.oeffnen();
		}
		else {
			System.out.println("Benutzername nicht vorhanden!");
			SachbearbeiterEditierenAAS.oeffnen();
			
		}
		
		

	}
	
	public void paswortAendern(String name1, String passwort) {
		
		if(SachbearbeiterEK.gib(name1).getBenutzername().equals(name1)) {
			SachbearbeiterEK.gib(name1).setPasswort(passwort);
			SachbearbeiterEK.druckeAlleNamenPasswoerter();
			SachbearbeiterEditierenAAS.oeffnen();
		}
		else {
			System.out.println("Passwort nicht vorhanden!");
			SachbearbeiterEditierenAAS.oeffnen();
			
		}
		
		
		
		
			}
	
	public String[] gibAlleSachbearbeiterNamen() {
		// TODO - implement SachbearbeiterEditierenK.gibAlleSachbearbeiterNamen
		throw new UnsupportedOperationException();
	}

	public void gibSachbearbeiter() {
		// TODO - implement SachbearbeiterEditierenK.gibSachbearbeiter
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sachbearbeiter
	 */
	public void schriebeSachbearbeiter(int sachbearbeiter) {
		// TODO - implement SachbearbeiterEditierenK.schriebeSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public SachbearbeiterEK erzeugeSachbearbeiter() {
		// TODO - implement SachbearbeiterEditierenK.erzeugeSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void loescheSach() {
		// TODO - implement SachbearbeiterEditierenK.loescheSach
		throw new UnsupportedOperationException();
	}

}