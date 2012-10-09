#include <stdio.h>
#include <stdlib.h>
#include "minunit.h"
#include "embaralhar.h"
#include "retira.h"
#include "descarte.h"
#include "corta.h"

int tests_run = 0;

/*!Conta quantas cartas existem em determinado baralho.
 *@param B - Baralho a ser feita a contagem.
 */
int tamanho_baralho(Baralho B){

    int tamanho = 0;

    while (B != NULL){

        B = B->prox;
        tamanho++;
    }

    return tamanho;
}

/*!Testa a função de embaralhar.*/
static char * test_embaralhar() {

    Baralho B = embaralhar(0);
    Baralho aux = B;
    int cartas[10];
    char naipes [10];
    int i, cont=0;

    mu_assert("FUNCAO embaralhar - Erro ao embaralhar. O baralho ficou nulo.", B != NULL);
    mu_assert("FUNCAO embaralhar - Erro ao embaralhar. O baralho nao contem 52 cartas.", tamanho_baralho(B) == 52);

    for (i=0; i<5; i++){

        cartas[i]=aux->carta;
        naipes[i]=aux->naipe;

        aux=aux->prox;
    }

    B = embaralhar(B);

    mu_assert("FUNCAO embaralhar - Erro ao embaralhar. Depois de outra embaralhada o baralho nao ficou com 52 cartas", tamanho_baralho(B) == 52);

    aux=B;

    for (i=0; i<10; i++){

        if ((cartas[i]==aux->carta) && (naipes[i]==aux->naipe)){

            cont++;
        }
        aux=aux->prox;
    }

    mu_assert("FUNCAO embaralhar - Erro ao embaralhar. As cartas nao foram embaralhadas corretamente", cont<7);

    return 0;
}

/*!Testa a função de retirar a carta do final do baralho.*/
static char * test_retiraFim() {

    Baralho B = embaralhar(0);
    Baralho aux = B;
    lista penult;
    lista carta;

    while (aux->prox != NULL){

        if (aux->prox->prox == NULL){

            penult.carta = aux->carta;
            penult.naipe = aux->naipe;
        }

        aux = aux->prox;
    }

    carta = retiraFim(&B);

    mu_assert("FUNCAO retira_final - Erro! A carta que foi retirada nao estava no final!", (carta.carta == aux->carta) && (carta.naipe == aux->naipe));

    aux = B;

    while (aux->prox != NULL){

        aux = aux->prox;
    }

    mu_assert("FUNCAO retira_final - Erro! A penultima carta do baralho antes da remoção nao é a ultima carta do baralho atual", (penult.carta == aux->carta) && (penult.naipe == aux->naipe));
    mu_assert("FUNCAO retira_final - Erro! A carta do final foi supostamente retirada mas o baralho continua com 52 cartas.", tamanho_baralho(B) == 51);
    return 0;
}

/*!Testa a função de retirar a carta do inicio do baralho.*/
static char * test_retiraInicio() {

    Baralho B = embaralhar(0);
    Baralho aux = B;
    lista carta;
    lista segundaCarta;

    segundaCarta.carta = B->prox->carta;
    segundaCarta.naipe = B->prox->naipe;

    carta = retiraInicio(&B);

    mu_assert("FUNCAO retira_inicio - Erro! A carta que foi retirada nao estava no inicio.", (carta.carta == aux->carta) && (carta.naipe == aux->naipe));
    mu_assert("FUNCAO retira_inicio - Erro! A segunda carta do baralho antes da remoção não é a primeira no baralho atual.", (segundaCarta.carta == B->carta) && (segundaCarta.naipe == B->naipe));
    mu_assert("FUNCAO retira_inicio - Erro! A carta do inicio foi supostamente retirada mas o baralho continua com 52 cartas.", tamanho_baralho(B) == 51);
    return 0;
}

/*!Testa a função que retira a carta do inicio do baralho e coloca a mesma no final do baralho.*/
static char * test_retiraInicio_insereFim(){

	Baralho B = embaralhar(0);
	Baralho aux = B;
	lista carta;
	lista segundaCarta;

	segundaCarta.carta = B->prox->carta;
    segundaCarta.naipe = B->prox->naipe;

	retiraInicio_insereFim(&B);
	carta = retiraFim(&aux);

	mu_assert("FUNCAO retiraInicio_insereFim - Erro! A carta nao foi retirada do inicio e inserida no fim.", (carta.carta == aux->carta) && (carta.naipe == aux->naipe));
    mu_assert("FUNCAO retira_inicio_insereFim - Erro! A segunda carta do baralho antes da remoção e inserção no fim não é a primeira no baralho atual.", (segundaCarta.carta == B->carta) && (segundaCarta.naipe == B->naipe));
    mu_assert("FUNCAO retiraInicio_insereFim - Erro! A carta do inicio foi supostamente retirada e inserida no fim mas o baralho nao contem 52 cartas.", tamanho_baralho(B) == 52);
    return 0;
}

/*!Testa a função que corta um determinado baralho em uma determinada posição. No teste foi usada a posicao 5.*/
static char * test_cortar(){

	Baralho B = embaralhar(0);
	Baralho aux = B;
	lista carta_posicao, carta_final;
	int i = 0;

	while (i<5) {

		aux=aux->prox;
		i++;
	}

	carta_posicao = retiraInicio(&aux);

	B = cortar(B, 5);

    aux=B;

	carta_final = retiraFim(&aux);

	mu_assert("FUNCAO cortar - Erro! O baralho nao foi cortado corretamente.", (carta_posicao.carta == carta_final.carta) && (carta_posicao.naipe == carta_final.naipe));
    mu_assert("FUNCAO cortar - Erro! O barlaho nao permaneceu com as 52 cartas.", tamanho_baralho(B)==52);

    return 0;
}

static char * test_insereCartaDescarte() {

    Baralho D = NULL;
    D = insereCartaDescarte(D, 5, Copas);
    D = insereCartaDescarte(D, 1, Ouros);
    D = insereCartaDescarte(D, 2, Espadas);

    mu_assert("FUNCAO atualizaDescarte - Erro! A carta nao foi inserida no monte de descarte.", tamanho_baralho(D)==3);

    return 0;
}

/*!Testa a função que retorna uma carta de uma determinada posicao do monte de descarte. No teste foi usada a posicao 0*/
static char * test_mostraDescarte() {

    Baralho D = NULL;
    lista carta;

    D = insereCartaDescarte(D, 5, Copas);
    D = insereCartaDescarte(D, 7, Ouros);
    D = insereCartaDescarte(D, 1, Espadas);

    carta = mostraDescarte(D, 0);

    mu_assert("FUNCAO mostraDescarte - Erro!", (carta.carta != NULL) && (carta.naipe != NULL));
    mu_assert("FUNCAO mostraDescarte - Erro! O tamanho do baralho foi modificado", tamanho_baralho(D) == 3);

    return 0;
}

/*!Testa a função que retira uma carta em uma determinada posicao do monte de descarte. No teste foi usada a posicao 0*/
static char * test_retiraDescarte() {

    Baralho D = NULL;
    lista carta;
    lista segundaCarta;

    D = insereCartaDescarte(D, 5, Copas);
    D = insereCartaDescarte(D, 7, Ouros);
    D = insereCartaDescarte(D, 1, Espadas);

    segundaCarta.carta = D->prox->carta;
    segundaCarta.naipe = D->prox->naipe;

    carta = retiraDescarte(&D, 0);

    mu_assert("FUNCAO retiraDescarte - Erro! A carta nao foi retirada do monte de descarte.", tamanho_baralho(D)==2);
    mu_assert("FUNCAO retiraDescarte - Erro! A carta nao foi retirada da posição correta.", segundaCarta.carta == D->carta && segundaCarta.naipe == D->naipe);


    return 0;
}

/*!Aqui são chamados os testes*/
static char * testes() {

    mu_run_test(test_embaralhar);
    mu_run_test(test_retiraFim);
    mu_run_test(test_retiraInicio);
    mu_run_test(test_retiraInicio_insereFim);
    mu_run_test(test_cortar);
    mu_run_test(test_insereCartaDescarte);
	mu_run_test(test_mostraDescarte);
	mu_run_test(test_retiraDescarte);

    return 0;
}

int main() {

    char *result = testes();

    if (result != 0) {
        printf("%s\n", result);
    }

    else {
        printf("\nTODOS OS TESTES FORAM APROVADOS\n");
    }
    printf("Testes: %d\n", tests_run);

    return result != 0;
}
