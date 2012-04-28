package jogocartas;

import java.util.ArrayList;
import java.util.Collections;
import jogocartas.exception.InvalidNumberException;

/**
 * Classe que implementa o conceito de um baralho que deve estar relacionado a um Jogo de Cartas,
 * para oferecer funcionalidades de embaralhar, cortar, inserir e retirar cartas.
 * 
 * @author renanmarceluchoa
 */
public class Baralho {

    private ArrayList<Carta> cartas;

    /**
     * Método construtor que inicia um baralho a partir de um determinado número de cartas e um array de naipes.
     * 
     * @param numero
     * @param naipes
     * @throws InvalidNumberException 
     */
    public Baralho(int numero, String[] naipes) throws InvalidNumberException{
        
        this.cartas = new ArrayList<Carta>();
        this.criaBaralho(numero, naipes);
    
    }
    
    /**
     * Método responsável pela criação do baralho, validando o número de cartas com número de naipes
     * 
     * @param numero
     * @param naipes
     * @throws InvalidNumberException 
     */
    void criaBaralho(int numero, String[] naipes) throws InvalidNumberException {
        
        if(numero <= 0){
            
            String message = "O número de cartas do baralho deve ser maior do que zero";
            throw new InvalidNumberException(message);
            
        }

        else{
            
            if(numero%naipes.length != 0) {
                
                String message = "O numero de cartas deve ser múltiplo de 4 devido ao número de naipes";
                throw new InvalidNumberException(message);
            
            }
            
            else {
                
                System.out.println("criando baralho de " + numero + " cartas");
                
                for(int j=0; j<naipes.length; j++) {
                
                    for(int i=0; i<numero/naipes.length; i++){
                        cartas.add(new Carta(i+1, naipes[j]));
                    }
                
                }
                
            }
            
        }
        
    }
    
    /**
     * Método que implementa o embaralhamento das cartas do baralho.
     */
    void embaralha(){
        
        Collections.shuffle(cartas);
        
    }

    /**
     * Método que implementa o corte do baralho, validando se o número de corte é um número válido para o baralho.
     * 
     * @param valor
     * @throws InvalidNumberException 
     */
    void corta(int valor) throws InvalidNumberException{
        
        if(valor <= 0){
            String message = "O número de corte deve ser maior que zero";
            throw new InvalidNumberException(message);
        }

        if(valor > cartas.size()){
            String message = "O número de corte deve ser menor que o número de cartas";
            throw new InvalidNumberException(message);
        }

        else{
            
            System.out.println("Cortando o baralho em dois...");
            
            ArrayList<Carta> temp = new ArrayList<Carta>();
        
            for(int i=valor; i<cartas.size(); i++) {
                temp.add(cartas.get(i));
            }
            
            for(int i=0; i<valor; i++) {
                temp.add(cartas.get(i));
            }
        
            Collections.copy(cartas, temp);
            
        }
        
    }
    
    /**
     * Método que retira uma carta do topo do baralho e retorna a carta para a aplicação.
     * 
     * @return 
     */ 
    Carta retiraDoTopo(){
        
        Carta carta = cartas.get(0);
        cartas.remove(0);
        
        System.out.println("Retirando a carta " + carta.getNumero() + " de " + carta.getNaipe() + " do topo.");
        
        return carta;
        
    }
    
    /**
     * Método que retira uma cara do fim do baralho e retorna para a aplicação.
     * 
     * @return 
     */
    Carta retiraDoFim(){
        
        Carta carta = cartas.get(cartas.size()-1);
        cartas.remove(cartas.size()-1);
        
        System.out.println("Retirando a carta " + carta.getNumero() + " de " + carta.getNaipe() + " do fim do baralho.");
        
        return carta;
        
    }
    
    /**
     * Método que retorna o número de cartas existentes no baralho.
     * 
     * @return 
     */
    int getNumCartas() {
    
        return this.cartas.size();
    
    }
    
    /**
     * Método que insere uma determinada lista de cartas para a reposição do baralho.
     * @param reposicao 
     */
    void reporCartas(ArrayList<Carta> reposicao) {
        
        for(int i=0; i<reposicao.size(); i++) {
            cartas.add(reposicao.get(i));
            
            System.out.println("Reinserindo carta " + reposicao.get(i).getNumero() + " de " +
                    reposicao.get(i).getNaipe() + " no baralho.");
            
        }
        
    }
    
}