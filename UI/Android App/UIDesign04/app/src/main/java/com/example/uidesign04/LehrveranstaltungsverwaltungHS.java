package com.example.uidesign04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;


public class LehrveranstaltungsverwaltungHS  extends Activity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = new Intent(this, LoginAS.class);
		startActivity(intent);
		finish();


	}



	/*//-------------------Attribute-------------------------------------------------
	static JPanel PanelLoginLVV;
	
	OklauscherLogin okButton = new OklauscherLogin();
	BeendenLauscher beendenButton = new BeendenLauscher();
	
	public static JFrame f = new JFrame();
	public static JPanel jp = new JPanel();
	static JButton btnLogin = new JButton();
	static JButton btnBeenden = new JButton();
	static JMenuBar menuBar;
	static JMenu MenubarLogin;
	static JMenu MenubarBeenden;
	static JToolBar toolBar = new JToolBar();
	static JMenuItem menuItem;
	private static LehrveranstaltungsverwaltungHS instance;
	//--------------------------------------------------------------------------------
	
	//------------------------------Instance der Klasse erzeugen------------------------
	public static LehrveranstaltungsverwaltungHS getInstance() {
		if(instance == null) {
			instance = new LehrveranstaltungsverwaltungHS();
		}
		return instance;
	}
	//----------------------------------------------------------------------------------------------
	public void oeffnen() {
		f.setVisible(true);
	}
	//-----------------------------------------------------------------------------------------------
	//--------------------------Start des Frames--------------------------------------------------
			public void run() {
				try {
					f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
	//-----------------------------------------------------------------------------------------------		
	
	//---------------------------------------------------Frame erstellen-----------------------------
	public LehrveranstaltungsverwaltungHS() {
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setSize(800, 800);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setMinimumSize(new Dimension(700,700));
//		f.setBounds(100, 100, 450, 300);
		f.setTitle("Sachbearbeiter Vewaltung");
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		//f.getContentPane().add(menuBar);
		f.setJMenuBar(menuBar);
		
		JMenu MenubarLogin = new JMenu("Login");
		menuBar.add(MenubarLogin);
		
		JMenu MenubarBeenden = new JMenu("Beenden");
		MenubarBeenden.setBackground(Color.WHITE);
		menuBar.add(MenubarBeenden);
		f.getContentPane().setLayout(new BorderLayout(0, 0));
		//setContentPane(f);
		
		toolBar = new JToolBar();
		f.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		btnLogin = new JButton();
		btnLogin.setMnemonic(KeyEvent.VK_L);
		btnLogin.addActionListener(okButton);
		btnLogin.setText("Login");
		toolBar.add(btnLogin);
		
		btnBeenden = new JButton();
		btnBeenden.setMnemonic(KeyEvent.VK_B);
		btnBeenden.addActionListener(beendenButton);
		btnBeenden.setText("Beenden");
		toolBar.add(btnBeenden);
		
		JMenuItem menuItemBeenden = new JMenuItem("Beenden",KeyEvent.VK_B);
		KeyStroke beendenKeyStroke = KeyStroke.getKeyStroke("alt shift B");
		menuItemBeenden.setAccelerator(beendenKeyStroke);
		menuItemBeenden.addActionListener(beendenButton);
		
		JMenuItem menuItemLogin = new JMenuItem("Login",KeyEvent.VK_L);
		KeyStroke loginKeyStroke = KeyStroke.getKeyStroke("alt shift L");
		menuItemLogin.setAccelerator(loginKeyStroke);
		menuItemLogin.addActionListener(okButton);
		
				
		MenubarBeenden.add(menuItemBeenden);	
		MenubarLogin.add(menuItemLogin);
	}
	//---------------------------------------------------------------------------------------------
	
	class OklauscherLogin implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			buttonEnabelFalse();
			LoginAS anmelden = new LoginAS();
			JPanel panel = anmelden.loginPanel();
			LehrveranstaltungsverwaltungHS.f.repaint();
			LehrveranstaltungsverwaltungHS.f.add(panel);
			//LehrveranstaltungsverwaltungHS.setPanelLoginLVV(LoginAS.getInstance().login());
			//LehrveranstaltungsverwaltungHS.f.add(LehrveranstaltungsverwaltungHS.PanelLoginLVV, BorderLayout.CENTER);
			LehrveranstaltungsverwaltungHS.f.setVisible(true);
			
			System.out.println("Oklauscherlogin wurde aufgerufen");
			System.out.println("Login starten");
		}
		
	}
	class BeendenLauscher implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		
	}
	
	
	public static void setPanelLoginLVV(JPanel p) {
		
		PanelLoginLVV = p;
	}
	
	public static JFrame getFrame() {
		return f;
	}


	public static void loginBeenden(int akteur, JPanel panel) {
		//f.remove(panel);
		//panel.setVisible(false);
		SachbearbeiterS.getInstance().enableRadioButtonTextField();

		if(akteur == 1) {//AdminAS
			JFrame f1 = new JFrame();
			f1 = f;

			AdministratorAS.getInstance().start(LehrveranstaltungsverwaltungHS.f);
		}
		else if(akteur == 2) {
			System.out.println("SachbearbeiterAS wird ausgef�hrt");
			JFrame f2 = new JFrame();
			f2 = f;
			
			SachbearbeiterAS.getInstance().start(LehrveranstaltungsverwaltungHS.f);
		}
		
	
		System.out.println("loginBeenden Methode wurde Aufgerufen");
	}
	
	public JToolBar getMainToolBar() {
		return toolBar;
	}
	
	public static void buttonEnabelFalse() {
		btnLogin.setEnabled(false);
		btnBeenden.setEnabled(false);
	}
	public static void entgrauenLogin() {
		btnLogin.setEnabled(true);	
		btnBeenden.setEnabled(true);


	}
	
	
//##########################################################################################################################################
	
//	static Action ExitAction = new ExitAction();
//	static Action LoginAction = new LoginAction();	
	
//	class LoginAction extends AbstractAction{
//	
//		@Override
//		public void actionPerformed(ActionEvent event1) {
//			LoginAS anmelden = new LoginAS();
//			JPanel panel = anmelden.loginPanel();
//			LehrveranstaltungsverwaltungHS.f.repaint();
//			LehrveranstaltungsverwaltungHS.f.add(panel);
//			//LehrveranstaltungsverwaltungHS.setPanelLoginLVV(LoginAS.getInstance().login());
//			//LehrveranstaltungsverwaltungHS.f.add(LehrveranstaltungsverwaltungHS.PanelLoginLVV, BorderLayout.CENTER);
//			LehrveranstaltungsverwaltungHS.f.setVisible(true);
//			
//			System.out.println("Login starten");
//		}
//		
//	}
//	class ExitAction extends AbstractAction{
//		@Override
//		public void actionPerformed(ActionEvent event2) {
//				System.exit(0);
//			}
//		}*/
	

}	