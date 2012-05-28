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
    char escolha[10];
    int jogador = 1, vencedor;
    int numcartas1, numcartas2;
    Baralho B = cria();
    Baralho player1 = cria();
    Baralho player2 = cria();
    Baralho D = cria();
    lista C;
    char *strings[4] = { "Copas", "Espadas", "Ouros", "Paus" };

    printf("\nInsira o nome do Jogador 1 : ");
    gets(nome1);
    printf("\nInsira o nome do Jogador 2 : ");
    gets(nome2);

    srand(time(NULL));
    B = embaralhar(B);

    while (B != NULL){

        if(jogador == 1){

            printf("\n\nJogador %s. par ou impar?\n", nome1);
            gets(escolha);
        }
        else{
            printf("\n\nJogador %s. par ou impar?\n", nome2);
            gets(escolha);
        }

        if ( ((!(strcmp(escolha,"par"))) && (((B->carta)%2) == 0)) || ((!(strcmp(escolha,"impar"))) && (((B->carta)%2) != 0)) ){

                if(jogador == 1){

                    printf("\nBoa escolha!! Carta: %d de %s\n", B->carta, strings[B->naipe]);
                    C = retiraInicio(&B);
                    insereAux(&player1, C.carta, C.naipe);
                    player1 = transfereDescarte(player1, D);
                    D = cria();
                    jogador = 2;

                }
                else{

                    printf("\nBoa escolha!! Carta: %d de %s\n", B->carta, strings[B->naipe]);
                    C = retiraInicio(&B);
                    insereAux(&player2, C.carta, C.naipe);
                    player2 = transfereDescarte(player2, D);
                    D = cria();
                    jogador = 1;
                }
        }

        else{

             printf("\nQue azar!! Carta: %d de %s\n", B->carta, strings[B->naipe]);
             C = retiraInicio(&B);
             D = insereCartaDescarte(D, C.carta, C.naipe);

             if (jogador == 1){
                 jogador = 2;
             }

             else{

                 jogador = 1;
             }
       }
    }


    numcartas1 = conta(player1);
    numcartas2 = conta(player2);

    printf("\n\nFIM DE JOGO!\n");
    printf("\n\nJOGADOR 1 - %s: %d cartas\n", nome1, numcartas1);
    imprime(player1);

    printf("\n\nJOGADOR 2 - %s: %d cartas\n", nome2, numcartas2);
    imprime(player2);
    printf("\n\n");

    if (numcartas1 > numcartas2){

        printf("\n O VENCEDOR FOI O JOGADOR 1 (%s)\n", nome1);
        return 0;
    }

    if (numcartas1 == numcartas2){

        printf("\n DEU EMPATE\n");
        return 0;
    }

    printf("\n O VENCEDOR FOI O JOGADOR 2 (%s)\n", nome2);

    liberaBaralho(&B);
    liberaBaralho(&player1);
    liberaBaralho(&player2);
    liberaBaralho(&D);

    return 0;
}
