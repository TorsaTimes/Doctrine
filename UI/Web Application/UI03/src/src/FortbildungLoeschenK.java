package src;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;




public class FortbildungLoeschenK {

	
	
	
	public boolean fortbildungLoeschen(String benutzername, String fortbildung) {
		
		if(SachbearbeiterEK.gib(benutzername).getMap().containsKey(Fortbildung.gibFortbildung(fortbildung))) {
			
		
		
		if((fortbildungLoeschenUeberpruefen(benutzername, fortbildung)) == true) {
			
			SachbearbeiterEK.gib(benutzername).removeFortbildung( Fortbildung.gibFortbildung(fortbildung));
			System.out.println("Folgende Fortbildung: " + fortbildung + " wurde geloescht");
			Fortbildung.druckeFortbildungenStatus(SachbearbeiterEK.gib(benutzername));
			return true;
		}
		else {
			System.out.println("nein");
		}
		
		}
		else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Die Fortbildung wurde noch nicht dem Sacharbeiter " + benutzername + " zugewiesen", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);
			System.out.println("Die Fortbildung wurde noch nicht dem Sacharbeiter " + benutzername + " zugewiesen");
			return false;
		}
		return false;
	}
	
	
	
	public boolean fortbildungLoeschenUeberpruefen(String benutzername, String fortbildung) {
		
		Map<Fortbildung,String> speicher = SachbearbeiterEK.gib(benutzername).getMap();
	
		for(Fortbildung n : speicher.keySet()) {
			Fortbildung[] voraussetzungen = n.getFortbildungVoraussetzung();
			for(Fortbildung f : voraussetzungen) {
				
				if(n.equals(f)) {
					return false; 
				}
			}
			
		}
		return true;
		
		
		
}
}