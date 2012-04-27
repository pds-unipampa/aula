/*DECLARAÇÃO DO NÓ E DA LISTA DE CARTAS*/
/*!Estrutura que representa uma carta.
 * Armazena a carta e seu respectivo naipe.
 * Sendo as cartas representadas de 1 a 13.
 * Logo as cartas A, J, Q e K são representadas, pelos números 1, 11, 12 e 13 respectivamente.
 * As demais cartas seguem o padrão que conhecemos.
 * Os nipes são representados por um caractere. Paus, copas, espadas e ouro são representados por P, C, E e O respectivamente.
*/
typedef struct nodo {

    int carta;//!< armazena uma carta (seu respectivo número).
    char naipe;//!< armazena um nipe.
    struct nodo *prox;//!< apontador para o próximo nó.
    
}lista;

typedef lista* Baralho;//!< Lista que representa um baralho.



/*!Cria um baralho como NULL.
 */
Baralho cria(void);

/*!Embaralha um baralho de 52 cartas.
 *@param B - Baralho a ser embaralhado.
 */
Baralho embaralhar(Baralho B);

/*!Verifica se uma determinada carta está no baralho.
 *@param B - Baralho onde a carta vai ser pesquisada.
 *@param carta - Número da carta a ser pesquisada.
 *@param naipe - Naipe da carta.
 */
int verifica_Carta(Baralho B, int carta, int naipe);

/*!Insere uma determinada carta em um baralho.
 *@param B - Baralho onde a carta vai ser inserida.
 *@param carta - Número da carta a ser inserida.
 *@param naipe - Naipe da carta. 
 */
Baralho insere_Carta(Baralho B, int carta, int naipe);



void imprime(Baralho B);
    


