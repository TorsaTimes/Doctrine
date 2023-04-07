#include "pch.h"
#include <iostream>
#include <string>
#include <cstring>


using namespace std;


int main() {

	const char* table[256]{

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



	cout << "Herzlich Willkommen beim Morseuebersetzer \nBitte gebe deinen Eingabe ein: " << endl;

	getline(cin, zeile);

	strcpy_s(buchstabe, zeile.c_str());

	for (int i = 1; i < 50; i++) {

		int asci = (int) buchstabe[i];
		cout << buchstabe[asci-65];
		cout << " ";




	}
	return 0;
}