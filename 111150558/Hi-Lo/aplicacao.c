#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <time.h>
#include <string.h>
#include <embaralhar.h>
#include <retira.h>
#include <corta.h>
#include <descarte.h>

/*! Estrutura para os nomes dos jogadores
 * contendo uma string para o nome e um inteiro para o número do jogador
 */
typedef struct _nomes{
	char* nome;
	int jogador;
}Nome;

/*! Função que cria os nomes dos jogadores
 * @param qtd - Quantidade de jogadores.
 */
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
    int i, aux, war;
    int numjogador;
    char escolha[10];
    char fim[4] = "fim";
    Baralho B = cria();
    Baralho D = cria();
    Nome *nomes; 
    lista C;
    char *strings[4] = { "Copas", "Espadas", "Ouros", "Paus" };
	printf("\nInsira a quantidade de jogadores (de 2 a 8):");
	scanf("%d",&numjogador);
	getchar();
	if (numjogador > 8){
		printf("Por favor respeite o tamanho máximo de jogadores que é 8, o restante joga com o vencedor :)");
		printf("\nInsira a quantidade de jogadores (de 2 a 8):");
		scanf("%d",&numjogador);
		getchar();
	}
	if (numjogador< 2 ){
		printf("Chame mais alguém para jogar com você, este jogo é para no minimo 2 pessoas!");
		printf("\nInsira a quantidade de jogadores (de 2 a 8):");
		scanf("%d",&numjogador);
		getchar();
	}
	nomes=crianomes(9);
	aux =0;
	aux = numjogador;
    for (i=0;i<numjogador;i++){
		printf("\nInsira o nome do Jogador %d : ",i);
		gets(nomes[i].nome);
    }
	
    srand(time(NULL));
    B = embaralhar(B);

    while (aux>1){
		for (i=0;i<numjogador;i++){
				printf("\nCarta: %d de %s\n", B->carta, strings[B->naipe]);
				if ( (strcmp(nomes[i].nome,"fim")) != 0){
					printf("\n\n %s, a proxima carta sera maior ou menor?\n", nomes[i].nome);
					gets(escolha);     
					C = retiraInicio(&B);
					D = insereCartaDescarte(D, C.carta, C.naipe);
					if  ((strcmp(escolha,"maior")) == 0) { 
						if ((D->carta)<=(B->carta)){
							printf("\nCarta: %d de %s\n", B->carta, strings[B->naipe]);
							printf("\nBoa escolha!!");
						}
						else{
						printf("\nCarta: %d de %s\n", B->carta, strings[B->naipe]);
						printf("\nFim de jogo para %s\n",nomes[i].nome);
						nomes[i].nome="fim";
						aux--;
					}
					}
					if ((strcmp(escolha,"menor")) == 0){
						if ((D->carta)>=(B->carta)){
							printf("\nCarta: %d de %s\n", B->carta, strings[B->naipe]);
							printf("\nBoa escolha!!");
						}
						else{
						printf("\nCarta: %d de %s\n", B->carta, strings[B->naipe]);
						printf("\nFim de jogo para %s\n",nomes[i].nome);
						nomes[i].nome="fim";
						aux--;
					}
					}
					
				}
				}
		}		
		
    printf("\n\nFIM DE JOGO!\n");
	war = 0;
    for (i=0;i<numjogador;i++){
		if ( (strcmp(nomes[i].nome,"fim")) != 0){
				printf("\n\n O(a) vencedor(a) foi o(a) %s. \n", nomes[i].nome);
			}
		else{
			war++;
		}
		
    }
    //! variavel war, tem este nome porque não há vencedores na guerra.
    if (war == numjogador){
		printf("\n\n Não houve ganhadores.\n");
	}


    liberaBaralho(&B);
    liberaBaralho(&D);

    return 0;
}

