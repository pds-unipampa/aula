/*!
 *
 *  This file is part of Baralho.
 *
 *  Copyright 2012  Cristiano Ribeiro <cristiano.daitx@gmail.com>
 *
 *  Copyright 2012  Evair Severo <evairsevero@gmail.com>
 *
 *
 *
 *
 *  This library is free software; you can redistribute it and/or
 *
 *  modify it under the terms of the GNU Lesser General Public
 *
 *  License as published by the Free Software Foundation; either
 *
 *  version 2.1 of the License, or (at your option) any later version.
 *
 *
 *  This library is distributed in the hope that it will be useful,
 *
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *
 *  Lesser General Public License for more details.
 *
 *
 *  You should have received a copy of the GNU Lesser General Public
 *
 *  License along with this library.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

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

/*!Conta o numero de cartas existente em um baralho
 *@param A - baralho a ser contado
*/
int conta(Baralho A);

/*!Cria um baralho como NULL.
 */
Baralho cria(void);

/*!Embaralha um baralho de 52 cartas.
 *@param B - Baralho a ser embaralhado.
 */
Baralho embaralhar(Baralho B);

/*!Função interna. Utilizada apenas por outras funções.
 *Retorna 0 se a carta está no baralho e 1 se não está.
 *@param B - Baralho onde a carta vai ser pesquisada.
 *@param carta - Número da carta a ser pesquisada.
 *@param naipe - Naipe da carta.
 */
static int verifica_Carta(Baralho B, int carta, int naipe);

/*!Função interna. Utilizada apenas por outras funções.
 *Insere uma determinada carta em um baralho.
 *@param B - Baralho onde a carta vai ser inserida.
 *@param carta - Número da carta a ser inserida.
 *@param naipe - Naipe da carta.
 */
static Baralho insere_Carta(Baralho B, int carta, int naipe);
