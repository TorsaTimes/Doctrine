package src;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="SachbearbeiterS")
@RequestScoped

public class SachbearbeiterS implements Serializable {

	public static String benutzername;
	public static String passwort;
	public String name1;
	public String passwort1;
	public static boolean administratorCheckbox;
	public static boolean sachbearbeiterCheckbox;
	public static SachbearbeiterS instance;

	private static final long serialVersionUID = 1L;
	public static SachbearbeiterK SK = new SachbearbeiterK();
	
	//---------------------------------------------------------------
	
	
	

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public boolean isAdministratorCheckbox() {
		return administratorCheckbox;
	}

	public void setAdministratorCheckbox(boolean administratorCheckbox) {
		this.administratorCheckbox = administratorCheckbox;
	}

	public boolean isSachbearbeiterCheckbox() {
		return sachbearbeiterCheckbox;
	}

	public void setSachbearbeiterCheckbox(boolean sachbearbeiterCheckbox) {
		this.sachbearbeiterCheckbox = sachbearbeiterCheckbox;
	}
	
	//--------------------------------------------------------------------------
	
	public static SachbearbeiterS getInstance() {
		if(instance == null) {
			instance = new SachbearbeiterS();
		}
		return instance;
	}
	
	//----------------------------------------------------------------------------
	
	public void setDefault() {

		setAdministratorCheckbox(false);
		setSachbearbeiterCheckbox(false);
		setBenutzername("");
		setPasswort("");
	}
	

	public String[] praesentiereSachbearbeiterNamen() {
		// TODO - implement SachbearbeiterS.praesentiereSachbearbeiterNamen
		throw new UnsupportedOperationException();
	}

	public void praesentiereSachbearbeiter() {
		// TODO - implement SachbearbeiterS.praesentiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void selektiereSachbearbeiter() {
		// TODO - implement SachbearbeiterS.selektiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void modifizierenSachbearbeiter() {
		// TODO - implement SachbearbeiterS.modifizierenSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void setBenutzername() {
		// TODO - implement SachbearbeiterS.setBenutzername
		throw new UnsupportedOperationException();
	}

	public void setPasswort() {
		// TODO - implement SachbearbeiterS.setPasswort
		throw new UnsupportedOperationException();
	}

	public void setBerechtigung() {
		// TODO - implement SachbearbeiterS.setBerechtigung
		throw new UnsupportedOperationException();
	}

}