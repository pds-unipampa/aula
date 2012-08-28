

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nasser Rahman 101151428
 * @author Giovanni Pereira Garcia  111150199
 */

/**
 * Instancia um baralho completo com 52 cartas
 * @author nasser
 */
public class Baralho {

    static ArrayList<Carta> cartas = new ArrayList();
    ArrayList<Naipe> naipes = new ArrayList();
    ArrayList<Valor> valores = new ArrayList();
    static ArrayList<Carta> descarte = new ArrayList();
    private Carta descartando[];

    /**
     * 
     */
    public Baralho() {

        naipes.add(Naipe.COPAS);
        naipes.add(Naipe.ESPADA);
        naipes.add(Naipe.OURO);
        naipes.add(Naipe.PAUS);

        valores.add(Valor.AS);
        valores.add(Valor.DOIS);
        valores.add(Valor.TRES);
        valores.add(Valor.QUATRO);
        valores.add(Valor.CINCO);
        valores.add(Valor.SEIS);
        valores.add(Valor.SETE);
        valores.add(Valor.OITO);
        valores.add(Valor.NOVE);
        valores.add(Valor.DEZ);
        valores.add(Valor.VALETE);
        valores.add(Valor.DAMA);
        valores.add(Valor.REI);

        preencheBaralho();

    }

    /**
     * Preenche o baralho com todas as cartas
     */
    private void preencheBaralho() {
        for (int i = 0; i < valores.size(); i++) {
            for (int j = 0; j < naipes.size(); j++) {
                cartas.add(new Carta(valores.get(i), naipes.get(j)));
            }

        }
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
     * @param valor correspondente ao posição de corte
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
     * posição solicitada
     * @param posicao
     * @return carta
     */
    public Carta removeCartaDescarte(int posicao){
        return descarte.remove(posicao);
    }
    
    /**
     * Visualiza a carta do descarte conforme a posição solicitada
     * @param posicao
     * @return carta
     */
    public Carta visualizaCartaDescarte(int posicao){
        return descarte.get(posicao);
    }
    
    /*
     * Método que retorna o monte de descarte
     * @return array com cartas descartadas no jogo
     */
    public Carta[] PegaDescarteInteiro(){
       
       for (int i = 0; i <= tamanhoDescarte(); i++) {
           descartando[i] =  descarte.remove(i);
       }
 
            return descartando;
    }
    
    
    /**
     * Metodo de uso interno que faz a verificacao do baralho passado por parametro
     * se o mesmo possui alguma carta. Se o baralho conter pelo menos uma carta a
     * função retorna true, caso contrário false.
     * @return boolean
     */
    private boolean verificaBaralho(List baralhoAVerificar){

        if(baralhoAVerificar.size() == 0)
            return false;
        else
            return true;
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
