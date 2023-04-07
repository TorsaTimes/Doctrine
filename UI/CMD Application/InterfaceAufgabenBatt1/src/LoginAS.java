import java.util.Scanner;

public class LoginAS extends SachbearbeiterS {

	
	
	private LoginK LoginK = new LoginK();
	
	
	public static void oeffnen() {
		
		System.out.println("Willkommen im Login");
		System.out.println("-------------------");
		System.out.println(" ");
		SachbearbeiterEK user = SachbearbeiterS.anmeldung();
		
		if(user.gibBerechetigung().equals("normal")) {
			
			NormalAS.menue();
		}
		if(user.gibBerechetigung().equals("admin")) {
			System.out.println("Berechtigungszugang Auswählen: ");
			System.out.println("Für Normal wählen Sie die -> 1");
			System.out.println("Für Admin wählen Sie die -> 2");
			Scanner lies = new Scanner(System.in);
			int input = lies.nextInt();
			if(input == 1){
				NormalAS.menue();
			}
			else if(input == 2) {
				AdminAS.menue();
			}
			else {
				System.out.println("Die Eingabe ist Falsch");
				oeffnen();
				
			}
		
			
		}
			
	
	}
	
	public String[] praesentiereSachbearbeiterName() {
		// TODO - implement LoginAS.praesentiereSachbearbeiterName
		throw new UnsupportedOperationException();
	}

	public void praesentiereSachbearbeiter() {
		// TODO - implement LoginAS.praesentiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void selektiereSachbearbeiter() {
		// TODO - implement LoginAS.selektiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void modifiziereSachbearbeiter() {
		// TODO - implement LoginAS.modifiziereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	
	public void schliessen() {
		// TODO - implement LoginAS.schliessen
		throw new UnsupportedOperationException();
	}

	public void abbrechen() {
		// TODO - implement LoginAS.abbrechen
		throw new UnsupportedOperationException();
	}

	public void ausgefuehrt() {
		// TODO - implement LoginAS.ausgefuehrt
		throw new UnsupportedOperationException();
	}

}