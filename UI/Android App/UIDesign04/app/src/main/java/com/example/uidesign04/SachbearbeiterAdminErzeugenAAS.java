
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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class SachbearbeiterAdminErzeugenAAS extends AppCompatActivity {



    Activity act = this;
    SachbearbeiterAdminErzeugenK kontrolle = new SachbearbeiterAdminErzeugenK();

    Button.OnClickListener okKnopfLauscher = new Button.OnClickListener(){

        @Override
        public void onClick(View v) {
            String passwort = ((EditText) findViewById(R.id.editTextpasswort)).getText().toString();
            String benutzername = ((EditText) findViewById(R.id.editTextBenutzername)).getText().toString();
            boolean sachbearbeiterRadioButton = ((RadioButton) findViewById(R.id.sachbearbeiterRadio)).isChecked();
            boolean administratorRadioButton = ((RadioButton) findViewById(R.id.adminRadio)).isChecked();



            if (administratorRadioButton) {
                String berechtigung = "admin";
                if(kontrolle.erzeugen(benutzername, passwort, berechtigung)){
                    ausgabe();

                    Intent intent = new Intent(act, AdministratorAS.class);
                    act.startActivity(intent);
                }
                else{
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(SachbearbeiterAdminErzeugenAAS.this);
                    builder1.setMessage("Benutzername, Passwort falsch!");
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
                String berechtigung = "admin";

                if(kontrolle.erzeugen(benutzername, passwort, berechtigung)){
                    ausgabe();
                    Intent intent = new Intent(act, AdministratorAS.class);
                    act.startActivity(intent);
                }
                else{
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(SachbearbeiterAdminErzeugenAAS.this);
                    builder1.setMessage("Benutzername, Passwort falsch!");
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

            else {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(SachbearbeiterAdminErzeugenAAS.this);
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
        setContentView(R.layout.admin_sachbearbeiter_erzeugen_aas);
        Button okKnopf = ((Button) this.findViewById(R.id.buttonOk));
        okKnopf.setOnClickListener(this.okKnopfLauscher);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SachbearbeiterAdminErzeugenAAS.this, AdministratorAS.class);
        startActivity(intent);
    }


    public void ausgabe(){

        String b = ((EditText) findViewById(R.id.editTextBenutzername)).getText().toString();

        boolean sachbearbeiterRadioButton = ((RadioButton) findViewById(R.id.sachbearbeiterRadio)).isChecked();


        if(sachbearbeiterRadioButton){
            Toast.makeText(this, "Sachbearbeiter " + b + " erfolgreich Erstellt",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Administrator " + b + " erfolgreich Erstellt",Toast.LENGTH_SHORT).show();
        }

    }

























































	/*//------------------------------------Attribute der Klasse---------------------------------------
	private OkLauscherErzeugen okErzeugen = new OkLauscherErzeugen();
	private BeendenLauscherErzeugen beendenErzeugen = new BeendenLauscherErzeugen();
	
	private static SachbearbeiterAdminErzeugenAAS instance;
	
	private JButton buttonAbbruchErzeugen = new JButton();
	private JButton buttonOkErzeugen = new JButton();
	
	private JPanel adminErzeugenPanel = new JPanel();//panel was zur�ckgegeben wird
	private JPanel adminPanel;//Panel was im lauscher genutzt wird
	private JTextField textFielderzeugen;
	private JPasswordField passwortFielderzeugen;
	private JRadioButton radioButtonSachbearbeiter;
	private JRadioButton radioButtonAdministrator;
	//--------------------------------------------------------------------------------------------
	SachbearbeiterAdminErzeugenK kontrolle = new SachbearbeiterAdminErzeugenK();
	//---------------------------OK-Lauscher-----------------------------------------------------------------
	private class OkLauscherErzeugen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			String neuerName = textFielderzeugen.getText();
			String neuesPasswort = passwortFielderzeugen.getText();
			
			if(radioButtonAdministrator.isSelected()) {
				if(kontrolle.erzeugen(neuerName, neuesPasswort, "admin") == 2) {
					AdministratorAS.getInstance().entgrauen();
					adminPanel.setVisible(false);
				}
				else {
					
				}
			}
			else if(radioButtonSachbearbeiter.isSelected())  {
				if(kontrolle.erzeugen(neuerName, neuesPasswort, "normal") == 2) {
					AdministratorAS.getInstance().entgrauen();
					adminPanel.setVisible(false);
				}
				else {
					
				}

			}
			else {
				JOptionPane.showMessageDialog(null,
                        "�berpr�fen sie ihre Eingabe",
                        "Warnung",					      
                        JOptionPane.WARNING_MESSAGE);
			}
			//###########################Kontroll Ausgabe################################################
			System.out.println("Neuer Benutzername: " + neuerName);
			System.out.println("Passwort des neuen Benutzers: " + neuesPasswort);
			//###########################################################################################
		}
	}
	//----------------------------------------------------------------------------------
	//----------ActionListener Klasse fuer Beenden button im Editieren Panel------------------
	private class BeendenLauscherErzeugen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			AdministratorAS.getInstance().entgrauen();
			adminPanel.setVisible(false);
		}
		}
	//-------------------------------------------------------------------------------------------------
	//--------------------------------Instanc der Klasse-------------------------------------------------
	public SachbearbeiterAdminErzeugenAAS getInstance() {
		if(instance == null) {
			instance = new SachbearbeiterAdminErzeugenAAS();
		}
		return instance;
	}
	//----------------------------------------------------------------------------------------------------------
	
	
	public JPanel adminSachbearbeiternErzeugen() {
		JPanel erg = new JPanel();
		erg.setLayout(null);
		
		erg = sachbearbeiterErzeugen(true);
		JButton buttonAbbruchErzeugen = new JButton("Abbruch");
		buttonAbbruchErzeugen.setMnemonic(KeyEvent.VK_A);
		buttonAbbruchErzeugen.addActionListener(beendenErzeugen);
		buttonAbbruchErzeugen.setBounds(10, 410, 89, 23);
		erg.add(buttonAbbruchErzeugen);
		
		JButton buttonOkErzeugen = new JButton("Ok");
		buttonOkErzeugen.setMnemonic(KeyEvent.VK_O);
		buttonOkErzeugen.addActionListener(okErzeugen);
		buttonOkErzeugen.setBounds(137, 410, 89, 23);
		erg.add(buttonOkErzeugen);
		erg.repaint();
		adminPanel = erg;
		return erg;
	}
	
	
	public SachbearbeiterAdminErzeugenAAS() {
		adminErzeugenPanel.setLayout(null);
	
		adminErzeugenPanel.setSize(600, 400);
		JLabel lblSachbearbeiterAdmin = new JLabel("Sachbearbeiter Erstellen");
		lblSachbearbeiterAdmin.setBounds(10, 11, 226, 14);
		adminErzeugenPanel.add(lblSachbearbeiterAdmin);//0
		
		JLabel lblBenutzername = new JLabel("Benutzername");
		lblBenutzername.setBounds(10, 50, 137, 14);
		adminErzeugenPanel.add(lblBenutzername);//1
		
		JLabel lblPasswort = new JLabel("Passwort");
		lblPasswort.setBounds(10, 95, 127, 14);
		adminErzeugenPanel.add(lblPasswort);//2
		
		JLabel lblBerechtigung = new JLabel("Berechtigung");
		lblBerechtigung.setBounds(10, 143, 127, 14);
		adminErzeugenPanel.add(lblBerechtigung);//3
		
		JLabel lblFortbildungen = new JLabel("Fortbildungen");
		lblFortbildungen.setBounds(10, 200, 137, 14);
		adminErzeugenPanel.add(lblFortbildungen);//4
		
		textFielderzeugen = new JTextField();
		textFielderzeugen.setBounds(258, 47, 181, 20);
		adminErzeugenPanel.add(textFielderzeugen);//6
		textFielderzeugen.setColumns(10);
		
		passwortFielderzeugen = new JPasswordField();
		passwortFielderzeugen.setBounds(258, 92, 181, 20);
		adminErzeugenPanel.add(passwortFielderzeugen);
		passwortFielderzeugen.setColumns(10);
		
		radioButtonSachbearbeiter = new JRadioButton("Sachbearbeiter");
		radioButtonSachbearbeiter.setBounds(258, 139, 181, 23);
		adminErzeugenPanel.add(radioButtonSachbearbeiter);
		
		radioButtonAdministrator = new JRadioButton("Administrator");
		radioButtonAdministrator.setBounds(258, 165, 181, 23);
		adminErzeugenPanel.add(radioButtonAdministrator);
		
	}
	
	public JPanel sachbearbeiterErzeugen(boolean editierbar) {
		return adminErzeugenPanel;
	}

	
	
	public void schliessen() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.schliessen
		throw new UnsupportedOperationException();
	}

	public void abbrechen() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.abbrechen
		throw new UnsupportedOperationException();
	}

	public void ausgefuehrt() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.ausgefuehrt
		throw new UnsupportedOperationException();
	}

	

	public void praesentiereSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.praesentiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void praesentiereSachbearbeiterName() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.praesentiereSachbearbeiterName
		throw new UnsupportedOperationException();
	}

	public void selektiereSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.selektiereSachbearbeiter
		throw new UnsupportedOperationException();
	}

	public void modifiziereSachbearbeiter() {
		// TODO - implement SachbearbeiterAdminErzuegenASS.modifiziereSachbearbeiter
		throw new UnsupportedOperationException();
	}*/

}