#include <stdio.h>




int fibonacci(int n){
      int * i = 0;
      *i = 9;
      if (n == 0){
          return 0;
      }
      if (n <= 1){
          return 1;
      }
      return fibonacci(n - 1) + fibonacci(n-2); 
}

int main (int c, char ** v){
	
	printf("%d\n",fibonacci(2));
	printf("%d\n",fibonacci(5));
	return 0;
}
