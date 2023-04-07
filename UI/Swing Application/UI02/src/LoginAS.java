import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.*;

public class LoginAS extends SachbearbeiterS{

	//-------------------------Attribute------------------------------------------------
	private static LoginK controll = new LoginK();
	private static JPanel panel = SachbearbeiterS.getInstance().konfiguriereSachbearbeiterPanel();
	private static JButton buttonBeenden = SachbearbeiterS.getInstance().getJButtonBeenden();
	private static JButton buttonOk = SachbearbeiterS.getInstance().getJButtonOk();
	private static JTextField jTextBenutzername = SachbearbeiterS.getInstance().getTextFieldbenutzername();
	private static JPasswordField jPasswortfield = SachbearbeiterS.getInstance().getTextFieldpasswort();
	private static LoginAS instance;
	private OkLauscher okLauscher = new OkLauscher();
	private BeendenLauscher beendenLauscher = new BeendenLauscher();
	private static HashMap<String, Component> componentMap2 = SachbearbeiterS.getInstance().getComponentHashMap();
	private JPanel panelLogin;

	
	//------------------------------------------------------------------------------------
	//----------------------------Eine Instanz erzeugen von LoginAS------------------------
	public static LoginAS getInstance() {
		if(instance == null) {
			instance = new LoginAS();
		}
		return instance;
	}
	//-------------------------------------------------------------------------------------
	//---------Login JPanel von SachbearbeiterS an LehrveranstaltungHS uebergeben------------------
//	public JPanel login() {
//		instance.lauscherUebergeben();
//		return panel;
//	}
	//-------------------------------------------------------------------------------------------
	
	//----------ActionListener Klasse fuer Ok button im Login Panel------------------
		private class OkLauscher implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent event) {
				String berechtigung = "";
				berechtigung = controll.anmelden(jTextBenutzername.getText(), jPasswortfield.getText());
				if(berechtigung != null) {
					System.out.println(berechtigung + "Die Berechtigung des Benutzers");
					if((SachbearbeiterS.RadioButtonAdministrator.isSelected() && berechtigung.equals("admin"))) {
						System.out.println("admin ausgewaehlt super");
						LehrveranstaltungsverwaltungHS.loginBeenden(1,panel);
						
					} 
					else if(((SachbearbeiterS.RadioButtonSachbearbeiter.isSelected() == true) && berechtigung.equals("normal"))){
						System.out.println("Sach");
					}
					else {
						JOptionPane.showMessageDialog(null,
	                            "Die Berechtigung ist Falsch",
	                            "Warnung",					      
	                            JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null,
                            "Das Passwort/Benutzername wurde Falsch eingegeben",
                            "Warnung",					      
                            JOptionPane.WARNING_MESSAGE);
							
				}
				System.out.println("OKLauscher wurde Aufgerufen");
				
				}
			}
		//----------------------------------------------------------------------------------
		//----------ActionListener Klasse fuer Beenden button im Login Panel------------------
		class BeendenLauscher implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent event) {
//				System.out.println("Hallo");
				jTextBenutzername.setText(null);
				jPasswortfield.setText(null);
				SachbearbeiterS.RadioButtonAdministrator.setSelected(false);
				SachbearbeiterS.RadioButtonSachbearbeiter.setSelected(false);
//				//SachbearbeiterSS.getPanelLogin().setVisible(false);
//				LehrveranstaltungsverwaltungHS.f.remove(LehrveranstaltungsverwaltungHS.PanelLoginLVV);
//				//LehrveranstaltungsverwaltungHS.f.pack();
//				LehrveranstaltungsverwaltungHS.f.repaint();
//				//LehrveranstaltungsverwaltungHS.f.setVisible(true);
				System.out.println("beenden");
				panelLogin.setVisible(false);
			}
			}
		//----------------------------------------------------------------------------------
		
		//-----------------------------HashMap-Components-Fischen---------------------------
//		public static Component getComponentByName(String name) {
//	        if (componentMap2.containsKey(name)) {
//	                return (Component) componentMap2.get(name);
//	        }
//	        else return null;
//			}
		//-----------------------------------------------------------------------------------
		//-------------------ActionListener-Class uebergeben an die Buttons------------------
//		public void lauscherUebergeben() {
//			buttonOk.addActionListener(okLauscher);
//			buttonBeenden.addActionListener(beendenLauscher);
//		}
		//-----------------------------------------------------------------------------------
		//-----------------------------------Alte Klassen-------------------------------------
	public String[] praesentiereSachbearbeiterName() {
		// TODO - implement LoginAS.praesentiereSachbearbeiterName
		throw new UnsupportedOperationException();
	}

	public void praesentiereSachbearbeiter() {
		// TODO - implement LoginAS.praesentiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void selektiereSachbearbeiter() {
		// TODO - implement LoginAS.selektiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void modifiziereSachbearbeiter() {
		// TODO - implement LoginAS.modifiziereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	
	public void schliessen() {
		// TODO - implement LoginAS.schliessen
		throw new UnsupportedOperationException();
	}

	public void abbrechen() {
		// TODO - implement LoginAS.abbrechen
		throw new UnsupportedOperationException();
	}

	public void ausgefuehrt() {
		// TODO - implement LoginAS.ausgefuehrt
		throw new UnsupportedOperationException();
	}
	//---------------------------------------------------------------------------------------------
	public JPanel loginPanel() {
		JPanel erg = new JPanel();
		erg.setLayout(null);
		erg.setSize(400, 400);
		SachbearbeiterS loginPanelHolen = new SachbearbeiterS();
		erg = loginPanelHolen.getPanelLogin();
		JButton buttonAbbruchFortbildungLöschen = new JButton("Abbruch");
		buttonAbbruchFortbildungLöschen.addActionListener(beendenLauscher);
		buttonAbbruchFortbildungLöschen.setBounds(151, 348, 87, 23);
		erg.add(buttonAbbruchFortbildungLöschen);

		JButton buttonOkFortbildungLöschen = new JButton("OK");
		buttonOkFortbildungLöschen.addActionListener(okLauscher);
		buttonOkFortbildungLöschen.setBounds(35, 348, 87, 23);
		erg.add(buttonOkFortbildungLöschen);
		erg.repaint();
		erg.setVisible(true);
		panelLogin = erg;
		return erg;
	}
	public JPanel login(boolean editierbar) {
		return panel;
	}
	
	

}