import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class FortbildungZuordnenAAS {
	
	//---------------------------------Attribute der Klasse----------------------------------------------------------------------------------------------
	
	private OkLauscherFortbildungZuordnen okZuordnen = new OkLauscherFortbildungZuordnen();
	private BeendenLauscherFortbildungZuordnen beendenZuordnen = new BeendenLauscherFortbildungZuordnen();
	
	Action radioButtonBelegtListener = new radioButtonBelegtButton();
	Action radioButtonBestandenListener = new radioButtonBestandenButton();
	
	private JPanel fortbildungZuordnenPanel = new JPanel();
	private JPanel fortbildungPanel;
	
	private JRadioButton radioButtonBelegt = new JRadioButton(radioButtonBelegtListener);
	private JRadioButton radioButtonBestanden = new JRadioButton(radioButtonBestandenListener);
	SachbearbeiterAuswaehlenAAS comboSachbearbeiter = new SachbearbeiterAuswaehlenAAS();
	FortbildungAuswaehlenAAS comboFortbildung = new FortbildungAuswaehlenAAS();

	public FortbildungZuordnenK kontrolle = new FortbildungZuordnenK();
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------
	//---------------------------AactionListener klasse des OK Button im Fortbildung Zuordnen Panel------------------------------------------------------
	private class OkLauscherFortbildungZuordnen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			String benutzer = getComboBoxSachbearbeiter().getSelectedItem().toString();
			String fortbildung = getComboBoxFortbildung().getSelectedItem().toString();
			if(radioButtonBelegt.isSelected()) {
				System.out.println("belegt");
				String belegt = "belegt";
				if(kontrolle.sachbearbeiterFortbildungBuchen(benutzer, fortbildung, belegt) == 2) {
					
					JOptionPane.showMessageDialog(null,
	                        "Sachbearbeiter: " + benutzer + " wurde der Fortbildung: " + fortbildung + " zugewiesen mit dem Status: " + belegt,
	                        "Sachbearbeiter Fortbildung Zuordnen",					      
	                        JOptionPane.INFORMATION_MESSAGE);
					
					AdminAS.getInstance().entgrauen();
					fortbildungPanel.setVisible(false);
					
				}
				else {
					
				}
			}
			else if(radioButtonBestanden.isSelected()) {
				System.out.println("bestanden");
				String bestanden = "bestanden";
				if(kontrolle.sachbearbeiterFortbildungBuchen(benutzer, fortbildung, bestanden) == 2) {
					
					JOptionPane.showMessageDialog(null,
	                        "Sachbearbeiter: " + benutzer + " wurde der Fortbildung: " + fortbildung + " zugewiesen mit dem Status: " + bestanden,
	                        "Sachbearbeiter Bearbeitet",					      
	                        JOptionPane.INFORMATION_MESSAGE);
					AdminAS.getInstance().entgrauen();
					fortbildungPanel.setVisible(false);
					
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
			//############################Kontroll Ausgabe###################################################################
			System.out.println("Der Benutzer: " + benutzer + " hat die Fortbildung: "  + fortbildung);
			//###############################################################################################################
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//----------ActionListener Klasse fuer Beenden button im Fortbildung Zuordnen Panel---------------------------------------------------------------
	private class BeendenLauscherFortbildungZuordnen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			AdminAS.getInstance().entgrauen();
			fortbildungPanel.setVisible(false);
		}
		}
	//--------------------------------------------------------------------------------------------------------------------------------------------------	
	//----------------------------------------------------------------------------------------------------------------------
	public FortbildungZuordnenAAS() {
		
		fortbildungZuordnenPanel.setLayout(null);
		fortbildungZuordnenPanel.setSize(600, 270);
		
		//------------------------Labels----------------------------------------------------------------------
		JLabel lblFortbildungZuordnen = new JLabel("Fortbildung zuordnen");
		lblFortbildungZuordnen.setBounds(23, 33, 129, 14);
		fortbildungZuordnenPanel.add(lblFortbildungZuordnen);
		
		JLabel lblAusgewhlterSachbearbeiter = new JLabel("Ausgew\u00E4hlter Sachbearbeiter");
		lblAusgewhlterSachbearbeiter.setBounds(23, 90, 170, 14);
		fortbildungZuordnenPanel.add(lblAusgewhlterSachbearbeiter);
		
		JLabel lblAusgewhlteFortbildung = new JLabel("Ausgew\u00E4hlte Fortbildung");
		lblAusgewhlteFortbildung.setBounds(222, 90, 148, 14);
		fortbildungZuordnenPanel.add(lblAusgewhlteFortbildung);
		//-----------------------------------------------------------------------------------------------------
		
		//--------------------------ComboBox fortbildung-----------------------------------------------
		JComboBox comboBoxFortbildung = comboFortbildung.oeffnen();
		comboBoxFortbildung.setBounds(222, 115, 148, 20);
		comboBoxFortbildung.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = comboBoxFortbildung.getSelectedItem().toString();
				
			}
		});
		fortbildungZuordnenPanel.add(comboBoxFortbildung);
		//----------------------------------------------------------------------------------------------------
		
		//----------------------------ComboBox Sachbearbeiter-------------------------------------------------
		JComboBox comboBoxSachbearbeiter = comboSachbearbeiter.oeffnen();
		comboBoxSachbearbeiter.setBounds(23, 115, 148, 20);
		comboBoxSachbearbeiter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = comboBoxSachbearbeiter.getSelectedItem().toString();
				SachbearbeiterEK sach = SachbearbeiterEK.gib(name);
			}
		});
		fortbildungZuordnenPanel.add(comboBoxSachbearbeiter);
		//-----------------------------------------------------------------------------------------------------
		
		//------------------------------RadioButtons-------------------------------------------------------------
		//radioButtonBelegt = new JRadioButton("belegt");
		radioButtonBelegt.setText("belegt");
		radioButtonBelegt.setBounds(23, 225, 109, 23);
		fortbildungZuordnenPanel.add(radioButtonBelegt);
		
		//radioButtonBestanden = new JRadioButton("bestanden");
		radioButtonBestanden.setText("bestanden");
		radioButtonBestanden.setBounds(23, 250, 109, 23);
		fortbildungZuordnenPanel.add(radioButtonBestanden);
		//-----------------------------------------------------------------------------------------------------
	}
	//----------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------------
	public JComboBox getComboBoxSachbearbeiter() {
		return comboSachbearbeiter.oeffnen();
	}
	
	public JComboBox getComboBoxFortbildung() {
		return comboFortbildung.oeffnen();
	}
	//----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	public JPanel adminSachbearbeiternFortbildungZuordnen() {
		JPanel erg = new JPanel();
		erg.setLayout(null);
		
		erg = adminSachbearbeiterFortbildungZuordnen(true);
		JButton buttonAbbruchFortbildungZuordnen = new JButton("Abbruch");
		buttonAbbruchFortbildungZuordnen.addActionListener(beendenZuordnen);
		buttonAbbruchFortbildungZuordnen.setBounds(10, 320, 89, 23);
		erg.add(buttonAbbruchFortbildungZuordnen);
		
		JButton buttonOkFortbildungZuordnen = new JButton("OK");
		buttonOkFortbildungZuordnen.addActionListener(okZuordnen);
		buttonOkFortbildungZuordnen.setBounds(137, 320, 89, 23);
		erg.add(buttonOkFortbildungZuordnen);
		erg.repaint();
		fortbildungPanel = erg;
		return erg;
	}
	public JPanel adminSachbearbeiterFortbildungZuordnen(boolean editierbar) {
		return fortbildungZuordnenPanel;
	}
	//--------------------------------------------------------------------------------------------------------------------
	//------------------------ActionAbstract Klasse für RadioButton - gegenseitges Ausschalten-----------------------------
		class radioButtonBelegtButton extends AbstractAction{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(radioButtonBestanden.isSelected() == true) {
					radioButtonBestanden.setSelected(false);
					}
			}
		}
		class radioButtonBestandenButton extends AbstractAction{
			@Override
			public void actionPerformed(ActionEvent e) {			
				if(radioButtonBelegt.isSelected() == true) {
					radioButtonBelegt.setSelected(false);
				}
				
				}
			}
		//-----------------------------------------------------------------------------------------------------------------------
}
