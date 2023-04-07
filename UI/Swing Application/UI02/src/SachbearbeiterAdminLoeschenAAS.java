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
		private OkLauscherLöschen okErzeugen = new OkLauscherLöschen();
		private BeendenLauscherLöschen beendenErzeugen = new BeendenLauscherLöschen();
		
		private JButton buttonAbbruchLöschen = new JButton();
		private JButton buttonOkLöschen = new JButton();
		
		private JPanel adminLöschenPanel = new JPanel();//panel was zurückgegeben wird
		private JPanel adminPanel;//Panel was im lauscher genutzt wird

		private JRadioButton radioButtonSachbearbeiter;
		private JRadioButton radioButtonAdministrator;
		//--------------------------------------------------------------------------------------------
		private static SachbearbeiterAdminLoeschenAAS instance;
		SachbearbeiterAdminLoeschenK kontrolle = new SachbearbeiterAdminLoeschenK();
		SachbearbeiterAuswaehlenAAS combo = new SachbearbeiterAuswaehlenAAS();
		//---------------------------OK-Lauscher-----------------------------------------------------------------
	
	private class OkLauscherLöschen implements ActionListener{
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
	private class BeendenLauscherLöschen implements ActionListener{
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
	
	public JPanel adminSachbearbeiternLöschen() {
		JPanel erg = new JPanel();
		erg.setLayout(null);
		
		erg = sachbearbeiterLöschen(true);
		JButton buttonAbbruchEditieren = new JButton("Abbruch");
		buttonAbbruchEditieren.addActionListener(beendenErzeugen);
		buttonAbbruchEditieren.setBounds(10, 260, 89, 23);
		erg.add(buttonAbbruchEditieren);
		
		JButton buttonOkEditieren = new JButton("Löschen");
		buttonOkEditieren.addActionListener(okErzeugen);
		buttonOkEditieren.setBounds(137, 260, 89, 23);
		erg.add(buttonOkEditieren);
		erg.repaint();
		adminPanel = erg;
		return erg;
	}
	public JPanel sachbearbeiterLöschen(boolean editierbar) {
		return adminLöschenPanel;
	}
	
	
	public SachbearbeiterAdminLoeschenAAS() {
		adminLöschenPanel.setLayout(null);
		adminLöschenPanel.setSize(600, 250);
		
		JLabel lblSachbearbeiterLschen = new JLabel("Sachbearbeiter Loeschen");
		lblSachbearbeiterLschen.setBounds(26, 40, 165, 14);
		adminLöschenPanel.add(lblSachbearbeiterLschen);
		
		JLabel lblSachbearbeiterAuswhlen = new JLabel("Sachbearbeiter auswaehlen");
		lblSachbearbeiterAuswhlen.setBounds(26, 127, 182, 14);
		adminLöschenPanel.add(lblSachbearbeiterAuswhlen);
		
		JComboBox comboBox = combo.oeffnen();
		comboBox.setBounds(218, 124, 159, 20);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = comboBox.getSelectedItem().toString();
				SachbearbeiterEK sach = SachbearbeiterEK.gib(name);
			}
		});
		adminLöschenPanel.add(comboBox);

	}
	
	public JComboBox getComboBox() {
		return combo.oeffnen();
	}
	

}
