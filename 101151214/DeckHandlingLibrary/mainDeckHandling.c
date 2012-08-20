#include <stdio.h>
#include <stdlib.h>

#include "deckHandling.h"


int main(){
    int opcao, var;
    List *deck = initiateList();
    Card carta;
    do {
        printf ("Menu\n");
        printf (" Um baralho foi criado. Manipule ele com as opções abaixo. \n");
        printf (" 1 - Exibir o baralho completo. \n");
        printf (" 2 - Embaralhar e exibir. \n");
        printf (" 3 - Cortar o baralho em uma posição x. \n");
        printf (" 4 - Remover e imprimir a primeira carta.\n");
        printf (" 5 - Remover e imprimir a última carta.\n");
        printf (" 6 - Passar a primeira carta para o final do baralho.\n");
        printf (" 0 - Sair do programa. \n");
        scanf ("%d", &opcao);
        switch (opcao){

            case 1:
                printf ("Exibir deck completo \n");
                showDeck( deck );
                break;

            case 2:
                printf ("Deck embaralhado \n");
                shuffle( deck );
                showDeck( deck );
                break;
            case 3:
                printf ("Cortar o baralho em uma posição x \n");
                printf ("Em que posição deseja cortar o baralho: ");
                scanf("%d", &var);
                cutPosition( deck, var );
                break;
            case 4:
                printf ("Remove a carta do inicio \n");
                carta = removeTop( deck );
                printf("Primeira carta removida.\nValor: %d, naipe: %d\n", carta.value, carta.suit );
                break;
            case 5:
                printf ("Remove a carta do final \n");
                carta = removeBottom( deck );
                printf("Última carta removida.\nValor: %d, naipe: %d\n", carta.value, carta.suit );
                break;
            case 6:
                printf ("Primeira carta, passa a ser ultima \n");
                pushTopToBottom( deck );
                break;
            case 0:
                printf ("Saindo do programa \n");
                exit;
            break;
        }
    } while (opcao != 0);

    return 0;
}
