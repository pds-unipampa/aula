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

    mu_assert("FUNCAO embaralhar - Erro ao embaralhar. O baralho ficou nulo.", B != NULL);
    mu_assert("FUNCAO embaralhar - Erro ao embaralhar. O baralho nao contem 52 cartas.", tamanho_baralho(B) == 52);

    return 0;
}

/*!Testa a função de retirar a carta do final do baralho.*/
static char * test_retira_final() {

    Baralho B = embaralhar(0);
    Baralho aux = B;
    lista carta;

    while (aux->prox != NULL){

        aux = aux->prox;
    }

    carta = retira_final(&B);
    mu_assert("FUNCAO retira_final - Erro! A carta que foi retirada nao estava no final!", (carta.carta == aux->carta) && (carta.naipe == aux->naipe));
    mu_assert("FUNCAO retira_final - Erro! A carta do final foi supostamente retirada mas o baralho continua com 52 cartas.", tamanho_baralho(B) == 51);
    return 0;
}

/*!Testa a função de retirar a carta do inicio do baralho.*/
static char * test_retira_inicio() {

    Baralho B = embaralhar(0);
    Baralho aux = B;
    lista carta;

    carta = retira_inicio(&B);

    mu_assert("FUNCAO retira_inicio - Erro! A carta que foi retirada nao estava no inicio.", (carta.carta == aux->carta) && (carta.naipe == aux->naipe));
    mu_assert("FUNCAO retira_inicio - Erro! A carta do inicio foi supostamente retirada mas o baralho continua com 52 cartas.", tamanho_baralho(B) == 51);
    return 0;
}

/*!Testa a função que retira a carta do inicio do baralho e coloca a mesma no final do baralho.*/
static char * test_retiraInicio_insereFim(){

	Baralho B = embaralhar(0);
	Baralho aux = B;
	lista carta;

	retiraInicio_insereFim(&B);
	carta = retira_final(&aux);

	mu_assert("FUNCAO retiraInicio_insereFim - Erro! A carta nao foi retirada do inicio e inserida no fim.", (carta.carta == aux->carta) && (carta.naipe == aux->naipe));
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

	carta_posicao = retira_inicio(&aux);

	B = cortar(B, 5);

    aux=B;

	carta_final = retira_final(&aux);

	mu_assert("FUNCAO cortar - Erro! O baralho nao foi cortado corretamente.", (carta_posicao.carta == carta_final.carta) && (carta_posicao.naipe == carta_final.naipe));
    return 0;
}

static char * test_insereCartaDescarte() {

    Baralho D = NULL;
    D = insereCartaDescarte(D, 5, 'P');
    D = insereCartaDescarte(D, 1, 'C');
    D = insereCartaDescarte(D, 2, 'O');

    mu_assert("FUNCAO atualizaDescarte - Erro! A carta nao foi inserida no monte de descarte.", tamanho_baralho(D)==3);

    return 0;
}

/*!Aqui são chamados os testes*/
static char * testes() {

    mu_run_test(test_embaralhar);
    mu_run_test(test_retira_final);
    mu_run_test(test_retira_inicio);
    mu_run_test(test_retiraInicio_insereFim);
    mu_run_test(test_cortar);
    mu_run_test(test_insereCartaDescarte);

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
