package Baralho;

import Exceções.CartaInexistenteException;
import java.util.LinkedList;

/**
 * Classe abstrata que representa um monte do baralho. As posições das cartas do monte são consideradas de baixo para cima.
 * @author Rafael
 */
public abstract class Monte {

    private LinkedList<Carta> cartas;

    /**
     * Inicializa o monte. As cartas que haviam nele são excluídas.
     * @param cartas - Cartas do monte.
     */
    public void initialize(LinkedList<Carta> cartas) {
        this.cartas = cartas;
    }

    /**
     * Adiciona uma carta ao monte.
     * @param carta - Carta a ser adicionda.
     * @return true se a carta foi adicionada ou false caso contrário.
     */
    public boolean addCarta(Carta carta) {
        return this.cartas.add(carta);
    }
    
    /**
     * Adiciona uma carta em uma posição específica do monte.
     * @param carta - Carta a ser adicionada.
     * @param pos - Posição onde a carta será inserida.
     * @throws IndexOutOfBoundsException - caso a posição em que a carta for inserida for fora dos limites do monte (menor que 0 ou maior que o tamanho do baralho). 
     */
    public void addCarta(Carta carta, int pos) throws IndexOutOfBoundsException{
        this.cartas.add(pos,carta);
    }

    /**
     * Remove uma carta do monte.
     * @param carta - Carta a ser removida.
     * @return true se a carta foi removida ou false caso contrário.
     */
    public void removeCarta(Carta carta) throws CartaInexistenteException{
        if (this.cartas.remove(carta))
            throw new CartaInexistenteException("Carta inexistente no monte");
    }
    
    /**
     * Remove uma carta do monte.
     * @param pos - posição da carta que irá ser removida.
     * @return true se a carta foi removida ou false caso contrário.
     */
    public void removeCarta(int pos) throws CartaInexistenteException {
        try{
            this.cartas.remove(pos);
        }catch (IndexOutOfBoundsException ex){
            throw new CartaInexistenteException ("Carta inexistente no monte");
        }
    }

    /**
     * Retorna as cartas do monte.
     * @return - cartas do monte.
     */
    public LinkedList<Carta> listaCartas() {
        return this.cartas;
    }

    /**
     * Retorna a carta de uma posição do monte.
     * @param pos - posição da carta no monte.
     * @return A carta, se ela constar no monte, ou null, caso contrário.
     * @throws CartaInexistenteException - Caso a posição especificada não aponte para uma carta do monte.
     */
    public Carta obtemCarta(int pos) throws CartaInexistenteException{
        try{
            return this.cartas.get(pos);
        }catch (IndexOutOfBoundsException ex){
            throw new CartaInexistenteException ("Carta inexistente no monte");
        }
    }

    /**
     * Retorna uma carta do monte.
     * @param carta - A carta que se deseja obter do monte.
     * @return A carta que se deseja, se ela constar no monte, ou null, caso contrário.
     * @throws CartaInexistenteException - Caso a carta especificada não conste no monte.
     */
    public Carta obtemCarta(Carta carta) throws CartaInexistenteException {
        try{
            return this.cartas.get(this.cartas.indexOf(carta));
        }catch (IndexOutOfBoundsException ex){
            throw new CartaInexistenteException ("Carta inexistente no monte");
        }
    }

    /**
     * Retira todas as cartas do monte.
     */
    public void esvaziaMonte(){
        try{
            this.cartas.clear();
        }catch(Exception x){}
    }
    
    /**
     * Retorna o tamanho do monte.
     * @return tamanho do monte.
     */
    public int tamanho(){
        return this.cartas.size();
    }

}


