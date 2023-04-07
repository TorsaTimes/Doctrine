import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Fortbildung {

	
	public String title;
	public Fortbildung[] voraussetzung = new Fortbildung[2];
	
	
	private static HashSet<Fortbildung> fortbildungHashSet = new HashSet<Fortbildung>();
	
	public Fortbildung(String name) {
		
		this.title = name;
		fortbildungHashSet.add(this);
	}
	
	public Fortbildung(String name, Fortbildung fort){
		
		this.title = name;
		this.voraussetzung[0] = fort; 
		fortbildungHashSet.add(this);
	}
	
	public Fortbildung(String name, Fortbildung fort, Fortbildung fort1){
	
		this.title = name;
		this.voraussetzung[0] = fort;
		this.voraussetzung[1] = fort1;
		fortbildungHashSet.add(this);
	}

			
	public String getFortbildungTitle() {
		
		return this.title;
		
	}
	
	public Fortbildung[] getFortbildungVoraussetzung() {
		
		
		return this.voraussetzung;
	}
	
	public String[] getFortbildungNamen() {
		
		
		
		return null;

	}
	
	public static Fortbildung gibFortbildung(String fortbildung) {
		
		
		Iterator it = fortbildungHashSet.iterator();
		while (it.hasNext()) {
			Fortbildung temp = (Fortbildung) it.next();
			if((temp.title.equals(fortbildung))) {
				System.out.println(temp.title);
				return temp;
			}
		}	
//		
//			if(temp.getFortbildungTitle().equals(fortbildung));{
//				return temp;
//		}	
//	}
		return null;
		
}
	
	public static void druckeFortbildungenStatus(SachbearbeiterEK sachB) {
		System.out.println("-------------" + sachB.getBenutzername() + "-------------");
		for (Fortbildung a : sachB.fortbildungen.keySet()) {
			System.out.println(a.getFortbildungTitle() + "  " + sachB.fortbildungen.get(a));
		}
		System.out.println("-------------------------------");

	}
	
	public static void druckeAlleFortbildungen() {
		System.out.println("-------Fortbildungen-------");
			Iterator it = fortbildungHashSet.iterator();
			while (it.hasNext()) {
				System.out.println(((Fortbildung) (it.next())).title);
			}
			System.out.println("---------------------------");
		}
	
	public static boolean belegungPruefen(String name, String fort) {
		
		for (Fortbildung a : SachbearbeiterEK.gib(name).fortbildungen.keySet()) {
			
			if(a.getFortbildungTitle().equals(fort)) {
				
				return false;
			}
			else {
				
				return true;
			}
		
	}
			return true;

	}
			
		public boolean voraussetzungPruefen(String name, String fort) {
			
			if(Fortbildung.gibFortbildung(fort).getFortbildungVoraussetzung()[0] == null) {
					
					return true;
			}
			
				if(Fortbildung.gibFortbildung(fort).getFortbildungVoraussetzung()[0] != null && SachbearbeiterEK.gib(name).fortbildungen.get( Fortbildung.gibFortbildung(fort).getFortbildungVoraussetzung()[0]).equals("Bestanden")){
					System.out.println(SachbearbeiterEK.gib(name).fortbildungen.get(name));
					return true;
				}
				
				if(Fortbildung.gibFortbildung(fort).getFortbildungVoraussetzung()[0] != null && Fortbildung.gibFortbildung(fort).getFortbildungVoraussetzung()[1] != null) {
					
					if((Fortbildung.gibFortbildung(fort).getFortbildungVoraussetzung()[0].getFortbildungTitle().equals(SachbearbeiterEK.gib(name).fortbildungen.get(name)) && (Fortbildung.gibFortbildung(fort).getFortbildungVoraussetzung()[1].getFortbildungTitle().equals(SachbearbeiterEK.gib(name).fortbildungen.get(name))))) {
						
						return true;
					}
				}
				else {
					
				return false;
				}
		
		return false;
		
		}
	}
