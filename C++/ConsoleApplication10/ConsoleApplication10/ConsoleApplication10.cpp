// ConsoleApplication10.cpp : Diese Datei enthält die Funktion "main". Hier beginnt und endet die Ausführung des Programms.
//

#include "pch.h"
#include <iostream>
#include <string>

using namespace std;


using namespace std;


/*bool p(int x) {
	int y = 0;
	while (x) {
		int z = x & 1;
		
		x = x / 2;
		y = 2 * y + z;
		cout << "y "<< y << endl;
	}
	return (y);
}*/


/*char* conca(const char* s1, const char* s2) {
	
	int a = 0;
	int b = 0;

	while (*s1 != '\0') {
		s1 = s1 + 1;
		a = a + 1;
	}
	while (*s2 != '\0') {
		s2 = s2 + 1;
		b = b + 1;
	}


	int l = a + b;

	
	char* s12 = new char[l];//dynamische speicherresavierung

	int z = 0;

	for (int i = 0; i <= l; i++) {

		if (i <= a) {
			s12[i] = s1[i];
			a = a + 1;
		}
		else {
			s12[i] = s2[z];
			z = z + 1;
		}
	}
	for (int k = 0; k <= l; k++) {

		cout << s11[k];

	}


	return s12;


}*/


int nach(double x, int i) {

	double zwischen;
	double nachk;//double oben als übergabeparameter nur umbenannt
	nachk = x;//double x wird zu nackomma x 
	int erg;// ergebniss variabel
	zwischen = x - (int)x;
	cout << "zischen = " << zwischen << endl;
	erg = zwischen * pow(10, i);
	cout << "Erg " << erg << endl;
	double zwi2;
	zwi2 = (double)erg / 10;
	cout << "Zwi2: " << zwi2 << endl;
	zwi2 = (zwi2 - (int)zwi2) * 10;
	cout << "Zwi2 nummer 2: " << zwi2 << endl;
	


	return 0;
}

int main()
{

	cout << nach(125.783, 2) << endl;


	/*const char* s1 = "beispiel";
	const char* s2 = "text";
	cout << conca(s1, s2) << endl;*/
	
	//cout << p(8) << endl;






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
