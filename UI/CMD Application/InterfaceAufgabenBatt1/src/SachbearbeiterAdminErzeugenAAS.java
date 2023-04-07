import java.util.Scanner;

public class SachbearbeiterAdminErzeugenAAS {

	static SachbearbeiterAdminErzeugenK controll = new SachbearbeiterAdminErzeugenK();
	
	public static void oeffnen() {
		
		
		System.out.println("Wie soll der neue Benutzer heissen?");
		Scanner input = new Scanner(System.in);
		String eingabe = input.nextLine();
		controll.duplikatenpruefung(eingabe);
		controll.benutzernamenVorgabenpruefen(eingabe);
		System.out.println("Welches Passwort soll der neue Benutzer besitzen?");
		Scanner input1 = new Scanner(System.in);
		String eingabe1 = input1.nextLine();
		System.out.println("Welche Rechte soll der neue Benutzer besitzen?");
		Scanner input2 = new Scanner(System.in);
		String eingabe2 = input2.nextLine();
		
		controll.erzeugen(eingabe, eingabe1, eingabe2);
	}
	
	
	public void schliessen() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.schliessen
		throw new UnsupportedOperationException();
	}

	public void abbrechen() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.abbrechen
		throw new UnsupportedOperationException();
	}

	public void ausgefuehrt() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.ausgefuehrt
		throw new UnsupportedOperationException();
	}

	

	public void praesentiereSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.praesentiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void praesentiereSachbearbeiterName() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.praesentiereSachbearbeiterName
		throw new UnsupportedOperationException();
	}

	public void selektiereSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.selektiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void modifiziereSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.modifiziereSachbearbeiter
		throw new UnsupportedOperationException();
	}

}