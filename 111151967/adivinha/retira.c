#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <time.h>
#include <string.h>
#include "embaralhar.h"
#include "retira.h"
#include "corta.h"

lista retiraInicio (Baralho* B){

        lista compra;

        compra.carta = (*B)->carta;
        compra.naipe = (*B)->naipe;

        (*B) = (*B)->prox;

        return compra;
}

lista retiraFim (Baralho *B){

        lista compra;
        Baralho aux = cria();

        while ((*B) != NULL){

                compra.carta = (*B)->carta;
                compra.naipe = (*B)->naipe;

                if (((*B)->prox) == NULL){

                    break;
                }

                insereAux(&aux, ((*B)->carta), ((*B)->naipe));

                (*B) = ((*B)->prox);
        }

        (*B) = aux;

        return compra;
}

void retiraInicio_insereFim(Baralho *B){

    lista inicio;

    inicio = retiraInicio(&(*B));

    insereAux(&(*B), inicio.carta, inicio.naipe);
}
