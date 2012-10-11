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

# ifndef BARALHO_H // inicio do guarda
# define BARALHO_H

typedef struct Baralho{
        struct Baralho *prox; /*!< Ponteiro para a próxima carta do monte. Apontará para NULL se for a última carta*/
        char naipe[8]; /*!< Nome do naipe da carta.*/
        char valor[3];/*!< Valor da carta.*/
} baralho_t;


/** 
  * Função que cria o baralho com 52 cartas.
  * Esta função inicializa o ponteiro baralho apontando-o para NULL.
  * O ponteiro baralho referencia o início do baralho.
  * Posteriormente chama a função montaBaralho() que insere todas as cartas chamando 52 vezes a
  * função insereBaralho(), fazendo todos os ajustes de ponteiros necessários.
  * @param baralho ponteiro para o início do baralho.
  */
void criaBaralho(baralho_t **baralho);

/** 
  * Função que cria o monte de descarte apontando o ponteiro monte para NULL.
  * monte indica o início do baralho, e esta função cria um monte de descarte vazio.
  * @param monte ponteiro para o início do monte de descarte.
  */
void criaDescarte(baralho_t **monte);

/** 
  * Função que monta o baralho ordenadamente por naipe, 
  * e a cada naipe adiciona as 13 cartas correspondentes chamando a função insereBaralho().
  * @param baralho ponteiro para o início do baralho.
  */
void montaBaralho(baralho_t **baralho);

/** 
  * Função que insere uma carta no baralho alocando um espaço de memória
  * e atribuindo o seu valor e naipe conforme os parâmetros passados
  * pela função montaBaralho(). Faz os ajustes de ponteiro para o início do baralho.
  * @param baralho ponteiro para o início do baralho.
  * @param i valor das cartas.
  * @param j naipe das cartas.
  */
void insereBaralho(baralho_t **baralho, int i, int j);

/** 
  * Esta função percorre todo monte e mostra da tela as cartas do início 
  * ao fim do baralho. O fim é referenciado por NULL.
  * @param baralho ponteiro para o início do baralho.
  */
void imprimeMonte(baralho_t *baralho);

/** 
  * Esta função corta o baralho em uma posição aleatória a aprtir do tamanho do baralho.
  * tamanho - 1 para nao ocorrer de cortar na última carta.
  * + 1 garante cortar a aprtir da primeira carta.
  * Os números aleatórios gerados não são aprimorados, apenas usou-se a função rand()
  * @param baralho ponteiro para o início do baralho.
  */
void cortarBaralho(baralho_t **baralho);

/** 
  * Esta função embaralha o baralho chamando 10 vezes a função cortarBaralho().
  * Ela deveria embaralhar o baralho e tirar as cartas de ordem, porém 
  * há algum problema que não foi resolvido na sua implementação
  * @param baralho ponteiro para o início do baralho.
  */
void embaralhar(baralho_t **baralho);

/** 
  * Esta função libera os espaços de memória alocados para cada carta do
  * monte passado como parâmetro.
  * @param baralho ponteiro para o início do baralho.
  */
void liberaMonte(baralho_t **baralho);

/** 
  * Esta função compra/retira uma carta do início do baralho e retorna a carta 
  * para onde foi chamada a função.
  * @param baralho ponteiro para o início do baralho.
  */
baralho_t* comprarInicio(baralho_t **baralho);

/** 
  * Esta função compra/retira uma carta do fim do baralho e retorna a carta 
  * para onde foi chamada a função.
  * @param baralho ponteiro para o início do baralho.
  */
baralho_t* comprarFim(baralho_t **baralho);

/** 
  * Esta função adiciona uma carta no topo do monte de descarte fazendo 
  * os ajustes de ponteiro necessários.
  * @param carta ponteiro para a carta a ser inserida no monte de descarte.
  * @param baralho ponteiro para o início do baralho.
  */
void addDescarte(baralho_t **carta, baralho_t **monte);

/** 
  * Esta função passa uma carta do início para o fim do baralho 
  * sem mostrar que carta é essa. Todos os ajustes de ponteiros são feitos.
  * @param baralho ponteiro para o início do baralho.
  */
void cartaInicioParaFim(baralho_t **baralho);

#endif
