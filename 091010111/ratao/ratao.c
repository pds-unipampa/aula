#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <time.h>
#include <string.h>
#include "embaralhar.h"
#include "retira.h"
#include "corta.h"
#include "descarte.h"

/*!Adiciona as cartas contidas no baralho de descarte em outro determinado baralho.
 * Retorna esse determinado baralho após a operação.
 *@param D - Baralho de descarte.
 *@param B - Determinado baralho.
 */
Baralho transfereDescarte(Baralho B, Baralho D){

        while (D != NULL){

                insereAux(&B, D->carta, D->naipe);
                D = D->prox;
        }
        return B;
}

/*!Imprime as cartas de um baralho.
 *@param B - Baralho que vai ser imprimido.
 */
void imprime(Baralho B){

        Baralho aux = B;

        char *strings[4] = { "Copas", "Espadas", "Ouros", "Paus" };

        while (aux!= NULL){

                printf(" %d de %s\n", aux->carta, strings[aux->naipe]);

                aux = aux->prox;
        }
}

int main(){
    	char nome1[20];
    	char nome2[20];
    	Baralho B = cria();
	int jogador=1;
	int carta;
	int vencedor=0;

    	printf("\nInsira o nome do Profeta 1 : ");
    	gets(nome1);
    	printf("\nInsira o nome do Profeta 2 : ");
    	gets(nome2);

    	srand(time(NULL));

    	B = embaralhar(B);

    	while (B != NULL && vencedor==0){

        	if(jogador == 1){

            printf("\n\nProfeta %s. Descubra qual é a carta?\n", nome1);
			scanf("%d", &carta);
			jogador=2;

			if (B->carta==carta){

				vencedor = 1;

				printf("\nAcertou! Venceu o jogo!");
			}

			else{

				printf("\nErrou!");
			}

			B=B->prox;
        }
        else{
            printf("\n\nProfeta %s. Descubra qual é a carta?\n", nome2);
			scanf("%d", &carta);
			jogador=1;

			if (B->carta==carta){

				vencedor = 2;

				printf("\nAcertou! Venceu o jogo!");
			}

			else{

				printf("\nErrou!");
			}
			B=B->prox;
        }
	}

       	liberaBaralho(&B);

    	return 0;
}
