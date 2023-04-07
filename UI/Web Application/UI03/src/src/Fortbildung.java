package src;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Fortbildung {

	
	
	public String title;
	public Fortbildung[] voraussetzung = new Fortbildung[2];
	
	
	public static HashSet<Fortbildung> fortbildungHashSet = new HashSet<Fortbildung>();

	
	static{
		Fortbildung AllgemeineBetriebswirtschaft = new Fortbildung("Allgemeine Betriebswirtschaft");
		Fortbildung Mathe1 = new Fortbildung("Mathe1");
		Fortbildung Mathe2 = new Fortbildung("Mathe2", Mathe1);
		Fortbildung kostenrechnung = new Fortbildung("kostenrechnung", Mathe2 ,AllgemeineBetriebswirtschaft);
    }

	public static boolean getFortbildungsStatus(String sachB, String fortbildung, String status) {
		SachbearbeiterEK sachBe = SachbearbeiterEK.gib(sachB);
		for (Fortbildung a : sachBe.fortbildungen.keySet()) {
			if ((a.getFortbildungTitle().equals(fortbildung)) && (sachBe.fortbildungen.get(a).equals(status))) {
				System.out.println("sachBe.fortbildungen.get(a).equals(status)" + sachBe.fortbildungen.get(a).toString());//belegt steht d
				return false;
			}
		}
		return true;
	}
	
	public static boolean belegungPruefen(String name, String fort,String status) {

		if(status.equals("belegt")) {
		
			for (Fortbildung a : SachbearbeiterEK.gib(name).fortbildungen.keySet()) {
			
			if (a.getFortbildungTitle().equals(fort)) {
				return false;
				
			} 
			else {
				System.out.println("belegt wurde ausgeführt");
				return true;
			}

		}
		}
		else {
			return false;
		}
		return true;

	}
	
	
	
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
				return temp;
			}
		}	
		return null;
		
}
	
	public static String druckeFortbildungenStatusReturn(SachbearbeiterEK sachB) throws NullPointerException{
		
		String gebuchteFortbildungen = "";
		try {
			
			Iterator it = fortbildungHashSet.iterator();
			while (it.hasNext()) {
				Fortbildung temp = (Fortbildung) it.next();
				if(sachB.fortbildungen.containsKey(temp)) {
					gebuchteFortbildungen = gebuchteFortbildungen + (temp.getFortbildungTitle() + "  " + sachB.fortbildungen.get(temp) + System.lineSeparator());
				}
				else {
					gebuchteFortbildungen = gebuchteFortbildungen + (temp.getFortbildungTitle() + " " + " Kein Status " + System.lineSeparator());
				}
			}
			
		}catch (NullPointerException n) {
//			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", null);
//			FacesContext fc = FacesContext.getCurrentInstance();
//			fc.addMessage(null, msg);//Fehler bei SachbearbeiterSachEditieren nur ein Punkt taucht auf!!!
			
		}
		
		return gebuchteFortbildungen;
		
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
	
	
public static boolean belegungPruefen1(String name, String fort) {
		
		for (Fortbildung a : SachbearbeiterEK.gib(name).fortbildungen.keySet()) {
			
			if(a.getFortbildungTitle().equals(fort)) {
				return true;
			}
		
	}
			return false;

	}
	
	
			
		public static boolean voraussetzungPruefen(String name, String fort) {
			
			if(Fortbildung.gibFortbildung(fort).getFortbildungVoraussetzung()[0] == null) {
					
					return true;
			}
			if(Fortbildung.gibFortbildung(fort).getFortbildungVoraussetzung()[0] != null && SachbearbeiterEK.gib(name).fortbildungen.get( Fortbildung.gibFortbildung(fort).getFortbildungVoraussetzung()[0]) == null){
				
				return false;
				
			}
			
				if(Fortbildung.gibFortbildung(fort).getFortbildungVoraussetzung()[0] != null && SachbearbeiterEK.gib(name).fortbildungen.get( Fortbildung.gibFortbildung(fort).getFortbildungVoraussetzung()[0]).equals("bestanden")){
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
