


import java.util.ArrayList;
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

        naipes.add(new Naipe("ouro"));
        naipes.add(new Naipe("espada"));
        naipes.add(new Naipe("paus"));
        naipes.add(new Naipe("copas"));

        valores.add(new Valor("A"));
        valores.add(new Valor("2"));
        valores.add(new Valor("3"));
        valores.add(new Valor("4"));
        valores.add(new Valor("5"));
        valores.add(new Valor("6"));
        valores.add(new Valor("7"));
        valores.add(new Valor("8"));
        valores.add(new Valor("9"));
        valores.add(new Valor("10"));
        valores.add(new Valor("J"));
        valores.add(new Valor("Q"));
        valores.add(new Valor("K"));

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
     * Mistura as cartas do baralho
     */
    public void embaralha() {
        java.util.Collections.shuffle(cartas);
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
    
    public Carta[] PegaDescarteInteiro(){
       
       for (int i = 0; i <= tamanhoDescarte(); i++) {
           descartando[i] =  descarte.remove(i);
       }
 
            return descartando;
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
