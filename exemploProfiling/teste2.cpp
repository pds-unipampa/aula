#include <iostream>


long fib(int n){
	if (n <= 0)
		return 0;
	if (n == 1)
		return 1;
	return fib(n-1)+fib(n-2);
}

long fib2(int n){
	long a = 0;
	long r = 1;
	
	while (n > 1){
		n--;
		long t = r;
		r = r + a;
		a = t;
	}

	return r;
}


int main (int c, char** v){
	fib(1);
	fib(10);
	fib(30);
	fib2(1);
	fib2(10);
	fib2(30);
	
	return 0;
}
