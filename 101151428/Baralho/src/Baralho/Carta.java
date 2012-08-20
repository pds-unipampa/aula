/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Baralho;

/**
 *
 * @author nasser
 */
public class Carta {

    private Valor valor;
    private Naipe naipe;

    public Carta() {
    }

    
    public Carta(Valor v, Naipe n) {
        this.setNaipe(n);
        this.setValor(v);
    }

    @Override
    public String toString() {
        return valor + " " + naipe ;
    }
    
    public Naipe getNaipe() {
        return naipe;
    }

    public void setNaipe(Naipe n) {
        this.naipe = n;
    }

    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }
    
    

}
