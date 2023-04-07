// OOP2.cpp : Diese Datei enthält die Funktion "main". Hier beginnt und endet die Ausführung des Programms.
//

#include "pch.h"
#include <iostream>
#include <ostream>
#include <string>
#include <ctime>
#include <fstream>
#include <sstream>
#include <iomanip>
#include "Book.h"
#include "assert.h"
#include "Header.h"
#include <set>


	std::ostream& hfu::operator<<(std::ostream& out, const hfu::Book& other) {
	return out << "(" << other.getBuchTitle() << "," << other.getAutor() << "," << other.getAnDatum() << ")";
	}


hfu::Book::~Book() {
	std::cout << this->getBuchTitle() << std::endl;
	std::cout << "Buch geloescht" << std::endl;
}



std::string hfu::Book::today() {

	auto t = std::time(nullptr);
	auto tm = *std::localtime(&t);
	std::string datum = "";
	std::ostringstream oss;
	oss << std::put_time(&tm, "%Y-%m-%d");
	datum = oss.str();

	return datum;
}
std::string hfu::Book::getStatus() const {

	if (status == true) {

		return "ausgeliehen";
	}
	else {
		return "verfuegbar";
	}
}
std::string hfu::Book::getBuchTitle() const {

	return buchTitle;
}
std::string hfu::Book::getAutor() const {

	return autor;
}
std::string hfu::Book::getAnDatum() const {

	
		return anDatum;
}

	/*hfu::Book hfu::Book::operator[](int i){

	return get(i);

	}*/

	/*hfu::Book get(int i){
		
			return Book[i];
		
	}*/


	bool hfu::operator==(const hfu::Book& other, const hfu::Book& other1) {

		if ((other.getBuchTitle() == other1.getBuchTitle()) && (other.getAutor() == other1.getAutor()) && (other.getAnDatum() == other1.getAnDatum())) {
			return true;
		}

		return false;
	}

	bool hfu::operator<(const hfu::Book& other, const hfu::Book& other1) {

		return(other.getBuchTitle() < other1.getBuchTitle());
	}

	

void hfu::Book::dump() const {
	std::cout << "----------------------------------------------------" << std::endl;
	std::cout << "Buchtitle: " << getBuchTitle() << std::endl;
	std::cout << " Autor: " << getAutor() << std::endl;
	std::cout << " Anschaffungs Datum: " << getAnDatum() << std::endl;
	std::cout << " Status: " << getStatus() << std::endl;
	std::cout << "----------------------------------------------------" << std::endl;
	std::cout << "    " << std::endl;
}

void uebergabe(hfu::Book bw, hfu::Book &br, hfu::Book *bz) {

	bw.dump();
	br.dump();
	(*bz).dump();
}

void test(hfu::Book bw, hfu::Book &br, hfu::Book *bz) {

	std::cout << "Zeiger Book Ausgabe" << std::endl;
	bz->dump();
	std::cout << "######################################" << std::endl;
	std::cout << "Referenz Book Ausgabe" << std::endl;
	br.dump();
	std::cout << "######################################" << std::endl;
	std::cout << "Normal Ausgabe" << std::endl;
	bw.dump();
	std::cout << "######################################" << std::endl;
}

int main()
{
	hfu::Book bwert("Spongbob", "Schwammkopf", "1999-10-24", true);
	hfu::Book breferenz("Patrick", "Star", "1999-10-24", true);
	hfu::Book bzeiger("Thaddeaus", "Tentakel", "1999-10-24", true);

	uebergabe(bwert, breferenz, &bzeiger);

	hfu::Book book1("Goethe", "Faust");
	hfu::Book book2("Goethe", "Faust", "2018-10-13");
	hfu::Book book3("Goethe", "Faust", "2018-10-13", true);

	book3.dump();
	book1.dump();
	book2.dump();

	std::cout << "Buch mit dem << operator Ausgeben" << std::endl;
	std::cout << book1 << std::endl;

	std::cout << " Book zuweisungvon bwert = bzeiger" << std::endl;
	std::cout << bwert << std::endl;

	auto goethe = hfu::Book("Goethe", "Faust");
	auto schiller = hfu::Book("Schiller", "Die Räuber");
	auto shakespeare = hfu::Book("Shakespeare", "Hamlet");
	hfu::Book books[] = { goethe, schiller, shakespeare };


	for (int i = 0; i < 3; i++) {
		bool isContained = find(books, 3, books[i]);
		assert(isContained);
	}
	auto king = hfu::Book("King", "It");
	bool isContained = find(books, 3, king);
	assert(!isContained);

	//----------------------------------------------------------------------------------------------------------------------

	std::cout << "Test Aufgabe 3.) c.)" << std::endl;
	std::cout << "Pointer" << std::endl;

	try {

	auto *array = new ArrayList<hfu::Book*>(3);//ArrayList dient als Container
	auto goethe1 = hfu::Book("Goethe", "Faust");
	auto schiller1 = hfu::Book("Schiller", "Die Räuber");
	auto shakespeare1 = hfu::Book("Shakespeare", "Hamlet");
	array->set(0, &goethe1);
	array->set(1, &schiller1);
	array->set(2, &shakespeare1);

	std::cout << *array << std::endl;//speicher Adresse wird Ausgegeben
	delete array;
	}
	catch (const char *e) {
		std::cout << e << std::endl;
	}
	/*	std::cout << "Value\n" << std::endl; Macht kein Sinn als Wert ggf. Default-Konstruktor für Klasse Book schreiben
		auto *array2 = new ArrayList<hfu::Book>(3);
		array2->set(0, goethe);
		array2->set(1, schiller);
		array2->set(2, shakespeare);

		std::cout << array2 << std::endl;

		std::cout << "Referenz\n" << std::endl; Referenz geht nicht als Template Argument
		auto *array2 = new ArrayList<hfu::Book&>(3);
		array2->set(0, goethe);
		array2->set(1, schiller);
		array2->set(2, shakespeare);

		std::cout << array2 << std::endl;*/


		//------------------------------------------------------------------------------------------------------------------------------------------------
		//Aufgabenblatt 05
		
	std::cout << "Aufgabe 5" << std::endl;
	std::set<hfu::Book> books1;
	auto book5= hfu::Book("Disney", "LTB1");
	auto book6 = hfu::Book("Disney", "LTB2");
	books1.insert(book1);
	books1.insert(book2);
	for (auto book : books) {
		std::cout << book << std::endl;
	}

}

