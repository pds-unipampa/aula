/**
 * <Biblioteca para manipulação de cartas.>
 * Copyright (C) <2012>  Brandon Marques dos Santos <brdonsb@gmail.com>
 * Copyright (C) <2012>  Renan Marcel Uchôa <renanmarceluchoa@gmail.com>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
**/



package libcartas;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe que implementa o conceito de um baralho de 52 cartas
 * 
 */

public class Baralho {
private ArrayList<Carta> cartas;

    public Baralho(){
    }
    
    /**
     * Método que cria um baralho com um dado número de cartas divididas entre espadas, copas, paus e ouros 
     * @param numero 
     */
    public void criaBaralho(int numero){
        if(numero%4!=0 || numero ==0){
            System.err.println("O numero de cartas deve ser múltiplo de 4 devido ao númeor de naipes");
        }

        else{
            ArrayList<String> naipes=new ArrayList<String>();
            cartas=new ArrayList<Carta>();
            naipes.add("ouro");
            naipes.add("paus");
            naipes.add("copas");
            naipes.add("espada");

            for(int x=0; x<naipes.size(); x++) {
                for(int i=0;i<numero/4;i++){
                    cartas.add(new Carta(i+1, naipes.get(x)));
                }
           }
        }

    }
    
   /**
     * Método que embaralha as cartas do baralho de maneira aleatória
     */
    public void embaralhar(){
        Collections.shuffle(cartas);
    }

    /**
     * Método que parte o baralho em duas partes, pondo a parte final à frente da parte inicial
     * @param valor
     * 
     */

    public void cortar(int valor){
        if(valor<0){
            System.err.println("Número de corte deve ser maior que zero");
        }

        if(cartas.size()<valor){
            System.err.println("Número de corte deve ser menor que o número de cartas");
        }

        else{
            ArrayList<Carta> temp = new ArrayList<Carta>();
        
            for(int i=valor;i<cartas.size();i++)
                temp.add(cartas.get(i));

            for(int i=0;i<valor;i++)
                temp.add(cartas.get(i));
        
            Collections.copy(cartas, temp);
        }
    }
   
     /**
     * Método que remove uma carta do início do baralho
     * @return 
     */

    public void retiraInicio(){
        if(cartas.size()<1){
            System.err.println("Número de cartas deve ser maior que zero");
        }
        else
            cartas.remove(0);
    }
       
     /**
     * Método que remove uma carta do fim do baralho
     * @return 
     */

    public void retiraFim(){
        if(cartas.size()<1){
            System.err.println("Número de cartas deve ser maior que zero");
        }
        else
            cartas.remove(cartas.size()-1);    
    }
    
     /**
     * Método que passa uma carta do início para o fim do baralho
     * 
     */

    public void passaCartaInicioParaFim() {
            ArrayList<Carta> temp = new ArrayList<Carta>();
        
            for(int i=0;i<cartas.size();i++)
                temp.add(cartas.get(i));

            temp.add(cartas.get(0));
            Collections.copy(cartas, temp);
        cartas.remove(0);        
    }

     /**
     * Método que busca uma carta
     * 
     */
    public Carta getCarta(int x){
        return cartas.get(x);
    }
}