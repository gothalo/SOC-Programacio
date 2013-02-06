/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runnables;

/**
 *
 * @author llorenc
 */
public class Tasca implements Runnable {
    
    public String name;
    
    public Tasca (String name) {
        this.name = name;
    }
    
    @Override
    public void run () {
        
        System.out.println ("Iniciando " + this.name);
        
        for (int i = 0; i < 10; i++) {
            
            System.out.println ("Ejecutando " + this.name 
                    + " (" + i + ")");
            
            try {
                Thread.sleep (1000);
            } catch (InterruptedException ex) {
                System.out.println (ex.getMessage ());
            }
        } // final de for
        
        System.out.println ("Finalizando " + this.name);
        
    }
    
}
