package baralho;

/**
 *
 * @author Nasser Rahman 101151428
 * @author Ricardo Burg Machado
 * @author Rafael Fernando dos Santos
 * @author Giovanni Garcia
 * @author Mateus Dal Forno
 * @author Bruno Segui
 * @author Isabel Boaventura
 * @author Rafhael Cunha
 */

/**
 * Classe Carta com os construtores valor e naipe para inicializar 
 * @author Greicy
 */
public class Carta {

    private Valor valor;
    private Naipe naipe;

    /**
     * 
     */
    public Carta() {
    }

    
    /**
     * construtor inicializa naipe com n como argumento
     * construtor inicializa valor com v como argumento
     * @param v
     * @param n
     */
    public Carta(Valor v, Naipe n) {
        this.setNaipe(n);
        this.setValor(v);
    }

    @Override
    public String toString() {
        return valor + " " + naipe ;
    }
    
    /**
     * metodo que recupera o naipe
     * @return
     */
    public Naipe getNaipe() {
        return naipe;
    }

    /**
     * metodo que configura o naipe
     * @param n
     */
    public void setNaipe(Naipe n) {
        this.naipe = n;
    }

    /**
     * metodo que recupera o valor 
     * @return
     */
    public Valor getValor() {
        return valor;
    }

    /**
     * metodo que configura o valor
     * @param valor
     */
    public void setValor(Valor valor) {
        this.valor = valor;
    }
    
    

}
