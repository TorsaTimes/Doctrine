// ConsoleApplication11.cpp : Diese Datei enthält die Funktion "main". Hier beginnt und endet die Ausführung des Programms.
//

#include "pch.h"
#include <iostream>
#include <cmath>


using namespace std;


int main()
{
	int counter = 0;
	int f = 12;
	int erg = 0;
	for (int i = 1; i <= 9; i++) {

		erg = erg + pow(2, i);

		counter++;


		if (f == erg) {

			cout << counter << endl;
		}
		else if (f == (erg - 1)) {

			cout << counter - 1 << endl;
		}
	}
	

		
	






}

