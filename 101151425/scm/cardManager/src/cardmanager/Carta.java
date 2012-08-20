/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cardmanager;

/**
 * @author Juliano Rodovalho & Lucas Capanelli
 */
class Carta {

    private int numCarta;
    private String naipeCarta;

    /**
     * Construtor da classe CartaBara
     *
     * @param numeroCarta
     * @param naipes
     */
    public Carta(int numeroCarta, String naipes) {

        numCarta = numeroCarta;
        naipeCarta = naipes;

    }

    public int getNumCarta() {

        return numCarta;
    }

    public String getNaipeCarta() {

        return naipeCarta;
    }

    public void setNumCarta(int numeroCarta) {

        this.numCarta = numeroCarta;
    }

    public void setNaipeCarta(String naipes) {

        this.naipeCarta = naipes;
    }
}
