package src;

import java.util.Iterator;
import java.util.Scanner;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


public class SachbearbeiterK {

	public static SachbearbeiterK instance;

	public static SachbearbeiterK getinstance() {
		if (instance == null) {
			instance = new SachbearbeiterK();
		}
		return instance;
	}

	
	
	
	public boolean kontrollAnmelden(String benutzername, String passwort) throws NullPointerException {

		String name = benutzername; 
		String pass = passwort;
		SachbearbeiterEK kopie = SachbearbeiterEK.gib(benutzername);

		try {
		
			if (!(name.equals("") && pass.equals(""))) {
				System.out.println("Step1");
					if (name.equals(kopie.getBenutzername())) {//Exception "SachbearbeiterEK" 
						System.out.println("Step3");
						if (kopie.getPasswort().equals(pass)) {
							System.out.println("geschafft");
							System.out.println("Benutzername: " + name + " Passwort: " + pass);
							return  true;
						} else {
							FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Passwort ist falsch!!!",null);
							FacesContext fc = FacesContext.getCurrentInstance();
							fc.addMessage(null, msg);
							return  false;
						}
					} else {
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Benutzername ist Falsch!!!!", null);
						FacesContext fc = FacesContext.getCurrentInstance();
						fc.addMessage(null, msg);
						return  false;
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
			return  false;
		}
	}
	
	public String kontrolleBerechtigung(boolean administrator, boolean sachbearbeiter, String name) throws NullPointerException {
		
		
		String admin = "admin";
		String sach = "normal";
		
		try {
		
		if(name.equals(null)) {
			return "";
		}
		else {
			SachbearbeiterEK akt = SachbearbeiterEK.gib(name);
		
			
		if(administrator == true) {
			
			if(akt.gibBerechetigung().equals(admin)) {
				return admin;
			}
			else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Berechtigung des Benutzername ist Falsch!!!", null);
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.addMessage(null, msg);
				return  "";
			}
		}
		else if(sachbearbeiter == true) {
			
			if(akt.gibBerechetigung().equals(sach)) {
				return sach;
			}
			else if(akt.gibBerechetigung().equals(admin)) {
				return sach;
			}
			else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Berechtigung des Benutzername ist Falsch!!!", null);
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.addMessage(null, msg);
				return  "";
			}
		}
		else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Berechtigung Auswählen!!!", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);
		}
		
		return "";
		
		}
		}catch (NullPointerException n) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Falsch Eingabe!!!", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);
			System.out.println("Nur Berechtigung Ausgewählt Error");
			return  "";
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean controll(String benutzername, String passwort) {

		SachbearbeiterEK kopie = SachbearbeiterEK.gib(benutzername);
		System.out.println("hallo");
		if (!(benutzername.equals("") && passwort.equals(""))) {
			System.out.println("Step1");
			for (Iterator<SachbearbeiterEK> it = SachbearbeiterEK.sachbearbeiter.iterator(); it.hasNext();) {
				SachbearbeiterEK temp = it.next();
				if (benutzername.equals(temp.getBenutzername())) {
					System.out.println("Step3");
					if (kopie.getPasswort().equals(passwort)) {
						System.out.println("geschafft");
						return true;
					} else {
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Passwort ist falsch", null);
						FacesContext fc = FacesContext.getCurrentInstance();
						fc.addMessage(null, msg);
						return false;
					}
				} else {
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Benutzername ist Falsch du pissla",
							null);
					FacesContext fc = FacesContext.getCurrentInstance();
					fc.addMessage(null, msg);
				}
			}
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Passwort oder Benutzername darf nicht leer sein!", null);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, msg);

			return false;
		}
		return false;
	}

	public String[] gibSachbearbeiterName() {
		// TODO - implement SachbearbeiterK.gibSachbearbeiterName
		throw new UnsupportedOperationException();
	}

	public void gibSachbearbeiter() {
		// TODO - implement SachbearbeiterK.gibSachbearbeiter
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param kopie
	 */
	public void schreibeSachbearbeiter(SachbearbeiterEK kopie) {
		// TODO - implement SachbearbeiterK.schreibeSachbearbeiter
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public SachbearbeiterEK erzeugeSachbearbeiter(String name) {
		// TODO - implement SachbearbeiterK.erzeugeSachbearbeiter
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void loescheSachbearbeiter(String name) {
		// TODO - implement SachbearbeiterK.loescheSachbearbeiter
		throw new UnsupportedOperationException();
	}

}