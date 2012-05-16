package apicartasteste;

/*
 * <Essa biblioteca tem como objetivo facilitar o manuseio de um baralho de
 * cartas tradicional com 52 cartas, possuindo algumas métodos que farão
 * determinadas ações automatizadas, como baralhar, cortar, etc..> Copyright (C)
 * <2012> <Rafhael Cunha>
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>. email:
 * rcrafhaelrc@gmail.com
 */
import baralho.*;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * Classe que mostra uma pequena implementação da biblioteca API Cartas
 * @author RafhaelRC
 */
public class Main {
    static Baralho baralho;
    static int auxiliar = 999;
    static int cortebaralho = 0;
    static int destinocarta = 0;
    static Carta cartaauxiliar;
    static Descarte descarte = new Descarte();
    static Scanner in = new Scanner(System.in);
    static LinkedList <Carta> mão = new LinkedList<Carta>();
    public static void cortarbaralho(){
    System.out.println("Digite a posição que deseja cortar o baralho: ");
    cortebaralho = in.nextInt();
    baralho.cortarbaralho(cortebaralho);
    }
    public static String PercorreMão() {
        String saida = "";
        for (Carta carta : mão) {
            saida = saida +  "|" + carta.retornacarta() + "|, ";
        }
        return saida;
    }
    
    public static void menu(){
    while (auxiliar != 0){
        
        System.out.println("Digite a opção que você deseja: ");
        System.out.println("--------------------------------");
        System.out.println("1 -- Criar o baralho: ");
        System.out.println("--------------------------------");
        System.out.println("2 -- Embaralhar " + "(Lembrando que só é possível embaralhar depois de criar o baralho)");
        System.out.println("--------------------------------");
        System.out.println("3 -- Cortar o baralho (Lembrando que deve ser passado a posição do corte)");
        System.out.println("--------------------------------");
        System.out.println("4 -- Comprar uma carta do baralho ");
        System.out.println("--------------------------------");
        System.out.println("5 -- Visualizar as cartas que tenho na mão ");
        System.out.println("--------------------------------");
        System.out.println("6 -- Visualizar as cartas que tenho no descarte ");
        System.out.println("--------------------------------");
        System.out.println("7 -- Pegar uma carta que tem na mão e colocar no descarte ");
        System.out.println("--------------------------------");
        System.out.println("8 -- Pegar uma carta que tem no descarte e colocar na mão ");
        auxiliar = in.nextInt();
    
    //
    if (auxiliar == 1){
    baralho = new Baralho();    
    }
    else if (auxiliar == 2){
    baralho.embaralhar();        
    }
    else if (auxiliar == 3){    
    System.out.println("Digite a posição que deseja cortar o baralho: ");
    cortebaralho = in.nextInt();
    baralho.cortarbaralho(cortebaralho); 
    //cortarbaralho();
    menu();
    }
    else if (auxiliar == 4){
        cartaauxiliar = baralho.getPrimeiraCartaeRemoveEladoBaralho();
        System.out.println("Foi comprada a carta: " + cartaauxiliar.retornacarta());
        System.out.println("O que você deseja fazer com a carta: ");
        System.out.println("--------------------------------------");
        System.out.println("1 -- Adicionar ela na mão ");
        System.out.println("--------------------------------------");
        System.out.println("2 -- Colocar ela no monte de descarte ");
        destinocarta = in.nextInt();
        if(destinocarta == 1){
        mão.add(cartaauxiliar);
        menu();
        }
        else{
            descarte.addCarta(cartaauxiliar);
            menu();
        }    
    }
    else if (auxiliar == 5){
        System.out.println(PercorreMão());
        menu();
    }
    else if (auxiliar == 6){
        System.out.println(descarte.toString());
        
    }
    else if (auxiliar == 7){
        System.out.println(PercorreMão());
        System.out.println("Qual carta da mão você deseja remover: (Lembrando que a primeira carta tem o valor 0, a segunda carta o valor 1 e assim sucessivamente)");
        int pegamonte = in.nextInt();
        descarte.addCarta(mão.remove(pegamonte));
    }
    else if (auxiliar == 8){
        System.out.println(descarte.toString());
        System.out.println("Qual carta do descarte você deseja remover: (Lembrando que a primeira carta tem o valor 0, a segunda carta o valor 1 e assim sucessivamente)");
        int pegamonte = in.nextInt();
        //descarte.addCarta(mão.remove(pegamonte));
        mão.add(descarte.removecarta(pegamonte));
    }
  }
}
    
    public static void main(String[] args) {
    
    menu();
        
    }
}

