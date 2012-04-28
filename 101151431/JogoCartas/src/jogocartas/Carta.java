package jogocartas;

/**
 * Classe que implementa o conceito de uma carta, com número e naipe.
 * @author renanmarceluchoa
 */
public class Carta {
    
    private int numero;
    private String naipe;
    
    /**
     * Método construtor que inicializa a carta com um número e um naipe.
     * 
     * @param numero
     * @param naipe 
     */
    public Carta(int numero, String naipe){
        
        this.numero = numero;
        this.naipe = naipe;
        
    }

    /**
     * Método que retorna o número da carta.
     * 
     * @return 
     */
    public int getNumero(){
        
        return numero;
        
    }
    
    /**
     * Método que retorna o naipe da carta.
     * 
     * @return 
     */
    public String getNaipe(){
        
        return naipe;
        
    }

}
