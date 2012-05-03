
/*!Retira a carta que está no inicio do baralho.
 * O retorno dessa função será um nodo com essa carta.
 *@param B - Baralho a ser retirada a carta.
 */
lista retira_inicio (Baralho* B);

/*!Retira a carta que está no final do baralho.
 * O retorno dessa função será um nodo com essa carta.
 *@param B - Baralho a ser retirada a carta.
 */
lista retira_final (Baralho* B);

/*!Retira a carta que está no inicio e insere no final do baralho.
 *@param B - Baralho a ser realizada a função.
 */
void retiraInicio_insereFim(Baralho *B);

