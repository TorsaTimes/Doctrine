import java.util.Map;

import javax.swing.JOptionPane;

public class FortbildungLoeschenK {

	
	
	public int fortbildungLoeschen(String benutzername, String fortbildung) {

		if(SachbearbeiterEK.gib(benutzername).getMap().containsKey(Fortbildung.gibFortbildung(fortbildung))) {
			
		
		
		if(fortbildungLoeschenUeberpruefen(benutzername, fortbildung) == true) {
			
			SachbearbeiterEK.gib(benutzername).removeFortbildung( Fortbildung.gibFortbildung(fortbildung));
			System.out.println("Folgende Fortbildung: " + fortbildung + " wurde geloescht");
			Fortbildung.druckeFortbildungenStatus(SachbearbeiterEK.gib(benutzername));
			return 2;
		}
		
		}
		else {
			
			JOptionPane.showMessageDialog(null,
					"Die Fortbildung wurde noch nicht dem Sacharbeiter " + benutzername + " zugewiesen",
                    "Warnung",					      
                    JOptionPane.ERROR_MESSAGE);
			return 1;
			
		}
		return 2;
	}
	
	
	
	public boolean fortbildungLoeschenUeberpruefen(String benutzername, String fortbildung) {
		
		Map<Fortbildung,String> speicher = SachbearbeiterEK.gib(benutzername).getMap();
	
		for(Fortbildung n : speicher.keySet()) {
			Fortbildung[] voraussetzungen = n.getFortbildungVoraussetzung();
			for(Fortbildung f : voraussetzungen) {
				
				if(n == f) {
					return false; 
				}
			}
			
		}
		return true;
		
		
		
}
}