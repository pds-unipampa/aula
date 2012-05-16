/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import Baralho.*;
import Exceções.CartaInexistenteException;
import java.util.*;

/**
 * Simples simulação de uma rodada de truco. Apenas para demonstrar a comparação de carta do baralho.
 * @author Rafael
 */
public class Jogo {
    
    private Jogador j1;
    
    private Jogador j2;
    
    private Baralho baralho;
    
    private ComparacaoTruco ct;
    
    Scanner scn = new Scanner(System.in);
    
    /**
     * Configura os jogadors, inicia o baralho de truco e começa o jogo.
     * @param j1 Jogador 1
     * @param j2 Jogador 2
     */
    public Jogo(Jogador j1, Jogador j2){
        this.j1 = j1;
        this.j2 = j2;
        
        inicializaBaralho();
        iniciaJogo();
    }
    
    /**
     * Inicia o baralho de truco. 40 cartas. Excetua-se 8, 9 e 10.
     */
    private void inicializaBaralho(){
        Monte principal = new MonteComum();
        MonteDescarte descarte = new MonteDescarte();
        
        List<Integer> sequencia = new ArrayList<Integer>();
        
        for(int i = 1; i <=13;i++){
            switch(i){
                case 8: continue;
                case 9: continue;
                case 10: continue;
            }
            
            sequencia.add(i);
        }
        
        this.ct = new ComparacaoTruco(new Carta(1, Naipe.ESPADAS));
        
        this.baralho = new Baralho(principal, descarte, ct, sequencia);
        
    }
    
    /**
     * Começa o jogo (rodada de truco). Embaralha e solicita o corte do baralho e distribui as cartas.
     * Simula 3 mãos de jogo, onde a cada mão, cada jogador deve jogar uma carta. Mostra quem venceu a rodada.
     */
    private void iniciaJogo(){
        
        baralho.embaralhar();
        
        solicitaCorte();
        
        Carta vira = baralho.retirarCartaDoFim();
        ct.setCartaVira(vira);
        System.out.println("\n Vira da rodada: " + vira);
        baralho.setComparacao(ct);
        
        distribuiCartas(j1);
        distribuiCartas(j2);
        
        do{
            System.out.println("\n Jogador 1 - " + j1.getNome() + " Joga!");
            j1.imprimeCartas();
            Carta cj1 = solicitaCarta(j1);
            System.out.println("Carta jogada - " + cj1);
            
            System.out.println("\n Jogador 2 - " + j2.getNome() + " Joga!");
            j2.imprimeCartas();
            Carta cj2 = solicitaCarta(j2);
            System.out.println("Carta jogada - " + cj2);
            
            if(cj1.comparaCarta(cj2) == true){
                j1.addPontosMao();
                System.out.println("\n Jogador 1 - " + j1.getNome() + " Venceu a mão!");
            }else{
                j2.addPontosMao();
                System.out.println("Jogador 2 - " + j2.getNome() + " Venceu a mão!");
            }
            
            
        }while(j1.getPontosMao()<2 && j2.getPontosMao()<2);
        
        System.out.println("\n Fim da rodada!");
        
        if(j1.getPontosMao() == 2)
            System.out.println("Jogador 1 - " + j1.getNome() + " Venceu!");
        else
            System.out.println("Jogador 2 - " + j2.getNome() + " Venceu!");
        
    }
    
    /**
     * Informa randomicamente qual jogadors deve cortar o baralho e solicita que ele corte.
     * Enquanto o corte não válido, continua solicitando que ele informe o corte.
     */
    private void solicitaCorte(){
        int x = (int)Math.floor(Math.random() * 2);
        
        switch(x){
            case 0:{ System.out.println("Jogador 1 - " + j1.getNome() + " , corte o baralho");
                     System.out.println("Para cortar informe de qual posição até qual posição das cartas deseja cortar (1-40)");
                     break;
            }
            default:{ System.out.println("Jogador 2 - " + j2.getNome() + " , corte o baralho");
                     System.out.println("Para cortar informe de qual posição até qual posição das cartas deseja cortar (1-40)");
            }
        }
        
        recebeCorte();
    }
    
    /**
     * Recebe as entradas do corte: posição inicial (onde começa o corte) e a posição final (onde termina o corte).
     */
    private void recebeCorte(){
        boolean v;
        
        do{
            try{
                System.out.println("Posição inicial: ");
                int ini = leEntrada();
                System.out.println("Posição final: ");
                int fim = leEntrada();
                baralho.cortar(ini, fim);
                v = true;
            }catch(CartaInexistenteException cie){
                System.out.println("Posição inválida do baralho! (1-40)");
                v = false;
            }
        }while(!v);
        
    }
    
    /**
     * Lê e valida uma entrada numérica através do Scanner.
     * @return 
     */
    private int leEntrada(){
        boolean v = true;
        do{
            try{
                return scn.nextInt();
            }catch(InputMismatchException ime){
                System.out.println("Entrada inválida! Somente números.");
                v = false;
            }catch(NoSuchElementException nsee){
                System.out.println("Deve ser inserido um valor!");
                v = false;
            }finally{
                scn = new Scanner(System.in);
            }
        }while(!v);
        
        return 0;
    }
    
    /**
     * Adiciona três cartas para o jogador.
     * @param j Jogador que receberá as cartas.
     */
    private void distribuiCartas(Jogador j){
        for(int i = 0; i<3; i++){
            j.addCarta(baralho.retirarCartaDoFim());
        }
    }
    
    
    /**
     * Solicita que o jogador jogue uma de suas cartas. 
     * Ele deverá informar a posição da qual que deseja jogar em sua lista de cartas.
     * O sistema irá solicitar a carta até que ele informe uma posição válida.
     * @param j Jogador que irá jogar a carta.
     * @return Carta que o jogador jogou.
     */
    private Carta solicitaCarta(Jogador j){
        scn = new Scanner(System.in);
        boolean v;
        
        
        System.out.println("Informe a posição da carta a ser jogada!");
        
        do{
            try{
                Carta c = j.jogarCarta(leEntrada());
                v = true;
                return c;
            }catch(IndexOutOfBoundsException iooe){
                System.out.println("Não existe carta nessa posição. Informe outra!");
                v = false;
            }
        }while(!v);
        
        return null;
    }
    
}
