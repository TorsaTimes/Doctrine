
#include "pch.h"
#include <iostream>
#include <string>


namespace n1 {

	void aufgabEe() {

		std::string line;

		std::cout << "Text angeben: " << std::endl;
		std::cin.ignore();
		std::getline(std::cin, line);
		std::cout << line << std::endl;
		std::cout << " " << std::endl;
	}
	void aufgabea() {
		int Zahl = 0;
		std::cout << "Bitte geben Sie eine Zahl an: " << std::endl;
		std::cin >> Zahl;
		std::cout << "Ausgabe der Zahl: " << Zahl << std::endl;
		std::cout << " " << std::endl;
	}
	void aufgabeb() {
		int Erste = 0, Zweite = 0;
		std::cout << "Geben Sie zwei Zahlen an: " << std::endl;
		std::cin >> Erste >> Zweite;
		std::cout << "Ausgabe der Zwei Zahlen: " << Erste << " Und " << Zweite << std::endl;
		std::cout << " " << std::endl;
	}
	void aufgabec() {
		char c;
		int Zahl = 0;
		std::cout << "Bitte geben Sie eine Zahl an Und ein Zeichen: " << std::endl;
		std::cin >> Zahl >> c;
		std::cout << "Ausgabe der Zahl: " << Zahl << " Ausgabe Zeichen: " << c << std::endl;
		std::cout << " " << std::endl;
	}
	void aufgabed() {
		float f = 0;
		char c;
		std::cout << "Bitte geben Sie eine Float-Zahl an Und ein Zeichen: " << std::endl;
		std::cin >> f >> c;
		std::cout << "Ausgabe der Float-Zahl: " << f << " Ausgabe Zeichen: " << c << std::endl;
		std::cout << " " << std::endl;
	}


}



int gcd_iterative(int a, int b) {

	try {


		a = abs(a);
		b = abs(b);


		if (a == 0 && b == 0) {

			throw 0;
		}

		else if (a == 0) {

			return b;
		}

		else if (b == 0) {
			return a;
		}


		while (b != 0) {
			if (a > b) {
				a -= b;
			}
			else {
				b -= a;
			}

		}





	}
	catch (...) {

		std::cout << "Exception" << std::endl;

	}

	return a;


}


int gcd_recursive(int a, int b)
{

	a = abs(a);
	b = abs(b);

	if (a == 0 && b == 0) {
		throw "A und B darf nicht 0 sein";
	}

	if (b == 0) {
		return 0;
	}


	if (b != 0)
	{
		if (b < a)
		{
			return gcd_recursive(b, a);
		}
		else
		{
			return gcd_recursive(a, b - a);
		}
	}
	else
	{
		return a;
	}
}



void reduce(int& num, int& den) {

	if (num < 0) {

	}
	int ggt = gcd_iterative(num, den);
	if (ggt) {
		num /= ggt;
		den /= ggt;

	}
}



namespace n2 {

	int* to_ip(std::string testIp) {
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Variablen Initialisieren

		int point = 0;
		int point1 = 0;

		std::string zws = "";
		std::string zwi2 = "";

		int zahl = 0;
		int zahl2 = 0;

		int* erg = new int[4];
		int leange = testIp.length();

		int del = 0;

		std::string testip1 = testIp;
		std::string zahlwk = testIp;

		//-----------------------------------------------------------------------------------------------------------------------------------------------------------
		//Punkte zählen 

		for (int y = 0; y < 3; y++) {

			zahl2 = testip1.find('.') + 1;

			if (zahl2 > 0) {
				zahlwk = testip1.substr(zahl2, testip1.length());
				point1++;
				std::cout << zahlwk << "A" << std::endl;
			
			
			}

		}

		//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

		if (point1 == 3) {

			for (int i = 0; i <= leange; i++) {

				if (testIp[i] != '.') {

					zws += testIp[i];
				}
				else {
					zahl = std::stoi(zws);


					if (zahl <= 255 && zahl >= 0) {

						erg[point] = zahl;
						zws = "";
						point++;

					}
					else {
						throw 0;

					}


				}

			}

			zahl = std::stoi(zws);
			if (zahl <= 255 && zahl >= 0) {

				erg[point] = zahl;
			}

			if (point == 3) {

				for (int i = 0; i < 3; i++) {

					std::cout << erg[i] << ".";

				}
				std::cout << erg[3] << std::endl;

				return erg;

			}
			else {
				throw 0;
			}
		}

		return 0;

	}
}




int main() {

	//_____________________________________________________________________________________________________________________________________________________________________________________
	//Aufgabe 1.
	//e
	/*
	std::cout << "Aufgabe 1." << std::endl;
	std::cout << "Aufgabe 1. e" << std::endl;
	n1::aufgabEe();

	//a

	std::cout << "Aufgabe 1. a" << std::endl;
	n1::aufgabea();

	//b

	std::cout << "Aufgabe 1. b" << std::endl;
	n1::aufgabeb();

	//c

	std::cout << "Aufgabe 1. c" << std::endl;
	n1::aufgabec();

	//d

	std::cout << "Aufgabe 1. d" << std::endl;
	n1::aufgabed();
	*/
	//_________________________________________________________________________________________________________________________________________________________________________________________
	//Aufgabe 2
	std::cout << "Aufgabe 2" << std::endl;

	//a
	std::cout << "Aufgabe 2. a)" << std::endl;

	std::cout << gcd_iterative(10, 5) << std::endl;
	//d//c
	std::cout << gcd_iterative(12, 4) << std::endl;
	std::cout << gcd_iterative(0, 0) << std::endl;


	//b
	std::cout << "Aufgabe 2. b)" << std::endl;

	std::cout << gcd_recursive(10, 5) << std::endl;
	//d//c
	std::cout << gcd_recursive(9, 6) << std::endl;
	std::cout << gcd_recursive(0, 0) << std::endl;





	std::cout << " " << std::endl;
	//e
	std::cout << "Aufgabe 2. e)" << std::endl;
	int num = 9, den = 15;
	std::cout << num << " / " << den << " = ";
	reduce(num, den);
	std::cout << num << " / " << den << std::endl;
	std::cout << "Aufgabe 2. e)" << std::endl;


	//___________________________________________________________________________________________________________________________
	//Aufgabe 3
	std::cout << " " << std::endl;
	std::cout << "Aufgabe 3" << std::endl;

	std::string testIp1 = "192.33.96.2";
	std::string testIp2 = "193.33.96.250";
	std::string testIp3 = "192.33.96.250.454";
	std::string testIp4 = "192.133.96.250";



	n2::to_ip(testIp1);
	n2::to_ip(testIp2);
	n2::to_ip(testIp3);
	n2::to_ip(testIp4);


}