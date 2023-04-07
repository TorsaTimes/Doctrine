package src;
import java.io.IOException;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@ApplicationScoped
public class SachbearbeiterSachbearbeiterEditierenAAS extends SachbearbeiterEditierenAAS {

	// ----------------------------------------------------------------------------------------------------------------------------------

	
	
				public String benutzername;
				public String passwort;
			
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


			  
				// ----------------------------------------------------------------------------------------------------------------------------------

			  
				public String start() throws IOException {
					
					String nextpage = "/SachbearbeiterAS.xhtml?faces-redirect=true";
					String berechtigung = "";

					benutzername = SachbearbeiterS.benutzername;
					passwort = SachbearbeiterS.passwort;
					boolean page = false;
					
					SachbearbeiterEK akt = SachbearbeiterEK.gib(SachbearbeiterAuswaehlenAAS.selectedSachbearbeiter);
					berechtigung = akt.berechtigung;

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
					String nextpage = "/SachbearbeiterAS.xhtml?faces-redirect=true";
					SachbearbeiterS.getInstance().setDefault();
					return nextpage;
				}
	
	
	
	
	public void schliessen() {
		// TODO - implement SachbearbeiterNormalEditierenASS.schliessen
		throw new UnsupportedOperationException();
	}

	public void abbrechen() {
		// TODO - implement SachbearbeiterNormalEditierenASS.abbrechen
		throw new UnsupportedOperationException();
	}

	public void ausgefuehrt() {
		// TODO - implement SachbearbeiterNormalEditierenASS.ausgefuehrt
		throw new UnsupportedOperationException();
	}

	public void sachbearbeiterAuswaehlen() {
		// TODO - implement SachbearbeiterNormalEditierenASS.sachbearbeiterAuswaehlen
		throw new UnsupportedOperationException();
	}

	public void praesentiereSacharbeiter() {
		// TODO - implement SachbearbeiterNormalEditierenASS.praesentiereSacharbeiter
		throw new UnsupportedOperationException();
	}

	public void praesentiereSacharbeiterName() {
		// TODO - implement SachbearbeiterNormalEditierenASS.praesentiereSacharbeiterName
		throw new UnsupportedOperationException();
	}

	public void selektiereSacharbeiter() {
		// TODO - implement SachbearbeiterNormalEditierenASS.selektiereSacharbeiter
		throw new UnsupportedOperationException();
	}

	public void modifiziereSacharbeiter() {
		// TODO - implement SachbearbeiterNormalEditierenASS.modifiziereSacharbeiter
		throw new UnsupportedOperationException();
	}


}