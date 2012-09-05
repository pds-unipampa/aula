#include <iostream>


long factorial(long n){
	if (n <= 1)
		return 1;
	return n * factorial(n-1);
}


long factorial2(long n){
	long r = 1;
	while (n > 1){
		r = r * n--;
	}
	return r;

}

int main (int c, char** v){
	long v1 = factorial(20);
	long v2 = factorial(1);
	long v3 = factorial2(20);
	long v4 = factorial2(1);

}
