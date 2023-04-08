// übung 1 bruchrechnen.cpp : Diese Datei enthält die Funktion "main". Hier beginnt und endet die Ausführung des Programms.
//

#include "pch.h"
#include <iostream>
#include <string>
#include <cstring>

using namespace std;

int main()
{
	double a, b, c, d;
	
	
	double sum;
	
	int y = 0;

	cout << "Geben sie bitten den ersten Bruch ein: " << endl; 
	cout << "Zaehler: "; cin >> a;
	cout << "Nenner: "; cin >> b;
	cout << "Zweiter Bruch" << endl; 
	cout << "Zaehler"; cin >> c;
	cout << "Nenner: "; cin >> d;

	cout << "Bitte waehlen sie die Operationen: " << endl;
	cout << "1 fuer +" "2 fuer -" "3 fuer *" "4 fuer /" << endl;
	cin >> y;


	
		if (y == 1) {
			sum = (a / b) + (c / d);
		}
		else if (y == 2) {
			sum = (a/b) - (c/d);
		}
		else if (y == 3) {
			sum = (a / b)*(c / d);
		}
		else if (y == 4) {
			sum = (a / b) / (c / d);
		}
	
	
	cout << "Der Ergebnis ist: " << sum << endl;
	
	
}

// Programm ausführen: STRG+F5 oder "Debuggen" > Menü "Ohne Debuggen starten"
// Programm debuggen: F5 oder "Debuggen" > Menü "Debuggen starten"

// Tipps für den Einstieg: 
//   1. Verwenden Sie das Projektmappen-Explorer-Fenster zum Hinzufügen/Verwalten von Dateien.
//   2. Verwenden Sie das Team Explorer-Fenster zum Herstellen einer Verbindung mit der Quellcodeverwaltung.
//   3. Verwenden Sie das Ausgabefenster, um die Buildausgabe und andere Nachrichten anzuzeigen.
//   4. Verwenden Sie das Fenster "Fehlerliste", um Fehler anzuzeigen.
//   5. Wechseln Sie zu "Projekt" > "Neues Element hinzufügen", um neue Codedateien zu erstellen, bzw. zu "Projekt" > "Vorhandenes Element hinzufügen", um dem Projekt vorhandene Codedateien hinzuzufügen.
//   6. Um dieses Projekt später erneut zu öffnen, wechseln Sie zu "Datei" > "Öffnen" > "Projekt", und wählen Sie die SLN-Datei aus.
