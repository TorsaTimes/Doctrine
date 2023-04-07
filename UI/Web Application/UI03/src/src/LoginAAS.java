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

@ManagedBean(name = "loginAAS")
@RequestScoped

public class LoginAAS extends SachbearbeiterK implements Serializable {

	

	
	private static final long serialVersionUID = 1L;
	//SachbearbeiterS sachS = new SachbearbeiterS();
	public String usernameInputLogin = SachbearbeiterS.benutzername;
	public String userpasswordInputLogin = SachbearbeiterS.passwort;
	public String nameLogin;
	public String passwortLogin;
	public boolean userberechtigungInputAdminLogin = SachbearbeiterS.administratorCheckbox;
	public boolean userberechtigungInputSachLogin = SachbearbeiterS.sachbearbeiterCheckbox;
	private boolean prüfen = false;
	private static LoginAAS instance;
	
	SachbearbeiterK kontrolle = new SachbearbeiterK();

	// ------------------------------------------------------------------------------------------
	
	
	public String getUsernameInputLogin() {
		return usernameInputLogin;
	}
	public void setUsernameInputLogin(String usernameInputLogin) {
		this.usernameInputLogin = usernameInputLogin;
	}
	public String getUserpasswordInputLogin() {
		return userpasswordInputLogin;
	}
	public void setUserpasswordInputLogin(String userpasswordInputLogin) {
		this.userpasswordInputLogin = userpasswordInputLogin;
	}
	public String getNameLogin() {
		return nameLogin;
	}
	public void setNameLogin(String nameLogin) {
		this.nameLogin = nameLogin;
	}
	public String getPasswortLogin() {
		return passwortLogin;
	}
	public void setPasswortLogin(String passwortLogin) {
		this.passwortLogin = passwortLogin;
	}
	public boolean isUserberechtigungInputAdminLogin() {
		return userberechtigungInputAdminLogin;
	}
	public void setUserberechtigungInputAdminLogin(boolean userberechtigungInputAdminLogin) {
		this.userberechtigungInputAdminLogin = userberechtigungInputAdminLogin;
	}
	public boolean isUserberechtigungInputSachLogin() {
		return userberechtigungInputSachLogin;
	}
	public void setUserberechtigungInputSachLogin(boolean userberechtigungInputSachLogin) {
		this.userberechtigungInputSachLogin = userberechtigungInputSachLogin;
	}


	// --------------------------------------------------------------------------------------
	public static LoginAAS getInstance() {
		if (instance == null) {
			instance = new LoginAAS();
		}
		return instance;
	}
	// ---------------------------------------------------------------------------------------
	public String start() throws IOException {
		
		String nextpage = null;
		boolean istAdmin = userberechtigungInputAdminLogin;
		boolean istSach = userberechtigungInputSachLogin;
		String name = usernameInputLogin;
		String passwort = userpasswordInputLogin;
		
		
		System.out.println("Berechtigung wurde ausgewählt: "+istAdmin +" "+ istSach);

		
		
		String berechtigungZwischenspeicher = kontrolle.kontrolleBerechtigung(istAdmin, istSach, name);

		if (berechtigungZwischenspeicher.equals("admin")) {
			System.out.println("Administrator Ausgewählt");
			nextpage = "/AdministratorAS.xhtml?faces-redirect=true";
		} else if (berechtigungZwischenspeicher.equals("normal")) {
			System.out.println("Sachbearbeiter Ausgewählt");

			nextpage = "/SachbearbeiterAS.xhtml?faces-redirect=true";
		}
//		else{
//			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
//					"Berechtigung AuswählenElse in der Start methode!!!!", null);
//			FacesContext fc = FacesContext.getCurrentInstance();
//			fc.addMessage(null, msg);
//		}
		
		
		System.out.println("Kontrolle");
		System.out.println("Name und Passwort: "+usernameInputLogin +" "+ userpasswordInputLogin );
		prüfen = kontrolle.kontrollAnmelden(name, passwort);
		
		if (prüfen) {
			System.out.println("NextPage ausgeführt");
			SachbearbeiterS.getInstance().setDefault();
			return nextpage;
		} else {
			System.out.println("falsch");
			SachbearbeiterS.getInstance().setDefault();
			return null;
		}
	}
	
	//--------------------------------------------------------------------------------------------------
	public String zurueck() {
		String nextpage = "/SachbearbeiterverwaltungHS.xhtml?faces-redirect=true";
		SachbearbeiterS.getInstance().setDefault();
		return nextpage;
	}

//	public void kontroll(String benutzername, String passwort) throws NullPointerException {
//
//		String name = benutzername; 
//		String pass = passwort;
//		SachbearbeiterEK kopie = SachbearbeiterEK.gib(benutzername);
//
//		try {
//		
//			if (!(name.equals("") && pass.equals(""))) {
//				System.out.println("Step1");
//					if (name.equals(kopie.getBenutzername())) {//Exception "SachbearbeiterEK" 
//						System.out.println("Step3");
//						if (kopie.getPasswort().equals(pass)) {
//							System.out.println("geschafft");
//							System.out.println("Benutzername: " + name + " Passwort: " + pass);
//							prüfen = true;
//						} else {
//							FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Passwort ist falsch!!!",null);
//							FacesContext fc = FacesContext.getCurrentInstance();
//							fc.addMessage(null, msg);
//							prüfen = false;
//						}
//					} else {
//						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
//								"Benutzername ist Falsch!!!!", null);
//						FacesContext fc = FacesContext.getCurrentInstance();
//						fc.addMessage(null, msg);
//						prüfen = false;
//					}
//			} else {
//				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
//						"Passwort oder Benutzername darf nicht leer sein!", null);
//				FacesContext fc = FacesContext.getCurrentInstance();
//				fc.addMessage(null, msg);
//				prüfen = false;
//			}
//		} catch (NullPointerException n) {
//			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Benutzername oder Passwort falsch!", null);
//			FacesContext fc = FacesContext.getCurrentInstance();
//			fc.addMessage(null, msg);
//			prüfen = false;
//		}
//	}
	
//	public String berechtigungPrüfen(boolean admin, boolean sach) {
//		
//		if((admin && sach) == false) {
////			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Berechtigung Auswählen!!!!", null);
////			FacesContext fc = FacesContext.getCurrentInstance();
////			fc.addMessage(null, msg);
//			return "";
//		}
//		return "";
//	}
	
	
	
	public String[] praesentiereSachbearbeiterName() {
		// TODO - implement LoginAS.praesentiereSachbearbeiterName
		throw new UnsupportedOperationException();
	}

	public void praesentiereSachbearbeiter() {
		// TODO - implement LoginAS.praesentiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void selektiereSachbearbeiter() {
		// TODO - implement LoginAS.selektiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void modifiziereSachbearbeiter() {
		// TODO - implement LoginAS.modifiziereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void schliessen() {
		// TODO - implement LoginAS.schliessen
		throw new UnsupportedOperationException();
	}

	public void abbrechen() {
		// TODO - implement LoginAS.abbrechen
		throw new UnsupportedOperationException();
	}

	public void ausgefuehrt() {
		// TODO - implement LoginAS.ausgefuehrt
		throw new UnsupportedOperationException();
	}

}