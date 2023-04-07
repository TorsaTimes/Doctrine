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
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;




public class SachbearbeiterAdminEditierenAAS  extends SachbearbeiterEditierenAAS {


		Activity act = this;

		SachbearbeiterEditierenK kontrolle = new SachbearbeiterEditierenK();

	Button.OnClickListener okKnopfLauscher = new Button.OnClickListener() {

		@Override
		public void onClick(View v) {
			String passwort = ((EditText) findViewById(R.id.editTextpasswort)).getText().toString();
			String benutzername = ((EditText) findViewById(R.id.editTextBenutzername)).getText().toString();
			boolean sachbearbeiterRadioButton = ((RadioButton) findViewById(R.id.sachbearbeiterRadio)).isChecked();
			boolean administratorRadioButton = ((RadioButton) findViewById(R.id.adminRadio)).isChecked();
			String benutzer = SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter;



			if (administratorRadioButton) {
				String berechtigung = "admin";

				if(kontrolle.editieren(benutzername, passwort, berechtigung,benutzer )){
					ausgabe();
					Intent intent = new Intent(act, AdministratorAS.class);
					act.startActivity(intent);
				}
				else{
					AlertDialog.Builder builder1 = new AlertDialog.Builder(SachbearbeiterAdminEditierenAAS.this);
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
				String berechtigung = "normal";
				if(kontrolle.editieren(benutzername, passwort, berechtigung,benutzer )){
					ausgabe();
					Intent intent = new Intent(act, AdministratorAS.class);
					act.startActivity(intent);
				}
				else{
					AlertDialog.Builder builder1 = new AlertDialog.Builder(SachbearbeiterAdminEditierenAAS.this);
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
				AlertDialog.Builder builder1 = new AlertDialog.Builder(SachbearbeiterAdminEditierenAAS.this);
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
		setContentView(R.layout.admin_sachbearbeiter_editierenaas);
		Button okKnopf = ((Button) this.findViewById(R.id.buttonOk));
		okKnopf.setOnClickListener(this.okKnopfLauscher);

		((EditText) findViewById(R.id.editTextpasswort)).setText(SachbearbeiterEK.gib(SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter).passwort);
		((EditText) findViewById(R.id.editTextBenutzername)).setText(SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter);
		((EditText) findViewById(R.id.editTextpasswort)).setTransformationMethod(HideReturnsTransformationMethod.getInstance());

	}

	public void ausgabe(){

		String neuerName = ((EditText) findViewById(R.id.editTextBenutzername)).getText().toString();
		String alterName = SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter;

		boolean sachbearbeiterRadioButton = ((RadioButton) findViewById(R.id.sachbearbeiterRadio)).isChecked();

		if(neuerName.equals(alterName)){
			if(sachbearbeiterRadioButton){
				Toast.makeText(this, "Sachbearbeiter " + alterName + " erfolgreich Editiert",Toast.LENGTH_SHORT).show();
			}
			else{
				Toast.makeText(this, "Administrator " + alterName + " erfolgreich Editiert",Toast.LENGTH_SHORT).show();
			}

		}else{
			Toast.makeText(this, "Sachbearbeiter " + neuerName + " erfolgreich Editiert",Toast.LENGTH_SHORT).show();
			if(sachbearbeiterRadioButton){
				Toast.makeText(this, "Sachbearbeiter " + alterName + " erfolgreich Editiert",Toast.LENGTH_SHORT).show();
			}
			else{
				Toast.makeText(this, "Administrator " + alterName + " erfolgreich Editiert",Toast.LENGTH_SHORT).show();
			}
		}


	}






















































	/*private OkLauscherEditieren okeditieren = new OkLauscherEditieren();
	private BeendenLauscherEditieren beendeneditieren = new BeendenLauscherEditieren();
	private static SachbearbeiterAdminEditierenAAS instance;
	private JButton buttonAbbruchEditieren = new JButton();
	private JButton buttonOkEditieren = new JButton();
	private JPanel adminPanel;
	SachbearbeiterEditierenK kontrolle = new SachbearbeiterEditierenK();
	SachbearbeiterEditierenAAS sachbearbeiterEdit;
	//------------------------------------------------------------------------------------------
	//-------------------------Ok-lauscher---------------------------------------------------------
	private class OkLauscherEditieren implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			String benutzer = sachbearbeiterEdit.getComboBox().getSelectedItem().toString();
			String geandertName = sachbearbeiterEdit.getTextFieldBenutzer();
			String geandertPasswort = sachbearbeiterEdit.getPasswortFieldpasswort();

			if(sachbearbeiterEdit.getRadioButtonAdministrator().isSelected() == true) {
				if(kontrolle.editieren(geandertName, geandertPasswort, "admin", benutzer) == 2){

					JOptionPane.showMessageDialog(null,
	                        "Benutzer :" + benutzer + " wurde editiert",
	                        "Sachebarbeiter Editieren",
	                        JOptionPane.INFORMATION_MESSAGE);

					AdministratorAS.getInstance().entgrauen();
					adminPanel.setVisible(false);
				}
				else {
					//Passiert nicht Benutzer bleibt im Men� Sachbearbeiter Editieren
				}

			}
			else if(sachbearbeiterEdit.getRadioButtonSachbearbeier().isSelected() == true){
				if(kontrolle.editieren(geandertName, geandertPasswort, "normal", benutzer) == 2) {

					JOptionPane.showMessageDialog(null,
	                        "Benutzer :" + benutzer + " wurde editiert",
	                        "Sachebarbeiter Editieren",
	                        JOptionPane.INFORMATION_MESSAGE);

					AdministratorAS.getInstance().entgrauen();
					adminPanel.setVisible(false);
				}
				else {
					//Passiert nicht Benutzer bleibt im Men� Sachbearbeiter Editieren
				}
			}
			else {
				JOptionPane.showMessageDialog(null,
                        "Keine Berechtigung gew�hlt",
                        "Sachebarbeiter Editieren",
                        JOptionPane.WARNING_MESSAGE);
			}


			//#########################Kontroll Ausgaben in der Konsole##########################################
			System.out.println("Ausgewaehlter Benutzer " + benutzer);
			System.out.println("Geanderter Name des Benutzers " + geandertName);
			System.out.println("Geandertes Passwort des Benutzers " + geandertPasswort);
			//System.out.println(SachbearbeiterEK.gib(benutzer).gibBerechetigung());
			SachbearbeiterEK.druckAlleNamen();
			//###########################################################################################
		}
	}
	//----------------------------------------------------------------------------------
	//----------ActionListener Klasse fuer Beenden button im Editieren Panel------------------
	private class BeendenLauscherEditieren implements ActionListener, Action{
		@Override
		public void actionPerformed(ActionEvent event) {
			AdministratorAS.getInstance().entgrauen();
			adminPanel.setVisible(false);
		}

		@Override
		public void addPropertyChangeListener(PropertyChangeListener arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public Object getValue(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void putValue(String arg0, Object arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void removePropertyChangeListener(PropertyChangeListener arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void setEnabled(boolean arg0) {
			// TODO Auto-generated method stub

		}
		}
	//-------------------------------------------------------------------------------------------------
	public SachbearbeiterAdminEditierenAAS getInstance() {
		if(instance == null) {
			instance = new SachbearbeiterAdminEditierenAAS();
		}
		return instance;
	}
	//-----------------------------------------------------------------------------------------------------

	public JPanel adminSachbearbeiternEditieren() {
		JPanel erg = new JPanel();
		erg.setLayout(null);
		sachbearbeiterEdit = new SachbearbeiterEditierenAAS();
		erg = sachbearbeiterEdit.sachbearbeiterEditieren(true);
		JButton buttonAbbruchAdminEditieren = new JButton("Abbruch");
		buttonAbbruchAdminEditieren.setMnemonic(KeyEvent.VK_A);
		buttonAbbruchAdminEditieren.addActionListener(beendeneditieren);
		buttonAbbruchAdminEditieren.setBounds(10, 410, 89, 23);
		erg.add(buttonAbbruchAdminEditieren);

		JButton buttonOkAdminEditieren = new JButton("Ok");
		buttonOkAdminEditieren.setMnemonic(KeyEvent.VK_O);
		buttonOkAdminEditieren.addActionListener(okeditieren);
		buttonOkAdminEditieren.setBounds(137, 410, 89, 23);
		erg.add(buttonOkAdminEditieren);
		erg.repaint();
		adminPanel = erg;
		return erg;
	}	*/
}
