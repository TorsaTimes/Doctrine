package com.example.uidesign04;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class FortbildungZuordnenAAS extends AppCompatActivity {


    Activity act = this;

    public static String gewaehlterFortbildung;

    FortbildungZuordnenK kontrolle = new FortbildungZuordnenK();

    Button.OnClickListener okKnopfLauscher = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {

            boolean belegtButton = ((RadioButton) findViewById(R.id.radioButtonBelegt)).isChecked();
            boolean bestandenButton = ((RadioButton) findViewById(R.id.radioButtonBestanden)).isChecked();
            String benutzer = SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter;


            if(belegtButton){
                String status = "belegt";
                if(kontrolle.sachbearbeiterFortbildungBuchen(benutzer, gewaehlterFortbildung, status)){
                        if(AdministratorAS.fortbildungBack = true){
                            ausgabe();
                            Intent intent = new Intent(act, AdministratorAS.class);
                            act.startActivity(intent);
                        }
                        else{
                            ausgabe();
                            Intent intent = new Intent(act, SachbearbeiterAS.class);
                            act.startActivity(intent);
                        }
                }
                else{
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(FortbildungZuordnenAAS.this);
                    builder1.setMessage("Fehler!");
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
            else if(bestandenButton){
                String status = "bestanden";
                if(kontrolle.sachbearbeiterFortbildungBuchen(benutzer, gewaehlterFortbildung, status)){
                    if(AdministratorAS.fortbildungBack = true){
                        ausgabe();
                        Intent intent = new Intent(act, AdministratorAS.class);
                        act.startActivity(intent);
                    }
                    else{
                        ausgabe();
                        Intent intent = new Intent(act, SachbearbeiterAS.class);
                        act.startActivity(intent);
                    }
                }
                else{
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(FortbildungZuordnenAAS.this);
                    builder1.setMessage("Fehler!");
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
            else{
                AlertDialog.Builder builder1 = new AlertDialog.Builder(FortbildungZuordnenAAS.this);
                builder1.setMessage("Error!");
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
    protected void onStart(){
        super.onStart();
        final ListView FortbildungListe = this.findViewById(R.id.listeFortbildung);
        String[] alleFortbildungen = Fortbildung.gibAlleFortbildungen();

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, alleFortbildungen);
        FortbildungListe.setAdapter(itemsAdapter);

        FortbildungListe.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                for (int j = 0; j < FortbildungListe.getChildCount(); j++)
                    FortbildungListe.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);

                // change the background color of the selected element
                view.setBackgroundColor(Color.LTGRAY);


                gewaehlterFortbildung = (String)FortbildungListe.getAdapter().getItem(position);
                System.out.println("Fortbildung gewählt " + gewaehlterFortbildung);
/*                Intent naechsterIntent = new Intent(FortbildungZuordnenAAS.this, naechsteAktivitaet);
                naechsterIntent.putExtra("Gewählter Sachbearbeiter",gewaehlterFortbildung);
                startActivity(naechsterIntent);
                finish();*/
            }
        });
    }




        @Override
        protected void onCreate( Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fortbildung_zuweisen_aas);
            Button okKnopf = ((Button) this.findViewById(R.id.buttonZuweisen));
            okKnopf.setOnClickListener(this.okKnopfLauscher);
        }


    public void ausgabe(){

        String alterName = SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter;


            if(SachbearbeiterEK.gib(alterName).gibBerechetigung().equals("normal")){
                Toast.makeText(this, "Sachbearbeiter: " + alterName + " belegt Fortbildung: " + gewaehlterFortbildung,Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Administrator: " + alterName + " belegt Fortbildung: " + gewaehlterFortbildung,Toast.LENGTH_SHORT).show();
            }


    }






























	
	/*//---------------------------------Attribute der Klasse----------------------------------------------------------------------------------------------
	
	private OkLauscherFortbildungZuordnen okZuordnen = new OkLauscherFortbildungZuordnen();
	private BeendenLauscherFortbildungZuordnen beendenZuordnen = new BeendenLauscherFortbildungZuordnen();
	
	Action radioButtonBelegtListener = new radioButtonBelegtButton();
	Action radioButtonBestandenListener = new radioButtonBestandenButton();
	
	private JPanel fortbildungZuordnenPanel = new JPanel();
	private JPanel fortbildungPanel;
	
	private JRadioButton radioButtonBelegt = new JRadioButton(radioButtonBelegtListener);
	private JRadioButton radioButtonBestanden = new JRadioButton(radioButtonBestandenListener);
	SachbearbeiterAuswaehlenAAS comboSachbearbeiter = new SachbearbeiterAuswaehlenAAS();
	FortbildungAuswaehlenAAS comboFortbildung = new FortbildungAuswaehlenAAS();

	public FortbildungZuordnenK kontrolle = new FortbildungZuordnenK();
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------
	//---------------------------AactionListener klasse des OK Button im Fortbildung Zuordnen Panel------------------------------------------------------
	private class OkLauscherFortbildungZuordnen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			String benutzer = getComboBoxSachbearbeiter().getSelectedItem().toString();
			String fortbildung = getComboBoxFortbildung().getSelectedItem().toString();
			if(radioButtonBelegt.isSelected()) {
				System.out.println("belegt");
				String belegt = "belegt";
				if(kontrolle.sachbearbeiterFortbildungBuchen(benutzer, fortbildung, belegt) == 2) {
					
					JOptionPane.showMessageDialog(null,
	                        "Sachbearbeiter: " + benutzer + " wurde der Fortbildung: " + fortbildung + " zugewiesen mit dem Status: " + belegt,
	                        "Sachbearbeiter Fortbildung Zuordnen",					      
	                        JOptionPane.INFORMATION_MESSAGE);
					SachbearbeiterAS.getInstance().entgrauen();
					AdministratorAS.getInstance().entgrauen();
					fortbildungPanel.setVisible(false);
					
				}
				else {
					
				}
			}
			else if(radioButtonBestanden.isSelected()) {
				System.out.println("bestanden");
				String bestanden = "bestanden";
				if(kontrolle.sachbearbeiterFortbildungBuchen(benutzer, fortbildung, bestanden) == 2) {
					
					JOptionPane.showMessageDialog(null,
	                        "Sachbearbeiter: " + benutzer + " wurde der Fortbildung: " + fortbildung + " zugewiesen mit dem Status: " + bestanden,
	                        "Sachbearbeiter Bearbeitet",					      
	                        JOptionPane.INFORMATION_MESSAGE);
					SachbearbeiterAS.getInstance().entgrauen();
					AdministratorAS.getInstance().entgrauen();
					fortbildungPanel.setVisible(false);
					
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
			//############################Kontroll Ausgabe###################################################################
			System.out.println("Der Benutzer: " + benutzer + " hat die Fortbildung: "  + fortbildung);
			//###############################################################################################################
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//----------ActionListener Klasse fuer Beenden button im Fortbildung Zuordnen Panel---------------------------------------------------------------
	private class BeendenLauscherFortbildungZuordnen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			SachbearbeiterAS.getInstance().entgrauen();
			AdministratorAS.getInstance().entgrauen();
			fortbildungPanel.setVisible(false);
		}
		}
	//--------------------------------------------------------------------------------------------------------------------------------------------------	
	//----------------------------------------------------------------------------------------------------------------------
	public FortbildungZuordnenAAS() {
		
		fortbildungZuordnenPanel.setLayout(null);
		fortbildungZuordnenPanel.setSize(600, 270);
		
		//------------------------Labels----------------------------------------------------------------------
		JLabel lblFortbildungZuordnen = new JLabel("Fortbildung zuordnen");
		lblFortbildungZuordnen.setBounds(23, 33, 129, 14);
		fortbildungZuordnenPanel.add(lblFortbildungZuordnen);
		
		JLabel lblAusgewhlterSachbearbeiter = new JLabel("Ausgew\u00E4hlter Sachbearbeiter");
		lblAusgewhlterSachbearbeiter.setBounds(23, 90, 170, 14);
		fortbildungZuordnenPanel.add(lblAusgewhlterSachbearbeiter);
		
		JLabel lblAusgewhlteFortbildung = new JLabel("Ausgew\u00E4hlte Fortbildung");
		lblAusgewhlteFortbildung.setBounds(222, 90, 148, 14);
		fortbildungZuordnenPanel.add(lblAusgewhlteFortbildung);
		//-----------------------------------------------------------------------------------------------------
		
		//--------------------------ComboBox fortbildung-----------------------------------------------
		JComboBox comboBoxFortbildung = comboFortbildung.oeffnen();
		comboBoxFortbildung.setBounds(222, 115, 148, 20);
		comboBoxFortbildung.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = comboBoxFortbildung.getSelectedItem().toString();
				
			}
		});
		fortbildungZuordnenPanel.add(comboBoxFortbildung);
		//----------------------------------------------------------------------------------------------------
		
		//----------------------------ComboBox Sachbearbeiter-------------------------------------------------
		JComboBox comboBoxSachbearbeiter = comboSachbearbeiter.oeffnen();
		comboBoxSachbearbeiter.setBounds(23, 115, 148, 20);
		comboBoxSachbearbeiter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = comboBoxSachbearbeiter.getSelectedItem().toString();
				SachbearbeiterEK sach = SachbearbeiterEK.gib(name);
			}
		});
		fortbildungZuordnenPanel.add(comboBoxSachbearbeiter);
		//-----------------------------------------------------------------------------------------------------
		
		//------------------------------RadioButtons-------------------------------------------------------------
		//radioButtonBelegt = new JRadioButton("belegt");
		radioButtonBelegt.setText("belegt");
		radioButtonBelegt.setBounds(23, 225, 109, 23);
		fortbildungZuordnenPanel.add(radioButtonBelegt);
		
		//radioButtonBestanden = new JRadioButton("bestanden");
		radioButtonBestanden.setText("bestanden");
		radioButtonBestanden.setBounds(23, 250, 109, 23);
		fortbildungZuordnenPanel.add(radioButtonBestanden);
		//-----------------------------------------------------------------------------------------------------
	}
	//----------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------------
	public JComboBox getComboBoxSachbearbeiter() {
		return comboSachbearbeiter.oeffnen();
	}
	
	public JComboBox getComboBoxFortbildung() {
		return comboFortbildung.oeffnen();
	}
	//----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	public JPanel adminSachbearbeiternFortbildungZuordnen() {
		JPanel erg = new JPanel();
		erg.setLayout(null);
		
		erg = adminSachbearbeiterFortbildungZuordnen(true);
		JButton buttonAbbruchFortbildungZuordnen = new JButton("Abbruch");
		buttonAbbruchFortbildungZuordnen.setMnemonic(KeyEvent.VK_A);
		buttonAbbruchFortbildungZuordnen.addActionListener(beendenZuordnen);
		buttonAbbruchFortbildungZuordnen.setBounds(10, 320, 89, 23);
		erg.add(buttonAbbruchFortbildungZuordnen);
		
		JButton buttonOkFortbildungZuordnen = new JButton("OK");
		buttonOkFortbildungZuordnen.setMnemonic(KeyEvent.VK_O);
		buttonOkFortbildungZuordnen.addActionListener(okZuordnen);
		buttonOkFortbildungZuordnen.setBounds(137, 320, 89, 23);
		erg.add(buttonOkFortbildungZuordnen);
		erg.repaint();
		fortbildungPanel = erg;
		return erg;
	}
	public JPanel adminSachbearbeiterFortbildungZuordnen(boolean editierbar) {
		return fortbildungZuordnenPanel;
	}
	//--------------------------------------------------------------------------------------------------------------------
	//------------------------ActionAbstract Klasse f�r RadioButton - gegenseitges Ausschalten-----------------------------
		class radioButtonBelegtButton extends AbstractAction{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(radioButtonBestanden.isSelected() == true) {
					radioButtonBestanden.setSelected(false);
					}
			}
		}
		class radioButtonBestandenButton extends AbstractAction{
			@Override
			public void actionPerformed(ActionEvent e) {			
				if(radioButtonBelegt.isSelected() == true) {
					radioButtonBelegt.setSelected(false);
				}
				
				}
			}
		//-----------------------------------------------------------------------------------------------------------------------*/
}
