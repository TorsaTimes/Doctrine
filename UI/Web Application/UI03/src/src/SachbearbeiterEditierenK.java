package src;

import java.util.regex.Pattern;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.NamedEvent;


public class SachbearbeiterEditierenK {


	
	// ----------------------------------------------------------------------------------------------------------------------------------

	public boolean editieren(String name, String passwort, String berechtigung)throws NullPointerException  {
		
		String ausgewählterName = SachbearbeiterAuswaehlenAAS.selectedSachbearbeiter;
		SachbearbeiterEK akt = SachbearbeiterEK.gib(ausgewählterName);
		System.out.println(ausgewählterName + " ausgewählter name");
		try {
			if (!(name.equals("") || passwort.equals(""))) {
					if(!(berechtigung.equals(""))) {
				if(benutzernamenVorgabenpruefen(name)) {
				if((SachbearbeiterEK.sachbearbeiter.contains(SachbearbeiterEK.gib(ausgewählterName))) && (!(name.equals(ausgewählterName)))){
					
			SachbearbeiterAuswaehlenAAS.sachbearbeiterCollectionString.remove(ausgewählterName);
			akt.setBenutzername(name);
			akt.setPasswort(passwort);
			akt.setBerechtigung(berechtigung);
			SachbearbeiterAuswaehlenAAS.sachbearbeiterCollectionString.add(name);
			System.out.println("Sachbearbeiter Editieren Geschafft");
			return true;
				}
				else {
					FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Benutzername schon vergeben", null);
	                FacesContext fc1 = FacesContext.getCurrentInstance();
	                fc1.addMessage(null, msg1);
	                return  false;

				}
				
				}else {
					System.out.println("Benutzername entspricht nicht den Vorgaben!!!!");
					System.out.println("Beispiel: Müller_Hans");
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Benutzername entspricht nicht den Vorgaben!!!!", null);
					FacesContext fc = FacesContext.getCurrentInstance();
					fc.addMessage(null, msg);
					return  false;
				}
			}
			else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Berechtigung Auswählen!!!! ",
						null);
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.addMessage(null, msg);
				return  false;
			}
			}	else {
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Passwort oder Benutzername darf nicht leer sein!!!", null);
					FacesContext fc = FacesContext.getCurrentInstance();
					fc.addMessage(null, msg);
					return  false;
				}
			}
		
	
		catch (NullPointerException n) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Benutzername oder Passwort falsch!", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);
			return  false;
		}
		}

	public boolean benutzernamenaendern(String name1, String name2) {

		if (SachbearbeiterEK.gib(name1) != null) {

			if (benutzernamenVorgabenpruefen(name2)) {

				if (SachbearbeiterEK.gib(name1).getBenutzername().equals(name1)) {

					SachbearbeiterEK.gib(name1).setBenutzername(name2);
					SachbearbeiterEK.druckAlleNamen();

				} else {
					System.out.println("Benutzername nicht vorhanden!");
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Benutzername nicht vorhanden!",
							null);
					FacesContext fc = FacesContext.getCurrentInstance();
					fc.addMessage(null, msg);
					return  false;

				}
			} else {
				System.out.println("Benutzername entspricht nicht den Vorgaben!!!!");
				System.out.println("Beispiel: Müller_Hans");
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Benutzername entspricht nicht den Vorgaben!!!!", null);
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.addMessage(null, msg);
				return  false;

			}
		} else {
			System.out.println("Benutzername ist Falsch geschrieben/exsistiert nicht!!!!");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Benutzername ist Falsch geschrieben/exsistiert nicht!!!!", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);
			return  false;
		}
		return false;

	}

	public void paswortAendern(String name1, String passwort) {

		if (SachbearbeiterEK.gib(name1) != null) {

			if (SachbearbeiterEK.gib(name1).getBenutzername().equals(name1)) {
				SachbearbeiterEK.gib(name1).setPasswort(passwort);
				SachbearbeiterEK.druckeAlleNamenPasswoerter();

			} else {
				System.out.println("Passwort nicht vorhanden!");

			}
		} else {
			System.out.println("Benutzername ist Falsch geschrieben/exsistiert nicht!!!!");

		}

	}

	public boolean benutzernamenVorgabenpruefen(String name) {

		String eingabenKontrolle = "^((((\\w*))|(([ä])*)|(([ö])*)|(([ü])*)|(([Ü])*)|(([Ö])*)|(([Ä])*)|(([ß])*))*)[_]?((((\\w*))|(([ä])*)|(([ö])*)|(([ü])*)|(([Ü])*)|(([Ö])*)|(([Ä])*)|(([ß])*))*)$";

		if (Pattern.matches(eingabenKontrolle, name)) {
			return true;
		} else {

			return false;
		}
	}
	// ----------------------------------------------------------------------------------------------------------------------------------

	public String[] gibAlleSachbearbeiterNamen() {
		// TODO - implement SachbearbeiterEditierenK.gibAlleSachbearbeiterNamen
		throw new UnsupportedOperationException();
	}

	public void gibSachbearbeiter() {
		// TODO - implement SachbearbeiterEditierenK.gibSachbearbeiter
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sachbearbeiter
	 */
	public void schriebeSachbearbeiter(int sachbearbeiter) {
		// TODO - implement SachbearbeiterEditierenK.schriebeSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public SachbearbeiterEK erzeugeSachbearbeiter() {
		// TODO - implement SachbearbeiterEditierenK.erzeugeSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void loescheSach() {
		// TODO - implement SachbearbeiterEditierenK.loescheSach
		throw new UnsupportedOperationException();
	}

}