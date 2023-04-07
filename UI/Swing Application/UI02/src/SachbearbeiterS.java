import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.util.*;



//	class OKAction extends AbstractAction{
//		
//		@Override
//		public void actionPerformed(ActionEvent event) {
//			//SachbearbeiterSS.textFieldbenutzername.getText();
//			System.out.println(SachbearbeiterSS.getInstance().getTextFieldbenutzername().getText());
//			System.out.println(SachbearbeiterSS.getInstance().getTextFieldpasswort().getText());
//			String name = SachbearbeiterSS.getInstance().getTextFieldbenutzername().getText();
//			String passwort = SachbearbeiterSS.getInstance().getTextFieldpasswort().getText();
//			
//			SachbearbeiterSS.SK.controll(name, passwort);
//			
//		}
//		
//	}
//	class ExitAAction extends AbstractAction{
//	
//		@Override
//		public void actionPerformed(ActionEvent event) {
//			
//			System.out.println("Hallo");
//			//SachbearbeiterSS.getPanelLogin().setVisible(false);
//			LehrveranstaltungsverwaltungHS.f.remove(LehrveranstaltungsverwaltungHS.PanelLoginLVV);
//			//LehrveranstaltungsverwaltungHS.f.pack();
//			LehrveranstaltungsverwaltungHS.f.repaint();
//			//LehrveranstaltungsverwaltungHS.f.setVisible(true);
//		}
//		
//	}
	class RadioButtonSach extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent event) {
			if(SachbearbeiterS.RadioButtonAdministrator.isSelected() == true) {
				SachbearbeiterS.RadioButtonAdministrator.setSelected(false);
			}
			
		}
	}
	
	class RadioButtonAdmin extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent event) {
			if(SachbearbeiterS.RadioButtonSachbearbeiter.isSelected() == true) {
				SachbearbeiterS.RadioButtonSachbearbeiter.setSelected(false);
			}	
		}
	}
public class SachbearbeiterS extends JPanel{
	
	//-------------Attribute--------------------------------------------------
	static Action RadioButtonSach = new RadioButtonSach();
	static Action RadioButtonAdmin = new RadioButtonAdmin();
//	static Action ExitAAction = new ExitAAction();
//	static Action OKAction = new OKAction();
	private static JTextField textFieldBenutzername = new JTextField();
	private static JPasswordField textFieldPasswort = new JPasswordField();
	private static JPanel panelLogin = new JPanel();
	private static SachbearbeiterS instance;
	private static JButton buttonAbbruch = new JButton();//ExitAAction fehlt
	private static JButton buttonOk = new JButton();//OkAction fehlt
	public static JRadioButton RadioButtonSachbearbeiter = new JRadioButton(RadioButtonSach);
	public static JRadioButton RadioButtonAdministrator = new JRadioButton(RadioButtonAdmin);
	public static HashMap<String, Component> componentMap;
	
	//-------------------------------------------------------------------------
	//-----------------Eine Instanz der KLasse SachbearbeiterS erzeugen---------
	public static SachbearbeiterS getInstance() {[]
		if(instance == null) {
			instance = new SachbearbeiterS();
		}
		return instance;
	}
	//-------------------------------------------------------------------
	//-----------------------Panel fuer Login uebergeben----------------
	public JPanel konfiguriereSachbearbeiterPanel() {

		return instance.panelLogin;	
	}
	//-------------------------------------------------------------------
	//------------------Panel anzeigen lassen-----------------------------
		public void run() {//
			
			try {
				getPanelLogin().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	//---------------------------------------------------------------------
	//-------------Konstruktor der Klasse SachbearbeiterS-----------------
		public SachbearbeiterS() {
			panelLogin.setName("Login");
			panelLogin.setSize(400, 400);
			panelLogin.setLayout(null);

		//------------------------TextField----------------------------------------------------------
		textFieldBenutzername.setBounds(157, 114, 188, 20);
		textFieldBenutzername.setName("TextFieldBenutzername");
		panelLogin.add(textFieldBenutzername);
		textFieldBenutzername.setColumns(10);
		
		textFieldPasswort.setBounds(157, 171, 188, 20);
		textFieldPasswort.setName("TextFieldPasswort");
		panelLogin.add(textFieldPasswort);
		textFieldPasswort.setColumns(10);
		//--------------------------------------------------------------
		//------------------RadioButton---------------------------------
		RadioButtonSachbearbeiter.setText("Sachbearbeiter");
		RadioButtonSachbearbeiter.setName("RadioButtonSachbearbeiter");//Name
		RadioButtonSachbearbeiter.setBounds(189, 263, 205, 23);
		panelLogin.add(RadioButtonSachbearbeiter);

		RadioButtonAdministrator.setText("Administrator");
		RadioButtonAdministrator.setName("RadioButtonAdministrator");//Name
		RadioButtonAdministrator.setBounds(189, 223, 205, 23);
		panelLogin.add(RadioButtonAdministrator);
		//---------------------------------------------------------------------------
		//------------------------Label----------------------------------------------
		JLabel PanelLabelBerechtigung = new JLabel("Berechtigung");
		PanelLabelBerechtigung.setName("LabelBerechtigung");//Name
		PanelLabelBerechtigung.setBounds(35, 227, 112, 14);
		panelLogin.add(PanelLabelBerechtigung);
		
		JLabel PanelLabelBenutzername = new JLabel("Benutzername");
		PanelLabelBenutzername.setName("LabelBenutzername");
		PanelLabelBenutzername.setBounds(35, 117, 112, 14);
		panelLogin.add(PanelLabelBenutzername);
		
		JLabel PanelLabelLogin = new JLabel("Login");
		PanelLabelLogin.setName("LabelLogin");
		PanelLabelLogin.setBounds(35, 8, 69, 14);
		panelLogin.add(PanelLabelLogin);
		
		JLabel PanelLabelPasswort = new JLabel("Passwort");
		PanelLabelPasswort.setName("LabelPasswort");
		PanelLabelPasswort.setBounds(35, 174, 69, 14);
		panelLogin.add(PanelLabelPasswort);
		//-------------------------------------------------------------------------------
		//--------------------------Buttons------------------------------------------------
//		buttonAbbruch.setText("Abbruch");
//		buttonAbbruch.setName("ButtonAbbruch");//Name
//		buttonAbbruch.setBounds(35, 348, 87, 23);
//		panelLogin.add(buttonAbbruch);
//		
//		buttonOk.setText("OK");
//		buttonOk.setName("ButtonOk");//Name
//		buttonOk.setBounds(151, 348, 87, 23);
//		panelLogin.add(buttonOk);
		
		createComponentMap();
		
		//---------------------------------------------------------------------------------------
		}
		//-------------------------------------------------------------------
		public void enableRadioButtonTextField() {
			textFieldBenutzername.setText(null);
			textFieldPasswort.setText(null);
			RadioButtonSachbearbeiter.setSelected(false);
			RadioButtonAdministrator.setSelected(false);
		}
		
		
		
		
		//---------------------Getter und Setter------------------------------
		public JPanel getPanelLogin() {
			return panelLogin;
		}


		public static void setPanelLogin(JPanel panelLogin) {
			SachbearbeiterS.panelLogin = panelLogin;
		}


		public JPasswordField getTextFieldpasswort() {
			return textFieldPasswort;
		}


		public void setTextFieldpasswort(JPasswordField textFieldpasswort) {
			this.textFieldPasswort = textFieldpasswort;
		}


		public JTextField getTextFieldbenutzername() {
			return textFieldBenutzername;
		}


		public void setTextFieldbenutzername(JTextField textFieldbenutzername) {
			this.textFieldBenutzername = textFieldbenutzername;
		}
		
		
		public JButton getJButtonOk() {
			return buttonOk;
		}
		
		public JButton getJButtonBeenden() {
			return buttonAbbruch;
		}
		public JRadioButton getRadioButtonSachbearbeiterS() {
			return RadioButtonSachbearbeiter;
		}
		public JRadioButton getRadioButtonAdministratorS() {
			return RadioButtonAdministrator;
		}
	//--------------------------------------------------------------------------	
	//-----------------------------HashMap mit allen Components von Panel--------	
		public static void alleComponents() {
			System.out.println(componentMap.size());
			for(String e: componentMap.keySet()){
		  System.out.println(e);
		}
		}
		public static void createComponentMap() {
	        componentMap = new HashMap<String,Component>();
	        Component[] components = ((JPanel) panelLogin).getComponents();
	        for (int i=0; i < components.length; i++) {
	                componentMap.put(components[i].getName(), components[i]);
	                System.out.println(components[i].getName());
	                System.out.println(components[i]);
	        }
//	        for(int i = 0; i<components.length;i++) {
//	    		System.out.println(i);
//	        	System.out.println(components[i]);
//	        }
	        }

	public static Component getComponentByName(String name) {
	        if (componentMap.containsKey(name)) {
	                return (Component) componentMap.get(name);
	        }
	        else return null;
	}
	public HashMap<String, Component> getComponentHashMap(){
		return componentMap;
	}
	//----------------------------------------------------------------------------------
	//----------------------------------Selecten_listener-------------------------------
	

}
