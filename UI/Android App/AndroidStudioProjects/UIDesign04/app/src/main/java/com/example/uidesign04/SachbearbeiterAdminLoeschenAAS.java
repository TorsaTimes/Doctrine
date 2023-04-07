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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SachbearbeiterAdminLoeschenAAS extends AppCompatActivity {

    Activity act = this;

    String ausgewaehlerSachbearbeiter = SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter;
    Button.OnClickListener buttonSachbearbeiterLoeschen = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            if((SachbearbeiterEK.sachbearbeiter.size() == 1) && (SachbearbeiterEK.gib(SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter).gibBerechetigung().equals("admin"))){
                AlertDialog.Builder builder1 = new AlertDialog.Builder(SachbearbeiterAdminLoeschenAAS.this);
                builder1.setMessage("Der letzte Administrator " + ausgewaehlerSachbearbeiter +" kann nicht gelöscht werden!");
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

            }else{
                ausgabe();
                SachbearbeiterEK.sachbearbeiter.remove(SachbearbeiterEK.gib(SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter));
                Intent intent = new Intent(act, AdministratorAS.class);
                act.startActivity(intent);
            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_sachbearbeiter_loeschen_aas);
        Button sachbearbeiterLoeschenKnopf = ((Button) this.findViewById(R.id.buttonSachbearbeiterLoeschen));
        sachbearbeiterLoeschenKnopf.setOnClickListener(this.buttonSachbearbeiterLoeschen);

        if(SachbearbeiterEK.gib(ausgewaehlerSachbearbeiter).gibBerechetigung().equals("admin")){
            ((TextView) findViewById(R.id.sachbearbeiterLoeschenText)).setText("Administrator: " + ausgewaehlerSachbearbeiter + " wirklich Löschen");
        }
        else{
            ((TextView) findViewById(R.id.sachbearbeiterLoeschenText)).setText("Sachbearbeiter: " + ausgewaehlerSachbearbeiter + " wirklich Löschen");
        }

    }

    private void zurueck(){
        Intent intent = new Intent(this, AdministratorAS.class);
        startActivity(intent);
        finish();
    }

    public void ausgabe(){

        if(SachbearbeiterEK.gib(SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter).gibBerechetigung().equals("admin")){
            Toast.makeText(this,"Sachbearbeiter: " + ausgewaehlerSachbearbeiter +  " erfolgreich gelöscht", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Sachbearbeiter: " + ausgewaehlerSachbearbeiter +  " erfolgreich gelöscht",Toast.LENGTH_SHORT).show();
        }
    }
}





































































	/*//------------------------------------Attribute der Klasse---------------------------------------
		private OkLauscherL�schen okErzeugen = new OkLauscherL�schen();
		private BeendenLauscherL�schen beendenErzeugen = new BeendenLauscherL�schen();
		
		private JButton buttonAbbruchL�schen = new JButton();
		private JButton buttonOkL�schen = new JButton();
		
		private JPanel adminL�schenPanel = new JPanel();//panel was zur�ckgegeben wird
		private JPanel adminPanel;//Panel was im lauscher genutzt wird

		private JRadioButton radioButtonSachbearbeiter;
		private JRadioButton radioButtonAdministrator;
		//--------------------------------------------------------------------------------------------
		private static SachbearbeiterAdminLoeschenAAS instance;
		SachbearbeiterAdminLoeschenK kontrolle = new SachbearbeiterAdminLoeschenK();
		SachbearbeiterAuswaehlenAAS combo = new SachbearbeiterAuswaehlenAAS();
		//---------------------------OK-Lauscher-----------------------------------------------------------------
	
	private class OkLauscherL�schen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			
			String benutzerMessagePanel = getComboBox().getSelectedItem().toString();
			String[] optionen = { "Ja", "Nein" }; 
            int n = JOptionPane.showOptionDialog( null, "Wollen Sie den Sachbearbeiter " + benutzerMessagePanel + " wirklich L�schen?", "Ja oder Nein", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, optionen,optionen[0] );       

                if ( n == JOptionPane.YES_OPTION ) {  
                  
                	String benutzer = getComboBox().getSelectedItem().toString();
        			kontrolle.loeschen(benutzer);
        			AdministratorAS.getInstance().entgrauen();
        			adminPanel.setVisible(false);
                	
                	
                }
                else if ( n == JOptionPane.NO_OPTION ) {
                        
                	
                    }
			
			//############################Kontroll Ausgabe###################################################################
			System.out.println("Der Benutzer: " + benutzerMessagePanel + " wurde geloescht");
			//###############################################################################################################
		}
	}
	//----------------------------------------------------------------------------------
	//----------ActionListener Klasse fuer Beenden button im Editieren Panel------------------
	private class BeendenLauscherL�schen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			AdministratorAS.getInstance().entgrauen();
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
	
	public JPanel adminSachbearbeiternL�schen() {
		JPanel erg = new JPanel();
		erg.setLayout(null);
		
		erg = sachbearbeiterL�schen(true);
		JButton buttonAbbruchL�schen = new JButton("Abbruch");
		buttonAbbruchL�schen.setMnemonic(KeyEvent.VK_A);
		buttonAbbruchL�schen.addActionListener(beendenErzeugen);
		buttonAbbruchL�schen.setBounds(10, 260, 89, 23);
		erg.add(buttonAbbruchL�schen);
		
		JButton buttonOkL�schen = new JButton("L�schen");
		buttonOkL�schen.setMnemonic(KeyEvent.VK_L);
		buttonOkL�schen.addActionListener(okErzeugen);
		buttonOkL�schen.setBounds(137, 260, 89, 23);
		erg.add(buttonOkL�schen);
		erg.repaint();
		adminPanel = erg;
		return erg;
	}
	public JPanel sachbearbeiterL�schen(boolean editierbar) {
		return adminL�schenPanel;
	}
	
	
	public SachbearbeiterAdminLoeschenAAS() {
		adminL�schenPanel.setLayout(null);
		adminL�schenPanel.setSize(600, 250);
		
		JLabel lblSachbearbeiterLschen = new JLabel("Sachbearbeiter Loeschen");
		lblSachbearbeiterLschen.setBounds(26, 40, 165, 14);
		adminL�schenPanel.add(lblSachbearbeiterLschen);
		
		JLabel lblSachbearbeiterAuswhlen = new JLabel("Sachbearbeiter auswaehlen");
		lblSachbearbeiterAuswhlen.setBounds(26, 127, 182, 14);
		adminL�schenPanel.add(lblSachbearbeiterAuswhlen);
		
		JComboBox comboBox = combo.oeffnen();
		comboBox.setBounds(218, 124, 159, 20);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = comboBox.getSelectedItem().toString();
				SachbearbeiterEK sach = SachbearbeiterEK.gib(name);
			}
		});
		adminL�schenPanel.add(comboBox);

	}
	
	public JComboBox getComboBox() {
		return combo.oeffnen();
	}*/
	


