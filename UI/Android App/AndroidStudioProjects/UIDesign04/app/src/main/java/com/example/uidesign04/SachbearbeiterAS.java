package com.example.uidesign04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class SachbearbeiterAS extends AppCompatActivity {


    private Button buttonSachbearbeiterEditieren;
    private Button buttonSachbearbeiterFbZuweisen;
    private Button buttonSachbearbeiterFbLoeschen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sachbearbeiteras);

        // Buttons
        this.buttonSachbearbeiterEditieren = this.findViewById(R.id.buttonSachbearbeiterEditieren);
        this.buttonSachbearbeiterFbZuweisen = this.findViewById(R.id.buttonFortbildungZuordnen);
        this.buttonSachbearbeiterFbLoeschen = this.findViewById(R.id.buttonFortbildungLoeschen);

        // Wenn button Editieren geklickt wird
        this.buttonSachbearbeiterEditieren.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                editieren();
            }
        });

        // Wenn button Fortbildung Zuweisen geklickt wird
        this.buttonSachbearbeiterFbZuweisen.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                fbZuweisen();
            }
        });

        // Wenn button Fortbildung Löschen geklickt wird
        this.buttonSachbearbeiterFbLoeschen.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                fbLoeschen();
            }
        });



    }



    private void editieren(){
        SachbearbeiterAuswaehlenTestAAS.naechsteAktivitaet = SachbearbeiterSachbearbeiterEditierenAAS.class;
        Intent intent = new  Intent(this, SachbearbeiterAuswaehlenTestAAS.class);
        startActivity(intent);
    }

    public void fbZuweisen(){
        SachbearbeiterAuswaehlenTestAAS.naechsteAktivitaet = FortbildungZuordnenAAS.class;
        Intent intent = new Intent(this, SachbearbeiterAuswaehlenTestAAS.class);
        startActivity(intent);
    }

    public void fbLoeschen(){
        SachbearbeiterAuswaehlenTestAAS.naechsteAktivitaet = FortbildungLoeschenAAS.class;
        Intent intent = new Intent(this, SachbearbeiterAuswaehlenTestAAS.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SachbearbeiterAS.this, LoginAS.class);
        startActivity(intent);
    }

}





	/*//------------------------------------Attribute der Klasse SachbearbeiterAS-----------------------------------------------------------------------------------
	public static JMenuBar sachbearbeiterMenuBar = new JMenuBar();
	public static JToolBar sachbearbeiterToolBar = new JToolBar();
	public static JFrame frame = new JFrame();
	
	JButton btnEditieren = new JButton("Editieren");
	JButton btnFortbildungZuordnen = new JButton("Fortbildung zuordnen");
	JButton btnFortbildungszuordnungLschen = new JButton("Fortbildungszuordnung loeschen");
	JButton  btnZurueck = new JButton("Zurueck");
	
	EditierenListener editierenButtonListener = new EditierenListener();
	FortbildungL�schenListener fortbildungL�schenButtonListener = new FortbildungL�schenListener();
	FortbildungZordnenListener fortbildungZuordnenButtonListener = new FortbildungZordnenListener();
	Zur�ckListener zur�ckButtonListener = new Zur�ckListener();
	
	public static SachbearbeiterAS instance;
	
	
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	public static SachbearbeiterAS getInstance() {
		if(instance == null) {
			instance = new SachbearbeiterAS();
		}
		return instance;
	}
	
	public SachbearbeiterAS(){
		
		JMenu menuSachbearbeiterSachbearbeiterAS = new JMenu("Sachbearbeiter");
		sachbearbeiterMenuBar.add(menuSachbearbeiterSachbearbeiterAS);
		
		JMenu menuZurckSachbearbeiterAS = new JMenu("Zurueck");
		sachbearbeiterMenuBar.add(menuZurckSachbearbeiterAS);
		
		btnEditieren.addActionListener(editierenButtonListener);
		btnEditieren.setMnemonic(KeyEvent.VK_E);
		sachbearbeiterToolBar.add(btnEditieren);
		
		btnFortbildungZuordnen.addActionListener(fortbildungZuordnenButtonListener);
		btnFortbildungZuordnen.setMnemonic(KeyEvent.VK_U);
		sachbearbeiterToolBar.add(btnFortbildungZuordnen);
		
		btnFortbildungszuordnungLschen.addActionListener(fortbildungL�schenButtonListener);
		btnFortbildungszuordnungLschen.setMnemonic(KeyEvent.VK_O);
		sachbearbeiterToolBar.add(btnFortbildungszuordnungLschen);
		
		btnZurueck.addActionListener(zur�ckButtonListener);
		btnZurueck.setMnemonic(KeyEvent.VK_Z);
		sachbearbeiterToolBar.add(btnZurueck);
		
		JMenuItem menuItemEditieren = new JMenuItem("Editieren", KeyEvent.VK_D);
		menuItemEditieren.setMnemonic(KeyEvent.VK_D);
		KeyStroke editierenKeyStroke = KeyStroke.getKeyStroke("alt shift D");
		menuItemEditieren.setAccelerator(editierenKeyStroke);		
		menuItemEditieren.addActionListener(editierenButtonListener);
		
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
		menuSachbearbeiterSachbearbeiterAS.add(menuItemEditieren);
		menuSachbearbeiterSachbearbeiterAS.add(menuItemFortbildungzuordnen);
		menuSachbearbeiterSachbearbeiterAS.add(menuItemfortbildungszuordnungloeschen);
		
		menuZurckSachbearbeiterAS.add(menuItemZur�ck);
		
	}
	
	public void start(JFrame hs) {

		frame = hs;
		frame.getContentPane().removeAll();//.removeAll()
		frame.getJMenuBar().removeAll();
		frame.validate();
		frame.repaint();
		frame.setTitle("Sachbearbeiter Verwaltung - Sachbearbeiter");
		sachbearbeiterMenuBar.setBackground(Color.WHITE);
		frame.setJMenuBar(sachbearbeiterMenuBar);
		frame.getContentPane().add(sachbearbeiterToolBar, BorderLayout.NORTH);
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frame.setMinimumSize(new Dimension(700,700));
		frame.validate();
		frame.repaint();
//		frame.getContentPane().setVisible(true);
//		frame.setVisible(true);
		
	}
	
	//---------------------------------ToolBar entgrauen Methoden-------------------------------------------------------------------------------------------
		public void buttonEnabelFalse() {
			btnEditieren.setEnabled(false);
			btnFortbildungszuordnungLschen.setEnabled(false);
			btnFortbildungZuordnen.setEnabled(false);
			btnZurueck.setEnabled(false);
		}
		public void entgrauen() {
			btnEditieren.setEnabled(true);	
			btnFortbildungszuordnungLschen.setEnabled(true);
			btnFortbildungZuordnen.setEnabled(true);
			btnZurueck.setEnabled(true);
		}
		//---------------------------------------------------------------------------------------------------------------------------------------------------------
	
	class EditierenListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonEnabelFalse();
			SachbearbeiterSachbearbeiterEditierenAAS sachbearbeiterEditierenAAS = new SachbearbeiterSachbearbeiterEditierenAAS();
			JPanel panel = sachbearbeiterEditierenAAS.sachbearbeiterSachbearbeiternEditieren();
			frame.repaint();
			frame.add(panel);
			frame.setVisible(true);
			//##################################Kontroll Ausgabe####################################
			System.out.println("Sachbearbeiter - Editieren wurde ausgew�hlt");
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
	}*/
	

