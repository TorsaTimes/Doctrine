
#include "pch.h"
#include <iostream>
#include <string>


namespace n1 {

	void aufgabEe() {

		std::string line = "";

		std::cout << "Text angeben: " << std::endl;
		//std::cin.ignore();
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

		a = std::abs(a);
		b = abs(b);



		if (a == 0 && b == 0) {

			throw std::invalid_argument("Nicht beides 0");
		}

		else if (b == 0) {
			return a;
		}
		else if (a == 0) {
			return b;

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


int gcd_recursive(int a, int b) {

	try {
		a = abs(a);
		b = abs(b);

		if (a == 0 && b == 0) {

			throw 0;
		}


		if (b == 0) {

			return a;
		}

		if (a == 0) {

			return b;
		}

		if (b != 0) {

			if (a > b) {

				return gcd_recursive(b, a);
			}
			else {

				return gcd_recursive(a, b - a);
			}
		}
		else {

			return a;
		}
	}
	catch (...) {
		std::cout << "Exception" << std::endl;
	}

	return 0;
}

void reduce(int& num, int& den) {

	
	int ggt = gcd_iterative(num, den);
	if (ggt) {
		num /= ggt;
		den /= ggt;

	}
}

namespace n2
{
	int* to_ip(std::string testIp) {

		int point = 0;
		int zahl = 0;
		int* erg = new int[4];
		int l = 0;
		std::string punktfinden = testIp;

		size_t n = std::count(punktfinden.begin(), punktfinden.end(), '.');//iteratoren begin() und end()
		if (n == 3) {
			while (point < 4) {

				l = punktfinden.find('.');
				int zahl = std::stoi(punktfinden.substr(0, l));
				if (zahl <= 255 && zahl >= 0) {
					erg[point] = std::stoi(punktfinden.substr(0, l));
				}
				else {
					throw 0;
				}
				l++;
				punktfinden.erase(0, l);
				point++;

				if (point == 3) {
					int zahl = std::stoi(punktfinden.substr(0, l));
					if (zahl <= 255 && zahl >= 0) {
						erg[point] = std::stoi(punktfinden.substr(0, l));
					}
					else {
						throw 0;
					}
				}
			}
			return erg;
		}
		else {
			throw 0;
		}
	}
}

void ausgabe(int* e) {

	for (int i = 0; i < 3; i++) {

		std::cout << e[i] << ".";

	}
	std::cout << e[3] << std::endl;

}


void testReduce() {

	std::cout << "Willkommen zum Test der Funktion reduce(), Bitte geben sie 2 Zahlen ein: " << std::endl;
	int a = 0;
	int b = 0;
	std::cin >> a >> b;
	std::cout << "Deine Eingabe lautet wie folgt: " << a << " " << b << std::endl;
	reduce(a, b);
	std::cout << a << " / " << b << std::endl;
}



int main() {

	//_____________________________________________________________________________________________________________________________________________________________________________________
	//Aufgabe 1.
	//e

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

	//_________________________________________________________________________________________________________________________________________________________________________________________
	//Aufgabe 2
	std::cout << "Aufgabe 2" << std::endl;
	std::cout << " " << std::endl;

	//a
	std::cout << "Aufgabe 2. a)" << std::endl;

	std::cout << gcd_iterative(-10, -5) << std::endl;
	//a Test
	/*try {
		std::cout << gcd_iterative(0, 0) << std::endl;
	}
	catch (...) {
		std::cout << "E" << std::endl;
	}
	try {
		std::cout << gcd_iterative(1, 0) << std::endl;
	}
	catch (...) {
		std::cout << "E" << std::endl;
	}
	try {
		std::cout << gcd_iterative(0, 1) << std::endl;
	}
	catch (...) {
		std::cout << "E" << std::endl;
	}*/
	
	std::cout << gcd_iterative(0, 0) << std::endl;
	std::cout << gcd_iterative(0, 1) << std::endl;
	std::cout << gcd_iterative(1, 0) << std::endl;


	//b
	std::cout << "Aufgabe 2. b)" << std::endl;

	std::cout << gcd_recursive(10, -5) << std::endl;
	//Test
	std::cout << gcd_recursive(0, 0) << std::endl;
	std::cout << gcd_recursive(0, 1) << std::endl;
	std::cout << gcd_recursive(1, 0) << std::endl;




	std::cout << " " << std::endl;
	//e

	std::cout << "Aufgabe 2. e)" << std::endl;
	int num = 9, den = 15;
	std::cout << num << " / " << den << " = ";
	reduce(num, den);
	std::cout << num << " / " << den << std::endl;
	//e test
	std::cout << "Aufgabe 2. e) TEST " << std::endl;
	testReduce();


	//___________________________________________________________________________________________________________________________
	//Aufgabe 3
	std::cout << " " << std::endl;
	std::cout << "Aufgabe 3" << std::endl;

	std::string testIp1 = "255.33.96.2.1.35";
	std::string testIp2 = "0.0.0.0";
	std::string testIp3 = "192.33.96";
	std::string testIp4 = "192.133.96.250";

	try {
		ausgabe(n2::to_ip(testIp1));
	}
	catch (...) {

		std::cout << "E" << std::endl;
	}

	try {
		ausgabe(n2::to_ip(testIp2));
	}
	catch (...) {

		std::cout << "Exception" << std::endl;
	}

	try {
		ausgabe(n2::to_ip(testIp3));
	}
	catch (...) {

		std::cout << "Exception" << std::endl;
	}

	try {
		ausgabe(n2::to_ip(testIp4));
	}
	catch (...) {

		std::cout << "Exception" << std::endl;
	}


}