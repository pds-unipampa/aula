/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceções;

/**
 *
 * @author pc
 */
public class CartaInvalidaException extends RuntimeException {
    
    private int valorCarta;
    private String naipeCarta;
    
    public CartaInvalidaException(String s, int valorCarta, String naipeCarta){
        super(s);
        this.valorCarta = valorCarta;
        this.naipeCarta = naipeCarta;
    }
    
    @Override
    public String getMessage(){
        return "Carta - Valor: " + valorCarta + " Naipe: " + naipeCarta;
    }
    
    
}
