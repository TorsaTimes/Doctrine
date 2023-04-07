
public class FortbildungZuordnenK {

	
	public void sachbearbeiterFortbildungBuchen(String benutzername, String fortbildung) {
			
		
		if(Fortbildung.gibFortbildung(fortbildung).voraussetzungPruefen(benutzername, fortbildung)) {
		
		
		
		if((Fortbildung.belegungPruefen(benutzername, fortbildung)) != false) {
		
		//Fortbildung test = Fortbildung.gibFortbildung(fortbildung);
		
		if(Fortbildung.gibFortbildung(fortbildung).getFortbildungTitle().equals(fortbildung)) {
			
			Fortbildung test = Fortbildung.gibFortbildung(fortbildung);
			
			SachbearbeiterEK.gib(benutzername).fortbildungen.put(test, "belegt");
			Fortbildung.druckeFortbildungenStatus(SachbearbeiterEK.gib(benutzername));
			FortbildungAS.menue();
		}
		else {
			System.out.println("!!!!!!Achtung!!!!!! Diese Fortbildung exsistiert nicht oder wurde falsch geschrieben");
			FortbildungAS.menue();
		}
		}
		
		else {
			
			System.out.println("Sachbearbeiter belegt diese Fortbildung schon");
			System.out.println("Bitte ordnen Sie den Sachbearbeiter einer anderen Fortbildun"
					+ "g zu");
			FortbildungAS.menue();
			
		}
		}
		else{
			
			System.out.println("Vorraussetzung nicht erfuellt ");
			FortbildungAS.menue();
			
		}
		
	}
	
	
	
	
	
	
	
	
	
}

