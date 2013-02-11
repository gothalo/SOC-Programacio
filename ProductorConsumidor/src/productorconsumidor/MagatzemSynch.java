/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

/**
 *
 * @author llorenc
 */
public class MagatzemSynch extends Magatzem {
    
    private char item;
    private boolean estaPle = false;
    
    @Override
    public synchronized void desar (char newItem) {
        
        // esperem mentre el magatzem no estigui buit.
        while (estaPle == true) {
            try {
                wait ();
            } catch (InterruptedException ex) {}
        }
        
        item = newItem;
        estaPle = true;
        // avisar que hi ha item
        notify ();
    }
    
    @Override
    public synchronized char recuperar () {
        char elMeuItem;
        
        while (estaPle != true) {
            try {
                wait ();
            } catch (InterruptedException ex) {}
        }
        
        if (estaPle == true) {
            estaPle = false;
            elMeuItem = item;
            notify ();
            return elMeuItem;
        } else {
            return '\t';
        }
        
    }
    
}
