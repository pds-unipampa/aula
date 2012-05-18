package baralho;

public class Carta {
	  	public enum Valor_Carta{
	  		AS, DOIS, TRES, QUATRO, CINCO, SEIS, SETE,OITO, NOVE, DEZ, VALETE, RAINHA, REI
	  	}

	    public enum Naipe {
	    	ESPADAS, PAUS, COPAS, OURO
	    }
	    
	    private final Valor_Carta valor_Carta;
	    private final Naipe naipe;
	  
	    public Carta(Valor_Carta valor_Carta, Naipe naipe) {
	        this.valor_Carta = valor_Carta;
	        this.naipe = naipe;
	    }

	    public Valor_Carta get_Valor_Carta(){
	    	return valor_Carta;
	    }
	    
	    public Naipe get_Naipe(){
	    	return naipe;
	    }
	    
	    public String toString(){
	    	return valor_Carta + " de " + naipe;
	    }

	   
	 
}
