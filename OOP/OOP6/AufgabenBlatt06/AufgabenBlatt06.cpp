// AufgabenBlatt06.cpp : Diese Datei enthält die Funktion "main". Hier beginnt und endet die Ausführung des Programms.
//

#include "pch.h"
#include <iostream>
#include "Header.h"
#include <array>
#include <ostream>
#include <string>


//-----------------------------------Aufgabe 1----------------------------------------------------------------------------------------------------------------------------

class Rectangle {

private:
	double length;
	double width;

public:

	Rectangle(double length, double width) : length(length), width(width){}

	double getlength() const{
		return this->length;
	}

	double getWidth() const {//zugrunde liegende objekt
		return this->width;
	}

	double circumference() const{
		return ((this->length * 2) + (this->width * 2));
	}

	double area() const{
		return (this->length*this->width);
	}



};

class Cuboid : public Rectangle {

private:
	double height;

public:
	Cuboid(double length, double width, double height) : Rectangle(length, width), height(height){}

	double volume() const{
		
		return ((this->getlength()*this->getWidth())*this->height);
	}

	double getHeight() const{
		return this->height;
	}


};

//---------------------------------------------------------------------------------------------------------------------------------------------------------------

//--------------------------------Aufgabe 2-------------------------------------------------------------------------------------------------------------------------------

class Base {
	int valueB;
public:

	void setValueB(int value);
	int getValueB();
};
void Base::setValueB(int value) {
	this->valueB = value;
}

int Base::getValueB() {
	return valueB;
}
typedef std::array<int, 1> SingleArray;
class Derived : public Base {

	SingleArray* array = new SingleArray();
public:

	void setValueD(int value);
	int getValueD();
};
void Derived::setValueD(int value) {
	(*array)[0] = value;
}
int Derived::getValueD() {
	return (*array)[0];
}



//---------------------------------------------------------------------------------------------------------------------------------------------------------------

//-----------Aufgabe 3----------------------------------------------------------------------------------------------------------------------------------------------------

class Person {

private:
	int id;
	std::string lastName;
	std::string firstName;

public:

	Person(int id, std::string fn, std::string ln) : id(id), lastName(ln), firstName(fn) {}
	Person() {};

	int getId() const{
		return this->id;
	}

	std::string getLastName()const {
		return this->lastName;
	}

	std::string getFirstName() const{
		return this->firstName;
	}

};



class Guest : public Person {

private:
	int day;
	int roomRate;

public:

	Guest(int day, int roomRate, int id, std::string fn, std::string ln) : Person(id,fn,ln), day(day), roomRate(roomRate){}

	double check()const {
		return this->day*this->roomRate;
	}

	int getDay() const{
		return this->day;
	}

	int getRoomRate() const{
		return this->roomRate;
	}

};

//---------Aufgabe 4------------------------------------------------------------------------------------------------------------------------------------------------------

class Employee : public Person {

private:

public:

	Employee(int id, std::string fn, std::string ln) : Person(id,fn,ln){}


	virtual ~Employee() = default;
	
	virtual int salary() const = 0 ;

	// int salary()  const{//Abstrakte methode = 0;//virtual entfernt fuer Aufgabenblatt 7 aufgabe 1
	//	std::cout << "Employee salary" << std::endl;
	//	return 0;
	//}

	
};

class Worker : public Employee {

private:
	int hourlyRate;
	int hoursWorked;

public:

	Worker(int id, std::string fn, std::string ln, int hr, int hw) : Employee(id,fn,ln), hourlyRate(hr), hoursWorked(hw){}

	~Worker() { std::cout << "in Worker destructor" << std::endl; }


	virtual int salary() const{ //virtual entfernt fuer Aufgabenblatt 7 aufgabe 1
		std::cout << "worker salary" << std::endl;
		return (hourlyRate*hoursWorked);
	}

	int getHourlyRate() const{
		return this->hourlyRate;
	}

	int getHoursWorked() const{
		return this->hoursWorked;
	}
};

class Seller : public Employee {

private:

	int pay;
	int commission;

public:

	Seller(int id, std::string fn, std::string ln,int pay, int com) : Employee(id, fn, ln), pay(pay), commission(com){}

	~Seller() { std::cout << "in Seller destructor" << std::endl; }

	virtual int salary() const{
		return (pay + commission);
	}

	int getPay() const{
		return this->pay;
	}

	int getCommission() const{
		return this->commission;
	}
};










//---------------------------------------------------------------------------------------------------------------------------------------------------------------

int main()
{
	//------------------Aufgabe 1---------------------------------------------------------------------------------------------------------------------------------------------

	Rectangle R1(3, 5);
	Rectangle R2(10, 5);

	std::cout << R1.getlength() << std::endl;
	std::cout << R1.getWidth() << std::endl;
	std::cout << R1.circumference() << std::endl;
	std::cout << R1.area() << std::endl;

	Cuboid Q1(3, 5, 3);

	std::cout << Q1.circumference() << std::endl;
	std::cout << Q1.area() << std::endl;
	std::cout << Q1.volume() << std::endl;

	//---------------------------------------------------------------------------------------------------------------------------------------------------------------

	//--------------Aufgabe 2-------------------------------------------------------------------------------------------------------------------------------------------------


	Derived D1;
	Derived D2;

	Base B1;
	Base B2;

	D1 = D2;//Typ Derived an ein anderes Objekt vom Typ Derived
	
	//D1 = B1;// Typ Base an ein anderes Objekt vom Typ Derived
	//Unter Klasse wird die oberklasse zugewissen -Problem
	
	B1 = D1;//Typ Derived an ein anderes Objekt vom Typ Base
	//methoden aufruf von B1 funktioniert nicht da D1 keine attribute von B1 besitzte (private) -Problem
	
	B2 = B1;//Typ Base an ein anderes Objekt vom Typ Base


	//---------------------------------------------------------------------------------------------------------------------------------------------------------------

	//----------------Aufgabe 3-----------------------------------------------------------------------------------------------------------------------------------------------

	Person P1(1, "Sam", "Mustermann");
	Person P2(1, "Uwe", "Mustermann");

	std::cout << P1.getId() << std::endl;
	std::cout << P1.getFirstName() << std::endl;
	std::cout << P1.getLastName() << std::endl;

	Guest G1(20, 5, 1, "Hans", "MusterMann");

	std::cout << G1.getFirstName() << std::endl;
	std::cout << G1.getLastName() << std::endl;
	std::cout << G1.getId() << std::endl;
	std::cout << G1.getDay() << std::endl;
	std::cout << G1.getRoomRate() << std::endl;
	std::cout << G1.check() << std::endl;

	//---------------------------------------------------------------------------------------------------------------------------------------------------------------

	//-----------Aufgabe 4----------------------------------------------------------------------------------------------------------------------------------------------------


	//Worker worker1 = Worker(11, "Peter", "Mustermann", 20, 30);
	//Employee& e = worker1;
	//Employee employee1(22, "Hans", "Uludag");

	//employee1 = worker1;//dynamische seite gewinnt zuweisung funktioniert!

	//std::cout << e.salary() << std::endl;//employee salary
	//std::cout << employee1.getFirstName() << std::endl;//peter
	//std::cout << worker1.salary() << std::endl;//worker salary

	//---------------------------------------------------------------------------------------------------------------------------------------------------------------

	//--------------------------Aufgabenblatt7--------------------------------------------------------------------------------------------------------------------------
	
	//Aufgabe 1.a. das virtual in der Klasse Employee und Worker entfernen damit die Klassen die polymorph agieren
	
	//Aufgabe 1.b.c. die Klasse Employee Abstrakt definieren und deklarieren - ein virtuellen Destruktor definieren - 
	//Man kein objekt einer Abstrakten klasse instanzieren werden eine virtuellen Funktion 0 setzt , funktion kann nicht implementiert werden. 
	//schlussfolgernd kann keine Instanz der Klasse angelegt werden. Abstrakte klassen können nur zur Ableitung von anderen Klassen genutzt werden
	//virtueller Kopnstruktor Wird über einen solchen Zeiger der Befehl delete aufgerufen, würden bei einem nicht virtuellen Destruktor nur die Bestandteile der Klasse Employee, aber nicht der Klasse Worker angesprochen

	//Aufgabe 2. 

	std::cout << "Aufgabenblatt 7" << std::endl;

	std::shared_ptr<Employee>  employee;//aenderungen fuer A2
	//std::cout << employee->salary() << std::endl; //aenderungen fuer A2
	std::shared_ptr<Worker> worker = std::make_shared<Worker>(4, "Duck", "Tick", 9, 40);
	employee = worker;
	std::cout << employee->salary() << std::endl;
	std::shared_ptr<Seller> seller = std::make_shared<Seller>(5, "Duck", "Trick", 1000, 2000);
	employee = seller;
	std::cout << employee->salary() << std::endl;

}

