/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceções;

/**
 *
 * @author rafael
 */
public class SequenciaInvalidaException extends RuntimeException{
    
    public SequenciaInvalidaException(String s){
        super(s);
    }
    
    @Override
    public String getMessage(){
        return "A sequência de cartas informada contém valores que não são válidos em um baralho";
    }
}
