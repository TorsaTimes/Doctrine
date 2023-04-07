#include <iostream>
#include <cmath>

using namespace std;
	
	double a;
	double b;
	
	
	double mittelwert (double a, double b){
		
		
		return (a+b)/2;
	}
	
main(){
	
	cout << "Mittelwert" << " " << mittelwert << endl;
	
	cin >> a;
	cin >> b;
	
	if(a>b)
	
	cout << a << endl;
	else
	
	cout << b << endl;
	
	
}

