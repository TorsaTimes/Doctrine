package src;
import java.util.Scanner;

public class SachbearbeiterEditierenAAS extends SachbearbeiterS {

	private static SachbearbeiterEditierenK kontrolle = new SachbearbeiterEditierenK();

	
	
	
	public static void oeffnen() {

		
		System.out.println("Willkommen im Sachbearbeiter-Editieren-Menue");
		System.out.println("--------------------------------------------");
		System.out.println("Waehlen Sie die Editierungs-Optionen");
		System.out.println("Benutzernamen ändern -> 1");
		System.out.println("Passwort ändern -> 2");
		System.out.println("Zurueck in das Sachbearbeiter-Menue -> 3");
		
		Scanner input = new Scanner(System.in);
		int eingabe = input.nextInt();
		if(eingabe == 1) {
			
			System.out.println("Welchen Benutzernamen möchten Sie aendern?");
			SachbearbeiterEK.druckAlleNamen();
			Scanner input1 = new Scanner(System.in);
			String eingabe1 = input1.nextLine();
			System.out.println();
			System.out.println("Wie lautet der neue Benutzername?");
			Scanner input2 = new Scanner(System.in);
			String eingabe2 = input2.nextLine();
			
			kontrolle.benutzernamenaendern(eingabe1, eingabe2);
			oeffnen();
		}
		else if(eingabe == 2) {

			System.out.println("Von welchem Benutzer möchten Sie das Passwort aendern?");
			SachbearbeiterEK.druckeAlleNamenPasswoerter();
			Scanner input3 = new Scanner(System.in);
			String eingabe3 = input3.nextLine();
			System.out.println(eingabe3);
			System.out.println("Wie lautet das neue Passwort");
			Scanner input4 = new Scanner(System.in);
			String eingabe4 = input4.nextLine();
			
			System.out.println(eingabe4);
			
			kontrolle.paswortAendern(eingabe3, eingabe4);
			oeffnen();
		}
		else if(eingabe == 3) {
			
		}
	
	}

	
	public void schliessen() {
		// TODO - implement SachbearbeiterEditierenASS.schliessen
		throw new UnsupportedOperationException();
	}

	public void abbrechen() {
		// TODO - implement SachbearbeiterEditierenASS.abbrechen
		throw new UnsupportedOperationException();
	}

	public void ausgefuehrt() {
		// TODO - implement SachbearbeiterEditierenASS.ausgefuehrt
		throw new UnsupportedOperationException();
	}

	

	public void praesentiereSachbearbeiterName() {
		// TODO - implement SachbearbeiterEditierenASS.praesentiereSachbearbeiterName
		throw new UnsupportedOperationException();
	}

	public void praesentiereSachbearbeiter() {
		// TODO - implement SachbearbeiterEditierenASS.praesentiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void selektiereSachbearbeiter() {
		// TODO - implement SachbearbeiterEditierenASS.selektiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void modifiziereSachbearbeiter() {
		// TODO - implement SachbearbeiterEditierenASS.modifiziereSachbearbeiter
		throw new UnsupportedOperationException();
	}

}