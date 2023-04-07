import java.util.regex.*;

import javax.swing.JOptionPane;


public class SachbearbeiterAdminErzeugenK {


	
	
	public boolean duplikatenpruefung(String name) {
		
		for(String n : SachbearbeiterEK.gibAlleNamen()) {
			
			if(name.equals(n)) {
				return false;

			}
			
	}
		return true;
	}
	
	public boolean benutzernamenVorgabenpruefen(String name) {

		String eingabenKontrolle = "^((((\\w*))|(([ä])*)|(([ö])*)|(([ü])*)|(([Ü])*)|(([Ö])*)|(([Ä])*)|(([ß])*))*)[_]?((((\\w*))|(([ä])*)|(([ö])*)|(([ü])*)|(([Ü])*)|(([Ö])*)|(([Ä])*)|(([ß])*))*)$";

		if (Pattern.matches(eingabenKontrolle, name)) {
			return true;
		} else {

			return false;
		}
	}
	
	
	public int erzeugen(String name, String passwort, String berechtigung) {
		
		
		if((name.equals("")) || (passwort.equals(""))) {
			JOptionPane.showMessageDialog(null,
                    "Es wurde kein Benutzer/Passwort eingegeben",
                    "Warnung",					      
                    JOptionPane.WARNING_MESSAGE);
			//########################################Kontroll Ausgabe#########################################################
			System.out.println("KontrollAusgabe Warnung - Kein Benutzername/Passwort eingegeben!!!!!!");
		
			//##############################################################################################################
			return 1;
			}
			else {
			if(berechtigung.equals("")) {
				JOptionPane.showMessageDialog(null,
	                    "Es wurde kein Berechtigung ausgewählt",
	                    "Warnung",					      
	                    JOptionPane.WARNING_MESSAGE);
				//########################################Kontroll Ausgabe#########################################################
				System.out.println("KontrollAusgabe Warnung - Keine Berechtigung Ausgewählt!!!!");
				//##############################################################################################################
				return 1;
			}
			else {	
			
			if(benutzernamenVorgabenpruefen(name)) {
				if(duplikatenpruefung(name)) {
			
			SachbearbeiterEK.sachbearbeiter.add(new SachbearbeiterEK(name, passwort, berechtigung));
			//###########################Kontroll Ausgabe#################################################
			System.out.println("KontrollAusgabe: Benutzer " + name + " wurde erstellt");
			SachbearbeiterEK.druckAlleNamen();
			System.out.println("huhuhuhuhuhuuhu");
			System.out.println(SachbearbeiterEK.gib(name).gibBerechetigung());
			//###############################################################################################
			return 2;
				}
				else {
					JOptionPane.showMessageDialog(null,
	                        "Benutzername exstiert schon",
	                        "Warnung",					      
	                        JOptionPane.WARNING_MESSAGE);
					//########################################Kontroll Ausgabe#########################################################
					System.out.println("KontrollAusgabe Warnung - Benutzer exsistiert schon!!!!");
					//##############################################################################################################
					return 1;
				}
		
			}
			else {
				JOptionPane.showMessageDialog(null,
                        "Benutzername entspricht nicht denn Vorgaben!!!!!",
                        "Warnung",					      
                        JOptionPane.WARNING_MESSAGE);
				//########################################Kontroll Ausgabe#########################################################
				System.out.println("KontrollAusgabe Warnung - Benutzername entspricht nicht denn Vorgaben!!!!");
				//##############################################################################################################
				return 1;
			}
		}
		}
		}
}

		
