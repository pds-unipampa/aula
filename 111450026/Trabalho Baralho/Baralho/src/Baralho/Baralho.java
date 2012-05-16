package Baralho;

import Exceções.CartaInexistenteException;
import Exceções.SequenciaInvalidaException;
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

        /**
         * @param montePrincipal - Monte de compra.
         * @param monteDescarte  - Monte de descarte.
         */
        public Baralho(Monte montePrincipal, MonteDescarte monteDescarte){
            this(montePrincipal, monteDescarte, new ComparacaoSimples());
        }
        
        /**
         * @param montePrincipal - Monte de compra.
         * @param monteDescarte - Monte de descarte.
         * @param formaComparacao - Forma de comparação das cartas.
         */
        public Baralho(Monte montePrincipal, MonteDescarte monteDescarte, ComparaCartas formaComparacao){
            this.montePrincipal = montePrincipal;
            this.monteDescarte = monteDescarte;
            this.comparacao = formaComparacao;
            initialize();
        }
        
        /**
         * @param montePrincipal Monte de compra.
         * @param monteDescarte Monte de descarte.
         * @param formaComparacao Forma de comparação de cartas.
         * @param sequencia Sequência contendo os valores das cartas que serão inseridas no baralho (entre 1 e 13).
         * @throws SequenciaInvalidaException Caso a sequência contenha valores menores que 0 ou maiores que 13.
         */
        public Baralho(Monte montePrincipal, MonteDescarte monteDescarte, ComparaCartas formaComparacao, List<Integer> sequencia) throws SequenciaInvalidaException{
        
            this.montePrincipal = montePrincipal;
            this.monteDescarte = monteDescarte;
            this.comparacao = formaComparacao;
            initialize(sequencia);
        }

        /**
         * Cria as cartas do baralho comum (52 cartas) e as adiciona no monte principal.
         */
        private void initialize() {
            
            for(int c = 1; c<=13; c++){
                montePrincipal.addCarta(new Carta(c, Naipe.OUROS, comparacao));
                montePrincipal.addCarta(new Carta(c, Naipe.ESPADAS, comparacao));
                montePrincipal.addCarta(new Carta(c, Naipe.COPAS, comparacao));
                montePrincipal.addCarta(new Carta(c, Naipe.PAUS, comparacao));
            }
	}
        
        /**
         * Cria as cartas com a sequencia informada e as adiciona no monte principal.
         * @param sequencia Sequência contendo os valores das cartas que serão inseridas no baralho (Entre 1 e 13).
         * @throws SequenciaInvalidaException Caso a sequência contenha valores menores que 0 ou maiores que 13.
         */
        private void initialize(List<Integer> sequencia) throws SequenciaInvalidaException{
            verificaSequencia(sequencia);
            
            for(int i = 0; i <sequencia.size(); i++){
                montePrincipal.addCarta(new Carta(sequencia.get(i),Naipe.OUROS, comparacao));
                montePrincipal.addCarta(new Carta(sequencia.get(i),Naipe.ESPADAS, comparacao));
                montePrincipal.addCarta(new Carta(sequencia.get(i),Naipe.COPAS, comparacao));
                montePrincipal.addCarta(new Carta(sequencia.get(i),Naipe.PAUS, comparacao));
            }
        }
        
        /**
         * Elimina as cartas dos montes e inicializa o baralho novamente (initialize()).
         */
        public void reiniciarBaralho(){
             montePrincipal.esvaziaMonte();
             monteDescarte.esvaziaMonte();
             initialize();
        }
        
        /**
         * Elimina as carta dos monte e inicialize o baralho novamente (initalize()).
         * @param sequencia Sequência contendo os valores das cartas que serão inseridas no baralho (Entre 1 e 13).
         * @param comparacao Foma de comparação das cartas. 
         * @throws SequenciaInvalidaException Caso a sequência contenha valores menores que 0 ou maiores que 13.
         */
        public void reiniciarBaralho(List<Integer> sequencia, ComparaCartas comparacao) throws SequenciaInvalidaException{
            montePrincipal.esvaziaMonte();
            monteDescarte.esvaziaMonte();
            this.comparacao = comparacao;
            initialize(sequencia);
        }
        
        /**
         * Configura a forma de comparação das cartas do baralho.
         * @param cc Forma de comparação das cartas.
         */
        public void setComparacao(ComparaCartas cc){
            
            for(Carta c: montePrincipal.listaCartas()){
                c.setComparaCartas(cc);
            }
            
            for(Carta c: monteDescarte.listaCartas()){
                c.setComparaCartas(cc);
            }
            
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
         * @param ini Posição de onde começa o conjunto a ser retirado.
         * @param fim Posição de onde termina o conjunto a ser retirado.
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
            
            for (int i = Math.abs(fim-1); i>=ini; i--){
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
        
        /**
         * Verifica se a sequência de valores informada é válida para o baralho.
         * @param sequencia Sequência de valores.
         * @throws SequenciaInvalidaException Caso a sequência contenha valores menores que 0 ou maiores que 13.
         */
        private void verificaSequencia(List<Integer> sequencia) throws SequenciaInvalidaException{
            
            for(Integer i: sequencia){
                if(i<1 || i>13)
                    throw new SequenciaInvalidaException("A sequência contém valores maiores que 13 ou menor que 1");
            }
        }

}
