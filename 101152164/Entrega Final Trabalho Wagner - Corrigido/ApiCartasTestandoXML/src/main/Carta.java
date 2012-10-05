package baralho;


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
 * Classe que apoia a simbolização de um carta, contendo seu número (1 a 13)
 * e seu naipe (pré definidos na classe naipe através do enumeration)
 */

public class Carta {
    private int numero;
    private Naipe naipe;
   
    /*
     * Método que retorna o número da carta
     * @return numero;
     */
    public int getNumero() {
        return numero;
    }
    /*
     * Método que retorna o naipe da carta
     * @return naipe;
     */
    public Naipe getNaipe() {
        return naipe;
    }
   
    /*
     * Método Construtor da Classe Carta
     * Recebe como parametro o número da carta e o naipe do qual ela é,
     * lembrando que o naipe é do tipo "Naipe" e é pré definido na classe Naipe.
     */
    public Carta(int numero, Naipe naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

    /*
     * Método que retorna uma string com o número da carta e o naipe da mesma.
     * Método separa o número e o naipe da carta por uma ,
     */
    public String retornacarta() {
        return this.getNumero() + "," + this.getNaipe();
    }
}
