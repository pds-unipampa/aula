package baralho;

import java.util.Collections;
import java.util.LinkedList;
import baralho.Carta.Naipe;
import baralho.Carta.Valor_Carta;

public class Baralho {
	private int tamBaralho=0;
	private final LinkedList<Carta> baralho = new LinkedList<Carta>();
	private final LinkedList<Carta> baralhoCortado = new LinkedList<Carta>();
	private final LinkedList<Carta> descarte = new LinkedList<Carta>();
				
	public Baralho(){
		for (Valor_Carta valor_Carta : Valor_Carta.values()){
		   	for (Naipe naipe : Naipe.values()){
		   		baralho.add(new Carta(valor_Carta, naipe));
		   		tamBaralho++;
		   	}
		}
	}
	
	public void embaralhar(){
    	int posicao = 0;
    	for (int i=0; i<tamBaralho;i++){
    		posicao = (int)(Math.random()*tamBaralho-1);
        	Collections.swap(baralho, i, posicao);
        }
    }
    
    public void cortarBaralho(int posicao){
    	for(int i = 0; i<posicao;i++){
    		baralhoCortado.add(baralho.get(0));
    		baralho.remove(baralho.get(0));
       	}
    	for(int j = 0; j<posicao;j++){
    		baralho.addFirst(baralhoCortado.get(j));
    	}
    	baralhoCortado.removeAll(baralhoCortado);
    }
    
    public Carta retirarCartaIni(){
       	Carta cartaRetirada = baralho.getFirst();
    	baralho.removeFirst();
    	return cartaRetirada;
    }
    
    public Carta retirarCartaFim(){
    	Carta cartaRetirada = baralho.getLast();
    	baralho.removeLast();
    	return cartaRetirada;
    }
    
    public void passarCartaIniFim(){
    	Carta cartaInicio = baralho.getFirst();
    	baralho.removeFirst();
    	baralho.addLast(cartaInicio);
    }
    
    public void descartar(Carta carta){
    	descarte.add(carta);
    }
    
    public Carta verCartaDescartada(int posicao){
    	return descarte.get(posicao);
    }
    
    public Carta comprarCarta(LinkedList<Carta> monte, int posicao){
    	Carta cartaComprada = monte.get(posicao);
    	baralho.remove(posicao);
    	return cartaComprada;
    }
}

