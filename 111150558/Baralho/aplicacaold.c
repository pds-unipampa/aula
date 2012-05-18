#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <time.h>
#include <string.h>
#include "embaralhar.h"
#include "retira.h"
#include "corta.h"
#include "descarte.h"

int main(){

    Baralho B = cria();
    Baralho C = cria();
    Baralho D = cria();
    lista Ci;
    lista Cf;
    lista R;

    srand(time(NULL));


    //embaralha um baralho
    printf("\nBaralho depois de embaralhado:\n");
    B = embaralhar(B);
    //imprime o baralho após ter sido embaralhado
    imprime(B);


    printf("\n\n");


    printf("Retira a carta do inicio e insere a mesma no fim:\n");
    retiraInicio_insereFim(&B);
    printf("Baralho após a operação de retira inicio e insere no fim\n");
    imprime(B);



    //retira uma carta do final do baralho
    printf("\nRetira a carta do final do baralho:");
    Cf = retira_final(&B);
    printf("\n%d %c\n", Cf.carta, Cf.naipe);
    printf("\nBaralho após a remoção da carta que estava no final:\n");
    imprime(B);

    //retira carta do inicio do baralho.
    printf("\n\nRetira do inicio.\n");
    Ci = retira_inicio(&B);
    printf("Carta retirada do inicio:");
    printf("\n%d %c\n", Ci.carta, Ci.naipe);
    printf("\nBaralho após a remoção da carta do inicio.\n");
    imprime(B);




    //corta o balho em detarminada posição.
    C = cortar(B, 5);
    printf("\n\nBaralho depois de cortado na posição 5\n");
    imprime(C);



    //insere uma carta no monte de descarte.
    printf("\n\nInserção de duas cartas no monte de descarte:");
    D = atualizaDescarte (D);
    //insere outra carta no monte de descarte.
    D = atualizaDescarte (D);
    //imprime o monte de descarte.
    printf("\nMonte de descarte após a inserção das cartas:\n");
    imprime(D);



    //retira uma carta no monte de descarte em determinada posição.
    //como exemplo foi usada a posição 1.
    R = retiraDescarte (&D, 1);
    //mostra a carta retirada do monte de descarte.
    printf("\nCarta removida da posição 1:");
    printf("\n%d %c\n\n", R.carta, R.naipe);
    //imprime o monte de descarte após a remoção da carta.
    printf("\nMonte de descarte após a remoção da carta:\n");
    imprime(D);
}
