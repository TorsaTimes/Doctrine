import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class SachbearbeiterAdminErzeugenAAS extends JPanel {
	
	//------------------------------------Attribute der Klasse---------------------------------------
	private OkLauscherErzeugen okErzeugen = new OkLauscherErzeugen();
	private BeendenLauscherErzeugen beendenErzeugen = new BeendenLauscherErzeugen();
	
	private static SachbearbeiterAdminErzeugenAAS instance;
	
	private JButton buttonAbbruchErzeugen = new JButton();
	private JButton buttonOkErzeugen = new JButton();
	
	private JPanel adminErzeugenPanel = new JPanel();//panel was zurückgegeben wird
	private JPanel adminPanel;//Panel was im lauscher genutzt wird
	private JTextField textFielderzeugen;
	private JPasswordField passwortFielderzeugen;
	private JRadioButton radioButtonSachbearbeiter;
	private JRadioButton radioButtonAdministrator;
	//--------------------------------------------------------------------------------------------
	SachbearbeiterAdminErzeugenK kontrolle = new SachbearbeiterAdminErzeugenK();
	//---------------------------OK-Lauscher-----------------------------------------------------------------
	private class OkLauscherErzeugen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			String neuerName = textFielderzeugen.getText();
			String neuesPasswort = passwortFielderzeugen.getText();
			
			if(radioButtonAdministrator.isSelected()) {
				if(kontrolle.erzeugen(neuerName, neuesPasswort, "admin") == 2) {
					AdminAS.getInstance().entgrauen();
					adminPanel.setVisible(false);
				}
				else {
					
				}
			}
			else if(radioButtonSachbearbeiter.isSelected())  {
				if(kontrolle.erzeugen(neuerName, neuesPasswort, "normal") == 2) {
					AdminAS.getInstance().entgrauen();
					adminPanel.setVisible(false);
				}
				else {
					
				}

			}
			else {
				JOptionPane.showMessageDialog(null,
                        "Überprüfen sie ihre Eingabe",
                        "Warnung",					      
                        JOptionPane.WARNING_MESSAGE);
			}
			//###########################Kontroll Ausgabe################################################
			System.out.println("Neuer Benutzername: " + neuerName);
			System.out.println("Passwort des neuen Benutzers: " + neuesPasswort);
			//###########################################################################################
		}
	}
	//----------------------------------------------------------------------------------
	//----------ActionListener Klasse fuer Beenden button im Editieren Panel------------------
	private class BeendenLauscherErzeugen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			AdminAS.getInstance().entgrauen();
			adminPanel.setVisible(false);
		}
		}
	//-------------------------------------------------------------------------------------------------
	//--------------------------------Instanc der Klasse-------------------------------------------------
	public SachbearbeiterAdminErzeugenAAS getInstance() {
		if(instance == null) {
			instance = new SachbearbeiterAdminErzeugenAAS();
		}
		return instance;
	}
	//----------------------------------------------------------------------------------------------------------
	
	
	public JPanel adminSachbearbeiternErzeugen() {
		JPanel erg = new JPanel();
		erg.setLayout(null);
		
		erg = sachbearbeiterErzeugen(true);
		JButton buttonAbbruchErzeugen = new JButton("Abbruch");
		buttonAbbruchErzeugen.addActionListener(beendenErzeugen);
		buttonAbbruchErzeugen.setBounds(10, 410, 89, 23);
		erg.add(buttonAbbruchErzeugen);
		
		JButton buttonOkErzeugen = new JButton("Ok");
		buttonOkErzeugen.addActionListener(okErzeugen);
		buttonOkErzeugen.setBounds(137, 410, 89, 23);
		erg.add(buttonOkErzeugen);
		erg.repaint();
		adminPanel = erg;
		return erg;
	}
	
	
	public SachbearbeiterAdminErzeugenAAS() {
		adminErzeugenPanel.setLayout(null);
	
		adminErzeugenPanel.setSize(600, 400);
		JLabel lblSachbearbeiterAdmin = new JLabel("Sachbearbeiter Erstellen");
		lblSachbearbeiterAdmin.setBounds(10, 11, 226, 14);
		adminErzeugenPanel.add(lblSachbearbeiterAdmin);//0
		
		JLabel lblBenutzername = new JLabel("Benutzername");
		lblBenutzername.setBounds(10, 50, 137, 14);
		adminErzeugenPanel.add(lblBenutzername);//1
		
		JLabel lblPasswort = new JLabel("Passwort");
		lblPasswort.setBounds(10, 95, 127, 14);
		adminErzeugenPanel.add(lblPasswort);//2
		
		JLabel lblBerechtigung = new JLabel("Berechtigung");
		lblBerechtigung.setBounds(10, 143, 127, 14);
		adminErzeugenPanel.add(lblBerechtigung);//3
		
		JLabel lblFortbildungen = new JLabel("Fortbildungen");
		lblFortbildungen.setBounds(10, 200, 137, 14);
		adminErzeugenPanel.add(lblFortbildungen);//4
		
		textFielderzeugen = new JTextField();
		textFielderzeugen.setBounds(258, 47, 181, 20);
		adminErzeugenPanel.add(textFielderzeugen);//6
		textFielderzeugen.setColumns(10);
		
		passwortFielderzeugen = new JPasswordField();
		passwortFielderzeugen.setBounds(258, 92, 181, 20);
		adminErzeugenPanel.add(passwortFielderzeugen);
		passwortFielderzeugen.setColumns(10);
		
		radioButtonSachbearbeiter = new JRadioButton("Sachbearbeiter");
		radioButtonSachbearbeiter.setBounds(258, 139, 181, 23);
		adminErzeugenPanel.add(radioButtonSachbearbeiter);
		
		radioButtonAdministrator = new JRadioButton("Administrator");
		radioButtonAdministrator.setBounds(258, 165, 181, 23);
		adminErzeugenPanel.add(radioButtonAdministrator);
		
	}
	
	public JPanel sachbearbeiterErzeugen(boolean editierbar) {
		return adminErzeugenPanel;
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