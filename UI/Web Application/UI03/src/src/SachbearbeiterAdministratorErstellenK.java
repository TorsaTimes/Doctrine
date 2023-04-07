package src;

import java.io.IOException;
import java.util.regex.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


public class SachbearbeiterAdministratorErstellenK {


	

	// ----------------------------------------------------------------------------------------------------------------------------------
	public boolean duplikatenpruefung(String name) {

		for (String n : SachbearbeiterEK.gibAlleNamen()) {

			if (name.equals(n)) {
				return true;
			}
		}
		return false;
	}

	public boolean benutzernamenVorgabenpruefen(String name) {

		String eingabenKontrolle = "^((((\\w*))|(([�])*)|(([�])*)|(([�])*)|(([�])*)|(([�])*)|(([�])*)|(([�])*))*)[_]?((((\\w*))|(([�])*)|(([�])*)|(([�])*)|(([�])*)|(([�])*)|(([�])*)|(([�])*))*)$";

		if (Pattern.matches(eingabenKontrolle, name)) {
			return true;
		} else {
//			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
//					null, null);//punkt gefunden
//			FacesContext fc = FacesContext.getCurrentInstance();
//			fc.addMessage(null, msg);
			return false;
		}
	}

	// --------------------------------------------------------------------------------------------------------------------------



	// --------------------------------------------------------------------------------------------------------------------------

	public boolean erzeugen(String name, String passwort, String berechtigung) throws NullPointerException {

		try {

			if (!(name.equals("") || passwort.equals(""))) {
				if (!(berechtigung.equals(""))) {
					System.out.println("Sachbearbeiter Erzeugen: Feld darf nicht null sein!");
					System.out.println("Sachbearbeiter Erzeugen: Sachbearbeiter Duplikaten pr�fung!");
					if (benutzernamenVorgabenpruefen(name)) {
						System.out.println(
								"Sachbearbeiter Erzeugen: Geschafft Sachbearbeiter: " + name + " Mit dem Passwort: "
										+ passwort + " Und der Berechtigung: " + berechtigung + " Wurde Angelegt");
						SachbearbeiterEK.sachbearbeiter.add(new SachbearbeiterEK(name, passwort, berechtigung));
						SachbearbeiterAuswaehlenAAS.sachbearbeiterCollectionString.add(name);
						SachbearbeiterEK.druckAlleNamen();
						return true;

					} else {

						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Benutzereingabe entspricht nicht den Vorgaben!!!", null);
						FacesContext fc = FacesContext.getCurrentInstance();
						fc.addMessage(null, msg);
						return false;
					}
				} else {
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Berechtigung Ausw�hlen!!!! ",
							null);
					FacesContext fc = FacesContext.getCurrentInstance();
					fc.addMessage(null, msg);
					return false;
				}

			} else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Passwort oder Benutzername darf nicht leer sein!", null);
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.addMessage(null, msg);
				return false;
			}

		} catch (NullPointerException n) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Benutzername oder Passwort falsch!", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);
			return false;
		}
	}
	// --------------------------------------------------------------------------------------------------------------------------

}