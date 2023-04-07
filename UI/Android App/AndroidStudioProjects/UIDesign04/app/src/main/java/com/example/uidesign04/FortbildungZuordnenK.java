package com.example.uidesign04;


public class FortbildungZuordnenK {

/*	public boolean sachbearbeiterFortbildungBuchen(String benutzername, String fortbildung, String status) {

		SachbearbeiterEK sachB = SachbearbeiterEK.gib(benutzername);
		
		if (SachbearbeiterEK.gib(benutzername) != null) {

			if (Fortbildung.voraussetzungPruefen(benutzername, fortbildung)) {

				if ((Fortbildung.getFortbildungsStatus(benutzername, fortbildung, status))) {
						
							
						if((Fortbildung.belegungPruefen(benutzername, fortbildung, status) != false) || SachbearbeiterEK.statusVonFortbildungenÜberprüfen(benutzername, fortbildung, status) ) {
							
									
									
					Fortbildung test = Fortbildung.gibFortbildung(fortbildung);

					SachbearbeiterEK.gib(benutzername).fortbildungen.put(test, status);
					Fortbildung.druckeFortbildungenStatus(SachbearbeiterEK.gib(benutzername));
					return true;
							
						}
						else {
                            System.out.println("Sachbearbeiter: " + benutzername + " belegt diese Fortbildung noch nicht");
						return false;
					}
					
					}

				else {
                    System.out.println(" belegt diese Fortbildung schon \t Bitte ordnen Sie den Sachbearbeiter einer anderen Fortbildung zu \n");
					return false;
				}
			} else {
                System.out.println("Vorraussetzung nicht erfuellt");
				return false;
			}

		} else {
			System.out.println("Überprüfen sie ihre Eingabe");

			return false;
		}

	}*/


	public boolean sachbearbeiterFortbildungBuchen(String benutzername, String fortbildung, String status) {

		System.out.println("hallo");
		// SachbearbeiterEK sachB = SachbearbeiterEK.gib(benutzername);
		if (!(status.equals(""))) {
			if (Fortbildung.voraussetzungPruefen(benutzername, fortbildung)) {

				if ((Fortbildung.getFortbildungsStatus(benutzername, fortbildung, status))) {

					if ((Fortbildung.belegungPruefen(benutzername, fortbildung, status) != false)
							|| SachbearbeiterEK.statusVonFortbildungenÜberprüfen(benutzername, fortbildung,
							status)) {

						Fortbildung test = Fortbildung.gibFortbildung(fortbildung);

						SachbearbeiterEK.gib(benutzername).fortbildungen.put(test, status);
						Fortbildung.druckeFortbildungenStatus(SachbearbeiterEK.gib(benutzername));
						return true;

					} else {
						System.out.println(
								"Sachbearbeiter: " + benutzername + " belegt diese Fortbildung noch nicht");

						return false;
					}

				} else {

					System.out.println("Sachbearbeiter: " + benutzername
							+ " belegt diese Fortbildung schon \t Bitte ordnen Sie den Sachbearbeiter einer anderen Fortbildung zu \n");

					return false;
				}
			} else {

				System.out.println("Vorraussetzung nicht erfuellt");
				return false;
			}

		} else {

			System.out.println("Status wählen");


			return false;
		}

	}
}
