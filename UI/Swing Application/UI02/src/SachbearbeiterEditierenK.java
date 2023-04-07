import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class SachbearbeiterEditierenK {

	public int editieren(String geandertName, String geandertPasswort, String radioButton, String Benutzer) {

		SachbearbeiterEK aktuellerBenutzer = SachbearbeiterEK.gib(Benutzer);

		if ((geandertName.equals("")) || (geandertPasswort.equals(""))) {

			JOptionPane.showMessageDialog(null, "Passwort/Benutzername Darf nicht null sein", "Warnung",
					JOptionPane.WARNING_MESSAGE);
			return 1;

		} else {

			if (benutzernamenVorgabenpruefen(geandertName)) {
				aktuellerBenutzer.setBerechtigung(radioButton);
				aktuellerBenutzer.setBenutzername(geandertName);
				aktuellerBenutzer.setPasswort(geandertPasswort);

				return 2;

			} else {

				JOptionPane.showMessageDialog(null, "Benutzername entspricht nicht den Vorgaben", "Warnung",
						JOptionPane.WARNING_MESSAGE);
				return 1;
			}

		}

	}

	public void berechtigungaendern(String benutzername, String berechtigung) {

		if (SachbearbeiterEK.gib(benutzername).getBenutzername().equals(benutzername)) {

			SachbearbeiterEK.gib(benutzername).setBerechtigung(berechtigung);
			System.out.println("Die Berechtigung des Benutzers " + benutzername + " wurde geändert");
			System.out.println("Die neue Berechtigung ist nun " + "[" + berechtigung + "]");
			return;
		}

		System.out.println("Die Benutzer eingabe war falsch!!!");

	}

	public void benutzernamenaendern(String name1, String name2) {

		if (SachbearbeiterEK.gib(name1) != null) {

			if (benutzernamenVorgabenpruefen(name2)) {

				if (SachbearbeiterEK.gib(name1).getBenutzername().equals(name1)) {

					SachbearbeiterEK.gib(name1).setBenutzername(name2);
					SachbearbeiterEK.druckAlleNamen();

				} else {
					System.out.println("Benutzername nicht vorhanden!");
					return;

				}
			} else {
				System.out.println("Benutzername entspricht nicht den Vorgaben!!!!");
				System.out.println("Beispiel: Müller_Hans");
				return;

			}
		} else {
			System.out.println("Benutzername ist Falsch geschrieben/exsistiert nicht!!!!");
			return;
		}

	}

	public void paswortAendern(String name1, String passwort) {

		if (SachbearbeiterEK.gib(name1) != null) {

			if (SachbearbeiterEK.gib(name1).getBenutzername().equals(name1)) {
				SachbearbeiterEK.gib(name1).setPasswort(passwort);
				SachbearbeiterEK.druckeAlleNamenPasswoerter();

			} else {
				System.out.println("Passwort nicht vorhanden!");

			}
		} else {
			System.out.println("Benutzername ist Falsch geschrieben/exsistiert nicht!!!!");
			return;
		}

	}

	public boolean benutzernamenVorgabenpruefen(String name) {

		String eingabenKontrolle = "^((((\\w*))|(([ä])*)|(([ö])*)|(([ü])*)|(([Ü])*)|(([Ö])*)|(([Ä])*)|(([ß])*))*)[_]?((((\\w*))|(([ä])*)|(([ö])*)|(([ü])*)|(([Ü])*)|(([Ö])*)|(([Ä])*)|(([ß])*))*)$";

		if (Pattern.matches(eingabenKontrolle, name)) {
			return true;
		} else {

			return false;
		}
	}

	public String[] gibAlleSachbearbeiterNamen() {
		// TODO - implement SachbearbeiterEditierenK.gibAlleSachbearbeiterNamen
		throw new UnsupportedOperationException();
	}

	public void gibSachbearbeiter() {
		// TODO - implement SachbearbeiterEditierenK.gibSachbearbeiter
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sachbearbeiter
	 */
	public void schriebeSachbearbeiter(int sachbearbeiter) {
		// TODO - implement SachbearbeiterEditierenK.schriebeSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public SachbearbeiterEK erzeugeSachbearbeiter() {
		// TODO - implement SachbearbeiterEditierenK.erzeugeSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void loescheSach() {
		// TODO - implement SachbearbeiterEditierenK.loescheSach
		throw new UnsupportedOperationException();
	}
	// -------------------------------------------------------------------------------------------------------------------

}