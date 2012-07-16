/**
 *  
 * Copyright (C) <2012>  <Bruno Segui and Isabel Boaventura>

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * 
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecabaralho;

/**
 *
 * @author bruno
 */
public class Cartas {

    private String naipe;
    private int num;

    /**
     * @return the naipe
     */
    public Cartas(String naipe, int num) {
        this.naipe = naipe;
        this.num = num;
    }

    public String getNaipe() {
        return naipe;
    }

    /**
     * @param naipe the naipe to set
     */
    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }
}
