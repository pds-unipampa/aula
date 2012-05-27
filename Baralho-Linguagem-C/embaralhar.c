#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <time.h>
#include <string.h>
#include "embaralhar.h"

static int verificaCarta(int carta, int naipe, Baralho B){

        Baralho aux = B;

        char n [4] = {'C', 'P', 'O', 'E'};

        while (aux != NULL){

                if ((aux->carta == carta) && (n[naipe] == aux->naipe)){

                        return 0;
                }

                else{

                        aux = aux->prox;
                }
        }

        return 1;
}

static Baralho insereCarta(Baralho B, int carta, int naipe){

        lista *aux =(lista*) malloc(sizeof (lista));

        aux->carta = carta;
        aux->naipe = naipe;
        aux->prox = B;

        return aux;
}

Baralho embaralhar(Baralho B){

        int cont = 0, carta, naipe, verifica;

        srand(time(NULL));

        libera(&B);

        B=NULL;

        sleep(1/2);

        while (cont<52){

                carta = rand()%(13)+1;
                naipe = rand()%4;

                verifica = verificaCarta(carta, naipe, B);

                if (verifica == 1){

                        B = insereCarta(B, carta, naipe);

                        cont++;
                }
         }

         return B;
}

Baralho cria(void){

    return NULL;
}

int conta(Baralho A){

    Baralho aux = A;
    int cont = 0;

    while(aux!= NULL){

        aux = aux->prox;
        cont++;
    }
    return cont;
}

void libera(Baralho *B){
    Baralho *temp;
    while(*B != NULL){
        temp = (*B)->prox;
        free(*B);
        *B = temp;
    }
}
