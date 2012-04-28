package jogocartas;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jogocartas.exception.InvalidNumberException;

/**
 * Classe responsável por gerenciar o funcionamento de qualquer jogo de baralho que utilize a API.
 * 
 * @author renanmarceluchoa
 * @version 0.1
 */
public class Jogo {
    
    private Baralho baralho;
    private MonteDescarte monteDescarte;
    private ArrayList<Mao> jogadores;
    
    /**
     * Método construtor que recebe um Baralho e o número de jogadores, definidos pela aplicaçAo cliente.
     * 
     * @param baralho
     * @param jogadores 
     */
    public Jogo(Baralho baralho, int jogadores) {
        
        this.baralho = baralho;
        this.monteDescarte = new MonteDescarte();
        this.jogadores = new ArrayList<Mao>();
        
        for(int i=0; i<jogadores; i++) {
            this.jogadores.add(new Mao(i));
        }
        
        System.out.println("Iniciando jogo para " + jogadores + " jogadores");
        
    }
    
    /**
     * Método que embaralha as cartas do baralho, executando um método de shuffle na Collection das cartas.
     */
    public void embaralharCartas() {
        
        this.baralho.embaralha();
        
        System.out.println("Jogo embaralhando as cartas...");
        
    }
    
    /**
     * Método que corta o baralho em dois, a partir de um índice de corte, 
     * reagrupando-o novamente, com o baralho de baixo sobre o baralho de cima.
     * 
     * @param numero
     * @throws InvalidNumberException 
     */
    public void cortarBaralho(int numero) throws InvalidNumberException {
    
        this.baralho.corta(numero);
        
        System.out.println("Baralho cortado");
        
    }
    
    /**
     * Método que alimenta as mãos dos jogadores com um determinado número de cartas para iniciar o jogo,
     * e retorna uma lista com as mãos e suas cartas.
     * 
     * @param numero
     * @return 
     */
    public ArrayList<Mao> darAsCartas(int numero) {
        
        System.out.println("Dando as cartas...");
        
        for(int i=0; i<numero; i++) {
                
            for(int j=0; j<jogadores.size(); j++) {
                jogadores.get(j).compraDoTopo(this.baralho);
            }
            
        }
        
        return jogadores;
        
    }
    
    public void jogar(Mao jogador) {
        
        monteDescarte.insereNoTopo(baralho.retiraDoTopo());
        
        if(baralho.getNumCartas() == 0) {
            this.reporBaralho();
        }
        
        int opcao = (int) Math.random() * 4;
        
        try {
        
            switch(opcao) {
            
                case 0: jogador.compraDoTopo(this.baralho);
                        break;

                case 1: jogador.compraDoTopo(this.baralho);
                        jogador.descarta(this.monteDescarte, (int) Math.random() * (jogador.getNumCartas() - 1));
                        break;

                case 2: jogador.compraDoLixo(this.monteDescarte);
                        jogador.descarta(this.monteDescarte, (int) Math.random() * (jogador.getNumCartas() - 1));
                        break;

                case 3: int quantidade = 1 + (int) Math.random() * 3;

                        for(int n=0; n<quantidade; n++) {
                            jogador.compraDoTopo(this.baralho);
                            jogador.descarta(this.monteDescarte, (int) Math.random() * (jogador.getNumCartas() - 1));

                            if(this.baralho.getNumCartas() == 0) {
                                this.reporBaralho();
                            }

                        }

                        break;
                        
            }
                    
        } catch(IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Método que repõe uma quantidade de cartas do monte de descarte informado.
     * 
     * @param descarte 
     */
    public void reporBaralho() {
        
        this.baralho.reporCartas(this.monteDescarte.obtemCartasReposicao());
        this.embaralharCartas();
        
        System.out.println("Repondo as cartas do monte de descarte no baralho");
            
    }
    
    /**
     * Método que retorna o baralho do jogo.
     * 
     * @return 
     */
    public Baralho getBaralho() {
        
        return this.baralho;
        
    }
    
    /**
     * Método que retorna o monte de descartes do jogo.
     * 
     * @return 
     */
    public MonteDescarte getMonteDescarte() {
        
        return this.monteDescarte;
        
    }
    
    public static void main(String[] args) {
        
        try {
            
            int numJogadores = 4;
            int numCartas = 52;
            int numCartasMao = 5;
            String[] naipes = new String[] {"espadas", "ouros", "paus", "copas"};
            Baralho baralho = new Baralho(numCartas, naipes);
            
            System.out.println("Criando um baralho com 52 cartas de espadas, ouros, paus e copas");
            
            Jogo jogo = new Jogo(baralho, numJogadores);
            
            jogo.embaralharCartas();
            jogo.cortarBaralho(15);
            ArrayList<Mao> jogadores = jogo.darAsCartas(numCartasMao);
            
            boolean vitoria = false;
            
            while(!vitoria) {
            
                for(int i=0; i<jogadores.size(); i++) {
                    
                    Mao jogador = jogadores.get(i);
                    
                    jogo.jogar(jogador);
                                
                    if(jogador.getNumCartas() == 0) {
                        vitoria = true;
                        System.out.println("Vitória!!!");
                        System.out.println("Jogador " + jogador.getJogador() + " bateu o jogo");
                    }
                
                }
                
            }
            
            
        } catch (InvalidNumberException ex) {
            
            Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            
        }
    
    }
    
}
