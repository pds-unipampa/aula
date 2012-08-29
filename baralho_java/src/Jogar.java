/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class Jogar {

    /**
     * cria-se um arraylist para pegar e simular a mão de um jogador para qualquer tipo de jogo
     */
    ArrayList<Carta> maojogador = new ArrayList();

    /**
     * metodo que adicionar carta a mao do jogador usando metodo daUmaCartaFinal da classe baralho
     */
    public void ComprarCarta(Baralho baralho) {
        maojogador.add(baralho.daUmaCartaFinal());
    }

    /**
     * metodo que retira carta da mao do jogador usando metodo colocaDescarte da classe baralho
     */
    public void DescartarMao(Baralho baralhomesa, int i) {
        baralhomesa.colocaDescarte(maojogador.remove(i));
    }

    public ArrayList<Carta> getMaojogador() {
        return maojogador;
    }

    public void setMaojogador(ArrayList<Carta> maojogador) {
        this.maojogador = maojogador;
    }
}
