// A8.cpp : Diese Datei enthält die Funktion "main". Hier beginnt und endet die Ausführung des Programms.
//

#include "pch.h"
#include <iostream>
#include<string>
#include<ostream>



class Vehicle {
public:
	std::string const numberPlate;
	std::string const manufacturer;

	Vehicle(std::string numP, std::string manF) : numberPlate(numP), manufacturer(manF){}
	Vehicle(){}
	virtual void dump() { std::cout << this->numberPlate << this->manufacturer << std::endl; }
	std::string getNumberPlate() { return this->numberPlate;}
	std::string getManufacturer() { return this->manufacturer;}
};

class Van : virtual public Vehicle {
private:
	int const maxLoad;
public:
	Van(std::string numP, std::string manF, int maxL) : Vehicle(numP, manF), maxLoad(maxL) { if (maxL > 1000) { throw _EXCEPTION_; } }
	Van() : maxLoad(0){}
	virtual void dump() { std::cout << this->getNumberPlate() << this->getManufacturer() << this->maxLoad << std::endl; }
	int getMaxLoad() { return this->maxLoad;}
};

class PassengerCar : virtual public Vehicle {
private: 
	bool const sunRoof;
public:
	PassengerCar(std::string numP, std::string manF, bool sunR) : Vehicle(numP,manF), sunRoof(sunR){}
	PassengerCar() : sunRoof(0){}
	virtual void dump() { std::cout << this->getNumberPlate() << this->getManufacturer() << this->sunRoof << std::endl; }
	bool hasSunRoof() { return this->sunRoof;}

};

class StationWagon : virtual public Van, virtual public PassengerCar {
private:
	int const numSeats;
public:
	StationWagon(std::string numP, std::string manL, int maxL, bool sunR, int numS) : Vehicle(numP,manL), Van(numP,manL,maxL), PassengerCar(numP,manL,sunR), numSeats(numS){}
	StationWagon() : numSeats(0){}
	virtual void dump() { std::cout << this->getNumberPlate() << this->getManufacturer() << this->getMaxLoad() << this->hasSunRoof() << this->numSeats << std::endl; }
	int getNumSeats() { return this->numSeats;}
};

int main()
{
  
	Van van = Van("VS XY 42", "BMW", 100);
	van.dump();
	Vehicle& vc = van;
	vc.dump();














}
