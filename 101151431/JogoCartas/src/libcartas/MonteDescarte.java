/**
 * <Biblioteca para manipulação de cartas.>
 * Copyright (C) <2012>  Brandon Marques dos Santos <brdonsb@gmail.com>
 * Copyright (C) <2012>  Renan Marcel Uchôa <renanmarceluchoa@gmail.com>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
**/

package libcartas;

import java.util.LinkedList;

/**
 * Classe que implementa o conceito de um monte de descarte para um jogo de baralho
 */
public class MonteDescarte {
    
    private LinkedList<Carta> monte;

    /**
     * Método construtor que inicializa um monte de descarte vazio
     */
    public MonteDescarte(){
        
        this.monte = new LinkedList<Carta>();
        
    }

    /**
     * Método que insere uma carta no topo do monte de descarte
     * @param carta 
     */
    public void insereTopo(Carta carta){
        
        monte.addFirst(carta);
        
    }
    
    /**
     * Método que remove e retorna uma carta do topo do monte de descarte
     * @return 
     */
    public Carta retiraTopo() {
        
        return monte.removeFirst();
        
    }
    
    /**
     * Método que mostra todas as cartas do monte de descarte em um terminal console
     */
    public void mostraCartas(){
        
        for(Carta cart:monte){
            System.out.println(cart.getNumero()+" "+cart.getNaipe());
            System.out.println("fim");
        }
        
    }
    
    /**
     * Método que retorna uma lista completa com as cartas do monte de descarte
     * @return 
     */
    public LinkedList<Carta> getCartas() {
        return this.monte;
    }
    
}
