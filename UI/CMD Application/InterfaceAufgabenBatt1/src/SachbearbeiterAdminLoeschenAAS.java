import java.util.Scanner;

public class SachbearbeiterAdminLoeschenAAS {

	static SachbearbeiterAdminLoeschenK controll = new SachbearbeiterAdminLoeschenK(); 
	
	public static void oeffnen() {
		
		System.out.println("Welcher Benutzer soll gelöscht werden?");
		System.out.println("Bitte geben Sie den Namen des Benutzers ein: ");
		Scanner input8 = new Scanner(System.in);
		String eingabe8 = input8.nextLine();
		
		controll.loeschen(eingabe8);
		
	}
	
	
	
	
	
	
	public void schliessen() {
		// TODO - implement SachbearbeiterAdminLoeschenASS.schliessen
		throw new UnsupportedOperationException();
	}

	public void abbrechen() {
		// TODO - implement SachbearbeiterAdminLoeschenASS.abbrechen
		throw new UnsupportedOperationException();
	}

	public void ausgefuehrt() {
		// TODO - implement SachbearbeiterAdminLoeschenASS.ausgefuehrt
		throw new UnsupportedOperationException();
	}

	public void praesentiereSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminLoeschenASS.praesentiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void praesentiereSachbearbeiterName() {
		// TODO - implement SachbearbeiterAdminLoeschenASS.praesentiereSachbearbeiterName
		throw new UnsupportedOperationException();
	}

	public void selektiereSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminLoeschenASS.selektiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void modifiziereSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminLoeschenASS.modifiziereSachbearbeiter
		throw new UnsupportedOperationException();
	}

}