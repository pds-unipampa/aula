package Baralho;

import Exceções.CartaInexistenteException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe que representa o baralho. O baralho conta com dois montes:
 * Monte principal: monte inicial do baralho. O monte que sofre o corte e onde se compram as cartas.
 * Monte de descarte: monte para vão as cartas descartadas pelos usuários do baralho.
 * @author Rafael
 */
public class Baralho {

	private Monte montePrincipal;

	private MonteDescarte monteDescarte;
        
        private ComparaCartas comparacao;

        public Baralho(Monte montePrincipal, MonteDescarte monteDescarte){
            this.montePrincipal = montePrincipal;
            this.monteDescarte = monteDescarte;
            this.comparacao = new ComparacaoSimples();
            initialize();
        }
        
        public Baralho(Monte montePrincipal, MonteDescarte monteDescarte, ComparaCartas formaComparacao){
            this.montePrincipal = montePrincipal;
            this.monteDescarte = monteDescarte;
            this.comparacao = formaComparacao;
            initialize();
        }

        /**
         * Cria as cartas do baralho e as adiciona no monte principal.
         */
        private void initialize() {
            for(int c = 1; c<=13; c++){
                for(int n = 1; n<=4; n++){
                    switch(n){
                        case 1: montePrincipal.addCarta(new Carta(c, Naipe.OUROS, comparacao));
                            break;
                        case 2: montePrincipal.addCarta(new Carta(c, Naipe.ESPADAS, comparacao));
                            break;
                        case 3: montePrincipal.addCarta(new Carta(c, Naipe.COPAS, comparacao));
                            break;
                        default: montePrincipal.addCarta(new Carta(c, Naipe.PAUS, comparacao));
                    }
                }
            }
	}
        
        /**
         * Elimina as cartas do monte e inicializa o baralho novamente (initialize()).
         */
        public void reiniciarBaralho(){
             montePrincipal.esvaziaMonte();
             monteDescarte.esvaziaMonte();
             initialize();
        }

	/**
         * Embaralha as cartas do baralho.
         */
        public void embaralhar() {
            LinkedList<Carta> monteEmbaralhado = this.montePrincipal.listaCartas();
            Collections.shuffle(monteEmbaralhado);
	}

	/**
         * Faz um corte no baralho, ou seja, retira um conjunto de cartas do baralho e as passa para o topo.
         * @param ini - Posição de onde começa o conjunto a ser retirado.
         * @param fim - Posição de onde termina o conjunto a ser retirado.
         * @throws CartaInexistenteException - Caso alguma das posições (inicial ou final) especificada aponte para uma carta que não existe no monte.
         */
        public void cortar(int ini, int fim) throws CartaInexistenteException{
            try{
                montePrincipal.obtemCarta(ini);
            }catch(IndexOutOfBoundsException ex){
                throw new CartaInexistenteException("A carta na posição " + ini + " não existe no monte");
            }
            
           try{
                montePrincipal.obtemCarta(fim-1);
            }catch(IndexOutOfBoundsException ex){
                throw new CartaInexistenteException("A carta na posição " + fim + " não existe no monte");
            }
                
            
            List<Carta> corte = new LinkedList<Carta>();
            
            for (int i = (fim-1); i>=ini; i--){
                corte.add(montePrincipal.obtemCarta(i));
                montePrincipal.removeCarta(i);
            }
            
            juntar(corte);
            
	}

	/**
         * Junta as cartas do corte.
         * @param cartas - Cartas a serem adicionadas ao monte.
         */
        private void juntar(List<Carta> cartas) {
            
            for (int i = cartas.size()-1; i >= 0 ; i--){
                montePrincipal.addCarta(cartas.get(i));
            }
	}

	/**
         * Retira uma carta do início do monte principal.
         * @return Carta - Carta retirada do início do baralho.
         * @throws CartaInexistenteException - Caso não haja mais cartas no monte principal.
         */
        public Carta retirarCartaDoInicio() throws CartaInexistenteException{
            Carta c = montePrincipal.obtemCarta(0);
            
            if(c != null)
                montePrincipal.removeCarta(0);
                
            return c;
            
	}

	/**
         * Retira uma carta do topo do monte principal.
         * @return Carta - Carta retidada do topo do monte principal
         * @throws CartaInexistenteException - Caso não haja mais cartas no monte principal.
         */
        public Carta retirarCartaDoFim() throws CartaInexistenteException {
            Carta c = montePrincipal.obtemCarta(tamanhoMontePrincipal() - 1);
            
            if(c != null)
                montePrincipal.removeCarta(tamanhoMontePrincipal() - 1);
                
            return c;
	}

	/**
         * Retira uma carta do topo do baralho e a passa para o início do baralho.
         * @throws CartaInexistenteException - Caso não haja mais cartas no monte principal.
         */
        public void moverDoInicioParaFim() throws CartaInexistenteException {
            Carta c = montePrincipal.obtemCarta(montePrincipal.tamanho() - 1 );
            montePrincipal.removeCarta(montePrincipal.tamanho() - 1 );
            montePrincipal.addCarta(c, 0);
	}

	/**
         * Adiciona uma carta ao monte de descarte.
         * @param carta - Carta a ser adicionada ao descarte.
         * @return true se a carta foi adicionada ou false caso contrário.
         */
        public boolean descartar(Carta carta) {
            return monteDescarte.addCarta(carta);
	}

	/**
         * Retira uma carta do monte de descarte.
         * @param pos - Posição do monte de descarte de onde a carta será retirada.
         * @return A carta, caso a posição especificada aponte para uma carta do monte.
         * @throws CartaInexistenteException - Caso a posição especificada não aponte para uma carta no monte.
         */
        public Carta retirarCartaDoDescarte(int pos) throws CartaInexistenteException {
            Carta c = monteDescarte.obtemCarta(pos - 1);
            
            if(c != null)
                monteDescarte.removeCarta(pos - 1);
                
            return c;
	}

	/**
         * Exibe uma carta do monte de descarte.
         * @param pos - Posição do monte de descarte que aponta para a carta a ser exibida.
         * @throws CartaInexistenteException - Caso a posição especificada não aponte para uma carta no monte.
         */
        public void verCartaDoDescarte(int pos) throws CartaInexistenteException {
            Carta c = monteDescarte.obtemCarta(pos - 1);
            
            if(c != null)
                monteDescarte.exibirCarta(pos - 1);
	}

        /**
         * Retorna o tamanho do baralho. O tamanho do baralho é dado pela soma do tamanho do monte principal com o tamanho do monte de descarte.
         * @return Tamanho do baralho.
         */
	public int tamanho() {
            return montePrincipal.tamanho() + monteDescarte.tamanho();
	}
        
        /**
         * Retorna o tamanho do monte principal (quantidade de cartas).
         * @return Tamanho do monte principal.
         */
        public int tamanhoMontePrincipal(){
            return montePrincipal.tamanho();
        }
        
        /**
         * Retorna o tamanho do mont de descarte (quantidade de cartas).
         * @return Tamanho do monte de descarte.
         */
        public int tamanhoMonteDescarte(){
            return monteDescarte.tamanho();
        }

}
