import java.util.Scanner;

public class AdminAS {

	SachbearbeiterAdminK controll = new SachbearbeiterAdminK();
	SachbearbeiterAdminEditierenAAS sachbearbeiterAdminEditierenAAS =  new SachbearbeiterAdminEditierenAAS();
	
	public static void menue() {
		

		System.out.println("Willkommen im AdmiSachbearbeiter-Menue");
		System.out.println("--------------------------------------");
		System.out.println("Sie können nun waehlen: ");
		System.out.println("Fuer Sachbearbeiter zu editieren waehlen Sie die -> 1");
		System.out.println("Fuer Sachbearbeiter berechtigung aendern -> 2");
		System.out.println("Fuer Sachbearbeiter erzeugen -> 3");
		System.out.println("Fuer Sachbearbeiter loeschen -> 4");
		System.out.println("Fuer Login waehlen Sie die -> 5");
		Scanner input = new Scanner(System.in);
		int eingabe = input.nextInt();
		switch(eingabe) {
		
		case 1:
			
			SachbearbeiterEditierenAAS.oeffnen();
			
		case 2:
			
			SachbearbeiterAdminEditierenAAS.oeffnen();
			
		case 3:
			
			SachbearbeiterAdminErzeugenAAS.oeffnen();
			
		case 4:
			
			SachbearbeiterAdminLoeschenAAS.oeffnen();
			
		case 5:	
		
			LoginAS.oeffnen();
		
		}
//		if(eingabe == 1) {
//			
//			SachbearbeiterEditierenAAS.oeffnen();
//		}
//		else if(eingabe == 2) {
//			
//			SachbearbeiterAdminEditierenAAS.oeffnen();
//			
//		}
//		else if(eingabe == 3) {
//			
//			SachbearbeiterAdminErzeugenAAS.oeffnen();
//		}
//		else if(eingabe == 4) {
//			
//			SachbearbeiterAdminLoeschenAAS.oeffnen();
//		}
//		else if(eingabe == 5) {
//			
//			LoginAS.oeffnen();
//		}

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