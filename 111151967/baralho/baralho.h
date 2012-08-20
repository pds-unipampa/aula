
/*!Estrutura que define um tipo carta de um baralho convencional
 *eh composta por inteiro numero que indica o numero da carta (de 1 a 13),
 *uma string naipe que se refere ao naipe da carta (basto,copas,ouro e espada)
 *uma estrutura auxiliar de mesmo tipo que sera um ponteiro.
*/
typedef struct baralho{
    int numero;
    char naipe[7];
    struct baralho *prox;
}Lista_Baralho;

typedef Lista_Baralho *comeco_baralho;//!<Ponteiro que se refere ao comeco do baralho, ou seja, o baralho
typedef Lista_Baralho *monte;//!<Ponteiro que se refere ao comeco do monte, ou seja, o monte

/*!Cria o ponteiro de baralho e do monte apontando NULL
 *chama funcao cria_baralho() enviando os parametros que definirao o numero e naipe da carta,
 *chama a funcao cria_baralho() 52(tamanho de um baralho) vezes.
 *@param *l - ponteiro que indica a lista a ser criada.
 *@param *h - ponteiro que sera igualado a NULL.
*/
Lista_Baralho * Cria_Lista(comeco_baralho *l, comeco_baralho *h);

/*!Aloca os nodos na lista conforme esta funcao eh chamada na funcao Cria_Lista()
 *especifica os tipos de cada nodo como o numero,naipe e ponteiro prox
 *e aloca na lista que no fim das chamdas sera o baralho
 *@param *l - ponteiro indicando a lista.
 *@param i - indica o naipe da carta.
 *@param k - indica o numero da carta.
*/
Lista_Baralho * cria_baralho(comeco_baralho *l, int i, int k);

/*!Percorre a lista criada na funcao cria_baralho ate o nodo desejado
 *faz a lista perder a refencia com o nodo e chama a funcao embaralha()
 *enviando de parametro o nodo.
 *cria outro ponteiro para lista(lista2) que tambem sera enviada como parametro para a funcao embaralha()
 *@param *l - ponteiro indicando o inicio da lista.
*/
Lista_Baralho * embaralha(comeco_baralho *l);
/*!redireciona os ponteiro da lista para outro ponteiro do inicio de lista
 *@param *lista2 - ponteiro indicando o inicio da outra lista.
 *@param *nodo - ponteiro indicando nodo sem refencia em nehuma lista.
*/
Lista_Baralho * embaralhando(Lista_Baralho*lista2, Lista_Baralho *nodo);
/*!Corta a lista baralho em alguma posicao.
 *@param *l - ponteiro indicando inicio de lista.
*/
Lista_Baralho * cortar(comeco_baralho *l);

/*!retira uma carta da lista do baralho e coloca na lista do baralho do monte.
 *@param *l - ponteiro indicando inicio da lista.
 *@param *h - ponteiro indicando inicio da lista do monte.
*/
Lista_Baralho * retira_carta(comeco_baralho *l, monte *h);

/*!Passa uma carta do inicio da lista do baralho para o final.
 *@param *l - ponteiro para inicio da lista.
*/
Lista_Baralho * passa_final(comeco_baralho *l);
/*!Imprime as listas do baralho e o baralho do monte
 *@param *lista - ponteiro indicando o inicio da lista do baralho
 *@param *resto - ponteiro indicando o inicio da lista do monte
*/
void imprimi (comeco_baralho *lista,comeco_baralho *resto);
