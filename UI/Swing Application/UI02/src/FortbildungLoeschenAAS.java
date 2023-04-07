import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class FortbildungLoeschenAAS {
	
	//------------------------------Attribute der Klasse--------------------------------------------------------------------------
	
	private OkLauscherFortbildungLöschen okFortbildungLöschen = new OkLauscherFortbildungLöschen();
	private BeendenLauscherFortbildungLöschen beendenFortbildungLöschen = new BeendenLauscherFortbildungLöschen();
	
	private JPanel fortbildungLöschenPanel = new JPanel();//panel was zurückgegeben wird
	private JPanel fortbildungPanellöschen;//Panel was im lauscher genutzt wird
	
	private JComboBox comboBoxFortbildungLoeschen;
	
	private static FortbildungLoeschenK kontrolle = new FortbildungLoeschenK();
	SachbearbeiterAuswaehlenAAS combo = new SachbearbeiterAuswaehlenAAS();

	//------------------------------------------------------------------------------------------------------------------------------
	//---------------------------AactionListener klasse des OK Button im Fortbildung Löschen Panel------------------------------------------------------
		private class OkLauscherFortbildungLöschen implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox sachbearbeiterCombo = combo.oeffnen();
				String name = sachbearbeiterCombo.getSelectedItem().toString();
				String fortbildung = comboBoxFortbildungLoeschen.getSelectedItem().toString();
				String erg = "";
				for(int i = 0;i<fortbildung.length();i++) {
					if(fortbildung.charAt(i) == '>') {
						break;
					}
					erg = erg + fortbildung.charAt(i);
				}
				
				if(kontrolle.fortbildungLoeschen(name, erg) == 2) {
					
					JOptionPane.showMessageDialog(null,
	                        "Sachbearbeiter: " + name + " Die Fortbildung: " + fortbildung + " wurde gelöscht ",
	                        "Sachbearbeiter Fortbildung Löschen",					      
	                        JOptionPane.INFORMATION_MESSAGE);
					
					AdminAS.getInstance().entgrauen();
					fortbildungPanellöschen.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null,
					"Bitte überprüfen sie Ihre Eingabe",
                    "Warnung",					      
                    JOptionPane.ERROR_MESSAGE);
				}
				//############################Kontroll Ausgabe###################################################################
				System.out.println();
				//###############################################################################################################
				
			}
		}
		//-----------------------------------------------------------------------------------------------------------------------------------------------
		//----------ActionListener Klasse fuer Beenden button im Fortbildung Zuordnen Panel---------------------------------------------------------------
		private class BeendenLauscherFortbildungLöschen implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent event) {
				AdminAS.getInstance().entgrauen();
				fortbildungPanellöschen.setVisible(false);
			}
			}
		//--------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	public FortbildungLoeschenAAS() {
	
	fortbildungLöschenPanel.setLayout(null);
	fortbildungLöschenPanel.setSize(600, 250);
	
	JLabel lblFortbildungZuordnen = new JLabel("Fortbildung loeschen");
	lblFortbildungZuordnen.setBounds(23, 33, 129, 14);
	fortbildungLöschenPanel.add(lblFortbildungZuordnen);
	
	JLabel lblAusgewhlterSachbearbeiter = new JLabel("Ausgewaehlter Sachbearbeiter");
	lblAusgewhlterSachbearbeiter.setBounds(23, 90, 190, 14);
	fortbildungLöschenPanel.add(lblAusgewhlterSachbearbeiter);
	
	JLabel lblAusgewhlteFortbildung = new JLabel("Ausgewaehlte Fortbildung");
	lblAusgewhlteFortbildung.setBounds(222, 90, 200, 14);
	fortbildungLöschenPanel.add(lblAusgewhlteFortbildung);
	
//	JComboBox comboBoxFortbildung = new JComboBox();
//	comboBoxFortbildung.setBounds(222, 115, 148, 20);
//	fortbildungLöschenPanel.add(comboBoxFortbildung);
	
	
	
	JComboBox ComboBoxSachbearbeiter = combo.oeffnen();
	ComboBoxSachbearbeiter.setBounds(23, 115, 148, 20);
	ComboBoxSachbearbeiter.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = ComboBoxSachbearbeiter.getSelectedItem().toString();
			SachbearbeiterEK sachbearbeiter = SachbearbeiterEK.gib(name);
			
			comboBoxFortbildungLoeschen = new JComboBox (sachbearbeiter.gibStringArrayfuertextArea(name));
			comboBoxFortbildungLoeschen.setBounds(222, 115, 170, 20);
			fortbildungLöschenPanel.add(comboBoxFortbildungLoeschen);
			
//			String fortbildung = comboBoxFortbildungLoeschen.getSelectedItem().toString();
//			String erg = "";
//			for(int i = 0;i<fortbildung.length();i++) {
//				if(fortbildung.charAt(i) == '<') {
//					break;
//				}
//				erg = erg + fortbildung.charAt(i);
//			}
//			kontrolle.fortbildungLoeschen(name, erg);
		}
	});
	fortbildungLöschenPanel.add(ComboBoxSachbearbeiter);
	

	
	
	}
	
	public JPanel adminSachbearbeiternFortbildungLöschen() {
		JPanel erg = new JPanel();
		erg.setLayout(null);
		erg.setSize(600, 250);
		erg = adminSachbearbeiterFortbildungLöschen(true);
		
		JButton buttonAbbruchFortbildungLöschen = new JButton("Abbruch");
		buttonAbbruchFortbildungLöschen.addActionListener(beendenFortbildungLöschen);
		buttonAbbruchFortbildungLöschen.setBounds(23, 290, 89, 23);
		erg.add(buttonAbbruchFortbildungLöschen);
		System.out.println("hallo");
		JButton buttonOkFortbildungLöschen = new JButton("Löschen");
		buttonOkFortbildungLöschen.addActionListener(okFortbildungLöschen);
		buttonOkFortbildungLöschen.setBounds(149, 290, 89, 23);
		erg.add(buttonOkFortbildungLöschen);
		erg.repaint();
		erg.setVisible(true);
		fortbildungPanellöschen = erg;
		return erg;
	}
	public JPanel adminSachbearbeiterFortbildungLöschen(boolean editierbar) {
		return fortbildungLöschenPanel;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static void oeffnen() {
//		
//		System.out.println("Von welchem Sachbearbeiter wird die Fortbildung geloescht?");
//		System.out.println("Bitte geben Sie den Sachbearbeiter ein: ");
//		Scanner input = new Scanner(System.in);
//		String name = input.nextLine();
//		SachbearbeiterEK.druckAlleNamen();
//		System.out.println("Welche Fortbildung soll geloescht werden?");
//		System.out.println("Bitte geben Sie die Fortbildung ein:");
//		String fortbildung = input.nextLine();
//		Fortbildung.druckeAlleFortbildungen();
//		
//		
//		
//		
//		kontrolle.fortbildungLoeschen(name, fortbildung);
//	}
	
	
	
}
