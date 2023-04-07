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
import android.widget.Toast;

import androidx.annotation.Nullable;


public class SachbearbeiterSachbearbeiterEditierenAAS extends SachbearbeiterEditierenAAS {


	Activity act = this;

	SachbearbeiterEditierenK kontrolle = new SachbearbeiterEditierenK();

	Button.OnClickListener okKnopfSachbearbeiterLauscher = new Button.OnClickListener() {

		@Override
		public void onClick(View v) {
			String passwort = ((EditText) findViewById(R.id.editTextpasswort)).getText().toString();
			String benutzername = ((EditText) findViewById(R.id.editTextBenutzername)).getText().toString();
			String benutzer = SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter;



			if (kontrolle.editieren(benutzername, passwort, getBerechtigung() , benutzer)) {
				ausgabe();
				Intent intent = new Intent(act, SachbearbeiterAS.class);
				act.startActivity(intent);
			} else {
				AlertDialog.Builder builder1 = new AlertDialog.Builder(SachbearbeiterSachbearbeiterEditierenAAS.this);
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
	};


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sachbearbeiter_sachbearbeiter_editieren_aas);
		Button okKnopf = ((Button) this.findViewById(R.id.buttonOk));
		okKnopf.setOnClickListener(this.okKnopfSachbearbeiterLauscher);

		((EditText) findViewById(R.id.editTextpasswort)).setText(SachbearbeiterEK.gib(SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter).passwort);
		((EditText) findViewById(R.id.editTextBenutzername)).setText(SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter);
		((EditText) findViewById(R.id.editTextpasswort)).setTransformationMethod(HideReturnsTransformationMethod.getInstance());

	}

	public void ausgabe() {

		String neuerName = ((EditText) findViewById(R.id.editTextBenutzername)).getText().toString();
		String alterName = SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter;



		if(alterName.equals(neuerName)){
			Toast.makeText(this, "Sachbearbeiter " + alterName + " erfolgreich Editiert", Toast.LENGTH_SHORT).show();
		}
		else{
			Toast.makeText(this, "Sachbearbeiter " + neuerName + " erfolgreich Editiert", Toast.LENGTH_SHORT).show();
		}


	}

	public String getBerechtigung(){
		String b = SachbearbeiterEK.gib(SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter).gibBerechetigung();
		return b;
	}



}
























































	/*private OkLauscherEditieren okeditieren = new OkLauscherEditieren();
	private BeendenLauscherEditieren beendeneditieren = new BeendenLauscherEditieren();
	private static SachbearbeiterSachbearbeiterEditierenAAS instance;
	private JButton buttonAbbruchEditieren = new JButton();
	private JButton buttonOkEditieren = new JButton();
	private JPanel sachbearbeiterPanel;
	
	SachbearbeiterEditierenK kontrolle = new SachbearbeiterEditierenK();
	SachbearbeiterEditierenAAS sachbearbeiterEdit;
	
	

	// ------------------------------------Instanz der KLasse
	// erzeugen-------------------------------------------------------------
	public SachbearbeiterSachbearbeiterEditierenAAS getInstance() {
		if (instance == null) {
			instance = new SachbearbeiterSachbearbeiterEditierenAAS();
		}
		return instance;
	}

	// -----------------------------------------------------------------------------------------------------
	// -------------------------Ok-lauscher---------------------------------------------------------
	private class OkLauscherEditieren implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			String benutzer = sachbearbeiterEdit.getComboBox().getSelectedItem().toString();
			String geandertName = sachbearbeiterEdit.getTextFieldBenutzer();
			String geandertPasswort = sachbearbeiterEdit.getPasswortFieldpasswort();
			String berechtigung = SachbearbeiterEK.gib(benutzer).gibBerechetigung();
					
				if (kontrolle.editieren(geandertName, geandertPasswort, berechtigung, benutzer) == 2) {

					JOptionPane.showMessageDialog(null, "Benutzer :" + benutzer + " wurde editiert",
							"Sachebarbeiter Editieren", JOptionPane.INFORMATION_MESSAGE);

					AdministratorAS.getInstance().entgrauen();
					SachbearbeiterAS.getInstance().entgrauen();
					sachbearbeiterPanel.setVisible(false);
				} else {
					// Passiert nicht Benutzer bleibt im Men� Sachbearbeiter Editieren
				}


			// #########################Kontroll Ausgaben in der
			// Konsole##########################################
			System.out.println("Ausgewaehlter Benutzer " + benutzer);
			System.out.println("Geanderter Name des Benutzers " + geandertName);
			System.out.println("Geandertes Passwort des Benutzers " + geandertPasswort);
			// System.out.println(SachbearbeiterEK.gib(benutzer).gibBerechetigung());
			SachbearbeiterEK.druckAlleNamen();
			// ###########################################################################################
		}
	}

	// ----------ActionListener Klasse fuer Beenden button im Editieren
	// Panel------------------
	private class BeendenLauscherEditieren implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			SachbearbeiterAS.getInstance().entgrauen();
			sachbearbeiterPanel.setVisible(false);
		}
	}
	// -------------------------------------------------------------------------------------------------
	public JPanel sachbearbeiterSachbearbeiternEditieren() {
		JPanel erg = new JPanel();
		erg.setLayout(null);
		sachbearbeiterEdit = new SachbearbeiterEditierenAAS();
		erg = sachbearbeiterEdit.sachbearbeiterEditieren(true);
		JButton buttonAbbruchEditieren = new JButton("Abbruch");
		buttonAbbruchEditieren.setMnemonic(KeyEvent.VK_A);
		buttonAbbruchEditieren.addActionListener(beendeneditieren);
		buttonAbbruchEditieren.setBounds(10, 410, 89, 23);
		erg.add(buttonAbbruchEditieren);
		
		
		JButton buttonOkEditieren = new JButton("Ok");
		buttonOkEditieren.setMnemonic(KeyEvent.VK_O);
		buttonOkEditieren.addActionListener(okeditieren);
		buttonOkEditieren.setBounds(137, 410, 89, 23);
		erg.add(buttonOkEditieren);
		erg.remove(sachbearbeiterEdit.getRadioButtonAdministrator());
		erg.remove(sachbearbeiterEdit.getRadioButtonSachbearbeier());
		erg.validate();
		erg.repaint();
		sachbearbeiterPanel = erg;
		return erg;
	}	*/

