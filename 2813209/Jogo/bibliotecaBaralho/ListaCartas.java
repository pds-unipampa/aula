/**
 *  
 * Copyright (C) <2012>  <Bruno Segui and Isabel Boaventura>

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * 
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecaBaralho;

/**
 *
 * @author bruno
 */
import java.util.*;
import javax.swing.JOptionPane;

public class ListaCartas {

    /**
     * 
     * @param lista 
     */
    public static List<Cartas> baralho;
    public static String[] naipes = {"espada", "ouro", "basto", "copas"};

    public static List CriaBaralho() {
        baralho = new ArrayList<Cartas>();
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                Cartas carta = new Cartas(naipes[j], i + 1);
                baralho.add(carta);
            }
        }
        return baralho;
    }

    public static List Embaralhar(List<Cartas> baralho2) {

        Collections.shuffle(baralho2);

        return baralho2;
    }

    /**
     * 
     * @param lista
     * @param parte1
     * @param parte2
     * @param montecompra 
     */
    // corta a lista em duas partes depedendo da posição que o usuario digitar
    //public static String CortarLista(List<Cartas> lista, List<Cartas> parte1, List<Cartas> parte2, List<Cartas> montecompra) {
    public static List cortarBaralho(List<Cartas> baralho, int posicao) {


        List<Cartas> baralho1 = new ArrayList<Cartas>();

        for (int i = posicao; i < baralho.size(); i++) {
            baralho1.add(baralho.get(i));
        }

        for (int i = 0; i < posicao; i++) {
            baralho1.add(baralho.get(i));
        }

        return baralho1;
    }

    /**
     * 
     * @param montecompra
     * @param maojogador 
     */
    // funcao comprar do monte
    public static Cartas ComprarMonte(List<Cartas> baralho, List<Cartas> maojogador) {

        maojogador.add(baralho.get(0));

        return baralho.remove(0);
    }

    /**
     * 
     * @param monte
     * @param maojogador 
     */
    // funcao comprar do descarte
    public static String ComprarDescarte(List<Cartas> monte, List<Cartas> maojogador) {

        String retorno = " ";
        int posicao;

        posicao = Integer.parseInt(JOptionPane.showInputDialog("digite a posicao da carta a comprada: "));

        for (int i = 0; i < monte.size(); i++) {
            if (i == posicao) {
                maojogador.add(monte.remove(i));
            }
        }
        return retorno = "carta comprada";
    }

    /**
     * 
     * @param montecompra
     * @param monte 
     */
    // funcao que remove do inicio da lista embaralhada ou monte de compra e move para o monte de descarte
    public static void RemoverInicio(List<Cartas> montecompra, List<Cartas> montedescarte) {
        montedescarte.add(montecompra.remove(0));
    }

    /**
     * 
     * @param montecompra
     * @param monte 
     */
    // funcao que remove do fim da lista embaralhada ou monte de compra e move para o monte de descarte
    public static void RemoverFim(List<Cartas> montecompra, List<Cartas> montedescarte) {

        int n = montecompra.size() - 1;

        montedescarte.add(montecompra.remove(n));
    }

    /**
     * 
     * @param montecompra 
     */
    // funcao que passa uma carta do inicio para o fim da lista embaralhada ou monte de compra
    public static void PassarCarta(List<Cartas> montecompra) {

        Cartas temp;

        temp = montecompra.remove(0);

        int n = montecompra.size() - 1;

        montecompra.add(temp);

        System.out.println(temp);
    }

    /**
     * 
     * @param montecompra
     * @return 
     */
    // funcao que atualiza a lista embaralhada ou monte de compra
    public static String AtualizarLista(List<Cartas> montecompra) {
        String retorno = "";

        for (int i = 0; i < montecompra.size(); i++) {
            retorno += "pos -> " + i + " -> " + montecompra.get(i).getNaipe() + " " + montecompra.get(i).getNum() + "\r\n";
        }
        return retorno;
    }

    /**
     * 
     * @param monte
     * @return 
     */
    // funcao que mostra a lista de descarte ou monte
    public static String ListarMonte(List<Cartas> montedescarte) {

        String retorno = "";

        for (int i = 0; i < montedescarte.size(); i++) {
            retorno += "pos -> " + i + " -> " + montedescarte.get(i).getNaipe() + " " + montedescarte.get(i).getNum() + "\r\n";
        }
        return retorno;
    }

    /**
     * 
     * @param maojogador
     * @return 
     */
    // mostra as cartas atualmente na mão do jogador 
    public static String VerMao(List<Cartas> maojogador) {

        String retorno = "";

        for (int i = 0; i < maojogador.size(); i++) {
            retorno += "pos -> " + i + " -> " + maojogador.get(i).getNaipe() + " " + maojogador.get(i).getNum() + "\r\n";
        }
        return retorno;
    }

    /**
     * 
     * @param maojogador
     * @param montedescarte
     * @return 
     */
    // descartar uma carta de cada vez da mão do jogador para o monte de descarte
    public static Cartas Descartar(List<Cartas> maojogador, List<Cartas> montedescarte, int posicao) {

        montedescarte.add(maojogador.get(posicao));

        return maojogador.remove(posicao);
    }

    /**
     * 
     * @param maojogador
     * @param montecompra
     * @param maoadver
     * @return 
     */
    // atribui cartas a mão do jogador adversário e mostra as cartas atualmente na mão do jogador 
    public static String MaoAdver(List<Cartas> maojogador, List<Cartas> baralho, List<Cartas> maoadver) {

        String retorno = " ";

        int num = maojogador.size() - 1;

        for (int i = 0; i < baralho.size(); i++) {
            if (i <= num) {
                maoadver.add(baralho.remove(i));
                retorno += "pos -> " + i + " -> " + maoadver.get(i).getNaipe() + " " + maoadver.get(i).getNum() + "\r\n";
            }
        }
        return retorno;
    }

    /**
     * 
     * @param maojogador
     * @param maoadver
     * @return 
     */
    // ocorre a implementação do jogo de maior carta 
    public static String JogoMaiorCarta(List<Cartas> maojogador, List<Cartas> maoadver) {

        String retorno = " ";

        for (int i = 0; i < maojogador.size(); i++) {
            if (maojogador.get(i).getNum() > maoadver.get(i).getNum()) {
                retorno += "maior carta jogador \n\r";
            } else if (maojogador.get(i).getNum() == maoadver.get(i).getNum()) {
                retorno += "cartas iguais \n\r";
            } else {
                retorno += "maior carta adversario \n\r";
            }
        }
        return retorno;
    }

    /**
     * 
     * @param maojogador
     * @param montedescarte
     * @return 
     */
    // limpa ou remove as cartas atualmente na mão do jogador para o monte de descarte para começar uma nova partida
    public static String LimparMaoJogador(List<Cartas> maojogador, List<Cartas> montedescarte) {

        String retorno = "mão limpa";

        int tam = maojogador.size();
        for (int i = 0; i < tam; i++) {
            montedescarte.add(maojogador.get(i));
        }
        maojogador.removeAll(maojogador);
        return retorno;
    }
}
