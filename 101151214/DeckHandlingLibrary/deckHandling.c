/*
*
*   Name:   Lucas Abreu
*           Adriano Gomes
*
*   Date:   May 15th, 2012.
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <stdbool.h>

#include "deckHandling.h"


// Cria um baralho vazio.
List *createEmptyDeck(){
    List *deck = (List*) malloc( sizeof( List ) );
    deck->TotalDeckCards = 0;
    deck->FirstNode = deck->LastNode = NULL;
    return deck;
}


// Cria um baralho com todas as cartas de um baralho comum (value de 0 à 13, suit de 0 à 3).
List *initiateList(){
    int k;
    List *deck = (List*) malloc( sizeof( List ) );
    Card *card = (Card*) malloc( sizeof( Card ) );
    deck->FirstNode = deck->LastNode = NULL;
    deck->TotalDeckCards = 0;
    for( k = 1; k <= 13; k++ ){
        card->suit = hearts;
        card->value = k;
        insertList( deck, *card );
    }

    for( k = 1; k <= 13; k++ ){
        card->suit = diamonds;
        card->value = k;
        insertList( deck, *card );
    }

    for( k = 1; k <= 13; k++ ){
        card->suit = clubs;
        card->value = k;
        insertList( deck, *card );
    }

    for( k = 1; k <= 13; k++ ){
        card->suit = spades;
        card->value = k;
        insertList( deck, *card );
    }
    return deck;

}


// Verifica se o baralho está vazio.
bool isEmpty( List *deck ){
    if( deck->FirstNode == NULL )
        return 1;

    return 0;
}

// Insere uma carta no baralho.
void insertList( List *deck, Card card ){
    int x;
    deck->TotalDeckCards++;
    Node *InsertNode = (Node*) malloc( sizeof( Node ) );
    InsertNode->Card.value = card.value;
    InsertNode->Card.suit = card.suit;
    InsertNode->next = NULL;

    if( isEmpty( deck ) ){
        deck->FirstNode = InsertNode;
        deck->LastNode = InsertNode;
        return;
    }

    deck->LastNode->next = InsertNode;
    deck->LastNode = InsertNode;
    return;
}


// Embaralha as cartas do baralho.
void shuffle( List *deck ){
    if( deck->TotalDeckCards < 2 )
        return;

    srand(time(NULL));
    int k, l, m;
    Node *tmpcard1, *tmpcard2;

    for( m = 0; m < total_game_cards*5; m++){

        tmpcard1 = deck->FirstNode;
        k = (rand()%deck->TotalDeckCards-1) + 1;
        if( k == 1 ){
            tmpcard2 = deck->FirstNode;
            deck->FirstNode = deck->FirstNode->next;
        }

        else{

            //Vai até a carta anterior, seta um ponteiro para a proxima, aponta next para next->next
            for( l = 0; l < k-1; l++){
                tmpcard1 = tmpcard1->next;
            }
            tmpcard2 = tmpcard1->next;
            tmpcard1->next = tmpcard1->next->next;

            //Seta o ponteiro para a última carta, saco seja manipulada.
            if( k == deck->TotalDeckCards-1){
                deck->LastNode = tmpcard1;
            }
        }

        k = (rand()%deck->TotalDeckCards-1) + 1;
        tmpcard1 = deck->FirstNode;

        if( k == 1 ){
            tmpcard2->next = deck->FirstNode;
            deck->FirstNode = tmpcard2;
        }

        else{

            for( l = 0; l < k-1; l++){
                tmpcard1 = tmpcard1->next;
            }
            tmpcard2->next = tmpcard1->next;
            tmpcard1->next = tmpcard2;
        }

        //Seta o ponteiro para a última carta, saco seja manipulada.
        if( k == deck->TotalDeckCards-1){
                deck->LastNode = tmpcard2;
            }
    }
    return;
}


// Corta o baralho na carta que ocupa a posição "PositionToCut".
void cutPosition( List *BuyingDeck, int PositionToCut ){
    if( PositionToCut < 0 || PositionToCut > BuyingDeck->TotalDeckCards-1 ) // Cortar valor negativo ou acima do número de cartas.
        return;

    if( BuyingDeck->TotalDeckCards < 1 ) // Baralho sem cartas
        return;

    int k;
    Node *MiddleNode = BuyingDeck->FirstNode;

    for( k = 0; k < PositionToCut - 1; k++ ){
        MiddleNode = MiddleNode->next;
    }

    BuyingDeck->LastNode->next = BuyingDeck->FirstNode;
    BuyingDeck->FirstNode = MiddleNode->next;

    while( BuyingDeck->LastNode != MiddleNode )
        BuyingDeck->LastNode = BuyingDeck->LastNode->next;
    BuyingDeck->LastNode->next = NULL;

    return;
}

// Remove uma carta do início do baralho.
Card removeTop( List *BuyingDeck ){
    Card TopCard;
    TopCard.suit = TopCard.value = -1;

    if( BuyingDeck->TotalDeckCards == 0 )   // Corrigir o retorno para algo
        return TopCard;

    TopCard.value = BuyingDeck->FirstNode->Card.value;
    TopCard.suit = BuyingDeck->FirstNode->Card.suit;

    Node *TopNode = BuyingDeck->FirstNode;
    BuyingDeck->FirstNode = BuyingDeck->FirstNode->next;

    if( BuyingDeck->TotalDeckCards == 1 )
        BuyingDeck->LastNode = NULL;
    BuyingDeck->TotalDeckCards--;

    free(TopNode);

    return TopCard;
}


// Remove uma carta do final do baralho.
Card removeBottom( List *BuyingDeck ){
    Card BottomCard;
    BottomCard.suit = BottomCard.value = -1;

    if( BuyingDeck->TotalDeckCards == 0 )   // Corrigir o retorno para algo
        return BottomCard;

    if ( BuyingDeck->TotalDeckCards == 1 )
        return removeTop( BuyingDeck );

    BottomCard.value = BuyingDeck->LastNode->Card.value;
    BottomCard.suit = BuyingDeck->LastNode->Card.suit;

    Node *BottomNode = BuyingDeck->FirstNode;

    while( BottomNode->next != BuyingDeck->LastNode ){
        BottomNode = BottomNode->next;
    }

    BuyingDeck->LastNode = BottomNode;
    BottomNode = BottomNode->next;
    BuyingDeck->LastNode->next = NULL;

    free(BottomNode);
    BuyingDeck->TotalDeckCards--;
    return BottomCard;
}


// Transfere a carta que está no início do baralho para o fim.
void pushTopToBottom( List *BuyingDeck ){

    Node *TopNode = BuyingDeck->FirstNode;
    BuyingDeck->FirstNode = BuyingDeck->FirstNode->next;
    TopNode->next = NULL;

    BuyingDeck->LastNode->next = TopNode;
    BuyingDeck->LastNode = TopNode;

    return;
}



// Imprime todo baralho, na ordem da primeira carta até a ultima, sem alterá-lo.
void showDeck( List *deck ){
    Node *aux = deck->FirstNode;
    int k = 0;
    while( aux != NULL ){
        k++;
        printf("Carta %.2d: Naipe: %d, Valor: %d.\n", k, aux->Card.suit, aux->Card.value);
        aux = aux->next;
    }
    printf("TotalCards: %d\n", deck->TotalDeckCards);
    return;
}

