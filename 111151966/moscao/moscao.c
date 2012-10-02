#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <time.h>
#include <string.h>
#include "embaralhar.h"
#include "retira.h"
#include "corta.h"
#include "descarte.h"

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

Baralho retornaMetade(Baralho* B){
	
	int i;
	Baralho aux=cria();

	for (i=0; i<26; i++){

                insereAux(&aux, ((*B)->carta), ((*B)->naipe));

                (*B) = (*B)->prox;
        }

	return aux;
}

Baralho transfereDescarte(Baralho B, Baralho D){

        while (D != NULL){

                insereAux(&B, D->carta, D->naipe);
                D = D->prox;
        }
        return B;
}

int main(){

	int rodada = 1;
	char nome1[20];
    	char nome2[20];
	char *strings[4] = { "Copas", "Espadas", "Ouros", "Paus" };
	Baralho B = cria();
	Baralho player1 = cria();
	Baralho player2 = cria();
	Baralho descarte = cria();


	B = embaralhar(B);
	printf("\nInsira o nome do Jogador 1 : ");
    	gets(nome1);
    	printf("\nInsira o nome do Jogador 2 : ");
	gets(nome2);

	player1=retornaMetade(&B);
	player2=B;

	printf("\nPLAYER1\n");
	imprime(player1);
	printf("\nPLAYER2\n");
	imprime(player2);

	while(player1 != NULL && player2 != NULL && rodada <= 12){

		printf("\n%s - %d    Carta - %d de %s\n",nome1, rodada, player1->carta, strings[player1->naipe]);

		if (rodada == player1->carta){

			player1 = transfereDescarte(player1, descarte);
			descarte = cria();
			printf("Que Sorte!!! Descarte transferido para o jogador %s\n", nome1);
			rodada++;
		}

		else{

			descarte = insereCartaDescarte(descarte, player1->carta, player1->naipe);
			player1 = player1->prox;
			rodada++;
		}

		printf("\n%s - %d    Carta - %d de %s\n",nome2,rodada, player2->carta, strings[player2->naipe]);

		if (rodada == player2->carta){

			player2 = transfereDescarte(player2, descarte);
			descarte = cria();
			printf("Que Sorte!!! Descarte transferido para o jogador %s\n", nome2);
			rodada++;
		}

		else{

			descarte = insereCartaDescarte(descarte, player2->carta, player2->naipe);
			player2 = player2->prox;
			rodada++;
		}
	}

	imprime(player1);
	printf("\n\n");
	imprime(player2);
	printf("\n\n");

	if (conta(player1)>conta(player2)){

	    printf("\nO vencedor é o player 1 - %s\n", nome1);
	}
	else if (conta(player1)<conta(player2)){

        printf("\nO vencedor é o player 2 - %s\n", nome2);
	}

	else{

         printf("\nEMPATOU!!\n");
	}

	return 0;
}
