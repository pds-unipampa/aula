package Baralho;

import java.util.LinkedList;

/**
 * Monte comum de cartas.
 * @author Rafael
 */
public class MonteComum extends Monte {

    /**
     * Método construtor. Chama initialize da classe monte.
     * @param cartas - Cartas iniciais do monte.
     */
    public MonteComum (LinkedList<Carta> cartas){
        super.initialize(cartas);
    }
    
    public MonteComum(){
        super.initialize(new LinkedList<Carta>());
    }
}
