/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package experimento;

/**
 *
 * @author llorenc
 */
public class SubeBaja implements Runnable {
    
    public static int valor = 0;
    
    public String nombre;
    public Thread thr;
    
    public SubeBaja (String nombre) {
        this.nombre = nombre;
        thr = new Thread (this);
    }
    
    @Override
    public void run () {
       
        for (int i = 0; i < 10000; i++) {
            
            synchronized (this) {
                if (nombre.equalsIgnoreCase ("SUBE")) {
                    valor++;
                } else {
                    valor--;
                }
            }
        }
        
    }
    
    
    
}
