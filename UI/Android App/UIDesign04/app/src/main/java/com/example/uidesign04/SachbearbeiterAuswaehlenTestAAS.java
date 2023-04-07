package com.example.uidesign04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SachbearbeiterAuswaehlenTestAAS extends AppCompatActivity {



    public static String gewaehlterSachbearbeiter;
    public static Class naechsteAktivitaet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sachbearbeiter_auswaehlen_test_aas);
    }

    @Override
    protected void onStart(){
        super.onStart();
        final ListView sachbearbeiterListe = this.findViewById(R.id.liste);
        String[] alleSachbearbeiter = SachbearbeiterEK.gibAlleNamen();

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, alleSachbearbeiter);
        sachbearbeiterListe.setAdapter(itemsAdapter);

        sachbearbeiterListe.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                gewaehlterSachbearbeiter = (String)sachbearbeiterListe.getAdapter().getItem(position);
                Intent naechsterIntent = new Intent(SachbearbeiterAuswaehlenTestAAS.this, naechsteAktivitaet);
                naechsterIntent.putExtra("Gewählter Sachbearbeiter",gewaehlterSachbearbeiter);
                startActivity(naechsterIntent);
                finish();
            }
        });
    }
























































/*    Class naechsteAktivitaet;
    static String GEWAEHLTER_SACHBEARBEITER;
    String gewaehlterSachbearbeiter;

    SachbearbeiterAuswaehlenK kontrolle = new SachbearbeiterAuswaehlenK();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sachbearbeiter_auswaehlen_test_aas);

        gewaehlterSachbearbeiter = getIntent().getStringExtra( SachbearbeiterAuswaehlenTestAAS.GEWAEHLTER_SACHBEARBEITER);

        ArrayList<String> sachbearbeiterNamen = new ArrayList<String>();
        for (String s : kontrolle.gibAlleSachbearbeiter()) {

            sachbearbeiterNamen.add(s);
        }
        Intent aktuellerIntent = this.getIntent(); this.naechsteAktivitaet = (Class) aktuellerIntent .getSerializableExtra( SachbearbeiterS.NAECHSTE_AKTIVITAET);
    }

    protected void onStart() {
        super.onStart();
        final ListView sachbearbeiterListe = (ListView) this.findViewById(R.id.liste);
        String[] alleSachbearbeiter = kontrolle.gibAlleSachbearbeiter();
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, R.layout.simple_item, alleSachbearbeiter);
        sachbearbeiterListe.setAdapter(itemsAdapter);
        sachbearbeiterListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String gewaehlterSachbearbeiter = (String) sachbearbeiterListe.getAdapter().getItem(position);
                Intent naechsterIntent = new Intent(SachbearbeiterAuswaehlenTestAAS.this, naechsteAktivitaet);
                naechsterIntent.putExtra(GEWAEHLTER_SACHBEARBEITER, gewaehlterSachbearbeiter);
                startActivity(naechsterIntent);

            }
        });
    }*/


}
