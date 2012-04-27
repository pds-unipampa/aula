
/*!Corta um baralho em uma determinada posição.
 *@param B - Baralho a ser cortado.
 *@param pos - posição em que o baralho vai ser cortado.
 */
Baralho cortar (Baralho B, int pos);

/*!Insere cartas em um baralho auxiliar.
 *@param A - Baralho a ser inserida a carta
 *@param carta - Numero da carta que vai ser inserida.
 *@param carta - Naipe da carta.
 */
void insere_aux(Baralho* A, int carta, char naipe);
