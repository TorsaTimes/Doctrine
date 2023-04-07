import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;

//		class LoginAction extends AbstractAction{
//		
//			@Override
//			public void actionPerformed(ActionEvent event1) {
//				LoginAS anmelden = new LoginAS();
//				JPanel panel = anmelden.loginPanel();
//				LehrveranstaltungsverwaltungHS.f.repaint();
//				LehrveranstaltungsverwaltungHS.f.add(panel);
//				//LehrveranstaltungsverwaltungHS.setPanelLoginLVV(LoginAS.getInstance().login());
//				//LehrveranstaltungsverwaltungHS.f.add(LehrveranstaltungsverwaltungHS.PanelLoginLVV, BorderLayout.CENTER);
//				LehrveranstaltungsverwaltungHS.f.setVisible(true);
//				
//				System.out.println("Login starten");
//			}
//			
//		}
//		class ExitAction extends AbstractAction{
//			@Override
//			public void actionPerformed(ActionEvent event2) {
//					System.exit(0);
//				}
//			}

public class LehrveranstaltungsverwaltungHS extends JFrame{

	
	
	//-------------------Attribute-------------------------------------------------
	static JPanel PanelLoginLVV;
//	static Action ExitAction = new ExitAction();
//	static Action LoginAction = new LoginAction();
	
	OklauscherLogin okButton = new OklauscherLogin();
	BeendenLauscher beendenButton = new BeendenLauscher();
	
	public static JFrame f = new JFrame();
	public static JPanel jp = new JPanel();
	static JButton btnLogin;
	static JButton btnBeenden;
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
		//f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		f.setSize(screenSize.width, screenSize.height);
		//f.setSize(800, 800);
		//f.setBounds(100, 100, 4500, 300);
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
		
		JButton btnLogin = new JButton();
		btnLogin.addActionListener(okButton);
		btnLogin.setText("Login");
		toolBar.add(btnLogin);
		
		JButton btnBeenden = new JButton();
		btnBeenden.addActionListener(beendenButton);
		btnBeenden.setText("Beenden");
		toolBar.add(btnBeenden);
		
		JMenuItem menuItemBeenden = new JMenuItem("Beenden");

		menuItemBeenden.setAccelerator(KeyStroke.getKeyStroke(
		KeyEvent.VK_B,ActionEvent.ALT_MASK | InputEvent.SHIFT_DOWN_MASK));
				
		MenubarBeenden.add(menuItemBeenden);	
	}
	//---------------------------------------------------------------------------------------------
	
	class OklauscherLogin implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
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

			AdminAS.getInstance().start(LehrveranstaltungsverwaltungHS.f);
		}
		else if(akteur == 2) {
			
			
		}
		
	
		System.out.println("loginBeenden Methode wurde Aufgerufen");
	}
	
	public JToolBar getMainToolBar() {
		return toolBar;
	}
	
	

}	