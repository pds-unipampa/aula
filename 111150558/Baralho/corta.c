#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <time.h>
#include <string.h>
#include "embaralhar.h"
#include "retira.h"
#include "corta.h"

Baralho cortar(Baralho B, int pos){

        int i;
        Baralho aux = B;
        Baralho aux2 = cria();
        Baralho cortado = cria();

        for (i=0; i<pos; i++){

                insere_aux(&aux2, (aux->carta), (aux->naipe));


                aux = aux->prox;
        }

        while (aux != NULL){

                 insere_aux(&cortado, (aux->carta), (aux->naipe));
                 aux = aux->prox;
        }

        while (aux2 != NULL){

                 insere_aux(&cortado, (aux2->carta), (aux2->naipe));
                 aux2 = aux2->prox;
        }

        return cortado;
}

void insere_aux(Baralho *A, int carta, char naipe){

        lista* novo = (lista*) malloc(sizeof(lista));

        novo->carta = carta;
        novo->naipe = naipe;

        novo->prox = NULL;

        if((*A) == NULL)

                (*A) = novo;
        else{

                lista* aux = (*A);

                while(aux->prox != NULL)
                        aux = aux->prox;
                aux->prox = novo;
        }
}
