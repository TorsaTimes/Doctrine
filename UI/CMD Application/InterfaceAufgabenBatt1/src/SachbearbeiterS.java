import java.util.Scanner;

public class SachbearbeiterS {


	
	public static SachbearbeiterK SK = new SachbearbeiterK();
	
	public static SachbearbeiterEK anmeldung() {
		
		Scanner name = new Scanner(System.in);
		Scanner passwort1 = new Scanner(System.in);
		
		System.out.println("Anmeldung");
		System.out.println(" ");
		System.out.println("Bitte geben Sie ihren Benutzernamen und Passwort ein. ");
		System.out.println("Benutzername: ");
		String benutzername = name.nextLine();
		
		System.out.println("Passwort: ");
		String passwort = passwort1.nextLine();
		
		
		
		return SK.controll(benutzername, passwort);
	}
	
	
	
	
	
	
	
	
	public String[] praesentiereSachbearbeiterNamen() {
		// TODO - implement SachbearbeiterS.praesentiereSachbearbeiterNamen
		throw new UnsupportedOperationException();
	}

	public void praesentiereSachbearbeiter() {
		// TODO - implement SachbearbeiterS.praesentiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void selektiereSachbearbeiter() {
		// TODO - implement SachbearbeiterS.selektiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void modifizierenSachbearbeiter() {
		// TODO - implement SachbearbeiterS.modifizierenSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void setBenutzername() {
		// TODO - implement SachbearbeiterS.setBenutzername
		throw new UnsupportedOperationException();
	}

	public void setPasswort() {
		// TODO - implement SachbearbeiterS.setPasswort
		throw new UnsupportedOperationException();
	}

	public void setBerechtigung() {
		// TODO - implement SachbearbeiterS.setBerechtigung
		throw new UnsupportedOperationException();
	}

}