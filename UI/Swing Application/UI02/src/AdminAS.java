import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

public class AdminAS {
	
		//------------------------Attribute------------------------------------------------------	
		public static JMenuBar adminMenuBar = new JMenuBar();
		private static JToolBar adminToolBar = new JToolBar();
		public static AdminAS instance;
		public static JFrame frame = new JFrame();
		public SachbearbeiterAdminErzeugenAAS adminErzeugenAAS = new SachbearbeiterAdminErzeugenAAS();
		//-----------------------------------Button----------------------------------------------------
		JButton btnEditieren = new JButton("Editieren");
		JButton btnErstellen = new JButton("Erstellen");
		JButton btnLschen = new JButton("Loeschen");
		JButton btnFortbildungZuordnen = new JButton("Fortbildung zuordnen");
		JButton btnFortbildungszuordnungLschen = new JButton("Fortbildungszuordnung loeschen");
		JButton  btnZurueck = new JButton("Zurueck");
		
		//-----------------------------Listener Objekte-------------------------------------------------------------------------
		ErstellenListener erstellenButtonListener = new ErstellenListener();
		EditierenListener editierenButtonListener = new EditierenListener();
		LöschenListener löschenButtonListener = new LöschenListener();
		FortbildungLöschenListener fortbildungLöschenButtonListener = new FortbildungLöschenListener();
		FortbildungZordnenListener fortbildungZuordnenButtonListener = new FortbildungZordnenListener();
		ZurückListener zurückButtonListener = new ZurückListener();
		//----------------------------------------------------------------------------
		
		//-------------------Eine Instanc der Klasse AdministratorAS Erzeugen---------
		public static AdminAS getInstance() {
			if(instance == null) {
				instance = new AdminAS();
			}
			return instance;
		}
		//----------------------------------------------------------------------------
	
		//-------------------------------------------------AdminAS-Frame erzeugen----------------------------------------------------------------
		public AdminAS() {
		
		//-------------JMenu-Sachbearbeiter und Zurueck-------------------------------------------------------------------
		JMenu menuSachbearbeiter = new JMenu("Sachbearbeiter");
		adminMenuBar.add(menuSachbearbeiter);
		
		JMenu menuZurck = new JMenu("Zurueck");
		adminMenuBar.add(menuZurck);
		//-------------------------------------------------------------------------------------------------------------------
		
		//-----------------------------------JButtons--------------------------------------------------------------------------
		
		//--------------------------------------------Erstellen--------------------------------------------------------
		btnErstellen.addActionListener(erstellenButtonListener);		
		adminToolBar.add(btnErstellen);
		//--------------------------------------------Editieren--------------------------------------------------------
		btnEditieren.addActionListener(editierenButtonListener);
		adminToolBar.add(btnEditieren);
		//--------------------------------------------Löschen--------------------------------------------------------
		btnLschen.addActionListener(löschenButtonListener);
		adminToolBar.add(btnLschen);
		//--------------------------------------------Zuordnen--------------------------------------------------------
		btnFortbildungZuordnen.addActionListener(fortbildungZuordnenButtonListener);
		adminToolBar.add(btnFortbildungZuordnen);
		//----------------------------------------------Fortbildung Löschen-----------------------------------------------------
		btnFortbildungszuordnungLschen.addActionListener(fortbildungLöschenButtonListener);
		adminToolBar.add(btnFortbildungszuordnungLschen);
		//-----------------------------------------------------------------------------------------------------------------
		//------------------------------------------Zurück Button-----------------------------------------------------------------------------------------------
		btnZurueck.addActionListener(zurückButtonListener);
		adminToolBar.add(btnZurueck);
		//--------------------------------------------------------------------------------------------------------------------------
		
		//----------------------MenuItems-------------------------------------------------------------------------------------------
		JMenuItem menuItemErstellen = new JMenuItem("Erstellen");
		JMenuItem menuItemEditieren = new JMenuItem("Editieren");
		JMenuItem menuItemLoeschen = new JMenuItem("Loeschen");
		JMenuItem menuItemFortbildungzuordnen = new JMenuItem("Fortbildung zuordnen");
		JMenuItem menuItemfortbildungszuordnungloeschen = new JMenuItem("fortbildungszuordnung loeschen");
		
		menuSachbearbeiter.add(menuItemErstellen);
		menuSachbearbeiter.add(menuItemEditieren);
		menuSachbearbeiter.add(menuItemLoeschen);
		menuSachbearbeiter.add(menuItemFortbildungzuordnen);
		menuSachbearbeiter.add(menuItemfortbildungszuordnungloeschen);
		//--------------------------------------------------------------------------------------------------------------------------
	}
	//-------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------Die MenuBar und Toolbar in den Frame einsetzten------------------------------------------------
	public void start(JFrame hs) {

		frame = hs;
		frame.getContentPane().removeAll();//.removeAll()
		frame.getJMenuBar().removeAll();
		frame.validate();
		frame.repaint();
		frame.setTitle("Sachbearbeiter Verwaltung-Administrator");
		adminMenuBar.setBackground(Color.WHITE);
		frame.setJMenuBar(adminMenuBar);
		frame.getContentPane().add(adminToolBar, BorderLayout.NORTH);
		frame.validate();
		frame.repaint();
//		frame.getContentPane().setVisible(true);
//		frame.setVisible(true);
		
	}
	
	//---------------------------------ToolBar entgrauen Methoden-------------------------------------------------------------------------------------------
	public void buttonEnabelFalse() {
		btnErstellen.setEnabled(false);
		btnEditieren.setEnabled(false);
		btnLschen.setEnabled(false);
		btnFortbildungszuordnungLschen.setEnabled(false);
		btnFortbildungZuordnen.setEnabled(false);
		btnZurueck.setEnabled(false);
	}
	public void entgrauen() {
		btnErstellen.setEnabled(true);
		btnEditieren.setEnabled(true);
		btnLschen.setEnabled(true);
		btnFortbildungszuordnungLschen.setEnabled(true);
		btnFortbildungZuordnen.setEnabled(true);
		btnZurueck.setEnabled(true);
	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public JMenuBar getMenubar() {
		return adminMenuBar;
	}
	//---------------------------------------------------------------------------------------------
	//-------------------------Getter fuer Button----------------------------------------------------
	public JButton getbtnErstellen() {
		return btnErstellen;
	}
	public JButton getbtnEditieren() {
		return btnEditieren;
	}
	public JButton getbtnLoeschen() {
		return btnLschen;
	}
	public JButton getbtnFortbildungZuordnen() {
		return btnFortbildungZuordnen;
	}
	public JButton getbtnFortbildugZuordnenLoeschen() {
		return btnFortbildungszuordnungLschen;
	}
	//--------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//------------------------ActionListener der Button von der ToolBar AdminAS------------------------------------------------------------------------------
	class EditierenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonEnabelFalse();
			SachbearbeiterAdminEditierenAAS adminEditierenAAS = new SachbearbeiterAdminEditierenAAS();
			JPanel panel = adminEditierenAAS.adminSachbearbeiternEditieren();
			frame.repaint();
			frame.add(panel);
			frame.setVisible(true);
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter - Editieren wurde ausgewählt");
			//#########################################################################################
		}
	}
	class ErstellenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonEnabelFalse();
			SachbearbeiterAdminErzeugenAAS adminErzeugenAAS = new SachbearbeiterAdminErzeugenAAS();
			JPanel panel = adminErzeugenAAS.adminSachbearbeiternErzeugen();
			frame.repaint();
			frame.add(panel);
			frame.setVisible(true);
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter - Erstellen wurde ausgewählt");
			//#########################################################################################
		}
	}
	class LöschenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonEnabelFalse();
			SachbearbeiterAdminLoeschenAAS adminLöschenAAS = new SachbearbeiterAdminLoeschenAAS();
			JPanel panel = adminLöschenAAS.adminSachbearbeiternLöschen();
			frame.repaint();
			frame.add(panel);
			frame.setVisible(true);
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter - Löschen wurde ausgewählt");
			//#########################################################################################
		}
	}
	class FortbildungZordnenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonEnabelFalse();
			FortbildungZuordnenAAS fortbildungZuordnen = new FortbildungZuordnenAAS();
			JPanel panel = fortbildungZuordnen.adminSachbearbeiternFortbildungZuordnen();
			frame.repaint();
			frame.add(panel);
			frame.setVisible(true);
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter - Fortbildung Zuordnen wurde ausgewählt");
			//#########################################################################################
		}
	}
	class FortbildungLöschenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonEnabelFalse();
			FortbildungLoeschenAAS fortbildunglöschen = new FortbildungLoeschenAAS();
			JPanel panel = fortbildunglöschen.adminSachbearbeiternFortbildungLöschen();
			frame.repaint();
			frame.add(panel);
			frame.setVisible(true);
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter - Fortbildung Zuordnen wurde ausgewählt");
			//#########################################################################################
		}
	}
	class ZurückListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().removeAll();
			frame.getJMenuBar().removeAll();
			frame.validate();
			frame.repaint();
			LehrveranstaltungsverwaltungHS anmelden = new LehrveranstaltungsverwaltungHS();
			anmelden.oeffnen();
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter Verwaltung-Administrator - Zurück wurde ausgewählt");
			//#########################################################################################
		}	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//	public static void menue() {
//		
//
//		System.out.println("Willkommen im Sachbearbeiter-Admin-Menue");
//		System.out.println("--------------------------------------");
//		System.out.println("Sie können nun waehlen: ");
//		System.out.println("Fuer Sachbearbeiter zu editieren waehlen Sie die -> 1");
//		System.out.println("Fuer Sachbearbeiter berechtigung aendern -> 2");
//		System.out.println("Fuer Sachbearbeiter erzeugen -> 3");
//		System.out.println("Fuer Sachbearbeiter loeschen -> 4");
//		System.out.println("Fuer Fortbildungauswaehlen -> 5");
//		System.out.println("Fuer Login waehlen Sie die -> 6");
//		Scanner input = new Scanner(System.in);
//		int eingabe = input.nextInt();
//		if(eingabe == 6) {
//			
//			//LoginAS.oeffnen();
//			
//		}
//		if(eingabe == 1) {
//		
//			SachbearbeiterEditierenAAS.oeffnen();
//					
//		}
//		if(eingabe == 2) {
//	
//			SachbearbeiterAdminEditierenAAS.oeffnen();
//			
//	
//		}
//		if(eingabe == 3) {
//	
//			SachbearbeiterAdminErzeugenAAS.oeffnen();
//			
//	
//		}	
//		if(eingabe == 4) {
//			
//			SachbearbeiterAdminLoeschenAAS.oeffnen();
//			
//		}
//		if(eingabe == 5) {
//			
//			FortbildungAS.menue();
//			
//		}
//
//	}

	public void sachbearbeiterAdminEditieren() {
		// TODO - implement AdminAS.sachbearbeiterAdminEditieren
		throw new UnsupportedOperationException();
	}

	public void Login() {
		// TODO - implement AdminAS.Login
		throw new UnsupportedOperationException();
	}

	public void sachbearbeiterAdminErzeugen() {
		// TODO - implement AdminAS.sachbearbeiterAdminErzeugen
		throw new UnsupportedOperationException();
	}

	public void sachbearbeiterAdminLoeschen() {
		// TODO - implement AdminAS.sachbearbeiterAdminLoeschen
		throw new UnsupportedOperationException();
	}

}