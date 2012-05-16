package baralho;

import java.util.LinkedList;


/*<Essa biblioteca tem como objetivo facilitar o manuseio de um baralho de cartas tradicional com 52 cartas, 
 * possuindo algumas métodos que farão determinadas ações automatizadas, como baralhar, cortar, etc..>
 *   Copyright (C) <2012>  <Rafhael Cunha>

 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.

 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *	You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *	email: rcrafhaelrc@gmail.com
 */

/**
 * @author Rafhael
 */
public class Descarte {

    private LinkedList<Carta> descarte = new LinkedList<Carta>();

    /**
     * Método construtor da classe Descarte que instancia uma novo baralho com o nome de descarte;
     */
    public Descarte() {
        this.descarte = new LinkedList<Carta>();
    }
    /**
     * Método que me retorna se a carta foi adiciona ao baralho
     * @param carta
     * @return this.descarte.add(carta)
     */
    public boolean addCarta(Carta carta) {
        return this.descarte.add(carta);
    }
    /**
     * Método que retorna um objeto carta no qual eu passo a posição como parametro;
     * @param posicao
     * @return this.descarte.get(posicao);
     */
    public Carta visualizar(int posicao) {
        return this.descarte.get(posicao);
    }
    
    /**
     * Método que removo uma carta do descarte passando a sua posição;
     * @param posicao
     * @return a carta que vai ser removida;
     */
    public Carta removecarta(int posicao){
        return this.descarte.remove(posicao);
    }
    /**
     * Método que percorre todas as cartas que eu tenho no baralho de descarte e as imprimi
     * @return saida
     */
    public String toString() {
        String saida = "";
        for (Carta carta : descarte) {
            saida = saida +  "|" + carta.retornacarta() + "|, ";
        }
        return saida;
    }
    
    
    
}