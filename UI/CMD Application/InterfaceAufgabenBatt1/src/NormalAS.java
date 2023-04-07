import java.util.Scanner;

public class NormalAS {

	
	
	public static void menue() {
		
		System.out.println("Willkommen im Sachbearbeiter-Menue");
		System.out.println("Sie können nun waehlen: ");
		System.out.println("Fuer Sachbearbeiter zu editieren waehlen Sie die -> 1");
		System.out.println("fuer Sachbearbeiter einer Fortbildung zuordnen -> 2");
		System.out.println("Fuer Login waehlen Sie die -> 3");
		Scanner input = new Scanner(System.in);
		int eingabe = input.nextInt();
		switch(eingabe) {
		
		case 1:
			
			SachbearbeiterNormalEditierenAAS.oeffnen();
			
		case 2:
			
			FortbildungZuordnenAAS.oeffnen();
			
		case 3:	
			
			LoginAS.oeffnen();
		
		}
	}
	
	
	
	
	public void sachbearbeiterNormalEditieren() {
		// TODO - implement NormalAS.sachbearbeiterNormalEditieren
		throw new UnsupportedOperationException();
	}

	public void Login() {
		// TODO - implement NormalAS.Login
		throw new UnsupportedOperationException();
	}

}