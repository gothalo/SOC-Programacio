/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

/**
 *
 * @author llorenc
 */
public class Magatzem {
    
    private char item;
    private boolean estaPle = false;
    
    
    
    public void desar (char newItem) {
        item = newItem;
        estaPle = true;
        
    }
    
    public char recuperar () {
        
        if (estaPle == true) {
            estaPle = false;
            return item;
        } else {
            return '\t';
        }
    }
    
}
