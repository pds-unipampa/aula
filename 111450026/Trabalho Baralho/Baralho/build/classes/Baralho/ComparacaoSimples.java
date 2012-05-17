package Baralho;

/**
 * Comparação simples des cartas. 
 * @author Rafael
 */
public class ComparacaoSimples implements ComparaCartas {


    /**
     * Comparação simples para saber se uma carta tem peso maior que outra.
     * @param carta1 - Carta 1 para comparação.
     * @param carta2 - Carta 2 para comparação.
     * @return true - se a carta 1 tiver peso maior que a carta 2.
     * false - se a carta 1 tiver peso menor ou igual que a carta 2.
     */
    @Override
    public boolean eMaior(Carta carta1, Carta carta2) {
        return carta1.getPesoCarta() > carta2.getPesoCarta();
    }

}
