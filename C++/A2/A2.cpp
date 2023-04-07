#include <iostream>
#include <cmath>
#include <math.h>

using namespace std;



main()
{


cout << "Geben Sie die laenge des Arryas ein: " << endl;


double x,n,y,z;
double sta;
double array[10];
double mid;
double sum = 0;
double wrz;



for(int i = 0; i<=10; i++)//Zahleneingabe
{
        			
cout << "Geben sie eine Zahl ein: " << endl;
					
cin >> array[i];


}



for(int i = 0; i<=10; i++){
sum = sum + array[i];
}

mid = sum/2;
cout <<"Mittelwert: " << mid << endl;

for(int i; i<10; i++){
	
	wrz = (array[i] - mid)*(array[i]-mid);
	
	if(wrz<0)
	{
		cout << "Es stimmt was nicht!" << endl;
	}
	
}

	sta = sqrt((1.0/9.0)*(wrz));
	cout << "Die Standartabweichung betreagt: " << sta << endl;
	cout << wrz << endl;



	return 0;

}






