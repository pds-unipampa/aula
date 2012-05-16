package Baralho;

import Exceções.CartaInvalidaException;

/**
 * Classe representativa de uma carta de baralho.
 * Possui um valor (1,2,...,13) e um naipe (ouros, espadas, copas ou paus).
 * @author Rafael
 */
public class Carta {

    private int valor;

    private Naipe naipe;

    private ComparaCartas comparacao;

    /**
     * Construtor da classe carta. Lança uma exceção caso o valor da carta seja inválido. Por exemplo, valor 14 ou 0.
     * @param valor - Valor da carta (1 à 13).
     * @param naipe - Naipe da carta (ouros, espadas, copas e paus).
     * @throws CartaInvalidaException - Exceção lançada caso o valor da carta seja inválido.
     */
    public Carta(int valor, Naipe naipe) throws CartaInvalidaException{
        if (valor <= 0 || valor > 13)
            throw new CartaInvalidaException ("Não existe carta desse valor para este baralho", valor, naipe.toString());
        else
            this.valor = valor;

        this.naipe = naipe;
        
        this.comparacao = new ComparacaoSimples();
    }
    
    /**
     * Construtor da classe carta. Lança uma exceção caso o valor da carta seja inválido. Por exemplo, valor 14 ou 0.
     * @param valor - Valor da carta (1 à 13).
     * @param naipe - Naipe da carta (ouros, espadas, copas e paus).
     * @param cp - Forma de comparação das cartas.
     * @throws CartaInvalidaException - Exceção lançada caso o valor da carta seja inválido.
     */
    public Carta(int valor, Naipe naipe, ComparaCartas cp) throws CartaInvalidaException{
        this(valor,naipe);
        
        this.comparacao = cp;
    }

    /**
     * Retorna o valor da carta.
     * @return valor - valor da carta. 
     */
    public int getValor() {
        return this.valor;
    }

    /**
     * Retorna o naipe da carta.
     * @return naipe - naipe da carta.
     */
    public Naipe getNaipe() {
        return this.naipe;
    }

    /**
     * Atribui a forma de comparar uma carta com outra. Pode variar de acordo com o jogo que as cartas estão sendo usadas.
     * @param cp - Objeto responsável por comparar as cartas.
     */
    public void setComparaCartas(ComparaCartas cp){
        this.comparacao = cp;
    }
    
    /**
     * Calcula o peso da carta de acordo com seu valor e naipe.
     * @return pc - peso da carta.
     */
    private int pesoCarta(){
        int valorNaipe = 0;

        try{
            valorNaipe = naipe.peso();
        }catch(Exception x){}

        String pc = "" + this.valor + valorNaipe;

        return Integer.parseInt(pc); 
    }
    
    /**
     * Retorna o peso da carta.
     * @return peso da carta.
     */
    public int getPesoCarta(){
        return this.pesoCarta();
    }

    /**
     * HashCode do objeto (carta). Baseado no peso da carta.
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        return this.pesoCarta();
    }

    /**
     * Equals de Object sobreposto. Duas cartas são iguais se possuírem o mesmo valor e naipe.
     * @param o - Object.
     * @return - true se iguais ou false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        return (o instanceof Carta && (
                ((Carta) o).getNaipe().equals(this.getNaipe()) 
                && ((Carta) o).getValor() == this.getValor()
                ));
    }

    /**
     * toString de Object sobreposto. "Carta - " + valor + " " + naipe". O valor pode ser a letra correspondente a carta.
     * @return String - Breve descrição da carta.
     */
    @Override
    public String toString() {
        String valorCarta = "";

        switch(this.getValor()){
            case 1: valorCarta = "A";
                break;
            case 11: valorCarta = "Q";
                break;
            case 12: valorCarta = "J";
                break;
            case 13: valorCarta = "K"; 
                break;
            default: valorCarta = String.valueOf(this.getValor());
        }

        return "Carta - " + valorCarta + " " + this.getNaipe();
    }
    
    /**
     * Compara com outra carta. 
     * @param carta - Carta a ser comparada.
     * @return true - Caso a carta com a qual está sendo comparada tiver peso menor ou igual.
     * false - Caso a carta com a qual está sendo comparada tiver peso maior.
     */
    public boolean comparaCarta(Carta carta){
        return comparacao.eMaior(this, carta);
    }

}
