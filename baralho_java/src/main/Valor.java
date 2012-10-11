package baralho;


/**
 *
 * @author Nasser Rahman 101151428
 * @author Ricardo Burg Machado
 * @author Rafael Fernando dos Santos
 * @author Giovanni Garcia
 * @author Mateus Dal Forno
 * @author Bruno Segui
 * @author Isabel Boaventura
 * @author Rafhael Cunha
 */

/**
 * Classe que contém as cartas com seus respectivos nomes e valores
 * @author Greicy
 */
public enum Valor {

     
        /**
         * metodo para recuperar o nome da carta AS
         */
    AS {

        public String getValor() {
            return "A";
        } 
                
        /**
         * metodo para recuperar o valor da carta AS
         */
        public int getNumero() {

            return 1;
        } 
        
    },
    
        /**
         * metodo para recuperar o nome da carta DOIS
         */
    DOIS {

        public String getValor() {
            return "2";
        }

        /**
         * metodo para recuperar o valor da carta DOIS
         */
        public int getNumero() {

            return 2;
        }
    },
    
        /**
         * metodo para recuperar o nome da carta TRES
         */
    TRES {

        public String getValor() {
            return "3";
        }

        /**
         * metodo para recuperar o valor da carta TRES
         */
        public int getNumero() {

            return 3;
        }
    },
    
        /**
         * metodo para recuperar o nome da carta QUATRO
         */
    
    QUATRO {

        public String getValor() {
            return "4";
        }

        /**
         * metodo para recuperar o valor da carta QUATRO
         */
        
        public int getNumero() {

            return 4;
        }
    },
    
        /**
         * metodo para recuperar o nome da carta CINCO
         */
    
    CINCO {

        public String getValor() {
            return "5";
        }

        /**
         * metodo para recuperar o valor da carta CINCO
         */
        
        public int getNumero() {

            return 5;
        }
    },
    
        /**
         * metodo para recuperar o nome da carta SEIS
         */
    
    SEIS {

        public String getValor() {
            return "6";
        }

         /**
         * metodo para recuperar o valor da carta SEIS
         */
        
        public int getNumero() {

            return 6;
        }
    },
    
        /**
         * metodo para recuperar o nome da carta SETE
         */
    
    SETE {

        public String getValor() {
            return "7";
        }

        /**
         * metodo para recuperar o valor da carta SETE
         */
        
        public int getNumero() {

            return 7;
        }
    },
    
        /**
         * metodo para recuperar o nome da carta OITO
         */
    
    OITO {

        public String getValor() {
            return "8";
        }

        /**
         * metodo para recuperar o valor da carta OITO
         */
        
        public int getNumero() {

            return 8;
        }
    },
    
        /**
         * metodo para recuperar o nome da carta NOVE
         */
    
    NOVE {

        public String getValor() {
            return "9";
        }

        /**
         * metodo para recuperar o valor da carta NOVE
         */
        
        public int getNumero() {

            return 9;
        }
    },
    
        /**
         * metodo para recuperar o nome da carta DEZ
         */
    
    DEZ {

        public String getValor() {
            return "10";
        }

        /**
         * metodo para recuperar o valor da carta DEZ
         */
        
        public int getNumero() {

            return 10;
        }
    },
    
        /**
         * metodo para recuperar o nome da carta VALETE
         */
    
    VALETE {

        public String getValor() {
            return "J";
        }

        /**
         * metodo para recuperar o valor da carta VALETE
         */
        
        public int getNumero() {

            return 11;
        }
    },
    
        /**
         * metodo para recuperar o nome da carta DAMA
         */
    
    DAMA {

        public String getValor() {
            return "Q";
        }

        /**
         * metodo para recuperar o valor da carta DAMA
         */
        
        public int getNumero() {

            return 12;
        }
    },
    
        /**
         * metodo para recuperar o nome da carta REI
         */
    
    REI {

        public String getValor() {
            return "K";
        }

        /**
         * metodo para recuperar o valor da carta REI
         */
        
        public int getNumero() {

            return 13;
        }
    };

    public int getNumero() {
    
    
        return 0;
    }
    

}