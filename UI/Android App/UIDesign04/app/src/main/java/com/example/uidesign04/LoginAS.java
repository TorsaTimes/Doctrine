package com.example.uidesign04;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.Nullable;


public class LoginAS extends SachbearbeiterS {

    Activity act = this;
    LoginK kontrolle = new LoginK();

    Button.OnClickListener okKnopfLauscher = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            String passwort = ((EditText) findViewById(R.id.editTextpasswort)).getText().toString();
            String benutzername = ((EditText) findViewById(R.id.editTextBenutzername)).getText().toString();
            boolean sachbearbeiterRadioButton = ((RadioButton) findViewById(R.id.sachbearbeiterRadio)).isChecked();
            boolean administratorRadioButton = ((RadioButton) findViewById(R.id.adminRadio)).isChecked();

            String pruefen = kontrolle.kontrollAnmelden(benutzername, passwort);

            if (administratorRadioButton) {
                if (pruefen.equals("admin")) {
                    Intent intent = new Intent(act, AdministratorAS.class);
                    act.startActivity(intent);
                }
                else{
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(LoginAS.this);
                    builder1.setMessage("Benutzername, Passwort oder Berechtigung falsch!");
                    builder1.setCancelable(true);

                    builder1.setNeutralButton(
                            "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    finish();
                                    startActivity(getIntent());
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            } else if (sachbearbeiterRadioButton) {
                if (pruefen.equals("normal") || pruefen.equals("admin")) {
                    Intent intent = new Intent(act, SachbearbeiterAS.class);
                    act.startActivity(intent);
                } else {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(LoginAS.this);
                    builder1.setMessage("Benutzername, Passwort oder Berechtigung falsch!");
                    builder1.setCancelable(true);

                    builder1.setNeutralButton(
                            "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    finish();
                                    startActivity(getIntent());
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            } else {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(LoginAS.this);
                builder1.setMessage("Benutzername, Passwort oder Berechtigung falsch!");
                builder1.setCancelable(true);

                builder1.setNeutralButton(
                        "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                finish();
                                startActivity(getIntent());
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginas);

        ((EditText) findViewById(R.id.editTextpasswort)).setText("");
        ((EditText) findViewById(R.id.editTextBenutzername)).setText("");
        //((EditText) findViewById(R.id.editTextpasswort)).setTransformationMethod(HideReturnsTransformationMethod.getInstance());

        Button okKnopf = ((Button) this.findViewById(R.id.buttonOk));
        okKnopf.setOnClickListener(this.okKnopfLauscher);
    }





































































	/*//-------------------------Attribute------------------------------------------------
	private static LoginK controll = new LoginK();
	private static JPanel panel = SachbearbeiterS.getInstance().konfiguriereSachbearbeiterPanel();
	private static JButton buttonBeenden = SachbearbeiterS.getInstance().getJButtonBeenden();
	private static JButton buttonOk = SachbearbeiterS.getInstance().getJButtonOk();
	private static JTextField jTextBenutzername = SachbearbeiterS.getInstance().getTextFieldbenutzername();
	private static JPasswordField jPasswortfield = SachbearbeiterS.getInstance().getTextFieldpasswort();
	private static LoginAS instance;
	private OkLauscher okLauscher = new OkLauscher();
	private BeendenLauscher beendenLauscher = new BeendenLauscher();
//	private static HashMap<String, Component> componentMap2 = SachbearbeiterS.getInstance().getComponentHashMap();
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
						System.out.println("admin ausgewaehlt");

						LehrveranstaltungsverwaltungHS.loginBeenden(1,panel);
						
					} 
					else if(((SachbearbeiterS.RadioButtonSachbearbeiter.isSelected() == true) && berechtigung.equals("normal"))){
						System.out.println("Sachbearbeiter ausgewaehlt");
						
						LehrveranstaltungsverwaltungHS.loginBeenden(2,panel);
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
				LehrveranstaltungsverwaltungHS.entgrauenLogin();
				System.out.println("Hallo");
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
		JButton buttonOkLoginPanel = new JButton("OK");
		buttonOkLoginPanel.setMnemonic(KeyEvent.VK_O);
		buttonOkLoginPanel.addActionListener(okLauscher);
		buttonOkLoginPanel.setBounds(151, 348, 87, 23);
		erg.add(buttonOkLoginPanel);

		JButton buttonAbbruchLoginPanel = new JButton("Abbruch");
		buttonAbbruchLoginPanel.setMnemonic(KeyEvent.VK_A);
		buttonAbbruchLoginPanel.addActionListener(beendenLauscher);
		buttonAbbruchLoginPanel.setBounds(35, 348, 87, 23);
		erg.add(buttonAbbruchLoginPanel);
		erg.repaint();
		erg.setVisible(true);
		panelLogin = erg;
		return erg;
	}
	public JPanel login(boolean editierbar) {
		return panel;
	}*/

}
