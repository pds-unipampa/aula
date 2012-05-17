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


package trabalho;

import libcartas.*;


public class Trabalho {

    public static void main(String[] args) {
        MonteDescarte descarte = new MonteDescarte();
        
        //cria um baralho
        Baralho baralho = new Baralho();
        
        //define a quantidade de cartas do baralho
        baralho.criaBaralho(52);
        
        System.out.println("Baralho atual");
        for(int i=0; i<52.; i++){
            System.out.print(baralho.getCarta(i).getNumero()+" "+ baralho.getCarta(i).getNaipe()+" ");
        }

        baralho.embaralhar();
        System.out.println("\nBaralho embaralhado");
        for(int i=0; i<52; i++){
            System.out.print(baralho.getCarta(i).getNumero()+" "+ baralho.getCarta(i).getNaipe()+" ");
        }

        
        baralho.cortar(4);
        System.out.println("\ncortado na posição 4");
        for(int i=0; i<52; i++){
            System.out.print(baralho.getCarta(i).getNumero()+" "+ baralho.getCarta(i).getNaipe()+" ");
        }

        for(int i=0;i<10;i++)
            baralho.retiraInicio();

        System.out.println("\nBaralho depois de retirada as 10 primeiras cartas");
        for(int i=0; i<42; i++){
            System.out.print(baralho.getCarta(i).getNumero()+" "+ baralho.getCarta(i).getNaipe()+" ");
        }

        baralho.passaCartaInicioParaFim();
        System.out.println("\nPassando a carta do início para o fim");
        for(int i=0; i<42; i++){
            System.out.print(baralho.getCarta(i).getNumero()+" "+ baralho.getCarta(i).getNaipe()+" ");
        }
        
        
        System.out.println("inserindo cartas no descarte... \n mostrando monte de descarte");
        descarte.insere(baralho.getCarta(0));
        descarte.insere(baralho.getCarta(1));
        descarte.insere(baralho.getCarta(2));
        descarte.insere(baralho.getCarta(3));

        descarte.mostra();
    }
}