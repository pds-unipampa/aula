#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <time.h>
#include <string.h>
#include "embaralhar.h"

int verificaCarta(int carta, int naipe, Baralho B){

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

Baralho insereCarta(Baralho B, int carta, int naipe){

        char n [4] = {'C', 'P', 'O', 'E'};
        lista *aux =(lista*) malloc(sizeof (lista));

        aux->carta = carta;
        aux->naipe = n[naipe];
        aux->prox = B;

        return aux;
}

void imprime(Baralho B){

        Baralho aux = B;

        while (aux!= NULL){

                printf(" %d %c\n", aux->carta, aux->naipe);

                aux = aux->prox;
        }
}

Baralho embaralhar(Baralho B){

        int cont = 0, carta, naipe, verifica;

        srand(time(NULL));

        free(B);

        B=NULL;

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
