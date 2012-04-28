/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogocartas;

import java.util.ArrayList;

/**
 * Classe que implementa o conceito da mão do jogador, com uma lista de cartas com as quais ele irá jogar.
 * 
 * @author renanmarceluchoa
 */
public class Mao {
    
    private int jogador;
    private ArrayList<Carta> cartas;
    
    /**
     * Método construtor que incializa a mão com um identificador do jogador.
     * 
     * @param jogador 
     */
    public Mao(int jogador) {
        
        this.jogador = jogador;
        this.cartas = new ArrayList<Carta>();
    
    }
    
    /**
     * Método responsável por comprar uma carta do topo de baralho.
     * 
     * @param baralho 
     */
    public void compraDoTopo(Baralho baralho) {
        Carta carta = baralho.retiraDoTopo();
        this.cartas.add(carta);
        System.out.println("Jogador " + jogador + " compra um " + carta.getNumero() + " de " + carta.getNaipe());
        
    }
    
    /**
     * Método responsável por comprar uma determinada quantidade de cartas do topo do baralho.
     * 
     * @param baralho
     * @param quantidade 
     */
    public void compraCartasDoTopo(Baralho baralho, int quantidade) {
        
        for(int i=0; i<quantidade; i++) {
            Carta carta = baralho.retiraDoTopo();
            this.cartas.add(carta);
            System.out.println("Jogador " + jogador + " compra um " + carta.getNumero() + " de " + carta.getNaipe());
        }
        
    }
    
    /**
     * Método responsável por comprar uma carta do fim do baralho.
     * 
     * @param baralho 
     */
    public void compraDoFim(Baralho baralho) {
        
        Carta carta = baralho.retiraDoFim();
        this.cartas.add(carta);
        System.out.println("Jogador " + jogador + " compra um " + carta.getNumero() + " de " + carta.getNaipe() + " do fim do baralho");
        
    }
    
    /**
     * Método responsável por comprar uma determinada quantidade de cartas do fim do baralho.
     * 
     * @param baralho
     * @param quantidade 
     */
    public void compraCartasDoFim(Baralho baralho, int quantidade) {
        
        for(int i=0; i<quantidade; i++) {
            Carta carta = baralho.retiraDoFim();
            this.cartas.add(carta);
            System.out.println("Jogador " + jogador + " compra um " + carta.getNumero() + " de " + carta.getNaipe() + " do fim do baralho");
        }
        
    }
    
    /**
     * Método responsável por descartar uma carta no monte de descarte a partir de um índice.
     * 
     * @param monte
     * @param numero 
     */
    public void descarta(MonteDescarte monte, int numero) {
        
        Carta carta = cartas.get(numero);
        monte.insereNoTopo(carta);
        cartas.remove(numero);
        System.out.println("Jogador " + jogador + " descarta um " + carta.getNumero() + " de " + carta.getNaipe());
        
    }
    
    /**
     * Método responsável por descartar um determinado conjunto de cartas, a partir de um array de indices.
     * 
     * @param monte
     * @param numCartas 
     */
    public void descartaVarias(MonteDescarte monte, int[] numCartas) {
        
        for(int i=0; i<numCartas.length; i++) {
            Carta carta = this.cartas.get(numCartas[i]);
            monte.insereNoTopo(carta);
            this.cartas.remove(numCartas[i]);
            System.out.println("Jogador " + jogador + " descarta um " + carta.getNumero() + " de " + carta.getNaipe());
        }
        
    }
    
    /**
     * Método responsável por comprar uma carta do topo do monte de descarte.
     * 
     * @param monte 
     */
    public void compraDoLixo(MonteDescarte monte) {
        
        Carta carta = monte.retiraDoTopo();
        this.cartas.add(carta);
        System.out.println("Jogador " + jogador + " compra um " + carta.getNumero() + " de " + carta.getNaipe() + " do monte de descarte");
        
    }
    
    /**
     * Método que retorna o identificador do jogador.
     * 
     * @return 
     */
    public int getJogador() {
        
        return this.jogador;
        
    }
    
    /**
     * Método que retorna o número de cartas existentes na mao do jogador.
     * 
     * @return 
     */
    public int getNumCartas() {
        
        return this.cartas.size();
        
    }
    
}
