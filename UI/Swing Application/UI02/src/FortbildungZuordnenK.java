
import javax.swing.JOptionPane;

public class FortbildungZuordnenK {

	public int sachbearbeiterFortbildungBuchen(String benutzername, String fortbildung, String status) {

		SachbearbeiterEK sachB = SachbearbeiterEK.gib(benutzername);
		
		if (SachbearbeiterEK.gib(benutzername) != null) {

			if (Fortbildung.voraussetzungPruefen(benutzername, fortbildung)) {

				if ((Fortbildung.getFortbildungsStatus(benutzername, fortbildung, status))) {
						
							
						if((Fortbildung.belegungPruefen(benutzername, fortbildung, status) != false) || SachbearbeiterEK.statusVonFortbildungenÜberprüfen(benutzername, fortbildung, status) ) {
							
									
									
					Fortbildung test = Fortbildung.gibFortbildung(fortbildung);

					SachbearbeiterEK.gib(benutzername).fortbildungen.put(test, status);
					Fortbildung.druckeFortbildungenStatus(SachbearbeiterEK.gib(benutzername));
					return 2;
							
						}
						else {
						JOptionPane.showMessageDialog(null, "Sachbearbeiter: " + benutzername + " belegt diese Fortbildung noch nicht",
								"Warnung", JOptionPane.WARNING_MESSAGE);
						return 1;
					}
					
					}

				else {
					JOptionPane.showMessageDialog(null, "Sachbearbeiter: " + benutzername
							+ " belegt diese Fortbildung schon \t Bitte ordnen Sie den Sachbearbeiter einer anderen Fortbildung zu \n",
							"Warnung", JOptionPane.WARNING_MESSAGE);
					return 1;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Vorraussetzung nicht erfuellt", "Warnung",
						JOptionPane.WARNING_MESSAGE);
				return 1;
			}

		} else {
			JOptionPane.showMessageDialog(null, "Überprüfen sie ihre Eingabe", "Warnung", JOptionPane.WARNING_MESSAGE);
			return 1;
		}

	}

}
