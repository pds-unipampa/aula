#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <time.h>
#include <string.h>
#include "embaralhar.h"
#include "retira.h"
#include "corta.h"

lista retira_inicio (Baralho* B){
        
        lista compra;
        
        compra.carta = (*B)->carta;
        compra.naipe = (*B)->naipe;
        
        (*B) = (*B)->prox;
        
        return compra;
}

lista retira_final (Baralho* B){
        
        lista compra;
        Baralho aux = (*B);
        
        while (aux != NULL){
        
                compra.carta = aux->carta;
                compra.naipe = aux->naipe;
                
                //falta destruir o ultimo nodo do baralho.              
                
                aux = aux->prox;
        }
        
        return compra;
}
