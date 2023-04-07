import java.util.Scanner;

public class FortbildungZuordnenAAS {

//	private static FortbildungZuordnenK kontrolle;
//	
//	public FortbildungZuordnenAAS(){
//		
//		kontrolle = new FortbildungZuordnenK();
//	}
//	
//	
//	FortbildungZuordnenAAS name = new FortbildungZuordnenAAS();
//	
	static FortbildungZuordnenK kontrolle = new FortbildungZuordnenK();
	
	public static void oeffnen() {
		
		System.out.println("Welchen Sachbearbeiter wollen Sie zuordnen?");
		System.out.println("Bitte geben Sie den Namen des Sachbearbeiters ein: ");
		Scanner input99 = new Scanner(System.in);
		String eingabe12 = input99.nextLine();
		System.out.println("Welche Fortbildung soll der Sachbearbeiter zugewiesen bekommen?");
		Fortbildung.druckeAlleFortbildungen();
		Scanner input199 = new Scanner(System.in);
		String eingabe112 = input199.nextLine();

		kontrolle.sachbearbeiterFortbildungBuchen(eingabe12, eingabe112);
		
	}
	
	
	
	
	
	
}
