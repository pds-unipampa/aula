/* Copyright (C) 2012 Cristiano Ribeiro, Evair Severo. All rights reserved.
 * 
 * This program and the accompanying materials are made available under
 * the terms of the Common Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/cpl-v10.html
 * 
 * $Id: IAppVersion.java,v 1.1.1.1 2004/05/09 16:57:28 vlad_r Exp $
 */

/*!Insere uma determinada carta no monte de descarte.
 *@param D - Baralho de descarte onde vai ser inserida a carta.
 */
Baralho atualizaDescarte (Baralho D);

/*!Retorna a carta que está em uma determinada posição do baralho de descarte.
 *@param D - Baralho de descarte.
 *@param pos - Posição da carta.
 */
lista mostraDescarte(Baralho D, int pos);

/*!Função interna. É utilizada apenas em outras funções.
 *@param D - Baralho de descarte.
 *@param carta - número da carta que vai ser inserida.
 *@param naipe - naipe da carta que vai ser inserida.
 */
Baralho insereCartaDescarte(Baralho D, int carta, char naipe);

/*!Remove uma carta do baralho de descarte e retorna a mesma.
 *@param D - Baralho de descarte.
 *@param pos - Posição do baralho em que vai ser removida a carta.
 */
lista retiraDescarte (Baralho* D, int pos);
