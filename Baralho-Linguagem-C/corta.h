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
 
 
/*!Corta um baralho em uma determinada posição.
 *@param B - Baralho a ser cortado.
 *@param pos - posição em que o baralho vai ser cortado.
 */
Baralho cortar (Baralho B, int pos);


/*!Função interna. Utilizada apenas por outras funções.
 *Insere cartas em um baralho auxiliar.
 *@param A - Baralho a ser inserida a carta
 *@param carta - Numero da carta que vai ser inserida.
 *@param carta - Naipe da carta.
 */
static void insere_aux(Baralho* A, int carta, char naipe);
