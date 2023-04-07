
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SachbearbeiterEK {

	private  String benutzername;
	private  String passwort;
	private  String berechtigung;

	public static HashSet<SachbearbeiterEK> sachbearbeiter = new HashSet<SachbearbeiterEK>();

	public  Map<Fortbildung, String> fortbildungen = new HashMap<Fortbildung,String>();
	
	
	
	
	public String[] getFortbildungNamen() {
		
		String[] alleFortbildungNamen = null;
		int i = 0;
		Set<Fortbildung> FortbildungNamen = fortbildungen.keySet();
		for(Fortbildung n : FortbildungNamen) {
			
			alleFortbildungNamen[i] = n.getFortbildungTitle();
			i++;
		}
		return alleFortbildungNamen;
	}
	
	
	public void setBenutzername(String benutzername) {
		
		this.benutzername = benutzername;
		
	}
	
	public void setPasswort(String passwort) {
		
		this.passwort = passwort;
		
	}
	
	public void setBerechtigung(String berechtigung) {
		
		this.berechtigung = berechtigung;
		
	}
	
	public String getBenutzername() {
		return this.benutzername;
	}
	public String getPasswort() {
		return this.passwort;
	}

	public SachbearbeiterEK(String bName, String passW, String access) {

		this.benutzername = bName;
		this.passwort = passW;
		this.berechtigung = access;

	}

	public static String[] gibAlleNamen() {

		String[] alleNamen = new String[sachbearbeiter.size()];
		int i = 0;
		for(SachbearbeiterEK s: sachbearbeiter) {
			alleNamen[i] = s.getBenutzername();
			i++;
		}
		return alleNamen;

	}
	
	public static void druckAlleNamen() {
		
		String[] alleNamen = SachbearbeiterEK.gibAlleNamen();
		System.out.println("_______________________________");
		for(String s: alleNamen) {
			
			System.out.println("Benutzername: " + s);
		}
		System.out.println("_______________________________");
	}
	
	public static String[] gibAllePasswoerter() {
		
		String[] allePasswoerter = new String[sachbearbeiter.size()];
		int i = 0;
		for(SachbearbeiterEK s: sachbearbeiter) {
			allePasswoerter[i] = s.getPasswort();
			i++;
		}
		return allePasswoerter;

	}
	
	
	
	public static void druckeAlleNamenPasswoerter() {
		
		System.out.println("_______________________________");
		for(SachbearbeiterEK n : sachbearbeiter) {
		
				System.out.println("Benutzername: " + n.getBenutzername() + " " + "Passwort: " + n.getPasswort() );
			
						}

		System.out.println("_______________________________");
	}
	
	
	@Override
	public String toString() {
		return benutzername;
	}

	public static SachbearbeiterEK gibKopie(String n) {
		SachbearbeiterEK kopie = null;
		// Iterator<SachbearbeiterEK> it = sachbearbeiter.iterator();
		for (Iterator<SachbearbeiterEK> it = sachbearbeiter.iterator(); it.hasNext();) {
			SachbearbeiterEK temp = it.next();
			if ((temp.getBenutzername()).equals(n)) {
				kopie = new SachbearbeiterEK(temp.benutzername,temp.passwort,temp.berechtigung);
				return kopie;
			
		}
			
		}
		return kopie;
	}

	public String gibBerechetigung() {
		return this.berechtigung;
	}
	
	public static int gibAnzahl() {
		return sachbearbeiter.size();
		
	}

	public static SachbearbeiterEK gib(String name) {
		
		
		for(SachbearbeiterEK s: sachbearbeiter) {
			
			if(s.benutzername.equals(name)) {
				
				return s;
			}
		}
		
		return null;
	}

	
	public void kopiereAttribute() {

	}

	public void add() {
		sachbearbeiter.add(this);
	}
	
	public void remove(SachbearbeiterEK name) {
		
		sachbearbeiter.remove(name);
		
	}
	
	public void put(Fortbildung title, String status) {
		
		fortbildungen.put(title, status);
		
	}
















}