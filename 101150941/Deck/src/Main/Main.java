/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import util.deck.Baralho;
import util.deck.Carta;

/**
 * Classe para testar algumas funcionalidades básicas do sistema
 *
 * @author Helison Teixeira
 * @author Bruno Vicelli
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Baralho criado:");
        Baralho bal = new Baralho();
        bal.exibirFullDeck();
        System.out.println("Embaralhando:");
        bal.embaralhar();
        bal.exibirFullDeck();
        System.out.println("Primeira Carta removida:");
        Carta card = bal.getPrimeiraCarta();
        System.out.println("numero: " + card.getNumero() + ", naipe: " + card.getnaipe());
    }
}
