package Baralho;

import java.util.LinkedList;

/**
 * Monte de descarte do baralho. Com ele é possível ver cartas sem que sejam retiradas do monte.
 * @author pc
 */
public class MonteDescarte extends Monte {

    /**
     * Método construtor. Chama initialize da classe monte.
     * @param cartas - Cartas iniciais do monte.
     */
    public MonteDescarte(LinkedList<Carta> cartas){
        super.initialize(cartas);
    }
    
    public MonteDescarte(){
        super.initialize(new LinkedList<Carta>());
    }
    
    /**
     * Exibe os dados da carta.
     * @param carta - carta a ser exibida.
     */
    public void exibirCarta(Carta carta) {
        imprimirCarta(super.obtemCarta(carta));
    }

    /**
     * Exibe os dados da carta.
     * @param pos - posição no monte da carta que se deseja exibir.
     */
    public void exibirCarta(int pos) {
        imprimirCarta(super.obtemCarta(pos));
    }
    
    /**
     * Confere se a carta que se está tentando exibir não é nula. 
     * Caso não for será exibida, e se for mostratá uma mensagem informando que não existe a carta.
     * @param carta - carta a ser impressa.
     */
    private void imprimirCarta(Carta carta){
        try{
            carta.toString();
        }catch(NullPointerException ex){
            System.err.println("Carta inexistente no monte de descarte");           
        } 
    }

}
