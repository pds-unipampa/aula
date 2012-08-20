package Jogo;

import Baralho.Carta;
import Baralho.ComparaCartas;

/**
 * Comparação de cartas de acordo com as regras do truco.
 * @author Rafael
 */
public class ComparacaoTruco implements ComparaCartas {


    private Carta cartaVira;
    
    private int valorMando;
    
    public ComparacaoTruco(Carta cartaVira){
        
        this.setCartaVira(cartaVira);
    }
    
    /**
     * Seguindo as regras do truco, compara duas cartas, e informa qual é a maior.
     * @param carta1 - Carta 1 da comparação.
     * @param carta2 - Carta 2 da comparação.
     * @return true se a carta 1 tiver peso maior, ou false caso contrário.
     */
    @Override
    public boolean eMaior(Carta carta1, Carta carta2) {
        int pesoCarta1 = pesoTruco(carta1);
        int pesoCarta2 = pesoTruco(carta2);
        
        return pesoCarta1 > pesoCarta2;
    }
    
    /**
     * Atribui peso maior para cartas que são consideradas mais "fortes" no truco. São elas: A, 2, 3.
     * Ou então a "carta vira" que determina qual carta será a "mais forte" do jogo. Sempre é a carta de valor seguinte ao da " carta vira".
     * @param carta - Carta a qual será atribuído o peso.
     * @return - peso da carta (getPesoCarta()) multiplicado pelos valores seguintes do baralho. Por exemplo: A (1) * 14, 2 * 15...
     */
    private int pesoTruco(Carta carta){
        if (carta.getValor() == valorMando)
            return carta.getPesoCarta() * 17;
        
        if (carta.getValor() == 1)
            return carta.getPesoCarta() * 14;
        else if (carta.getValor() == 2)
            return carta.getPesoCarta() * 15;
        else if (carta.getValor() == 3)
            return carta.getPesoCarta() * 16;
        else
            return carta.getPesoCarta();
        
    }

    /**
     * @return carta Vira.
     */
    public Carta getCartaVira() {
        return cartaVira;
    }

    /**
     * @param cartaVira Atribui a carta vira.
     */
    public void setCartaVira(Carta cartaVira) {
        this.cartaVira = cartaVira;
        
        if(cartaVira.getValor() == 13)
            this.valorMando = 1;
        else
            this.valorMando = cartaVira.getValor() + 1;
    }

}
