#include <stdio.h>
#include "arquivo.h"

int main (int c, char**v){
    if (3 == soma(2,1))
        printf ("Passou\n");
    else{
        printf ("Resultado inesperado %d\n", soma(2,1));
        return -1;
    }
	return 0;
}
