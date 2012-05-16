package Baralho;
/**
 * Interface responsável pela comparação das cartas.
 * @author Rafael
 */
public interface ComparaCartas {

    /**
     * Compara duas cartas pra saber se uma é maior do que a outra.
     * @param carta1 - Carta 1 da comparação.
     * @param carta2 - Carta 2 da comparação.
     * @return true - se a carta 1 tiver peso maior.
     * false - se a carta 2 tiver peso menor.
     */
    public boolean eMaior(Carta carta1, Carta carta2);

}
