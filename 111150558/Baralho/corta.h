/* Copyright (C) 2012 Cristiano Ribeiro, Evair Severo. All rights reserved.
 * 
 * This program and the accompanying materials are made available under
 * the terms of the Common Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/cpl-v10.html
 * 
 * $Id: IAppVersion.java,v 1.1.1.1 2004/05/09 16:57:28 vlad_r Exp $
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
void insere_aux(Baralho* A, int carta, char naipe);
