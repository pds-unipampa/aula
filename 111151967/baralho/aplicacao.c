#include <stdio.h>
#include <stdlib.h>
#include "baralho.h"

int main(){

    comeco_baralho l;
    monte h;

    int i;
    printf("\n____________________________________________________________\n");
    printf("1-cria baralho\n2-embaralha\n3-corta\n4-retira\n5-passa pro fim\n");
    printf("____________________________________________________________\n");

    do{
    printf("\no que deseja fazer\t");
    scanf("%d",&i);
    switch(i){

        case 1:
          l=Cria_Lista(&l,&h);
          printf("\nO BARALHO ESTA CRIADO");
        break;

        case 2:
           l=embaralha(&l);
           printf("\nO BARALHO FOI EMARALHADO");
        break;

        case 3:
            l=cortar(&l);
            printf("\nO BARALHO FOI CORTADO");
        break;

        case 4:
            h=retira_carta(&l,&h);
            printf("\nA CARTA FOI RETIRADA");
        break;

        case 5:
            l=passa_final(&l);
            printf("\nA CARTA ESTA NO FINAL");
        break;

        case 6:
            imprimi(&l,&h);
        break;
        }

    }while(i != 0);
}
