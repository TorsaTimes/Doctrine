
package com.example.uidesign04;

import java.util.Map;


public class FortbildungLoeschenK {

	
	
	public boolean fortbildungLoeschen(String benutzername, String fortbildung) {

		if(SachbearbeiterEK.gib(benutzername).getMap().containsKey(Fortbildung.gibFortbildung(fortbildung))) {
			
		
		
		if(fortbildungLoeschenUeberpruefen(benutzername, fortbildung) == true) {
			
			SachbearbeiterEK.gib(benutzername).removeFortbildung( Fortbildung.gibFortbildung(fortbildung));
			System.out.println("Folgende Fortbildung: " + fortbildung + " wurde geloescht");
			Fortbildung.druckeFortbildungenStatus(SachbearbeiterEK.gib(benutzername));
			return true;
		}
		
		}
		else {

			return false;
			
		}
		return false;
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