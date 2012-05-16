package Baralho;

public enum Naipe {

    OUROS,
    
    ESPADAS {public int peso(){
        return 2;
    }},
    
    COPAS {public int peso(){
        return 3;
    }},
    
    PAUS {public int peso(){
        return 4;
    }};
    
    public int peso(){
        return 1;
    }
}
