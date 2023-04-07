package src;

import java.io.IOException;

public class SachbearbeiterverwaltungHS {


	
		public static void main(String[] args) throws IOException {
			
			
			
			SachbearbeiterEK Tom = new SachbearbeiterEK("Tom","1","admin");
			SachbearbeiterEK Cedric = new SachbearbeiterEK("Ron_Metzger","1","normal");
			SachbearbeiterEK Dani = new SachbearbeiterEK("Daniel_Grimm","1","admin");
			SachbearbeiterEK saleh = new SachbearbeiterEK("S","1","admin");
			Tom.add();
			Cedric.add();
			Dani.add();
			saleh.add();
			Fortbildung AllgemeineBetriebswirtschaft = new Fortbildung("Allgemeine Betriebswirtschaft");
			Fortbildung Mathe1 = new Fortbildung("Mathe1");
			Fortbildung Mathe2 = new Fortbildung("Mathe2", Mathe1);
			Fortbildung kostenrechnung = new Fortbildung("kostenrechnung", Mathe2 ,AllgemeineBetriebswirtschaft);
		
		
			LoginAAS.getInstance().start();
			
		}


}