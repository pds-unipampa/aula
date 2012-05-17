/*
Copyright (C) 2012 Fabiano Cassol. Todos os direitos reservados
Copyright (C) 2012 Bruno Fontoura. Todos os direitos reservados

Autores:
            Fabiano Cassol (fabiano.babao@gmail.com)
            Bruno Fontoura (brunofontoura@alvorada-rs.com.br)
            
Esta bilbioteca e os arquivos que a acompanham estão sob os termos
do Common Public License v1.0 que acompanha esta implementação
e está disponível em http://www.eclipse.org/legal/cpl-v10.html

*/

#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<string.h>
#include "baralho.h"


int tamanhoBaralho(baralho_t *baralho){
        int tamanho = 0;
        
        while(baralho != NULL){
                  tamanho++;
                  baralho = baralho->prox;
        }
        
        return tamanho;
}

void criaBaralho(baralho_t **baralho){
        (*baralho) = NULL;
        montaBaralho(&(*baralho));
}

void criaDescarte(baralho_t **monte){
        (*monte) = NULL;
}

void montaBaralho(baralho_t **baralho){ // função que monta o baralho ordenado
        int i, j;
        
        for(j = 4; j >= 1; j--){ // naipe das cartas
              for(i = 13; i >= 1; i--){ // valor das cartas
                    insereBaralho(&(*baralho), i, j);
              }
        }
}

void insereBaralho(baralho_t **baralho, int i, int j){
        baralho_t *nova_carta;
        
        nova_carta = (baralho_t *) malloc (sizeof(baralho_t));
        
        if(i == 1){
            strcpy(nova_carta->valor, "A");
        }
        if(i == 11){
            strcpy(nova_carta->valor, "J");
        }
        if(i == 12){
            strcpy(nova_carta->valor, "Q");
        }
        if(i == 13){
            strcpy(nova_carta->valor, "K");
        }
        if(i != 1 && i != 11 && i != 12 && i != 13){
            sprintf(nova_carta->valor, "%d", i);
        }
        
        if (j == 1){
              strcpy(nova_carta->naipe, "OURO");
        }
        if (j == 2){
              strcpy(nova_carta->naipe, "COPAS");
        }
        if (j == 3){
              strcpy(nova_carta->naipe, "ESPADAS");
        }
        if (j == 4){
              strcpy(nova_carta->naipe, "PAUS");
        }
        
        nova_carta->prox = (*baralho); // a nova carta aponta para o início do baralho, passando a estar no topo
        (*baralho) = nova_carta; // o início do baralho aponta para a nova carta 
}

void imprimeMonte(baralho_t *baralho){
        while(baralho != NULL){
               printf("%s de %s\n", baralho->valor, baralho->naipe);
               baralho = baralho->prox;
        }
}

void cortarBaralho(baralho_t **inicio){
        int corte, i, tamanho;
        baralho_t *temp = (*inicio); // temp é o inicio do baralho antes de ser cortado
        baralho_t *fim_novo, *fim_velho;
        
        while((*inicio)->prox != NULL){ // Encontra o final do baralho antes de ser cortado
             (*inicio) = (*inicio)->prox;
        }
        
        fim_velho = (*inicio); // Atribui o (*inicio) ao fim velho
        (*inicio) = temp; // Recupera o inicio
        
        tamanho = tamanhoBaralho((*inicio)); // Conta quantas carta existem no baralho e atribui para a variável tamanho
        
        // tamanho - 1 para nao ocorrer de cortar na última carta
        // + 1 garante cortar a aprtir da primeira carta
        corte = rand()%(tamanho - 1) + 1;
        
        for(i = 1; i <= corte; i++){ // Encontra a posição para cortar o baralho e aponta o início do baralho para a posição seguinte
              fim_novo = (*inicio);
              (*inicio) = (*inicio)->prox;
        }
        
        fim_novo->prox = NULL; // A posição onde foi realizado o corte passa a ser o novo fim do baralho
        fim_velho->prox = temp; // O fim do baralho antes de ser cortado passa a apontar para o antigo início do baralho
}

void embaralhar(baralho_t **baralho){
        srand(time(NULL));
        int i;
        
        for(i = 0; i < 10; i++){
              cortarBaralho(&(*baralho));
        }
}

void liberaMonte(baralho_t **baralho){
        baralho_t *temp;
        
        while((*baralho) != NULL){
             temp = (*baralho)->prox;
             free(*baralho);
             (*baralho) = temp;
        }
}

baralho_t* comprarInicio(baralho_t **inicio){
        baralho_t *temp = (*inicio);
        
        (*inicio) = (*inicio)->prox;
        temp->prox = NULL; // A carta comprada do inicio perde a referência para a próxima, pois deixa de fazer parte do Baralho
        
        return (&(*temp));
}

baralho_t* comprarFim(baralho_t **inicio){
        baralho_t *temp = (*inicio);
        baralho_t *novo_ultimo;
        
        while(temp->prox != NULL){ // Encontra o ultimo elemento(temp) para ser comprado e define o elemento anterior a ele como sendo o novo ultimo do baralho
              novo_ultimo = temp;
              temp = temp->prox;
        }
        
        novo_ultimo->prox = NULL;
        
        return (&(*temp));
}

void addDescarte(baralho_t **carta, baralho_t **inicio){
        if((*inicio) == NULL){
                (*carta)->prox = NULL;
        }else{
           (*carta)->prox = (*inicio);
        }
        
        (*inicio) = (*carta);
}

void cartaInicioParaFim(baralho_t **inicio){
        baralho_t *temp = (*inicio);
        
        while(temp->prox != NULL){ // Encontra o elemento final do baralho
             temp = temp->prox;
        }
        
        temp->prox = (*inicio); // O ultimo elemento passa a apontar para o primeiro, pois este será o novo elemento final
        temp = (*inicio); // temp aponta para o inicio, ou seja, a primeira carta, que sera a ultima
        (*inicio) = (*inicio)->prox; // O segundo elemento do baralho passa a ser o inicio do baralho
        temp->prox = NULL; // A carta que era a primeira do baralho passa a apontar para NULL, sendo agora a carta do final
}






