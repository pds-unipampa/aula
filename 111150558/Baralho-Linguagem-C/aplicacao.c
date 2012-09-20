#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <time.h>
#include <string.h>
#include <embaralhar.h>
#include <retira.h>
#include <corta.h>
#include <descarte.h>

typedef struct _nomes{
	char* nome;
	int jogador;
}Nome;


Nome* crianomes(int qtd){
	int i;
	Nome *nomes;
	nomes= malloc(sizeof(int)*qtd);
	for (i=0;i<qtd;i++){
		nomes[i].nome = malloc(sizeof(char)*20);
		nomes[i].jogador = i;
	}
	return nomes;
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
    int i, aux;
    int numjogador;
    char escolha[10];
    Baralho B = cria();
    Baralho D = cria();
    Nome *nomes; 
    lista C;
    char *strings[4] = { "Copas", "Espadas", "Ouros", "Paus" };
	printf("\nInsira a quantidade de jogadores:");
	scanf("%d",&numjogador);
	getchar();
	nomes=crianomes(numjogador);
	aux = numjogador;
    for (i=0;i<numjogador;i++){
		printf("\nInsira o nome do Jogador %d : ",i);
		gets(nomes[i].nome);
    }
	
    srand(time(NULL));
    B = embaralhar(B);

    while (aux<=1){
		for (i=0;i<numjogador;i++){
				printf("\nCarta: %d de %s\n", B->carta, strings[B->naipe]);
				C = retiraInicio(&B);
				D = cria();
				D = insereCartaDescarte(D, C.carta, C.naipe);
				if ( (strcmp(nomes[i].nome,"fim")) == 0){
					printf("\n\n %s. maior ou menor?\n", nomes[i].nome);
					gets(escolha);     
					if  ((((!(strcmp(escolha,"maior"))) == 0) && ((B->carta)>(D->carta))) || ((!(strcmp(escolha,"menor")) == 0) && ((B->carta)<(D->carta)))) {

						printf("\nBoa escolha!!");

					}
					else{

						printf("\nFim de jogo para %s\n",nomes[i].nome);
						nomes[i].nome="fim";
						
					}
				}
		}		
		aux = aux--;
	}

   
    printf("\n\nFIM DE JOGO!\n");
    for (i=0;i<numjogador;i++){
		if ( (strcmp(nomes[i].nome,"fim")) != 0){
				printf("\n\n O(a) vencedor(a) foi o(a) %s. \n", nomes[i].nome);
			}
        return 0;
    }


    liberaBaralho(&B);
    liberaBaralho(&D);

	printf("\n nome1 - %s \n nome2 - %s\n",nomes[0].nome, nomes[1].nome);
    return 0;
}

