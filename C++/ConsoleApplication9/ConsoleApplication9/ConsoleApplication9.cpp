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


zahl operator* (zahl x, int c) {
	zahl a;
	
	for (int i = 0; i < x.laenge; i++) {
		a.speicher[a.laenge] = x.speicher[i] * c;
		a.laenge++;
	}

	for (int i = 0; i < 10; i++) {
		
		if(a.speicher[i] > 9) {
			a.speicher[i] %= 10;
			a.speicher[i + 1] += a.speicher[i] / 10;
		}

		if(a.speicher[i] > 9){
		
		}
	}

	return a;
}





int main()
{

	zahl x = converter(25);

	cout << x.speicher[0] << x.speicher[1];

	zahl test = x * 25;

	cout << test.speicher[0] << test.speicher[1] << test.speicher[2];
}
