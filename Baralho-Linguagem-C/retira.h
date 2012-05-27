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

