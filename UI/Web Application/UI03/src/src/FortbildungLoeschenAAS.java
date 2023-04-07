package src;

import java.io.IOException;
import java.util.Scanner;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class FortbildungLoeschenAAS {

	
	
	private static FortbildungLoeschenK kontrolle = new FortbildungLoeschenK();

	private static String nextpage = "";
	
	public String start() throws IOException {

		String ausgewählterName = SachbearbeiterAuswaehlenAAS.selectedSachbearbeiter;
		String ausgewählteFortbildung = FortbildungAuswaehlenAAS.fortbildung;
		boolean page = false;
		
		page = kontrolle.fortbildungLoeschen(ausgewählterName, ausgewählteFortbildung);
		if (page) {
			System.out.println("NextPage ausgeführt");
			SachbearbeiterS.getInstance().setDefault();
			return nextpage;
		} else {
			System.out.println("falsch");
			return "";
		}
	}
	
	public String zurueck() {
		return nextpage;
	}
	
	
	public String oeffnenSachbearbeiter() {
		nextpage = "/SachbearbeiterAS.xhtml?faces-redirect=true";
		return "/FortbildungLoeschenDK.xhtml?faces-redirect=true";
	}

	public String oeffnenAdministrator(){
		System.out.println("hallo");
		nextpage = "/AdministratorAS.xhtml?faces-redirect=true";
		return "/FortbildungLoeschenDK.xhtml?faces-redirect=true";
	}
	
	
}
