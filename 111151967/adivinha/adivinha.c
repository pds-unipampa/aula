#include <stdlib.h>
#include <stdio.h>
#include "embaralhar.h"
#include "descarte.h"
#include "retira.h"
#include "corta.h"
#include <string.h>
#include <time.h>

Baralho circula(Baralho B, lista *carta){

    carta = B;
    while(carta->prox != NULL){
        carta = carta->prox;
    }
    carta->prox = B;

    return B;
}



int main(){

    srand(time(NULL));
    int a=0,b=0,num1=0, num2=0, y = 13;
    Baralho B = cria();
    lista *carta = NULL;

    B = embaralhar(B);

    B = cortar(B,26);

    B = circula(B,carta);


    carta = B;


    printf("VOCE PRECISA ADIVINHAR AS CARTAS QUE ESTAO POR VIR,\nPRECISA ACERTAR 3 VEZES ANTES DO SEU OPONENTE, BOA SORTE!");


    while(a != 3 && b != 3){// WHILE NÃO PARA QUANDO A OU B ATIGE 3

        printf("\n______________________________________________________________\n");

        printf("\ntente adivinhar o numero da carta  ");
        scanf("%d",&num1);
        while(num1 < 1 || num1 > 13){
            printf("\ndigite um numero maior ou igual a 1 ou menor ou igual a 13\nDIGITE O NUMERO NOVAMENTE: ");
            scanf("%d",&num1);
        }

        num2 = rand() % y + 1;

        printf("\n\nO seu numero eh %d e o numero do seu oponete eh %d, quem vai acertar?",num1,num2);

        printf("\nO NUMERO DA CARTA: %d\n",carta->carta);

        if(num1 == carta->carta && num2 != carta->carta)
        {
            a++;
            printf("\nparabens, voce acertou!    sua pontuacao: %d  pontuacao da maquina: %d",a,b);
        }
        if(num2 == carta->carta && num1 != carta->carta)
        {
            b++;
            printf("\nque pena, a maquina acertou.    sua pontuacao: %d  pontuacao da maquina: %d",a,b);
        }
        if(num1 == carta->carta && num2 == carta->carta)
        {
            ++a; ++b;
            printf("\nos dois acertaram.    sua pontuacao: %d  pontuacao da maquina: %d",a,b);
        }
        if(num1 != carta->carta && num2 != carta->carta)
        {
            printf("\nnimguem acertou dessa vez.    sua pontuacao: %d  pontuacao da maquina: %d",a,b);
        }

        carta = carta->prox;
    }

    printf("\n______________________________________________________________\n");

    if(a == 3 && b != 3)
    {
        printf("\nparabens, voce venceu!\n");
    }
    if(a != 3 && b == 3)
    {
        printf("\nque pena, voce perdeu =\\\n");
    }
    if(a == 3 && b == 3)
    {
        printf("\nos oponentes empataram o jogo!\n");
    }

    return 0;
}

