import java.util.Scanner;

public class FortbildungAS {

	
public static void menue() {
	
	System.out.println("Willkommen im Fortbildung-Menue");
	System.out.println("Folgende Operationen stehen zur Auswahl bereit");
	System.out.println("Ein Sachbearbeiter zuordnen -> 1");
	System.out.println("Fortbildungsstatus eines Sachbearbeiters aendern -> 2");
	System.out.println("Aktuelle Fortbildungen des Sachbearbieters");
	System.out.println("Zurück in das Menue Sachbearbeiter -> 3");
	Scanner input = new Scanner(System.in);
	int eingabe = input.nextInt();
	switch(eingabe) {
	
	case 3:
		
		return;
	
	case 1:
		
		FortbildungZuordnenAAS.oeffnen();
		
	case 2:
		
	
	}
	
	}
	
	
	

	public void sachbearbeiterAdminEditieren() {
		// TODO - implement AdminAS.sachbearbeiterAdminEditieren
		throw new UnsupportedOperationException();
	}

	public void Login() {
		// TODO - implement AdminAS.Login
		throw new UnsupportedOperationException();
	}

	public void sachbearbeiterAdminErzeugen() {
		// TODO - implement AdminAS.sachbearbeiterAdminErzeugen
		throw new UnsupportedOperationException();
	}

	public void sachbearbeiterAdminLoeschen() {
		// TODO - implement AdminAS.sachbearbeiterAdminLoeschen
		throw new UnsupportedOperationException();
	}

}
