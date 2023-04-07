public class SachbearbeiterAdminEditierenK {

	
	public void berechtigungaendern(String benutzername,String berechtigung) {
		
		if(SachbearbeiterEK.gib(benutzername).getBenutzername().equals(benutzername)) {
			
			SachbearbeiterEK.gib(benutzername).setBerechtigung(berechtigung);
			
		}
		
		
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