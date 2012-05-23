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

/*!Aqui são chamados os testes*/
static char * testes() {

    mu_run_test(test_embaralhar);
    mu_run_test(test_retira_final);
    mu_run_test(test_retira_inicio);
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
