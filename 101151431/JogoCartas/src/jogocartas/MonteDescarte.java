package jogocartas;

import java.util.ArrayList;

/**
 * Classe que implementa o conceito de um monte de descarte para o jogo de cartas.
 * 
 * @author renanmarceluchoa
 */
public class MonteDescarte {
    
    private ArrayList<Carta> cartas;
    
    /**
     * Método construtor que inicializa o monte de descarte com uma lista vazia de cartas.
     */
    public MonteDescarte(){
        
        cartas = new ArrayList<Carta>();
        
    }

    /**
     * Método que insere uma carta no topo do monte de descarte.
     * 
     * @param carta 
     */
    void insereNoTopo(Carta carta){
        
        cartas.add(carta);
        
        System.out.println("Inserindo carta " + carta.getNumero() + " de " + carta.getNaipe() + " no monte de descarte");
        
    }
    
    /**
     * Método que retira uma carta do topo do monte de descarte.
     * 
     * @return 
     */
    Carta retiraDoTopo() {
        
        Carta carta = cartas.get(0);
        cartas.remove(0);
        
        System.out.println("retirando carta " + carta.getNumero() + " de " + carta.getNaipe() + " do monte de descarte");
        
        return carta;
        
    }
    
    /**
     * Método que retira uma lista de cartas para reposição do baralho do jogo.
     * 
     * @return 
     */
    ArrayList<Carta> obtemCartasReposicao() {
        
        ArrayList<Carta> reposicao = new ArrayList<Carta>();
        
        for(int i=1; i<cartas.size(); i++) {
            reposicao.add(cartas.get(i));
            System.out.println("Repondo carta " + cartas.get(i).getNumero() + " de " + cartas.get(i).getNaipe() + 
                    " do monte de descarte para o baralho.");
            cartas.remove(i);
        }
        
        return reposicao;
        
    }
    
    /**
     * Método que mostra as cartas do monte de descarte para visualizar o conteúdo.
     */
    public void mostraCartas(){
        
        for(Carta carta : cartas){
            System.out.println(carta.getNumero()+" "+carta.getNaipe());
            System.out.println("fim");
        }
        
    }
    
    /**
     * Método que retorna o número de cartas existentes no monte de descarte.
     * 
     * @return 
     */
    public int getNumCartas() {
    
        return this.cartas.size();
    
    }
    
}
