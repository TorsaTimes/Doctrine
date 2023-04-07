package com.example.uidesign04;


import java.util.regex.*;



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
	
	
	public boolean erzeugen(String name, String passwort, String berechtigung) {
		
		
		if((name.equals("")) || (passwort.equals(""))) {

			return false;
			}
			else {
			if(berechtigung.equals("")) {

				return false;
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

			return true;
				}
				else {

					return false;
				}
		
			}
			else {

				return false;
			}
		}
		}
		}


}

		
