import java.util.Scanner;

public class SachbearbeiterAdminEditierenAAS extends SachbearbeiterEditierenAAS {

		  static SachbearbeiterAdminEditierenK controll = new SachbearbeiterAdminEditierenK();
	
	
	public static void oeffnen() {
		
		System.out.println("Bei welchem Benutzer soll die Berechtigung geandert werden?");
		Scanner input = new Scanner(System.in);
		String eingabe = input.nextLine();
		Scanner input1 = new Scanner(System.in);
		String eingabe1 = input1.nextLine();
		
		controll.berechtigungaendern(eingabe,eingabe1);
		
	}
	
	
	
	public void schliessen() {
		// TODO - implement SachbearbeiterAdminEditierenASS.schliessen
		throw new UnsupportedOperationException();
	}

	public void abbrechen() {
		// TODO - implement SachbearbeiterAdminEditierenASS.abbrechen
		throw new UnsupportedOperationException();
	}

	public void ausgefuehrt() {
		// TODO - implement SachbearbeiterAdminEditierenASS.ausgefuehrt
		throw new UnsupportedOperationException();
	}

	public void sachbearbeiterAdminAuswaehlen() {
		// TODO - implement SachbearbeiterAdminEditierenASS.sachbearbeiterAdminAuswaehlen
		throw new UnsupportedOperationException();
	}

	public void praesentiereSacharbeiter() {
		// TODO - implement SachbearbeiterAdminEditierenASS.praesentiereSacharbeiter
		throw new UnsupportedOperationException();
	}

	public void praesentiereSacharbeiterName() {
		// TODO - implement SachbearbeiterAdminEditierenASS.praesentiereSacharbeiterName
		throw new UnsupportedOperationException();
	}

	public void selektiereSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminEditierenASS.selektiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void modifiziereSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminEditierenASS.modifiziereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	/*public void oeffnen() {
		// TODO - implement SachbearbeiterAdminEditierenASS.oeffnen
		throw new UnsupportedOperationException();
	}*/

}