#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <time.h>
#include <string.h>
#include "embaralhar.h"
#include "retira.h"
#include "corta.h"

lista retira_inicio (Baralho* B){

        lista compra;

        compra.carta = (*B)->carta;
        compra.naipe = (*B)->naipe;

        (*B) = (*B)->prox;

        return compra;
}

lista retira_final (Baralho *B){

        lista compra;
        Baralho aux = cria();

        while ((*B) != NULL){

                compra.carta = (*B)->carta;
                compra.naipe = (*B)->naipe;

                if (((*B)->prox) == NULL){

                    break;
                }

                insere_aux(&aux, ((*B)->carta), ((*B)->naipe));

                (*B) = ((*B)->prox);
        }

        (*B) = aux;

        return compra;
}

void retiraInicio_insereFim(Baralho *B){

    lista inicio;

    inicio = retira_inicio(&(*B));

    insere_aux(&(*B), inicio.carta, inicio.naipe);
}
