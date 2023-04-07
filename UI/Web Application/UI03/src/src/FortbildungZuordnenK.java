package src;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;


public class FortbildungZuordnenK {


	
	public boolean sachbearbeiterFortbildungBuchen(String benutzername, String fortbildung, String status)
			throws NullPointerException {
		try {
			System.out.println("hallo");
			// SachbearbeiterEK sachB = SachbearbeiterEK.gib(benutzername);
			if (!(status.equals(""))) {
				if (Fortbildung.voraussetzungPruefen(benutzername, fortbildung)) {

					if ((Fortbildung.getFortbildungsStatus(benutzername, fortbildung, status))) {

						if ((Fortbildung.belegungPruefen(benutzername, fortbildung, status) != false)
								|| SachbearbeiterEK.statusVonFortbildungenÜberprüfen(benutzername, fortbildung,
										status)) {

							Fortbildung test = Fortbildung.gibFortbildung(fortbildung);

							SachbearbeiterEK.gib(benutzername).fortbildungen.put(test, status);
							Fortbildung.druckeFortbildungenStatus(SachbearbeiterEK.gib(benutzername));
							return true;

						} else {
							FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
									"Sachbearbeiter: " + benutzername + " belegt diese Fortbildung noch nicht", null);
							FacesContext fc = FacesContext.getCurrentInstance();
							fc.addMessage(null, msg);
							
							System.out.println(
									"Sachbearbeiter: " + benutzername + " belegt diese Fortbildung noch nicht");

							return false;
						}

					}

					else {
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sachbearbeiter: "
								+ benutzername
								+ " belegt diese Fortbildung schon \t Bitte ordnen Sie den Sachbearbeiter einer anderen Fortbildung zu \n",
								null);
						FacesContext fc = FacesContext.getCurrentInstance();
						fc.addMessage(null, msg);
						System.out.println("Sachbearbeiter: " + benutzername
								+ " belegt diese Fortbildung schon \t Bitte ordnen Sie den Sachbearbeiter einer anderen Fortbildung zu \n");
						;
						return false;
					}
				} else {
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Vorraussetzung nicht erfuellt",
							null);
					FacesContext fc = FacesContext.getCurrentInstance();
					fc.addMessage(null, msg);
					System.out.println("Vorraussetzung nicht erfuellt");
					return false;
				}

			} else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Status auswählen!!!!", null);
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.addMessage(null, msg);
			}
		} catch (NullPointerException n) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fehler, Bitte Auswahl überprüfen!", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);
			return false;
		}
		return false;
	}



}
