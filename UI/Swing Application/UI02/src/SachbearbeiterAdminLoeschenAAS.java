import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SachbearbeiterAdminLoeschenAAS{

	//------------------------------------Attribute der Klasse---------------------------------------
		private OkLauscherL�schen okErzeugen = new OkLauscherL�schen();
		private BeendenLauscherL�schen beendenErzeugen = new BeendenLauscherL�schen();
		
		private JButton buttonAbbruchL�schen = new JButton();
		private JButton buttonOkL�schen = new JButton();
		
		private JPanel adminL�schenPanel = new JPanel();//panel was zur�ckgegeben wird
		private JPanel adminPanel;//Panel was im lauscher genutzt wird

		private JRadioButton radioButtonSachbearbeiter;
		private JRadioButton radioButtonAdministrator;
		//--------------------------------------------------------------------------------------------
		private static SachbearbeiterAdminLoeschenAAS instance;
		SachbearbeiterAdminLoeschenK kontrolle = new SachbearbeiterAdminLoeschenK();
		SachbearbeiterAuswaehlenAAS combo = new SachbearbeiterAuswaehlenAAS();
		//---------------------------OK-Lauscher-----------------------------------------------------------------
	
	private class OkLauscherL�schen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			String benutzer = getComboBox().getSelectedItem().toString();
			kontrolle.loeschen(benutzer);
			AdminAS.getInstance().entgrauen();
			adminPanel.setVisible(false);
			//############################Kontroll Ausgabe###################################################################
			System.out.println("Der Benutzer: " + benutzer + " wurde geloescht");
			//###############################################################################################################
		}
	}
	//----------------------------------------------------------------------------------
	//----------ActionListener Klasse fuer Beenden button im Editieren Panel------------------
	private class BeendenLauscherL�schen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			AdminAS.getInstance().entgrauen();
			adminPanel.setVisible(false);
		}
		}
	//-------------------------------------------------------------------------------------------------
	//--------------------------------Instanc der Klasse-------------------------------------------------
	public SachbearbeiterAdminLoeschenAAS getInstance() {
		if(instance == null) {
			instance = new SachbearbeiterAdminLoeschenAAS();
		}
		return instance;
	}
	
	public JPanel adminSachbearbeiternL�schen() {
		JPanel erg = new JPanel();
		erg.setLayout(null);
		
		erg = sachbearbeiterL�schen(true);
		JButton buttonAbbruchEditieren = new JButton("Abbruch");
		buttonAbbruchEditieren.addActionListener(beendenErzeugen);
		buttonAbbruchEditieren.setBounds(10, 260, 89, 23);
		erg.add(buttonAbbruchEditieren);
		
		JButton buttonOkEditieren = new JButton("L�schen");
		buttonOkEditieren.addActionListener(okErzeugen);
		buttonOkEditieren.setBounds(137, 260, 89, 23);
		erg.add(buttonOkEditieren);
		erg.repaint();
		adminPanel = erg;
		return erg;
	}
	public JPanel sachbearbeiterL�schen(boolean editierbar) {
		return adminL�schenPanel;
	}
	
	
	public SachbearbeiterAdminLoeschenAAS() {
		adminL�schenPanel.setLayout(null);
		adminL�schenPanel.setSize(600, 250);
		
		JLabel lblSachbearbeiterLschen = new JLabel("Sachbearbeiter Loeschen");
		lblSachbearbeiterLschen.setBounds(26, 40, 165, 14);
		adminL�schenPanel.add(lblSachbearbeiterLschen);
		
		JLabel lblSachbearbeiterAuswhlen = new JLabel("Sachbearbeiter auswaehlen");
		lblSachbearbeiterAuswhlen.setBounds(26, 127, 182, 14);
		adminL�schenPanel.add(lblSachbearbeiterAuswhlen);
		
		JComboBox comboBox = combo.oeffnen();
		comboBox.setBounds(218, 124, 159, 20);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = comboBox.getSelectedItem().toString();
				SachbearbeiterEK sach = SachbearbeiterEK.gib(name);
			}
		});
		adminL�schenPanel.add(comboBox);

	}
	
	public JComboBox getComboBox() {
		return combo.oeffnen();
	}
	

}
