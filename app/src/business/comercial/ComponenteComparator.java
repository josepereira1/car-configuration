/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.comercial;

import java.util.Comparator;

/**
 *
 * @author rafaela
 */



public class ComponenteComparator implements Comparator<Componente> {
  
    public int compare(Componente c1, Componente c2) {
         if (c1.getPreco() < c2.getPreco()) {
            return 1;
        }
        if (c1.getPreco() > c2.getPreco()) {
            return -1;
        }
        return 0;
    }
}
