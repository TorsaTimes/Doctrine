#include "pch.h"
#include <iostream>


using namespace std;



struct zahl
	{
		
		int speicher[1000];
		int laenge = 0;


	};


zahl converter(int y) {

	zahl x;
	
	for (int i = 0; y != 0; i++) {
		x.speicher[i] = y % 10;
		x.laenge++;
		y = y / 10;
	}

	return x;

}








int main()
	{

	zahl x = converter(25);

	cout << x.speicher[0] << x.speicher[1];


}
