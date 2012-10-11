/*
Copyright (C) 2012 Fabiano Cassol. Todos os direitos reservados
Copyright (C) 2012 Bruno Fontoura. Todos os direitos reservados

Autores:
            Fabiano Cassol (fabiano.babao@gmail.com)
            Bruno Fontoura (brunofontoura@alvorada-rs.com.br)
            
Esta bilbioteca e os arquivos que a acompanham est�o sob os termos
do Common Public License v1.0 que acompanha esta implementa��o
e est� dispon�vel em http://www.eclipse.org/legal/cpl-v10.html

*/

# ifndef BARALHO_H // inicio do guarda
# define BARALHO_H

typedef struct Baralho{
        struct Baralho *prox; /*!< Ponteiro para a pr�xima carta do monte. Apontar� para NULL se for a �ltima carta*/
        char naipe[8]; /*!< Nome do naipe da carta.*/
        char valor[3];/*!< Valor da carta.*/
} baralho_t;


/** 
  * Fun��o que cria o baralho com 52 cartas.
  * Esta fun��o inicializa o ponteiro baralho apontando-o para NULL.
  * O ponteiro baralho referencia o in�cio do baralho.
  * Posteriormente chama a fun��o montaBaralho() que insere todas as cartas chamando 52 vezes a
  * fun��o insereBaralho(), fazendo todos os ajustes de ponteiros necess�rios.
  * @param baralho ponteiro para o in�cio do baralho.
  */
void criaBaralho(baralho_t **baralho);

/** 
  * Fun��o que cria o monte de descarte apontando o ponteiro monte para NULL.
  * monte indica o in�cio do baralho, e esta fun��o cria um monte de descarte vazio.
  * @param monte ponteiro para o in�cio do monte de descarte.
  */
void criaDescarte(baralho_t **monte);

/** 
  * Fun��o que monta o baralho ordenadamente por naipe, 
  * e a cada naipe adiciona as 13 cartas correspondentes chamando a fun��o insereBaralho().
  * @param baralho ponteiro para o in�cio do baralho.
  */
void montaBaralho(baralho_t **baralho);

/** 
  * Fun��o que insere uma carta no baralho alocando um espa�o de mem�ria
  * e atribuindo o seu valor e naipe conforme os par�metros passados
  * pela fun��o montaBaralho(). Faz os ajustes de ponteiro para o in�cio do baralho.
  * @param baralho ponteiro para o in�cio do baralho.
  * @param i valor das cartas.
  * @param j naipe das cartas.
  */
void insereBaralho(baralho_t **baralho, int i, int j);

/** 
  * Esta fun��o percorre todo monte e mostra da tela as cartas do in�cio 
  * ao fim do baralho. O fim � referenciado por NULL.
  * @param baralho ponteiro para o in�cio do baralho.
  */
void imprimeMonte(baralho_t *baralho);

/** 
  * Esta fun��o corta o baralho em uma posi��o aleat�ria a aprtir do tamanho do baralho.
  * tamanho - 1 para nao ocorrer de cortar na �ltima carta.
  * + 1 garante cortar a aprtir da primeira carta.
  * Os n�meros aleat�rios gerados n�o s�o aprimorados, apenas usou-se a fun��o rand()
  * @param baralho ponteiro para o in�cio do baralho.
  */
void cortarBaralho(baralho_t **baralho);

/** 
  * Esta fun��o embaralha o baralho chamando 10 vezes a fun��o cortarBaralho().
  * Ela deveria embaralhar o baralho e tirar as cartas de ordem, por�m 
  * h� algum problema que n�o foi resolvido na sua implementa��o
  * @param baralho ponteiro para o in�cio do baralho.
  */
void embaralhar(baralho_t **baralho);

/** 
  * Esta fun��o libera os espa�os de mem�ria alocados para cada carta do
  * monte passado como par�metro.
  * @param baralho ponteiro para o in�cio do baralho.
  */
void liberaMonte(baralho_t **baralho);

/** 
  * Esta fun��o compra/retira uma carta do in�cio do baralho e retorna a carta 
  * para onde foi chamada a fun��o.
  * @param baralho ponteiro para o in�cio do baralho.
  */
baralho_t* comprarInicio(baralho_t **baralho);

/** 
  * Esta fun��o compra/retira uma carta do fim do baralho e retorna a carta 
  * para onde foi chamada a fun��o.
  * @param baralho ponteiro para o in�cio do baralho.
  */
baralho_t* comprarFim(baralho_t **baralho);

/** 
  * Esta fun��o adiciona uma carta no topo do monte de descarte fazendo 
  * os ajustes de ponteiro necess�rios.
  * @param carta ponteiro para a carta a ser inserida no monte de descarte.
  * @param baralho ponteiro para o in�cio do baralho.
  */
void addDescarte(baralho_t **carta, baralho_t **monte);

/** 
  * Esta fun��o passa uma carta do in�cio para o fim do baralho 
  * sem mostrar que carta � essa. Todos os ajustes de ponteiros s�o feitos.
  * @param baralho ponteiro para o in�cio do baralho.
  */
void cartaInicioParaFim(baralho_t **baralho);

#endif
