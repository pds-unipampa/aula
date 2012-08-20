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

int main(){
    baralho_t *ptBaralho; // Ponteiro para o inicio do baralho
    baralho_t *carta; // Ponteiro para as cartas a serem compradas
    baralho_t *ptMonteDescarte; // Ponteiro para o inicio do monte de descarte
    int i, comprar;
    
    criaBaralho(&ptBaralho); // Cria o baralho com todas as cartas
    criaDescarte(&ptMonteDescarte); // Cria o monte de descarte vazio, apontando para NULL
    
    printf("Baralho:\n");
    imprimeMonte(ptBaralho); // Imprime o baralho, neste caso completo, pois acabou de ser criado
    
    printf("\nBaralho apos passar uma carta do inicio para o final:\n");
    cartaInicioParaFim(&ptBaralho); // Passa uma carta do topo do baralho para o final
    imprimeMonte(ptBaralho);
    
    printf("\nBaralho embaralhado:\n"); 
    embaralhar(&ptBaralho);
    imprimeMonte(ptBaralho);
    
    printf("\nBaralho cortado:\n"); 
    cortarBaralho(&ptBaralho);
    imprimeMonte(ptBaralho);
    
    for(i = 0; i < 5; i++){
          carta = comprarInicio(&ptBaralho);
          printf("\nCarta comprada do INICIO: %s de %s\n", carta->valor, carta->naipe);
          addDescarte(&carta, &ptMonteDescarte);
    }
    
    printf("\nBaralho depois da Compra do INICIO:\n");
    imprimeMonte(ptBaralho);
    
    printf("\nMonte de descarte:\n");
    imprimeMonte(ptMonteDescarte);
    
    for(i = 0; i < 5; i++){
          carta = comprarFim(&ptBaralho);
          printf("\nCarta comprada do FINAL: %s de %s\n", carta->valor, carta->naipe);
          addDescarte(&carta, &ptMonteDescarte);
    }
    
    printf("\nBaralho depois da Compra do INICIO e FIM:\n");
    imprimeMonte(ptBaralho);
    
    printf("\nMonte de descarte:\n");
    imprimeMonte(ptMonteDescarte);
    
    liberaMonte(&ptBaralho);
    liberaMonte(&ptMonteDescarte);
    
    return 0;
}
