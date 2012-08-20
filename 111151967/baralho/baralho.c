#include <stdlib.h>
#include <stdio.h>
#include "baralho.h"
#include <time.h>
#include <string.h>

Lista_Baralho * cria_baralho(comeco_baralho *l, int i, int k){

    Lista_Baralho *novo = (Lista_Baralho*) malloc(sizeof(Lista_Baralho));
    if(i == 1){
        strcpy(novo->naipe,"basto");
    }
    if(i == 2){
        strcpy(novo->naipe,"ouro");
        }
    if(i == 3){
        strcpy(novo->naipe,"copas");
    }
    if(i == 4){
        strcpy(novo->naipe,"espada");
    }
    novo->prox = NULL;
    novo->numero = k;

    if(*l == NULL){
        *l = novo;
    }

    else{
        Lista_Baralho *aux = *l;

        while(aux->prox != NULL){
            aux = aux->prox;
        }
        aux->prox = novo;
    }
    return *l;
}

Lista_Baralho *Cria_Lista(comeco_baralho *l, comeco_baralho *h){

    int i,k;
    *h = NULL;
    *l = NULL;
    for(i = 1; i < 5; i++){
        for(k = 1; k < 14; k++){
            *l=cria_baralho(&(*l),i,k);
        }
    }
    return *l;
}

Lista_Baralho * embaralha(comeco_baralho *l){

    srand(time(NULL));
    comeco_baralho lista2 = NULL;
    Lista_Baralho *aux, *aux_ant;

    int i,x,num_x,h=0;
    int zerador = 1;

    for(i = 52; i >= 1; i--){
        x = rand()% i + 1;
        num_x = x;
        aux = *l;

        while(zerador != x){
            aux_ant = aux;
            aux = aux->prox;
            x--;
        }
        if(num_x != 1)
        {
            aux_ant->prox = aux->prox;
            aux->prox = NULL;
        }
        else
        {
            *l = aux->prox;
        }

        lista2 = embaralhando(lista2,aux);
    }
    return lista2;
}


Lista_Baralho * embaralhando(Lista_Baralho *lista2, Lista_Baralho *nodo){

    Lista_Baralho *aux;

    aux = lista2;
    nodo->prox = NULL;

    if(lista2 == NULL)
    {
        lista2 = nodo;
    }

    else
    {
        while(aux->prox != NULL){
            aux = aux->prox;
        }
        aux->prox = nodo;
    }

    return lista2;

}

Lista_Baralho * cortar(comeco_baralho *l){
    int pos;
    int i = 1;

    Lista_Baralho *aux;
    Lista_Baralho *aux_fim = *l;
    aux = *l;
    aux_fim = *l;

    printf("digite a posicao que deseja cortar:     ");
    scanf("%d",& pos);
    while(pos <= 1 || pos > 52){
        printf("posicao invalida!!! favor digitar uma posicao entre 1 e 52:   ");
        scanf("%d", &pos);
    }

    while(aux_fim->prox != NULL){
        aux_fim = aux_fim->prox;
    }
    while(i != pos){
        aux = aux->prox;
        i++;
    }
    aux_fim->prox = *l;
    *l = aux->prox;
    aux->prox = NULL;

    return *l;
}

Lista_Baralho * retira_carta(comeco_baralho *l, comeco_baralho *h){

    int op;
    Lista_Baralho *aux;
    Lista_Baralho *aux_2;

    aux = *l;
    aux_2 = *l;

    printf("Deseja Retirar uma carta do inicio do baralho ou do final:\n");
    printf("1 - Inicio\n");
    printf("2 - Fim\n");
    scanf("%d", & op);
    while(op < 1 || op > 2){
        printf("a opcao desejada eh invalida, digite novamente a opcao desejavel");
        scanf("%d", &op);
    }
    if( op == 1){
        *l = aux->prox;
        aux->prox = NULL;
        aux = *l;
    }
    else{
        while(aux->prox->prox != NULL){
            aux = aux->prox;
        }
        aux_2 = aux->prox;
        aux->prox = NULL;
    }
    if(*h == NULL){
        *h = aux_2;
    }
    else{
        aux_2->prox = *h;
        *h = aux_2;
    }
    return *h;
}

Lista_Baralho * passa_final(comeco_baralho *l){

    Lista_Baralho *aux, *aux2;
    aux = *l;
    aux2 = *l;

    while(aux->prox != NULL){
        aux = aux->prox;
    }
    aux->prox = *l;

    *l = aux2->prox;
    aux->prox->prox = NULL;
    aux = *l;

    return *l;
}

void imprimi (comeco_baralho *lista ,comeco_baralho *resto){

    Lista_Baralho *aux_dois = *lista;
    Lista_Baralho *aux = *resto;
    int num = 0;
    printf("\nBARALHO\n");

    while(aux_dois != NULL){
        printf("\nnumero %d-> e o naipe %s",aux_dois->numero,aux_dois->naipe);
        aux_dois = aux_dois->prox;
        num++;
    }
    printf("\n\nNUMERO DE CARTAS DO BARALHO->%d\n",num);
    printf("\n");

    printf("\nBARALAHO DO MONTE\n");
    while(aux != NULL){
        printf("\nnumero %d-> e o naipe %s",aux->numero,aux->naipe);
        aux = aux->prox;
    }
}

