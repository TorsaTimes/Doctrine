
package com.example.uidesign04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class  FortbildungAuswaehlenAAS extends Activity {


    public static String gewaehlteFortbildung;
    public static Class naechsteAktivitaet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.fortbildung_auswaehlen_ass);
    }

    @Override
    protected void onStart(){
        super.onStart();
        final ListView FortbildungListe = this.findViewById(R.id.liste);
        String[] alleFortbildungen = Fortbildung.gibAlleFortbildungen();

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, alleFortbildungen);
        FortbildungListe.setAdapter(itemsAdapter);

        FortbildungListe.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                gewaehlteFortbildung = (String)FortbildungListe.getAdapter().getItem(position);
                Intent naechsterIntent = new Intent(FortbildungAuswaehlenAAS.this, naechsteAktivitaet);
                naechsterIntent.putExtra("Gewählter Sachbearbeiter",gewaehlteFortbildung);
                startActivity(naechsterIntent);
                finish();
            }
        });
    }











































/*
	FortbildungAuswaehlenK kontrolle = new FortbildungAuswaehlenK();
	JComboBox auswahlBox;
	String auswahl;

	public FortbildungAuswaehlenAAS() {
		auswahlBox = new JComboBox(kontrolle.fortbildungen);
		auswahlBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				auswahl = (String) auswahlBox.getSelectedItem();
			}
		});
		
	}
	
	

	
	public JComboBox oeffnen() {
		return auswahlBox;
	}
	
	
	
	public String getAuswahl() {
		System.out.println(auswahl);
		return auswahl;
	}*/
	
}

