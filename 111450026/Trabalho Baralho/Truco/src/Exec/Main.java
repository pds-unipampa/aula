/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exec;

import Baralho.*;
import Jogo.ComparacaoTruco;
import Jogo.Jogador;
import Jogo.Jogo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rafael
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Monte principal = new MonteComum();
        MonteDescarte descarte = new MonteDescarte();
        ComparacaoTruco ct = new ComparacaoTruco(new Carta(4, Naipe.COPAS));
        /*Monte principal = new MonteComum();
        MonteDescarte descarte = new MonteDescarte();
        
        List<Integer> sequencia = new ArrayList<Integer>();
        
        ComparaCartas ct = new ComparacaoSimples();
        
        for(int i = 1; i <=13;i++){
            switch(i){
                case 8: continue;
                case 9: continue;
                case 10: continue;
            }
            
            sequencia.add(i);
        }
        
        Baralho b = new Baralho(principal, descarte, ct, sequencia);
        
        System.out.println(b.tamanhoMontePrincipal());*/
        /*Baralho b = new Baralho(principal, descarte, ct);
        
        b.embaralhar();
        
        b.cortar(20, 40);
        
        ct.setCartaVira(b.retirarCartaDoFim());
        
        System.out.println(ct.getCartaVira());
        
        Carta c1 = b.retirarCartaDoFim();
        
        System.out.println(c1);
        
        Carta c2 = b.retirarCartaDoFim();
        
        System.out.println(c2);
        
        System.out.println(c1.comparaCarta(c2));
        
        LinkedList<Carta> a = new LinkedList<Carta>();
        
        a.add(new Carta(1,Naipe.COPAS));
        
        a.add(new Carta(3, Naipe.ESPADAS));
        
        System.out.println(a);
        
        a.get(1);
        a.remove(1);
        
        System.out.println(a);*/
        
        Scanner scn = new Scanner(System.in);
        
        System.out.println("Informe o nome do jogador 1: ");
        Jogador j1 = new Jogador(scn.nextLine());
        
        System.out.println("Informe o nome do jogador 2: ");
        Jogador j2 = new Jogador(scn.nextLine());
        
        Jogo j = new Jogo(j1,j2);
    }
}
