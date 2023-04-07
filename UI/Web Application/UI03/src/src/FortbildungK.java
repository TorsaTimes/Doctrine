package src;
import java.util.Scanner;

public class FortbildungK {


	 
	
	
	public void aktFortbildungStatus() {
		for(int i = 0;i<3;i++) {
		System.out.println("Bitte geben sie den Benutzernamen ein: ");
		SachbearbeiterEK.druckAlleNamen();
		Scanner input = new Scanner(System.in);
		String eingabe = input.nextLine();
		
		if(SachbearbeiterEK.gib(eingabe) != null) {
		System.out.println("Der Benutzer: " + eingabe + " besitzt folgende Fortbildungen");
		System.out.println(" ");
		Fortbildung.druckeFortbildungenStatus(SachbearbeiterEK.gib(eingabe));
		return;
		}
		else {
			
			System.out.println("Der Benutzername ist Falsch!!!");
			
		}
		}
		System.out.println("Zu viele Fehleingaben - Zurueck zu Fortbildung-Menue");
		return;
		
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
