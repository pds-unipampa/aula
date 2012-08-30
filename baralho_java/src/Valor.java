
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
public enum Valor {

    AS {

        public String getValor() {
            return "A";
        }

        public int getNumero() {

            return 1;
        }
    },
    DOIS {

        public String getValor() {
            return "2";
        }

        public int getNumero() {

            return 2;
        }
    },
    TRES {

        public String getValor() {
            return "3";
        }

        public int getNumero() {

            return 3;
        }
    },
    QUATRO {

        public String getValor() {
            return "4";
        }

        public int getNumero() {

            return 4;
        }
    },
    CINCO {

        public String getValor() {
            return "5";
        }

        public int getNumero() {

            return 5;
        }
    },
    SEIS {

        public String getValor() {
            return "6";
        }

        public int getNumero() {

            return 6;
        }
    },
    SETE {

        public String getValor() {
            return "7";
        }

        public int getNumero() {

            return 7;
        }
    },
    OITO {

        public String getValor() {
            return "8";
        }

        public int getNumero() {

            return 8;
        }
    },
    NOVE {

        public String getValor() {
            return "9";
        }

        public int getNumero() {

            return 9;
        }
    },
    DEZ {

        public String getValor() {
            return "10";
        }

        public int getNumero() {

            return 10;
        }
    },
    VALETE {

        public String getValor() {
            return "J";
        }

        public int getNumero() {

            return 11;
        }
    },
    DAMA {

        public String getValor() {
            return "Q";
        }

        public int getNumero() {

            return 12;
        }
    },
    REI {

        public String getValor() {
            return "K";
        }

        public int getNumero() {

            return 13;
        }
    };

    public int getNumero() {
    
    
        return 0;
    }
    

}