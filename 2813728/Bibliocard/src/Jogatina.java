/**
 * @author Anderson Fortes e Francis Almeida
 */
/**
 *  
 *  Copyright (c) 2012 Anderson Fortes e Francis Almeida
 *  
 *  Este arquivo é parte do programa Baralho
 *
 *  Baralho é um software livre; você pode redistribui-lo e/ou modifica-lo dentro dos termos da Licença Pública Geral Menor GNU como 
 *  publicada pela Fundação do Software Livre (FSF); na versão 2 da licença, ou (na sua opnião) qualquer versão.
 *  
 *  Este programa é distribuido na esperança que possa ser  util, mas SEM NENHUMA GARANTIA; sem uma garantia implicita de ADEQUAÇÂO a qualquer
 *  MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral Menor GNU para maiores detalhes.
 *  
 *  Você deve ter recebido uma cópia da Licença Pública Geral Menor GNU junto com este programa, se não, escreva para a Fundação do Software
 *  Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 * 
 */


/**
 * Esta classe testa o jogo
 *
 */

//embaralhar, cortar, retirar do inicio, retira do final, passa do inicio pro fim, criar monte de descarte
public class Jogatina {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    Carta carta;
        Baralho baralho = new Baralho();
        System.out.println("baralho: ");
        baralho.exibirPilha();
        baralho.embaralhar();
        System.out.println("\nbaralho embaralhado: ");
        baralho.exibirPilha();
        
        baralho.cortar(14);
        System.out.println("\n\nbaralho cortado na posicao 14");
        baralho.exibirPilha();
        
        carta = baralho.getPrimeiraCarta();
        System.out.println("\n\nRETIRAR PRIMEIRA CARTA:   " + carta.getNum() + " " + carta.getNaipe() );
        System.out.println("\n\nMovendo "+carta.getNum()+" de "+carta.getNaipe()+" para o monte de descarte");
        
        baralho.exibirPilha();
        
        Carta ultima = baralho.getUltimaCarta();
        System.out.println("\n\nRETIRAR ULTIMA CARTA: " + ultima.getNum() + " " + ultima.getNaipe() );      
        System.out.println("\n\nMovendo "+ultima.getNum()+" de "+ultima.getNaipe()+" para o monte de descarte");
        
        baralho.exibirPilha();
        
        baralho.moverPrimeiraParaOFim();
        System.out.println("\n\nMOVENDO PRIMEIRA CARTA PARA O FIM");
        baralho.exibirPilha();
        
        carta.setNum(1);
        carta.setNaipe("copas");
        System.out.println("\n\nMovendo  1 de basto pro monte de descarte");
        baralho.Descartar("basto",1);
        baralho.visualizarDescartadas();        
        
    }
}
