#include <iostream>
using namespace std;

int main(){
	int size;
	cout << "n eingeben LOS" << endl;
	cin >>size;
	int v[size];
	cout << "Die leange des Arrays betraegt" << " " << size << endl;
	for(int i = 0; i<=size; i++){
		cin >> v[i];
	}

	cout << "first element" << v[0] << endl;
	cout << "last element" << v[size] << endl;

	return 0;

}
