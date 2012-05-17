#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define     total_game_cards    52     /// Define o número total de cartas para 52.


/// A estrutura cardsuit é utilizada para indicar um naipe correspondente à um valor inteiro.
/// Copas = 0, Ouros = 1, Paus = 2, Espadas = 3;
enum cardsuit{
    hearts = 0,
    diamonds,
    clubs,
    spades,
};


/// Card é a estrutura da carta.
/// Possui 2 campos. Sendo um a estrutura cardsuit, nomeada "suit", que indica o naipe da carta.
/// E o outro campo "value" é um inteiro variando de 1 à 13, indicando o valor da carta.
typedef struct card{
    enum cardsuit suit;
    int value;
}Card;


/// Node é a estrutura de um nó de uma lista.
/// Possui uma estrutura "Card", e um ponteiro "next" para um próximo Node.
typedef struct node{
    Card Card;
    struct node *next;
} Node;


/// List é a estrutura do baralho.
/// Possui 3 campos. Dois são ponteiros para Node, onde "FirstNode" é para o primeiro da lista e "LastNode" é para o último da lista.
/// E o campo "TotalDeckCards" é um inteiro que indica o número total de cartas que o baralho possui.
typedef struct list{
    Node *FirstNode;
    Node *LastNode;
    int TotalDeckCards;
} List;


/// Cria um baralho vazio, retornando um ponteiro para a estrutura List.
/// Os campos "FirstNode" e "LastNode" apontam para NULL.
/// O campo "TotalDeckCards" fica com valor 0.
List *createEmptyDeck();


/// Cria um baralho com todas as cartas de um baralho comum (value de 0 à 13, suit de 0 à 3),
/// retornando um ponteiro para a estrutura List
/// Os ponteiros para Node ficam da forma como explicado na estrutura List.
/// O campo "TotalDeckCards" fica com o valor 52.
List *initiateList( );


/// Verifica se o baralho está vazio.
/// Retorna 1 caso esteja, e 0 caso não.
bool isEmpty( List *deck );


/// Insere uma carta no baralho.
/// Primeiro parâmetro: uma List onde a carta será inserida.
/// Segundo: uma estrutura Card que terá seus valores copiados e adicionados ao baralho.
/// Sem retorno.
void insertList( List *deck, Card card );


/// Embaralha as cartas do baralho.
/// Escolhe uma carta aleatória, e a remove do baralho. Então escolhe uma posição aleatória, e a insere nesta nova posição.
/// Este processo se repete várias vezes para se tornar eficiente.
/// Recebe um ponteiro para a List como parâmetro, o qual será embaralhado.
/// Sem retorno.
void shuffle( List *deck );


/// Corta o baralho na carta que ocupa a posição "PositionToCut". Esta será o início do baralho,
/// e a anterior à ela será o final.
/// O primeiro parâmetro é um ponteiro para List, que é o baralho que se deseja cortar.
/// O segundo parâmetro é um inteiro que indica a posição que será cortado.
/// Sem retorno.
void cutPosition( List *BuyingDeck, int PositionToCut );


/// Remove uma carta do início do baralho.
/// Recebe como parâmetro um ponteiro para List.
/// Retorna uma estrutura Card com os valores correspondentes à ultima carta do baralho,
/// ou uma carta com os valores -1 em value e suit caso o baralho seja vazio.
Card removeTop( List *BuyingDeck );


/// Remove uma carta do final do baralho.
/// Recebe como parâmetro um ponteiro para List.
/// Retorna uma estrutura Card com os valores correspondentes à ultima carta do baralho,
/// ou uma carta com os valores -1 em value e suit caso o baralho seja vazio.
Card removeBottom( List *BuyingDeck );

/// Transfere a carta que está no início do baralho para o fim.
/// Recebe como parâmetro um ponteiro para List, que é o baralho a ser manipulado.
/// Sem retorno.
void pushTopToBottom( List *BuyingDeck );

/// Imprime todo baralho, na ordem da primeira carta até a ultima, sem alterá-lo.
/// Recebe como parâmetro um ponteiro para List, que é o baralho a ser impresso.
/// Sem retorno.
void showDeck( List *deck );


