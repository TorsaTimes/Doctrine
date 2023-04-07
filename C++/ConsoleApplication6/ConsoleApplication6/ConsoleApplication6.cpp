#include "pch.h"
#include <iostream>
#include <string>
#include <cstring>


using namespace std;

	

	void morse() {

		const char* table[256] = {

	"*-",//a
	"-***",//b
	"-*-*",//c
	"-**",//d	
	"*",//e
	"**-*",//f
	"--*",//g
	"****",//h
	"**",//i
	"*---",//j
	"-*-",//k
	"*-**",//l
	"--",//m
	"-*",//n
	"---",//o
	"*--*",//p
	"--*-",//q
	"*-*",//r
	"***",//s
	"-",//t
	"**-",//u
	"***-",//v
	"*--",//w
	"-**-",//x
	"-*--",//y
	"--**",//z

	"-----",//0
	"*----",//1
	"**---",//2
	"***--",//3
	"****-",//4
	"*****",//5
	"-****",//6
	"--***",//7
	"---**",//8
	"----*",//9 

			
			
		

		};


		string zeile = "";
		char buchstabe[256];


		getline(cin, zeile);

		strcpy_s(buchstabe, zeile.c_str());






		for (int i = 0; i < 50; i++) {

			int asci = (int)buchstabe[i];

			if (asci >= 65 && asci <= 90) {
				cout << table[asci - 65];
			}
			else if (asci >= 97 && asci <= 122) {
				cout << table[asci - 97];
			}
			else if (asci >= 48 && asci <= 57) {
				cout << table[asci - 22];
			}
			cout << " ";



		}


	}
	

	void morse1() {

		const char* table1[256] = { "c" };

		table1[7] = "A";
		table1[41] = "B";
		table1[50] = "C";
		table1[14] = "D";
		table1[1] = "E";
		table1[49] = "F";
		table1[17] = "G";
		table1[40] = "H";
		table1[4] = "I";
		table1[79] = "J";
		table1[23] = "K";
		table1[43] = "L";
		table1[8] = "M";
		table1[5] = "N";
		table1[26] = "O";
		table1[52] = "P";
		table1[71] = "Q";
		table1[16] = "R";
		table1[13] = "S";
		table1[2] = "T";
		table1[22] = "U";
		table1[67] = "V";
		table1[25] = "W";
		table1[68] = "X";
		table1[77] = "Y";
		table1[44] = "Z";

		table1[242] = "0";
		table1[241] = "1";
		table1[238] = "2";
		table1[229] = "3";
		table1[202] = "4";
		table1[121] = "5";
		table1[122] = "6";
		table1[125] = "7";
		table1[134] = "8";
		table1[161] = "9";



		string zeile1 = " ";
		char buchstabe1[256];
		int si = 0;
		int erg = 0;
		int hochzahl = 0;


		getline(cin, zeile1);


		strcpy_s(buchstabe1, zeile1.c_str());


		for (int z = 0; z < 256; z++) {

			if (buchstabe1[z] == '*' || buchstabe1[z] == '-') {

				if (buchstabe1[z] == '*') {
					si = 1;

				}
				else if (buchstabe1[z] == '-') {
					si = 2;
				}

				int hoch = pow(3, hochzahl);
				
				hochzahl++;
				erg = erg + (si * hoch);

			}

			else if (buchstabe1[z] == ' ') {
				cout << table1[erg];
				erg = 0;
				hochzahl = 0;
			}


		}

	



	}

	
	int main() {

		/*cout << "Willkommen im Morseuebersetzer" << endl;

		for (int x = 0; x <= 500000000; x++) {

			if (x == 100000000) {
				cout << "M";
			}
			else if (x == 200000000) {
				cout << "O";
			}
			else if (x == 300000000) {
				cout << "R";
			}
			else if (x == 400000000) {
				cout << "S";
			}
			else if (x == 500000000) {
				cout << "E";
			}

		}*/


		//morse();

		morse1();



		return 0;
}






	


	
