

#include "pch.h"
#include <iostream>
#include <string>

void aufgabEe() {

	std::string line;

	std::cout << "Text angeben: " << std::endl;
	std::getline(std::cin, line);
	std::cout << line << std::endl;
}
void aufgabea() {
	int Zahl = 0;
	std::cout << "Bitte geben Sie eine Zahl an: ";
	std::cin >> Zahl;
	std::cout << "Ausgabe der Zahl: " << Zahl << std::endl;
}
void aufgabeb() {
	int Erste = 0, Zweite = 0;
	std::cout << "Geben Sie zwei Zahlen an: ";
	std::cin >> Erste >> Zweite;
	std::cout << "Ausgabe der Zwei Zahlen: " << Erste << " Und " << Zweite << std::endl;
}
void aufgabec() {
	char c;
	int Zahl = 0;
	std::cout << "Bitte geben Sie eine Zahl an Und ein Zeichen: ";
	std::cin >> Zahl >> c;
	std::cout << "Ausgabe der Zahl: " << Zahl << " Ausgabe Zeichen: " << c << std::endl;
}
void aufgabed() {
	float f = 0;
	char c;
	std::cout << "Bitte geben Sie eine Zahl an Und ein Zeichen: ";
	std::cin >> f >> c;
	std::cout << "Ausgabe der Float-Zahl: " << f << " Ausgabe Zeichen: " << c << std::endl;
}

int gcd_iterative(int a, int b) {
	
	try {

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
	catch (int e) {

		std::cout << "Exception" << std::endl;
		
		return 0;

	}
	
	return a;
	}


int gcd_recursive(int a, int b) {

	try {

		if (a == 0 && b == 0) {

			throw 0;
		}

		if (b == 0) {
			return a;
		}
		else
			return b;

		if (a > b) {
			gcd_recursive(b, a);

		}
		else {
			gcd_recursive(a, b - a);
		}

		
		
	
	}
	catch (int e) {

		std::cout << "An Exception " << e;
	}

	return a;

}
void reduce(int num, int den) {
	std::cout << num << " / " << den << " = ";
	int ggt = gcd_iterative(num, den);
	if (ggt) {
		num /= ggt;
		den /= ggt;
		std::cout << num << " / " << den << std::endl;
	}
}




void to_ip(std::string testIp, int *erg[4]) {


	int punkte = 0;
	int zahlen = 0;
	int zwi = 0;
	int ergebnis[4];
	bool istIp = true;
	std::string zwiString = testIp;
	testIp += " ";

	for (int i = 0; i < 4; i++) {
		zahlen = std::stoi(testIp);
		if ((zahlen <= 255) && (zahlen >= 0) && (punkte <= 3) && (punkte >= 0) && istIp) {
			(*erg)[i] = zahlen;
			zwiString = std::to_string(zahlen);
			testIp = testIp.substr(zwiString.length() + 1, testIp.length());

			punkte++;
		}
		else
		{
			std::cout << "Es handelt sich hier nicht um eine IP-Adresse" << std::endl;
			istIp = false;
		}
	}

	for(int i = 0; i<4; i++){
	     std::cout << "Erg[" << i << "] ist: " << (*erg)[i] << std::endl; 
	 }


}




int main(){
	/*
	aufgabEe();
	//Aufgabe 1.
	//a
	aufgabea();
	//b
	aufgabeb();
	//c
	aufgabec();
	//d
	aufgabed();
	*/

	std::cout << "Aufgabe 2" << std::endl;
	std::cout << "a)" << std::endl;
	std::cout << gcd_iterative(41, 4) << std::endl;
	std::cout << gcd_iterative(12, 4) << std::endl;
	std::cout << gcd_iterative(0, 1) << std::endl;
	std::cout << gcd_iterative(10, 0) << std::endl;
	std::cout << gcd_iterative(3, 8) << std::endl;
	std::cout << gcd_iterative(73, 44) << std::endl;
	std::cout << "b)" << std::endl;
	std::cout << gcd_recursive(4000, 4) << std::endl;
	std::cout << gcd_recursive(424, 6) << std::endl;
	std::cout << gcd_recursive(1, 0) << std::endl;
	std::cout << gcd_recursive(0, 1) << std::endl;
	std::cout << gcd_recursive(0, 0) << std::endl;
	std::cout << gcd_recursive(42456, 2) << std::endl;
	std::cout << gcd_recursive(100, 5) << std::endl;
	//c siehe a und b 
	//d
	//d test


	//e
	reduce(9, 15);
	//e test
	reduce(0, 15);
	reduce(65, 100);
	reduce(111, 158);
	reduce(8000986, 34567455);
	reduce(0, 0);
	reduce(1999, 20);
	reduce(82, 7);
	reduce(11, 13);

	//Aufgabe 3


	std::string testip = "192.33.96.250";
	int *spei = new int[4];
	
	to_ip(testip, &spei);























}


