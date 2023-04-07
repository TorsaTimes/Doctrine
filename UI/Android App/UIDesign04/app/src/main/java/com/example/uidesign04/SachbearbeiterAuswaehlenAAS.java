package com.example.uidesign04;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SachbearbeiterAuswaehlenAAS extends AppCompatActivity {

    //private ListView auswahl;

    //SachbearbeiterAuswaehlenK kontrolle = new SachbearbeiterAuswaehlenK();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sachbearbeiter_auswaehlen);
        //auswahl = findViewById(R.id.listViewAusgewaehlterSachbearbeiter);

       // ArrayList<String> sachbearbeiterNamen = new ArrayList<String>();

        /*for(String s: kontrolle.gibAlleSachbearbeiter()){
            sachbearbeiterNamen.add(s);
        }*/

       // Intent aktuellerIntent = this.getIntent();

        //Class naechsteAktivitaet = (Class)aktuellerIntent.getSerializableExtra(SachbearbeiterS.NAECHSTE_AKTIVITAET);

       /* auswahl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(SachbearbeiterAuswaehlenAAS.this, naechsteAktivitaet);
                startActivity(i);
                finish();
            }
        });*/
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}

