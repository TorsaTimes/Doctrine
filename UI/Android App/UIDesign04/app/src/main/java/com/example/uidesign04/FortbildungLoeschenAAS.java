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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class FortbildungLoeschenAAS extends AppCompatActivity {


    Activity act = this;

    public static String gewaehlterFortbildung;

    FortbildungLoeschenK kontrolle = new FortbildungLoeschenK();

    Button.OnClickListener fortbildungLoeschenKnopf = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {


            String benutzer = SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter;

            if(kontrolle.fortbildungLoeschen(benutzer, gewaehlterFortbildung)){
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
                AlertDialog.Builder builder1 = new AlertDialog.Builder(FortbildungLoeschenAAS.this);
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


    };

    @Override
    protected void onStart(){
        super.onStart();
        final ListView FortbildungLoeschenListe = this.findViewById(R.id.fortbildungLoeschenListe);
        String[] alleFortbildungen = Fortbildung.gibAlleFortbildungen();

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, alleFortbildungen);
        FortbildungLoeschenListe.setAdapter(itemsAdapter);

        FortbildungLoeschenListe.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                for (int j = 0; j < FortbildungLoeschenListe.getChildCount(); j++)
                    FortbildungLoeschenListe.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);

                // change the background color of the selected element
                view.setBackgroundColor(Color.LTGRAY);


                gewaehlterFortbildung = (String)FortbildungLoeschenListe.getAdapter().getItem(position);
                System.out.println("Fortbildung gewählt " + gewaehlterFortbildung);
                ((TextView) findViewById(R.id.statusFortbildungText)).setText("Fortbildung: " + gewaehlterFortbildung + " Status: " + Fortbildung.druckeFortbildungenStatusReturn(SachbearbeiterEK.gib(SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter),gewaehlterFortbildung));
                ((TextView) findViewById(R.id.fortbildungLoeschenText)).setText("Fortbildung: " + gewaehlterFortbildung + " Des Sachbearbeiters: " + SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter +" wirklich Loeschen?");

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fortbildung_loeschen_aas);
        Button fortbildungLoeschenKnopf = ((Button) this.findViewById(R.id.buttonFortbildungLoeschen));
        fortbildungLoeschenKnopf.setOnClickListener(this.fortbildungLoeschenKnopf);


    }

    public void ausgabe(){

        String alterName = SachbearbeiterAuswaehlenTestAAS.gewaehlterSachbearbeiter;


        if(SachbearbeiterEK.gib(alterName).gibBerechetigung().equals("normal")){
            Toast.makeText(this, "Fortbildung: " + gewaehlterFortbildung + " des Sachbearbeiters: " + alterName + " wurde gelöscht",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Fortbildung: " + gewaehlterFortbildung + " des Administrators: " + alterName + " wurde gelöscht",Toast.LENGTH_SHORT).show();
        }


    }


	
	
}
