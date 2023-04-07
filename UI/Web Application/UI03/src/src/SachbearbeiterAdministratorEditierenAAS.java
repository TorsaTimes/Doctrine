package src;
import java.io.IOException;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class SachbearbeiterAdministratorEditierenAAS extends SachbearbeiterEditierenAAS {

	
	
	
		// ----------------------------------------------------------------------------------------------------------------------------------

			public String benutzername;
			public String passwort;
			public boolean administrator;
			public boolean sachbearbeiter;
			public boolean prüfen = false;
		
			// ----------------------------------------------------------------------------------------------------------------------------------
			
			  SachbearbeiterEditierenK kontrolle = new SachbearbeiterEditierenK();

			// ----------------------------------------------------------------------------------------------------------------------------------  
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

			public void setAdministrator(boolean admin) {
				administrator = admin;
			}

			public boolean isSachbearbeiter() {
				return sachbearbeiter;
			}

			public void setSachbearbeiter(boolean sach) {
				sachbearbeiter = sach;
			}
		  
			// ----------------------------------------------------------------------------------------------------------------------------------

		  
			public String start() throws IOException {
				
				String nextpage = "/AdministratorAS.xhtml?faces-redirect=true";
				String berechtigung = "";

				benutzername = SachbearbeiterS.benutzername;
				passwort = SachbearbeiterS.passwort;
				administrator = SachbearbeiterS.administratorCheckbox;
				sachbearbeiter = SachbearbeiterS.sachbearbeiterCheckbox;
				boolean page = false;
				
				
				if (administrator) {
					berechtigung = "admin";
				} else if (sachbearbeiter) {
					berechtigung = "normal";
				}

				page = kontrolle.editieren(benutzername, passwort, berechtigung);
				if (page) {
					System.out.println("NextPage ausgeführt");
					SachbearbeiterS.getInstance().setDefault();
					return nextpage;
				} else {
					System.out.println("falsch");
					SachbearbeiterS.getInstance().setDefault();
					return null;
				}
			}

			// ----------------------------------------------------------------------------------------------------------------------------------
		  
			public String zurueck() {
				String nextpage = "/AdministratorAS.xhtml?faces-redirect=true";
				SachbearbeiterS.getInstance().setDefault();
				return nextpage;
			}
			

	public void schliessen() {
		// TODO - implement SachbearbeiterAdminEditierenASS.schliessen
		throw new UnsupportedOperationException();
	}

	public void abbrechen() {
		// TODO - implement SachbearbeiterAdminEditierenASS.abbrechen
		throw new UnsupportedOperationException();
	}

	public void ausgefuehrt() {
		// TODO - implement SachbearbeiterAdminEditierenASS.ausgefuehrt
		throw new UnsupportedOperationException();
	}

	public void sachbearbeiterAdminAuswaehlen() {
		// TODO - implement SachbearbeiterAdminEditierenASS.sachbearbeiterAdminAuswaehlen
		throw new UnsupportedOperationException();
	}

	public void praesentiereSacharbeiter() {
		// TODO - implement SachbearbeiterAdminEditierenASS.praesentiereSacharbeiter
		throw new UnsupportedOperationException();
	}

	public void praesentiereSacharbeiterName() {
		// TODO - implement SachbearbeiterAdminEditierenASS.praesentiereSacharbeiterName
		throw new UnsupportedOperationException();
	}

	public void selektiereSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminEditierenASS.selektiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void modifiziereSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminEditierenASS.modifiziereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	/*public void oeffnen() {
		// TODO - implement SachbearbeiterAdminEditierenASS.oeffnen
		throw new UnsupportedOperationException();
	}*/

}