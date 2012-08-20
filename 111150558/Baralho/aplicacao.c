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

                insere_aux(&B, D->carta, D->naipe);
                D = D->prox;
        }
        return B;
}

/*!Verifica qual baralho contém mais cartas.
 *@param player1 - Um determinado baralho.
 *@param player2 - Outro determinado baralho.
 */
int verificaVencedor (Baralho player1, Baralho player2){

        Baralho aux = player1;
        int ncartas1, ncartas2;

        while (aux != NULL){

                ncartas1 ++;
                aux = aux->prox;
        }

        aux = player2;

        while (aux != NULL){

                ncartas2 ++;
                aux = aux->prox;
        }

        if (ncartas1 > ncartas2){

                return 1;
        }

        else if (ncartas1 == ncartas2){

                return 0;
        }

        else{
                return 2;
        }
}

main(){

    char nome1[20];
    char nome2[20];
    char escolha[20];
    int jogador = 1, vencedor;
    Baralho B = cria();
    Baralho player1 = cria();
    Baralho player2 = cria();
    Baralho D = cria();
    lista C;

    printf("\nInsira o nome do Jogador 1 : ");
    gets(nome1);
    printf("\nInsira o nome do Jogador 2 : ");
    gets(nome2);

    srand(time(NULL));
    B = embaralhar(B);

    while (B != NULL){

        printf("\n\nJogador %d. par ou impar?\n", jogador);
        gets(escolha);

        if ( ((!(strcmp(escolha,"par"))) && (((B->carta)%2) == 0)) || ((!(strcmp(escolha,"impar"))) && (((B->carta)%2) != 0)) ){

                if (jogador == 1){

                    printf("\nBoa escolha!! Carta: %d - %c\n", B->carta, B->naipe);
                    C = retira_inicio(&B);
                    insere_aux(&player1, C.carta, C.naipe);
                    player1 = transfereDescarte(player1, D);
                    D = cria();
                    jogador = 2;

                }
                else{

                    printf("\nBoa escolha!! Carta: %d - %c\n", B->carta, B->naipe);
                    C = retira_inicio(&B);
                    insere_aux(&player2, C.carta, C.naipe);
                    player2 = transfereDescarte(player2, D);
                    D = cria();
                    jogador = 1;
                }
        }

        else{

             printf("\nQue azar!! Carta: %d - %c\n", B->carta, B->naipe);
             C = retira_inicio(&B);
             D = insereCartaDescarte(D, C.carta, C.naipe);

             if (jogador == 1){
                 jogador = 2;
             }

             else{

                 jogador = 1;
             }
       }
    }

    printf("\n\nFIM DE JOGO!\n");
    printf("\n\nJOGADOR 1:\n");
    imprime(player1);

    printf("\n\nJOGADOR 2:\n");
    imprime(player2);
    printf("\n\n");

    vencedor = verificaVencedor(player1, player2);

    if (vencedor == 1){

        printf("\n O VENCEDOR FOI O JOGADOR 1 (%s)\n", nome1);
    }

    else if (vencedor == 0){

        printf("\n DEU EMPATE\n");
    }

    else{

        printf("\n O VENCEDOR FOI O JOGADOR 2 (%s)\n", nome2);
    }
}
