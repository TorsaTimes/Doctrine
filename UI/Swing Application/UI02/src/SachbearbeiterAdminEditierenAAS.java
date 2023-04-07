import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.*;



public class SachbearbeiterAdminEditierenAAS {

	private OkLauscherEditieren okeditieren = new OkLauscherEditieren();
	private BeendenLauscherEditieren beendeneditieren = new BeendenLauscherEditieren();
	private static SachbearbeiterAdminEditierenAAS instance;
	private JButton buttonAbbruchEditieren = new JButton();
	private JButton buttonOkEditieren = new JButton();
	private JPanel adminPanel;
	SachbearbeiterEditierenK kontrolle = new SachbearbeiterEditierenK();
	SachbearbeiterEditierenAAS sachbearbeiterEdit;
	//------------------------------------------------------------------------------------------
	//-------------------------Ok-lauscher---------------------------------------------------------
	private class OkLauscherEditieren implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			String benutzer = sachbearbeiterEdit.getComboBox().getSelectedItem().toString();
			String geandertName = sachbearbeiterEdit.getTextFieldBenutzer();
			String geandertPasswort = sachbearbeiterEdit.getPasswortFieldpasswort();
			
			if(sachbearbeiterEdit.getRadioButtonAdministrator().isSelected() == true) {
				if(kontrolle.editieren(geandertName, geandertPasswort, "admin", benutzer) == 2){
					
					JOptionPane.showMessageDialog(null,
	                        "Benutzer :" + benutzer + " wurde editiert",
	                        "Sachebarbeiter Editieren",					      
	                        JOptionPane.INFORMATION_MESSAGE);
					
					AdminAS.getInstance().entgrauen();
					adminPanel.setVisible(false);
				}
				else {
					//Passiert nicht Benutzer bleibt im Menü Sachbearbeiter Editieren
				}
				
			}
			else if(sachbearbeiterEdit.getRadioButtonAdministrator().isSelected() == true){
				if(kontrolle.editieren(geandertName, geandertPasswort, "normal", benutzer) == 2) {
					
					JOptionPane.showMessageDialog(null,
	                        "Benutzer :" + benutzer + " wurde editiert",
	                        "Sachebarbeiter Editieren",					      
	                        JOptionPane.INFORMATION_MESSAGE);
					
					AdminAS.getInstance().entgrauen();
					adminPanel.setVisible(false);
				}
				else {
					//Passiert nicht Benutzer bleibt im Menü Sachbearbeiter Editieren
				}
			}
			else {
				JOptionPane.showMessageDialog(null,
                        "Keine Berechtigung gewählt",
                        "Sachebarbeiter Editieren",					      
                        JOptionPane.WARNING_MESSAGE);
			}
			
			
			//#########################Kontroll Ausgaben in der Konsole##########################################
			System.out.println("Ausgewaehlter Benutzer " + benutzer);
			System.out.println("Geanderter Name des Benutzers " + geandertName);
			System.out.println("Geandertes Passwort des Benutzers " + geandertPasswort);
			//System.out.println(SachbearbeiterEK.gib(benutzer).gibBerechetigung());
			SachbearbeiterEK.druckAlleNamen();
			//###########################################################################################
		}
	}
	//----------------------------------------------------------------------------------
	//----------ActionListener Klasse fuer Beenden button im Editieren Panel------------------
	private class BeendenLauscherEditieren implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			AdminAS.getInstance().entgrauen();
			adminPanel.setVisible(false);
		}
		}
	//-------------------------------------------------------------------------------------------------
	public SachbearbeiterAdminEditierenAAS getInstance() {
		if(instance == null) {
			instance = new SachbearbeiterAdminEditierenAAS();
		}
		return instance;
	}
	//-----------------------------------------------------------------------------------------------------
	
	public JPanel adminSachbearbeiternEditieren() {
		JPanel erg = new JPanel();
		erg.setLayout(null);
		sachbearbeiterEdit = new SachbearbeiterEditierenAAS();
		erg = sachbearbeiterEdit.sachbearbeiterEditieren(true);
		JButton buttonAbbruchEditieren = new JButton("Abbruch");
		buttonAbbruchEditieren.addActionListener(beendeneditieren);
		buttonAbbruchEditieren.setBounds(10, 410, 89, 23);
		erg.add(buttonAbbruchEditieren);
		
		
		JButton buttonOkEditieren = new JButton("Ok");
		buttonOkEditieren.addActionListener(okeditieren);
		buttonOkEditieren.setBounds(137, 410, 89, 23);
		erg.add(buttonOkEditieren);
		erg.repaint();
		adminPanel = erg;
		return erg;
	}	
}
