// Operatoren.cpp : Diese Datei enthält die Funktion "main". Hier beginnt und endet die Ausführung des Programms.
//

#include "pch.h"
#include <iostream>
using namespace std;


enum Tag{
	Montag,
	Dienstag,
	Mittwoch,
	Donnerstag,
	Freitag,


};

enum Monat {
	Januar,
	Februar,
	März,
	April,
	Mai,


};



struct Datum {
	Tag tag;
	Monat monat;
	int jahr;
};


class Auto {
private:
	Datum* datum;
	int speed;
	double kosten;
public:
	Auto( int s, double k, Datum *d) :  speed(s), kosten(k), datum(d){}
	Auto(const Auto& other) : Auto(other.speed, other.kosten, other.datum){}
	~Auto() { }



};











int main()
{


	Datum d = { Montag, April, 2020 };
	

	Auto a(120, 12000, d);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	std::cout << "Hello World!\n"; 
}