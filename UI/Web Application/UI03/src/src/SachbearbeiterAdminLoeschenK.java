package src;
import java.util.Iterator;
import java.util.Scanner;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;


import java.io.IOException;
import java.util.*;

@ManagedBean
@ApplicationScoped
public class SachbearbeiterAdminLoeschenK {

	private boolean prüfen = false;
	

	
	public String start() throws IOException {
		System.out.println("bin drin");
		String nextpage = "/AdministratorAS.xhtml?faces-redirect=true";

		loeschen();
		if (prüfen) {
			System.out.println("NextPage ausgeführt");
			//SachbearbeiterS.getInstance().setDefault();
			return nextpage;
		} else {
			System.out.println("falsch");
			return null;
		}
	}
	
	public void loeschen()throws IOException {
		
		SachbearbeiterEK akt = SachbearbeiterEK.gib(SachbearbeiterAuswaehlenAAS.selectedSachbearbeiter);
		
		if((SachbearbeiterEK.sachbearbeiter.size() > 1)){
		
			SachbearbeiterAuswaehlenAAS.sachbearbeiterCollectionString.remove(SachbearbeiterAuswaehlenAAS.selectedSachbearbeiter);
			SachbearbeiterEK.sachbearbeiter.remove(akt);
			System.out.println("Der Sachbearbeiter: wurde erflogreich geloescht!!!");
			SachbearbeiterEK.druckAlleNamen();
			prüfen = true;
			
		}
		else{
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Der letzte Sachbearbeiter kann nicht geloescht werden!", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);
			prüfen = false;
			}
	}

}