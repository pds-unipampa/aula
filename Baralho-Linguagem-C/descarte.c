#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <time.h>
#include <string.h>
#include "embaralhar.h"
#include "retira.h"
#include "corta.h"
#include "descarte.h"

static Baralho insereCartaDescarte(Baralho D, int carta, char naipe){

        lista *aux =(lista*) malloc(sizeof (lista));

        aux->carta = carta;
        aux->naipe = naipe;
        aux->prox = D;

        return aux;
}

Baralho atualizaDescarte (Baralho D){

    int carta;
    char naipe;

    printf("\nEntre com o número da carta (1 a 13): ");
    scanf("%d", &carta);
    getchar();

    printf("\nEntre com o naipe da carta (O, C, P ou E): ");
    scanf("%c", &naipe);
    getchar();

    D = insereCartaDescarte(D, carta, naipe);

    return D;
}

lista mostraDescarte(Baralho D, int pos){

    lista retorno;
    int i;

    for (i=0; i<pos; i++){

        D=D->prox;
    }

    retorno.carta = D->carta;
    retorno.naipe = D->naipe;

    return retorno;

}

lista retiraDescarte (Baralho* D, int pos){

    int i;
    lista carta;
    Baralho aux = cria();

    for (i=0; i<pos; i++){

        insere_aux(&aux, (*D)->carta, (*D)->naipe);

        (*D)=(*D)->prox;
    }

    carta.carta = (*D)->carta;
    carta.naipe = (*D)->naipe;

    (*D)=(*D)->prox;

    while ((*D)!=NULL){

        insere_aux(&aux, (*D)->carta, (*D)->naipe);

        (*D)=(*D)->prox;
    }

    (*D)=aux;
    return carta;
}
