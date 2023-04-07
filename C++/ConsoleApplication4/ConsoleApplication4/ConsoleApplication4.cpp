

#include <pch.h>
#include <iostream>
using namespace std;


int main()
{
double v[3] = { 1.1, 1.5, 2.4 }; 



double* z=&v[0]; 

cout << &z << endl;

cout << "v[0]=" << *z << endl; 
z = z+1; 
cout << "v[1]=" << *z << endl; 
z = z+1; 
cout << "v[2]=" << *z << endl;


}



