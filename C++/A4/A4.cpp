#include <iostream>
#include <cmath>
#include <math.h>

using namespace std;



main(){

double x, mid;
mid = 0;
double sa;
int n = 10;

for(int i = 0; i<=n; i++){
        cout << "Geben sie eine Zahl ein: " << endl;
        double array[i];
		cin >> x;
        array[i] = {x};


}


for(int i = 0; i<=n;i++){
        mid = mid + array[i];
        }



        mid = mid/n;
        cout << "Mittelwert:" << mid << endl;


        for(int i =0; i<=(n-1); i++){
                sa = 0;
                sa = sa +  pow(array[i]-mid,2);

                cout << sa << endl;

        }


        return sa*1/(n-1);


}

