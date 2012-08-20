package util.deck;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A biblioteca de manipulação de baralho, por padrão o tradicional de 52 cartas
 * sem curingas, que deve fornecer uma representação das cartas e
 * funções/métodos/etc para manipulação das cartas. São esperadas as funções de
 * embaralhar, cortar em duas partes (em uma determinada posição e juntando em
 * um único baralho no final), retirar uma carta do inicio e do final, passar
 * uma carta do inicio para o final (sem mostrar que carta é), e a criação de um
 * monte de descarte do qual podemos ver qualquer carta sem removê-la (no monte
 * de compra uma carta só pode ser vista se for removida dele).
 *
 * @author Helison Teixeira
 * @author Bruno Vicelli
 * @Version 0.1 @Date 19/04/2012
 */
public class Baralho {

    private ArrayList<Carta> fullDeck = new ArrayList<>();
    private ArrayList<Carta> discardDeck = new ArrayList<>();
    private ArrayList<Carta> buyDeck = new ArrayList<>();

    /**
     * Construtor do baralho, falta adicionar as cartas ao baralho ¬¬ Colocar as
     * cartas ordenadamente para depois soh embaralhar
     */
    public Baralho() {
        ArrayList<String> numeros = new ArrayList<>();
        ArrayList<String> naipes = new ArrayList<>();
        numeros.add("A");
        numeros.add("2");
        numeros.add("3");
        numeros.add("4");
        numeros.add("5");
        numeros.add("6");
        numeros.add("7");
        numeros.add("8");
        numeros.add("9");
        numeros.add("10");
        numeros.add("J");
        numeros.add("Q");
        numeros.add("K");
        naipes.add("Copas");
        naipes.add("Ouro");
        naipes.add("Espada");
        naipes.add("Paus");
        Carta carta;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                carta = new Carta(naipes.get(i), numeros.get(j));
                //System.out.println("numero da carta: "+numeros.get(j)+", naipe:"+naipes.get(i));
                fullDeck.add(carta);
            }
        }

    }

    /**
     * Metodo que embaralha as cartas do jogo Dar um jeito de fazer isso
     *
     */
    public void embaralhar() {
        Collections.shuffle(fullDeck);
        //for (int i =0; i<200;i++){
        //Random rand = new Random();
        //Carta carta;
        //int num = rand.nextInt(52);
        //carta = fullDeck.remove(num);
        //fullDeck.add(carta);
        //  }

    }

    /**
     * Corta o Baralho na posicao informada pelo usuario e o remonta
     *
     * @param posicao
     */
    public void cortar(int posicao) {
        ArrayList<Carta> parte1 = new ArrayList<>();
        ArrayList<Carta> parte2 = new ArrayList<>();
        for (int i = 0; i < posicao; i++) {
            parte1.add(fullDeck.remove(i));
        }
        parte2.addAll(fullDeck);
        fullDeck.clear();
        fullDeck.addAll(parte2);
        fullDeck.addAll(parte1);
    }

    /**
     * Retorna a primeira carta do baralho
     *
     * @return
     *
     */
    public Carta getPrimeiraCarta() {
        return fullDeck.remove(0);
    }

    /**
     * Retorna a ultima carta do baralho
     *
     * @return
     */
    public Carta getUltimaCarta() {
        return fullDeck.remove(fullDeck.lastIndexOf(this));
    }

    /**
     * Move a primeira carta do baralho para o final Verificar se ao remover a
     * primeira carta a posicao nao vai ficar vazia caso seja necessario usar um
     * for para realocar a posicao delas
     */
    public void moverPrimeiraParaOFim() {
        fullDeck.add(fullDeck.remove(0));
    }

    /**
     * Remove a carta do baralho principal e o coloca na monte de descarte
     *
     * @param card
     */
    public void moverParaMonteDeDescarte(Carta card) {
        if (fullDeck.contains(card)) {
            discardDeck.add(card);
            fullDeck.remove(card);
        }
    }

    /**
     * Retona a carta do monte de descarte na posição escolhida
     *
     * @param posicao
     * @return carta dp
     */
    public Carta visualizarCartaDoMonteDeDescarte(int posicao) {
        return discardDeck.get(posicao);
    }

    /**
     * Retorna o ArrayList contendo todas as cartas do monte de discarte
     *
     * @return
     */
    public ArrayList<Carta> visualizarCartasDoMonteDeDescarte() {
        return discardDeck;
    }

    /**
     * Metodo de teste para verificar se as funcoes que utilizam o fulldeck
     * realmente estao ocorrendo Como por exemplo, embaralhar, remover carta,
     * mover carta, entre outras
     */
    public void exibirFullDeck() {
        for (int i = 0; i < 52; i++) {
            System.out.println("numero: " + fullDeck.get(i).getNumero() + ", naipe: " + fullDeck.get(i).getnaipe());
        }
    }
}
