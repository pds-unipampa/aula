/* Copyright (C) 2012 Cristiano Ribeiro, Evair Severo. All rights reserved.
 * 
 * This program and the accompanying materials are made available under
 * the terms of the Common Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/cpl-v10.html
 * 
 * $Id: IAppVersion.java,v 1.1.1.1 2004/05/09 16:57:28 vlad_r Exp $
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

