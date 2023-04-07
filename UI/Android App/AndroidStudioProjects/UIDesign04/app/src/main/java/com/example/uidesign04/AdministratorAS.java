package com.example.uidesign04;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


import androidx.annotation.Nullable;

public class AdministratorAS extends Activity {


    private Button buttonErstellen;
    private Button buttonEditieren;
    private Button buttonLoeschen;
    private Button buttonFbZuweisen;
    private Button buttonFbLoeschen;

    public static boolean fortbildungBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administratoras);

        // Buttons
        this.buttonErstellen = this.findViewById(R.id.buttonAdminErstellen);
        this.buttonEditieren = this.findViewById(R.id.buttonAdminEditieren);
        this.buttonLoeschen = this.findViewById(R.id.buttonadminLoeschen);
        this.buttonFbZuweisen = this.findViewById(R.id.buttonFortbildungZuweisen);
        this.buttonFbLoeschen = this.findViewById(R.id.buttonFortbildungLoeschen);

        // Wenn Button Erstellen geklickt wird
        this.buttonErstellen.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                erfassen();
            }
        });

        // Wenn button Editieren geklickt wird
        this.buttonEditieren.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                editieren();
            }
        });

        // Wenn button Löschen geklickt wird
        this.buttonLoeschen.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                loeschen();
            }
        });

        // Wenn button Fortbildung Zuweisen geklickt wird
        this.buttonFbZuweisen.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                fbZuweisen();
            }
        });

        // Wenn button Fortbildung Löschen geklickt wird
        this.buttonFbLoeschen.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                fbLoeschen();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(AdministratorAS.this, LoginAS.class);
        startActivity(intent);
    }

    private void erfassen(){
        Intent intent = new Intent(this, SachbearbeiterAdminErzeugenAAS.class);
        startActivity(intent);
        finish();
    }

    private void editieren(){
        SachbearbeiterAuswaehlenTestAAS.naechsteAktivitaet = SachbearbeiterAdminEditierenAAS.class;
        Intent intent = new  Intent(this, SachbearbeiterAuswaehlenTestAAS.class);
        startActivity(intent);
    }

    private void loeschen(){
        SachbearbeiterAuswaehlenTestAAS.naechsteAktivitaet = SachbearbeiterAdminLoeschenAAS.class;
        Intent intent = new Intent(this, SachbearbeiterAuswaehlenTestAAS.class);
        startActivity(intent);
    }

    public void fbZuweisen(){
        fortbildungBack = true;
        SachbearbeiterAuswaehlenTestAAS.naechsteAktivitaet = FortbildungZuordnenAAS.class;
        Intent intent = new Intent(this, SachbearbeiterAuswaehlenTestAAS.class);
        startActivity(intent);
    }

    public void fbLoeschen(){
        SachbearbeiterAuswaehlenTestAAS.naechsteAktivitaet = FortbildungLoeschenAAS.class;
        Intent intent = new Intent(this, SachbearbeiterAuswaehlenTestAAS.class);
        startActivity(intent);
    }















   /* @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administratoras);

        // Buttons
        this.buttonErstellen = this.findViewById(R.id.buttonAdminEditieren);


        Button buttonAdministratorEditieren = findViewById(R.id.buttonAdminEditieren);
        buttonAdministratorEditieren.setOnClickListener(e -> {
            Intent intent = new Intent(AdministratorAS.this, SachbearbeiterAuswaehlenTestAAS.class);
            intent.putExtra(SachbearbeiterS.NAECHSTE_AKTIVITAET, SachbearbeiterAdminEditierenAAS.class);
            startActivity(intent);
        });


    }*/

































































		/*//------------------------Attribute------------------------------------------------------
		public static JMenuBar adminMenuBar = new JMenuBar();
		private static JToolBar adminToolBar = new JToolBar();
		public static AdministratorAS instance;
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

		//----------------------------------------------------------------------------
		
		//-------------------Eine Instanc der Klasse AdministratorAS Erzeugen---------
		public static AdministratorAS getInstance() {
			if(instance == null) {
				instance = new AdministratorAS();
			}
			return instance;
		}
		//----------------------------------------------------------------------------
	
		//-------------------------------------------------AdminAS-Frame erzeugen----------------------------------------------------------------
		public AdministratorAS() {
		
		//-------------JMenu-Sachbearbeiter und Zurueck-------------------------------------------------------------------
		JMenu menuSachbearbeiterAdministratorAS = new JMenu("Sachbearbeiter");
		adminMenuBar.add(menuSachbearbeiterAdministratorAS);
		
		JMenu menuZurckAdministratorAS = new JMenu("Zurueck");
		adminMenuBar.add(menuZurckAdministratorAS);
		//-------------------------------------------------------------------------------------------------------------------
		
		//-----------------------------------JButtons--------------------------------------------------------------------------
		
		//--------------------------------------------Erstellen--------------------------------------------------------
		btnErstellen.addActionListener(erstellenButtonListener);
		btnErstellen.setMnemonic(KeyEvent.VK_E);
		adminToolBar.add(btnErstellen);
		//--------------------------------------------Editieren--------------------------------------------------------
		btnEditieren.addActionListener(editierenButtonListener);
		btnEditieren.setMnemonic(KeyEvent.VK_D);
		adminToolBar.add(btnEditieren);
		//--------------------------------------------L�schen--------------------------------------------------------
		btnLschen.addActionListener(l�schenButtonListener);
		btnLschen.setMnemonic(KeyEvent.VK_L);
		adminToolBar.add(btnLschen);
		//--------------------------------------------Zuordnen--------------------------------------------------------
		btnFortbildungZuordnen.addActionListener(fortbildungZuordnenButtonListener);
		btnFortbildungZuordnen.setMnemonic(KeyEvent.VK_U);
		adminToolBar.add(btnFortbildungZuordnen);
		//----------------------------------------------Fortbildung L�schen-----------------------------------------------------
		btnFortbildungszuordnungLschen.addActionListener(fortbildungL�schenButtonListener);
		btnFortbildungszuordnungLschen.setMnemonic(KeyEvent.VK_O);
		adminToolBar.add(btnFortbildungszuordnungLschen);
		//-----------------------------------------------------------------------------------------------------------------
		//------------------------------------------Zur�ck Button-----------------------------------------------------------------------------------------------
		btnZurueck.addActionListener(zur�ckButtonListener);
		btnZurueck.setMnemonic(KeyEvent.VK_Z);
		adminToolBar.add(btnZurueck);
		//--------------------------------------------------------------------------------------------------------------------------
		
		//----------------------MenuItems-------------------------------------------------------------------------------------------
		JMenuItem menuItemErstellen = new JMenuItem("Erstellen",KeyEvent.VK_E);
		menuItemErstellen.setMnemonic(KeyEvent.VK_E);
		KeyStroke erstellenKeyStroke = KeyStroke.getKeyStroke("alt shift E");
		menuItemErstellen.setAccelerator(erstellenKeyStroke);
		menuItemErstellen.addActionListener(erstellenButtonListener);
		
		JMenuItem menuItemEditieren = new JMenuItem("Editieren", KeyEvent.VK_D);
		menuItemEditieren.setMnemonic(KeyEvent.VK_D);
		KeyStroke editierenKeyStroke = KeyStroke.getKeyStroke("alt shift D");
		menuItemEditieren.setAccelerator(editierenKeyStroke);		
		menuItemEditieren.addActionListener(editierenButtonListener);
		
		JMenuItem menuItemLoeschen = new JMenuItem("Loeschen", KeyEvent.VK_L);
		menuItemLoeschen.setMnemonic(KeyEvent.VK_L);
		KeyStroke l�schenKeyStroke = KeyStroke.getKeyStroke("alt shift L");
		menuItemLoeschen.setAccelerator(l�schenKeyStroke);
		menuItemLoeschen.addActionListener(l�schenButtonListener);
		
		JMenuItem menuItemFortbildungzuordnen = new JMenuItem("Fortbildung zuordnen", KeyEvent.VK_U);
		menuItemFortbildungzuordnen.setMnemonic(KeyEvent.VK_U);
		KeyStroke fortbildungZordnenKeyStroke = KeyStroke.getKeyStroke("alt shift U");
		menuItemFortbildungzuordnen.setAccelerator(fortbildungZordnenKeyStroke);
		menuItemFortbildungzuordnen.addActionListener(fortbildungZuordnenButtonListener);
		
		JMenuItem menuItemfortbildungszuordnungloeschen = new JMenuItem("fortbildungszuordnung loeschen", KeyEvent.VK_O);
		menuItemfortbildungszuordnungloeschen.setMnemonic(KeyEvent.VK_O);
		KeyStroke fortbildungL�schenKeyStroke = KeyStroke.getKeyStroke("alt shift O");
		menuItemfortbildungszuordnungloeschen.setAccelerator(fortbildungL�schenKeyStroke);
		menuItemfortbildungszuordnungloeschen.addActionListener(fortbildungL�schenButtonListener);
		
		JMenuItem menuItemZur�ck = new JMenuItem("Zur�ck", KeyEvent.VK_Z);
		menuItemZur�ck.setMnemonic(KeyEvent.VK_Z);
		KeyStroke zur�ckKeyStroke = KeyStroke.getKeyStroke("alt shift Z");
		menuItemZur�ck.setAccelerator(zur�ckKeyStroke);
		menuItemZur�ck.addActionListener(zur�ckButtonListener);
		
		menuSachbearbeiterAdministratorAS.add(menuItemErstellen);
		menuSachbearbeiterAdministratorAS.add(menuItemEditieren);
		menuSachbearbeiterAdministratorAS.add(menuItemLoeschen);
		menuSachbearbeiterAdministratorAS.add(menuItemFortbildungzuordnen);
		menuSachbearbeiterAdministratorAS.add(menuItemfortbildungszuordnungloeschen);
		
		menuZurckAdministratorAS.add(menuItemZur�ck);
		//--------------------------------------------------------------------------------------------------------------------------
	}
	//-------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------Die MenuBar und Toolbar in den Frame einsetzten------------------------------------------------
	public void start(JFrame hs) {

		frame = hs;
		frame.getContentPane().removeAll();//.removeAll()
		//frame.getJMenuBar().removeAll();
		frame.validate();
		frame.repaint();
		frame.setTitle("Sachbearbeiter Verwaltung - Administrator");
		adminMenuBar.setBackground(Color.WHITE);
		frame.setJMenuBar(adminMenuBar);
		frame.getContentPane().add(adminToolBar, BorderLayout.NORTH);
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frame.setMinimumSize(new Dimension(700,700));
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
			System.out.println("Sachbearbeiter - Editieren wurde ausgew�hlt");
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
			System.out.println("Sachbearbeiter - Erstellen wurde ausgew�hlt");
			//#########################################################################################
		}
	}
	class L�schenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonEnabelFalse();
			SachbearbeiterAdminLoeschenAAS adminL�schenAAS = new SachbearbeiterAdminLoeschenAAS();
			JPanel panel = adminL�schenAAS.adminSachbearbeiternL�schen();
			frame.repaint();
			frame.add(panel);
			frame.setVisible(true);
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter - L�schen wurde ausgew�hlt");
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
			System.out.println("Sachbearbeiter - Fortbildung Zuordnen wurde ausgew�hlt");
			//#########################################################################################
		}
	}
	class FortbildungL�schenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonEnabelFalse();
			FortbildungLoeschenAAS fortbildungl�schen = new FortbildungLoeschenAAS();
			JPanel panel = fortbildungl�schen.adminSachbearbeiternFortbildungL�schen();
			frame.repaint();
			frame.add(panel);
			frame.setVisible(true);
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter - Fortbildung Zuordnen wurde ausgew�hlt");
			//#########################################################################################
		}
	}
	class Zur�ckListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.getContentPane().removeAll();
//			frame.getJMenuBar().removeAll();
			frame.validate();
			frame.repaint();
			LehrveranstaltungsverwaltungHS anmelden = new LehrveranstaltungsverwaltungHS();
			anmelden.oeffnen();
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter Verwaltung-Administrator - Zur�ck wurde ausgew�hlt");
			//#########################################################################################
		}	
	}


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
	}*/

}