/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.deck;

/**
 *
 * @author Helison Teixeira
 * @author  Bruno Vicelli
 */
public class Carta {

    private String naipe;
    private String numero;

    public Carta(String naipe, String numero) {
        this.naipe = naipe;
        this.numero = numero;
    }

    public Carta(String naipe) {
        this.naipe = naipe;

    }

    public String getnaipe() {
        return naipe;
    }

    public String getNumero() {
        return numero;
    }

    public void setnaipe(String naipe) {
        this.naipe = naipe;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
