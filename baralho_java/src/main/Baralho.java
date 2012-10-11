package baralho;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
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
 * Instancia um baralho completo com 52 cartas
 * @author nasser
 * @author Rafael Fernando dos Santos 111450026
 */
public class Baralho {

    
    static ArrayList<Carta> cartas = new ArrayList();
    static ArrayList<Carta> descarte = new ArrayList();
    private ArrayList<Carta> descartando;

    /**
     * 
     */
    public Baralho() {
        
        descartando = new ArrayList<>();
        preencheBaralho();
        embaralha();
    }

    /**
     * Preenche o baralho com todas as cartas
     */
    private void preencheBaralho() {
        
        for(Valor valor: Valor.values()){
            
            for(Naipe naipe: Naipe.values()){
                
                cartas.add(new Carta(valor, naipe));
            }
        }
        
        /*for (int i = 0; i < valores.size(); i++) {
            for (int j = 0; j < naipes.size(); j++) {
                cartas.add(new Carta(valores.get(i), naipes.get(j)));
            }

        }*/
    }
    
    /**
     * Metodo que muda aleatoriamente a ordem das carta do baralho. Mas antes faz
    * a verificacao se existe alguma carta no baralho
    */
    public void embaralha() {
        
        if(verificaBaralho(cartas)){
            java.util.Collections.shuffle(cartas);
        }
    }
    
    /**
     * Realiza o corte no baralho conforme entrada
     * aceita valores entre 2 e 50
     * @param valor correspondente ao posiÃ§Ã£o de corte
     */
    public void corta(int valor) {
        if ((valor < 2) || (valor > 50)) {
            JOptionPane.showMessageDialog(null, "Para cortar, preencha apenas com valores entre 2 e 50");
        } else {
        //    Random rand = new Random();
            //int i = 2 + rand.nextInt(valor);

       //     System.out.println(valor);
            ArrayList mCima = new ArrayList();
            ArrayList mBaixo = new ArrayList();

            for (int j = 0; j < valor; j++) {
                mCima.add(cartas.get(j));
            }
            for (int k = valor; k < cartas.size(); k++) {
                mBaixo.add(cartas.get(k));
            }

            cartas.clear();
            cartas.addAll(mBaixo);
            cartas.addAll(mCima);
        }
    }
    
    /**
     * Coloca a primeira carta na parte de baixo do baralho
     */
    public void umaParaBaixo() {
        
            Carta c = cartas.get(0);
            cartas.remove(0);
            cartas.add(c);
        }
    
    /**
     * Distribui uma carta do Inicio do baralho
     * @return carta
     */
    public Carta daUmaCartaInicio() {
        
        Carta c = cartas.get(0);
        cartas.remove(0);
        return c;
    }
    
    /**
     * Distribui uma carta do Final do baralho
     * @return carta
     */
    public Carta daUmaCartaFinal() {
        
        Carta c = cartas.get(cartas.size() - 1);
        cartas.remove(cartas.size() - 1);
        return c;
    }
    
    /**
     * Coloca a ultima carta na parte de cima do baralho
     */ 
    public void umaParaCima() {
        
        ArrayList mCima = new ArrayList();
            
        Carta c = cartas.get(cartas.size()-1);
        cartas.remove(cartas.size()-1);
        mCima.addAll(cartas);
        cartas.clear();
        cartas.add(c);
        cartas.addAll(mCima);
    }

    /**
     * Adiciona uma carta ao monte de descarte
     * @param c Carta
     */
    public void colocaDescarte(Carta c){
        
        descarte.add(c);
    }
    
    /**
     * Retorna o tamanho do monte de descarte 
     * @return int tamanho de monte de descarte
     */
    public int tamanhoDescarte(){
        
        return descarte.size();
    }
    
    /**
     * Remove uma carta do descarte e retorna essa carta conforme a 
     * posiÃ§Ã£o solicitada
     * @param posicao
     * @return carta
     */
    public Carta removeCartaDescarte(int posicao){
        
        return descarte.remove(posicao);
    }
    
    /**
     * Visualiza a carta do descarte conforme a posiÃ§Ã£o solicitada
     * @param posicao
     * @return carta
     */
    /*public Carta visualizaCartaDescarte(int posicao){
        
        return descarte.get(posicao);
    }*/
   
    /*
     * MÃ©todo que retorna o monte de descarte
     * @return array com cartas descartadas no jogo
     */
    public ArrayList<Carta> PegaDescarteInteiro(){
       
        
       for (int i = 0; i <= tamanhoDescarte(); i++) {
           descartando.add(descarte.remove(i));
       }
            
        return descartando;
    }
    
    /**
     * Metodo de uso interno que faz a verificacao do baralho passado por parametro
     * se o mesmo possui alguma carta. Se o baralho conter pelo menos uma carta a
     * funÃ§Ã£o retorna true, caso contrÃ¡rio false.
     * @return boolean
     */
    private boolean verificaBaralho(List baralhoAVerificar){

        if(baralhoAVerificar.isEmpty())
            return false;
        else
            return true;
    }
    
    /***
     * Metodo que verifica se a carta Ã© par ou impar
     * Retorna 0(zero) para par e 1(um) para impar]
     * @param carta
     * @return int
     */
    
    public int verificaPar(Carta c){
        
        int par = 0;
       
        switch (c.getValor().toString()){
            case "AS":
                    par = 1;
                break;
            case "DOIS":
                    par = 0;
                break;
            case "TRES":
                    par = 1;    
                break;
            case "QUATRO":
                    par = 0;    
                break;
            case "CINCO":
                    par = 1;    
                break;
            case "SEIS":
                    par = 0;    
                break;
            case "SETE":
                    par = 1;    
                break;
            case "OITO":
                    par = 0;    
                break;
            case "NOVE":
                    par = 1;    
                break;
            case "DEZ":
                    par = 0;    
                break;
            case "VALETE":
                    par = 1;    
                break;
            case "DAMA":
                    par = 0;    
                break;
            case "REI":
                    par = 1;    
                break;
        }    
        
        return par;
    }
    
    /**
     * Exibe uma carta do monte de decarte. A carta nÃ£o Ã© retirada do monte.
     * Se nÃ£o existe carta na posiÃ§Ã£o especificada, uma mensagem Ã© exibida informando o ocorrido.
     * @param pos PosiÃ§Ã£o da carta a ser exibida.
     */
    public void verCartaDoDescarte(int pos){
        
        try{
            
            JOptionPane.showMessageDialog(null, descarte.get(pos-1));
        }catch (IndexOutOfBoundsException iobe){
            
            JOptionPane.showMessageDialog(null, "NÃ£o existe carta na posiÃ§Ã£o indicada no monte de descarte.");
        }
    }
    
 
    
    /*public static void main(String args[]) {
        Baralho b = new Baralho();

        

        b.embaralha();
        for (int i = 0; i < cartas.size(); i++) {
            System.out.println(cartas.get(i).toString());
        }

//        b.corta(30);
        System.out.println();
    //    b.umaParaCima();
    //    for (int i = 0; i < cartas.size(); i++) {
      //      System.out.println(cartas.get(i).toString());
      //  }
        Carta c = b.daUmaCartaFinal();
        System.out.println("Carta do final: " + c.toString());
        //System.out.println("Carta do inicio: " + b.daUmaCartaInicio().toString());
        b.colocaDescarte(c);
        c = b.daUmaCartaFinal();
        b.colocaDescarte(c);
        
        System.out.println(b.tamanhoDescarte());
        
        System.out.println(b.visualizaCartaDescarte(0));
        System.out.println(b.visualizaCartaDescarte(1));
    }*/
}
