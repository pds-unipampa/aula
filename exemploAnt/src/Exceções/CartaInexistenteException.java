/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceções;

/**
 *
 * @author pc
 */
public class CartaInexistenteException extends RuntimeException{
    
    public CartaInexistenteException(String s){
        super(s);
    }
    
    @Override
    public String getMessage(){
        return "A carta que você está tentando acessar não existe neste monte";
    }
    
}
