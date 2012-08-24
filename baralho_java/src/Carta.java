/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Nasser Rahman 101151428
 * @author Giovanni Pereira Garcia  111150199
 */
public class Carta {

    private Valor valor;
    private Naipe naipe;

    /**
     * 
     */
    public Carta() {
    }

    
    /**
     * 
     * @param v
     * @param n
     */
    public Carta(Valor v, Naipe n) {
        this.setNaipe(n);
        this.setValor(v);
    }

    @Override
    public String toString() {
        return valor + " " + naipe ;
    }
    
    /**
     * 
     * @return
     */
    public Naipe getNaipe() {
        return naipe;
    }

    /**
     * 
     * @param n
     */
    public void setNaipe(Naipe n) {
        this.naipe = n;
    }

    /**
     * 
     * @return
     */
    public Valor getValor() {
        return valor;
    }

    /**
     * 
     * @param valor
     */
    public void setValor(Valor valor) {
        this.valor = valor;
    }
    
    

}
