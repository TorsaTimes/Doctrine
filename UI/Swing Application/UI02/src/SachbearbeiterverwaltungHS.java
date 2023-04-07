import java.awt.Window;

public class SachbearbeiterverwaltungHS {

		private static SachbearbeiterverwaltungHS instance;
		
		public static SachbearbeiterverwaltungHS getInstance() {
			if(instance ==null) {
				instance = new SachbearbeiterverwaltungHS();
			}
			return instance;
		}
	
		public static void main(String[] args) {
		
			
			
			SachbearbeiterEK Tom = new SachbearbeiterEK("Tom","1234","admin");
			SachbearbeiterEK Cedric = new SachbearbeiterEK("Ron_Metzger","1234","normal");
			SachbearbeiterEK Dani = new SachbearbeiterEK("Daniel_Grimm","1234","admin");
			SachbearbeiterEK saleh = new SachbearbeiterEK("Saleh_Omar","1234","normal");
			Tom.add();
			Cedric.add();
			Dani.add();
			saleh.add();
			Fortbildung AllgemeineBetriebswirtschaft = new Fortbildung("All-BW");
			Fortbildung Mathe1 = new Fortbildung("Mathe1");
			Fortbildung Mathe2 = new Fortbildung("Mathe2", Mathe1);
			Fortbildung kostenrechnung = new Fortbildung("Kost-rech", Mathe2 ,AllgemeineBetriebswirtschaft);
			
			LehrveranstaltungsverwaltungHS anfang = new LehrveranstaltungsverwaltungHS();

			anfang.oeffnen();

			
			
		}


}