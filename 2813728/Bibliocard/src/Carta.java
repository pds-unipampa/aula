/**
 * @author Anderson fortes e Francis Diego Almeida
 */
/**
 *  
 *  Copyright (c) 2012 Anderson Fortes e Francis Almeida
 *  
 *  Este arquivo é parte do programa Baralho
 *
 *  Baralho é um software livre; você pode redistribui-lo e/ou modifica-lo dentro dos termos da Licença Pública Geral Menor GNU como 
 *  publicada pela Fundação do Software Livre (FSF); na versão 2 da icença, ou (na sua opnião) qualquer versão.
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
     * Classe que define um objeto do tipo Carta, bem como métodos getters e setters.
     *
     */
public class Carta {

    private String naipe;
    private int num;

   
    public Carta(String naipe, int num) {
        this.naipe = naipe;
        this.num = num;
    }


	public String getNaipe() {
		return naipe;
	}


	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}
    
    
}