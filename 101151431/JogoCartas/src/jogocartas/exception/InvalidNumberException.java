/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogocartas.exception;

import java.util.InvalidPropertiesFormatException;

/**
 *
 * @author renanmarceluchoa
 */
public class InvalidNumberException extends InvalidPropertiesFormatException {
    
    public InvalidNumberException(String message) {
        
        super(message);
        
    }
    
    public String getMessage() {
        
        return super.getMessage();
        
    }
    
}
