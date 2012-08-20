/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import Baralho.Carta;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe que representa um jogador de truco. Há poucas funcionalidades.
 * @author Rafael
 */
public class Jogador {
    
    private String nome;
    
    private List<Carta> cartas;
    
    private int pontosMao;
    
    
    /**
     * @param nome Nome do jogador.
     */
    public Jogador(String nome){
        this.nome = nome;
        this.cartas = new LinkedList<Carta>();
        this.pontosMao = 0;
    }
    
    /**
     * 
     * @param nome Nome do jogador 
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * @return Nome do jogador.
     */
    public String getNome(){
        return this.nome;
    }
    
    /**
     * @param c Carta à ser adicionada para o jogador.
     */
    protected void addCarta(Carta c){
        this.cartas.add(c);
    }
    
    /**
     * Retira uma carta do jogador.
     * @param pos Posição de onde a carta será retirada.
     * @return Carta - Carta retirada.
     * @throws IndexOutOfBoundsException Caso a posição especificada não seja válida.
     */
    public Carta jogarCarta(int pos) throws IndexOutOfBoundsException{
        Carta c = cartas.get(pos-1);
        cartas.remove(pos-1);
        
        return c;
    }
    
    /**
     * Adiciona um ponto conquistado numa mão do jogo.
     */
    protected void addPontosMao(){
        this.pontosMao += 1;
    }
    
    /**
     * @return Quantidade de pontos conquistados em mãos de jogo.
     */
    public int getPontosMao(){
        return this.pontosMao;
    }
    
    /**
     * Mostra na tela as cartas do jogador.
     */
    public void imprimeCartas(){
        int x = 1;
        
        for(Carta c: cartas){
            System.out.println(x + " - " + c.toString());
            x++;
        }
    }
}
