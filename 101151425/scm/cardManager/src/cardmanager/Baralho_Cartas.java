/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cardmanager;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Juliano Rodovalho & Lucas Capanelli
 */
public class Baralho_Cartas {

    private ArrayList<Carta> cartas;
    /**
     * Metodo que cria o baralho
     *
     * @param numCartas
     * @param naipes
     */
    public void Baralho_Cartas(int numCartas, String[] naipes) {

        this.cartas = new ArrayList<>();
        this.newBaralho(naipes);

    }

    public void newBaralho(String[] naipes) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cartas.add(new Carta(j, naipes[i]));
            }
        }
    }

    /**
     * Método responsável por embaralhar o montante de cartas
     */
    public void embaralha() {

        Collections.shuffle(cartas);

    }

    /**
     * Método que retorna o número de cartas existentes no baralho.
     *
     * @return
     */
    int getNumCartas() {

        return this.cartas.size();

    }

    public void getBaralho() {

        for (Carta carta : cartas) {
            System.out.println(carta.getNumCarta() + 1 + " " + carta.getNaipeCarta());
        }
    }
}