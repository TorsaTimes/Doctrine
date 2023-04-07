import java.util.regex.*;


public class SachbearbeiterAdminErzeugenK {


	
	
	public void duplikatenpruefung(String name) {
		
		for(String n : SachbearbeiterEK.gibAlleNamen()) {
			
			if(name.equals(n)) {
				System.out.println("Der Benutzername ist vergeben!");
				SachbearbeiterAdminErzeugenAAS.oeffnen();
			}
			
	}
	}
	
	public void benutzernamenVorgabenpruefen(String name) {
		
			String eingabenKontrolle = "^((((\\w*))|(([ä])*)|(([ö])*)|(([ü])*)|(([Ü])*)|(([Ö])*)|(([Ä])*)|(([ß])*))*)[_]((((\\w*))|(([ä])*)|(([ö])*)|(([ü])*)|(([Ü])*)|(([Ö])*)|(([Ä])*)|(([ß])*))*)$";
		
			if(Pattern.matches(eingabenKontrolle, name)) {
				
			}
			else
			{
				System.out.println("Benutzername entspricht nicht den Vorgaben!!!!");
				System.out.println("Beispiel: Müller_Hans");
				SachbearbeiterAdminErzeugenAAS.oeffnen();
			}
	}
	
	
	public void erzeugen(String name, String passwort, String berechtigung) {
		
	
			
			SachbearbeiterEK.sachbearbeiter.add(new SachbearbeiterEK(name, passwort, berechtigung));
			SachbearbeiterEK.druckAlleNamen();
			AdminAS.menue();
		
		
	}






}