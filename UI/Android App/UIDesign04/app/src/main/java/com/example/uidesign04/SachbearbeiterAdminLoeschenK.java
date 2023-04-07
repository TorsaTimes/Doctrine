package com.example.uidesign04;


public class SachbearbeiterAdminLoeschenK {

	
	
	
	
	public void loeschen(String name) {
		
		
		if(SachbearbeiterEK.gib(name) != null) {
			
			SachbearbeiterEK.gib(name).remove(SachbearbeiterEK.gib(name));
			System.out.println("Der Sachbearbeiter: " + name + " wurde erflogreich geloescht!!!");
			SachbearbeiterEK.druckAlleNamen();

		}
		
		else{
			
		/*	JOptionPane.showMessageDialog(null,
                    "�berpr�fen sie ihre Eingabe",
                    "Warnung",					      
                    JOptionPane.WARNING_MESSAGE);*/
			//###############################Kontroll Ausgabe################################################################
			System.out.println("Der Benutzername exsistiert nicht oder wurde falsch eingegeben!");
			//#################################################################################################################
		}
	
		
		
		
	}

}