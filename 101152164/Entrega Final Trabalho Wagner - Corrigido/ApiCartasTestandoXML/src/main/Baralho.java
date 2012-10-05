package baralho;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
 *
 * @author Rafhael
 * Classe que implementa as funcionalidades do baralho como:
 * Embaralhar
 * Cortar em uma determinada Posição
 * Pegar a carta do final e passar pro inicio, entre outras coisas.
 */

public class Baralho {

   // private Stack <Carta> baralhonormal;
    private LinkedList <Carta> baralhonormal;
    
    /**
     * Método Construtor da classe Baralho aonde passo como baralho um baralho;
     * @param baralho 
     */
    public Baralho (LinkedList<Carta> baralho) {
       // this.baralhonormal = baralho;
        LinkedList<Carta> baralhonormal = new LinkedList<Carta>();
    }
    
    /**
     * Método Construtor da classe baralho aonde eu instancio um novo baralho, e preencho com cartas e naipes.
     */
    public Baralho() {
        this.baralhonormal = new LinkedList<Carta>();
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j <= 3; j++) {
                Carta carta = null;
                if (j == 0) {
                    carta = new Carta(i, Naipe.OUROS);
                } else if (j == 1) {
                    carta = new Carta(i, Naipe.PAUS);
                } else if (j == 2) {
                    carta = new Carta(i, Naipe.COPAS);
                } else if (j == 3) {
                    carta = new Carta(i, Naipe.ESPADAS);
                }
                this.adicionarcarta(carta);
            }
        }
    }

    /**
     * Método booleano que adiciona uma carta no baralho;
     * @param carta
     * @return this.baralhonormal.add(carta);
     */
    public boolean adicionarcarta(Carta carta) {
        return this.baralhonormal.add(carta);
    }
    /**
     * Método que embaralha as cartas do baralho, ou seja, troca a ordem delas na linkedlist
     */
    public void embaralhar() {
        Collections.shuffle(this.baralhonormal);
    }
    /**
     * Método que corta o baralho, ou seja, pega como baralho a posição que vai ser feito o corte e
     * dessa posição pra baixo ele passa pra cima reorganizando a linkedlist(o baralho);
     * @param corte 
     */
    public void cortarbaralho(int corte) {
        boolean status = false;
        List corteprabaixo = this.baralhonormal.subList(0, corte);
        List cortepracima = this.baralhonormal.subList(corte, size());
        //estazia o baralho
        this.baralhonormal = null;
        // instancio o baralho novamente
        this.baralhonormal = new LinkedList<Carta>();
        // status fica verdadeiro se ele conseguir adicionar as cartas de cima do corte no baralho
        status = this.baralhonormal.addAll(cortepracima);
        // Verifica se as cartas de cima do corte foram adicionadas ao baralho
        if (status == true) {
            // se sim  adiciona as proximas cartas ao baralho. lembrando ao jogo de cartaz tradicional
            // no qual as cartas do corte pra baixo ficam encima.
            status = this.baralhonormal.addAll(corteprabaixo);
        } else {
            // caso contrario ele também adiciona as cartas ao baralho
            this.baralhonormal.addAll(corteprabaixo);
        }
    }
    /**
     * Método que retorna a primeira carta que esta acima no baralho, ou seja, na 1º posição da linkedlist;
     * @return this.baralhonormal.getFirst();
     */
    public Carta getPrimeiraCarta() {
        return this.baralhonormal.getFirst();
    }
    /**
     * Método que pega a primeira carta do baralho e remove a mesma.
     * Usa como auxilio a variavel auxiliar, a mesma recebe a primeira carta do baralho com o método getFirt e após
     * remove essa carta do baralho com o método remove.
     * @return auxiliar;
     */
    public Carta getPrimeiraCartaeRemoveEladoBaralho() {
       Carta auxiliar = null; 
       auxiliar = baralhonormal.getFirst();
       baralhonormal.remove(auxiliar);
       return auxiliar;
    }
    /**
     * Método que retorna a última carta do baralho, ou seja, a que esta na ultima posição da linkedlist
     * @return  this.baralhonormal.getLast(); 
     */
    public Carta getUltimaCarta() {
        return this.baralhonormal.getLast();
    }
    /**
     * Método que pega a ultima carta do baralho e remove do mesmo. 
     * Usa como auxilio uma variavel auxiliar que recebe a última carta através do método getLast e após
     * remove ela do baralho com o método remove.
     * @return auxiliar;
     */
    public Carta getPegaUltimaCartaRemoveEladoBaralho() {
       Carta auxiliar = null; 
       auxiliar = baralhonormal.getLast();
       baralhonormal.remove(auxiliar);
       return auxiliar;
    }
    /**
     * Método que pega a primeira carta do baralho e passa para ultima posição
     */
    public void PassarPrimeiraCartaParaUltimaPosicao() {
        Carta carta = this.getPrimeiraCarta();
        this.baralhonormal.remove(carta);
        this.baralhonormal.add(size(),carta);
    }
    /**
     * Método que retorna o tamanho do baralho atualmente;
     * @return o tamanho do baralhonormal;
     */
    public int size() {
        return this.baralhonormal.size();
    }

    @Override
    /**
     * Método que retorna a saida, uma string, mostrando todas as cartas que tem no baralho no momento da consulta;
     * @return saida;
     */
    public String toString() {
        String saida = "";
        for (Carta carta : baralhonormal) {
            saida = saida +  "|" + carta.retornacarta() + "|, ";
        }
        return saida;
    }
}
