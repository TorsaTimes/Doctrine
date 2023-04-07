// Zeiger.cpp : Diese Datei enthält die Funktion "main". Hier beginnt und endet die Ausführung des Programms.
//

#include "pch.h"
#include <iostream>
using namespace std;


void berechenen(int& i) {
	i = i + 200;
}

void berechenen2(int* i) {
	*i = *i + 200;
}


int main()
{

	//int b = 100;
	//int *a = &b;
	//std::cout << a << std::endl;
	//std::cout << &a << std::endl;
	//std::cout << *a << std::endl;
	//a++;
	//*a++;
	//std::cout << a << std::endl;
	//std::cout << &a << std::endl;
	//std::cout << *a << std::endl;

	int array[5] = { 1,2,3,4,5};
	
	int *ip = array;
	std::cout << *ip << "Inhalt der Speicher Adresse --> " << &ip << " Speicheradresse von ip: " << ip << std::endl;
	*ip++;
	std::cout << *ip << "Inhalt der Speicher Adresse --> " << &ip << " Speicheradresse von ip: " << ip << std::endl;
	*ip++;
	*ip++;
	*ip++;
	std::cout << *ip << "Inhalt der Speicher Adresse --> " << &ip << " Speicheradresse von ip: " << ip << std::endl;
	//std::cout << " Speicheradresse von ip: " << ip  << std::endl;


	int i = 75;
	int *iz = NULL; // Zeigervariable
	iz = &i; // iz zeigt jetzt auf i
	std::cout << "i=" << i << std::endl;
	std::cout << " An der Adresse " << iz << " ist der Wert "
		<< *iz << " gespeichert" << std::endl;
	*iz = *iz + 2; // entspricht i = i + 2
	std::cout << "i=" << i << std::endl;


	int p = 100;
	int* pz = &p;
	std::cout << "p=" << p << std::endl;
	std::cout << "*pz=" << *pz << std::endl;
	p = p + 1;
	std::cout << "*pz=" << *pz << std::endl;
	*pz = *pz + 1;
	std::cout << "p=" << p << std::endl;//*pz ==  p 
	std::cout << &p << " Speicheradresse von p --- Abrufbar mit &p" << std::endl;
	std::cout << pz << " Speicheradresse auf die der Zeiger *pz zeigt, also die Speicheradresse von p -- Abrufbar mit pz" << std::endl;
	std::cout << "Die Speicher adresse des Zeigers wo dieser gespeichert ist -- Abrufbar mit &pz " << &pz << std::endl;

	//zeiger addieren:

	*pz = (*pz - 100) + 50;
	std::cout << "p=" << p << std::endl;

	{double v[3] = { 1.1, 1.5, 2.4 };
	double *z = &v[0];
	cout << "v[0]=" << *z << endl;
	z = z + 1;
	cout << "v[1]=" << *z << endl;
	z = z + 1;
	cout << "v[2]=" << *z << endl;
	}

	//referenz 
	int x = 10;
	int& ref = x;
	ref++;
	
	cout << "x=" << x << endl;
	berechenen(x);
	cout << "x=" << x << endl;
	berechenen2(&ref);
	cout << "x=" << x << endl;


	const char *p; // Die Daten vom Typ char sind geschuetzt.
	int q;
	p = q; // ist erlaubt
	//*p = 'A'; // fuehrt zu Fehlermeldung
	//char* const u; 
	//*u = 'A'; // ist erlaubt
	//u = q; // fuehrt zu Fehlermeldung




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
