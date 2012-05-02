#include <stdio.h>
#include "arquivo.h"

int main (int c, char**v){
    struct carta c1;
    c1.n = COPAS;
	printf ("%d\n",c1.n);
	return 0;
}
