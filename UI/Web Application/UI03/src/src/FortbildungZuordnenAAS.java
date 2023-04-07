package src;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class FortbildungZuordnenAAS {

	
	

	public boolean bestanden;
	public boolean belegt;
	public boolean pr�fen = false;
	
	private static String nextpage = "";
	
	FortbildungZuordnenK kontrolle = new FortbildungZuordnenK();
	
	public boolean isBelegt() {
		return belegt;
	}

	public void setBelegt(boolean belegt) {
		this.belegt = belegt;
	}

	public boolean isBestanden() {
		return bestanden;
	}

	public void setBestanden(boolean bestanden) {
		this.bestanden = bestanden;
	}
	
	
	
	// -------------------------------------------------------------------------------

		public String start() throws IOException {

			String status = null;
			boolean fBestanden = bestanden;
			boolean fBelegt = belegt;
			boolean page = false;
			
			if (fBestanden) {
				status = "bestanden";
			} else if (fBelegt) {
				status = "belegt";
			} else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Status ausw�hlen!!!!", null);
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.addMessage(null, msg);
			}

			// ----------------------------------------------------------------
			String ausgew�hlterName = SachbearbeiterAuswaehlenAAS.selectedSachbearbeiter;
			String ausgew�hlteFortbildung = FortbildungAuswaehlenAAS.fortbildung;

			page = kontrolle.sachbearbeiterFortbildungBuchen(ausgew�hlterName, ausgew�hlteFortbildung, status);
			if (page) {
				System.out.println("NextPage ausgef�hrt");
				SachbearbeiterS.getInstance().setDefault();
				return nextpage;
			} else {
				System.out.println("falsch");
				SachbearbeiterS.getInstance().setDefault();
				return "";
			}
		}
		
		public String zurueck() {
			return nextpage;
		}
		
		
		public String oeffnenSachbearbeiter() {
			nextpage = "/SachbearbeiterAS.xhtml?faces-redirect=true";
			return "/FortbildungZuordnenDK.xhtml?faces-redirect=true";
		}
	
		public String oeffnenAdministrator(){
			System.out.println("hallo");
			nextpage = "/AdministratorAS.xhtml?faces-redirect=true";
			return "/FortbildungZuordnenDK.xhtml?faces-redirect=true";
		}
	
	
}
