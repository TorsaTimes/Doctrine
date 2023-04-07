package src;
import java.io.IOException;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class SachbearbeiterAdministratorErstellenAAS {
	
	
	
	// --------------------------------------------------------------------------------------------------------------------------

		public String benutzername;
		public String passwort;
		public boolean administrator;
		public boolean sachbearbeiter;

		// ----------------------------------------------------------------------------------------------------------------------------------

		static SachbearbeiterAdministratorErstellenK kontrolle = new SachbearbeiterAdministratorErstellenK();
		
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

		public boolean isAdministrator() {
			return administrator;
		}

		public void setAdministrator(boolean administrator) {
			administrator = administrator;
		}

		public boolean isSachbearbeiter() {
			return sachbearbeiter;
		}

		public void setSachbearbeiter(boolean sachbearbeiter) {
			sachbearbeiter = sachbearbeiter;
		}
	
		public String start() throws IOException {

			String nextpage = "/AdministratorAS.xhtml?faces-redirect=true";
			String berechtigung = "";
			administrator = SachbearbeiterS.administratorCheckbox;
			sachbearbeiter = SachbearbeiterS.sachbearbeiterCheckbox;
			benutzername = SachbearbeiterS.benutzername;
			passwort = SachbearbeiterS.passwort;
			boolean page = false;

			if (administrator) {
				berechtigung = "admin";
			} else if (sachbearbeiter) {
				berechtigung = "normal";
			}

			page = kontrolle.erzeugen(benutzername, passwort, berechtigung);
			if (page) {
				System.out.println("NextPage ausgeführt");
				SachbearbeiterS.getInstance().setDefault();
				return nextpage;
			} else {
				System.out.println("OK Button wurde nicht Ausgeführt - Error - !!!");
				SachbearbeiterS.getInstance().setDefault();
				return null;
			}
		}
	
		public String zurueck() {
			SachbearbeiterS.getInstance().setDefault();
			String nextpage = "/AdministratorAS.xhtml?faces-redirect=true";
			return nextpage;
		}
		

	public void schliessen() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.schliessen
		throw new UnsupportedOperationException();
	}

	public void abbrechen() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.abbrechen
		throw new UnsupportedOperationException();
	}

	public void ausgefuehrt() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.ausgefuehrt
		throw new UnsupportedOperationException();
	}

	

	public void praesentiereSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.praesentiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void praesentiereSachbearbeiterName() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.praesentiereSachbearbeiterName
		throw new UnsupportedOperationException();
	}

	public void selektiereSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.selektiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void modifiziereSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.modifiziereSachbearbeiter
		throw new UnsupportedOperationException();
	}

}