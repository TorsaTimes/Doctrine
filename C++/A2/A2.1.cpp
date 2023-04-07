#include <iostream>
using namespace std;


main(){
	
	int v[9] = {12,123,51,72,4,8,19,44,105};
	
	int max = v[0];
	
	for(int i = 1; i<=9; i++ ){
		
		if(v[i]> max){
			max = v[i];
		}
		
	}
	
	cout << "Das max Element: " << max << endl;



	
	
	return 0;
	
	
	
	
	
	
	
	
	
	
	
	
}
