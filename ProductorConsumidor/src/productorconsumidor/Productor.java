/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

/**
 *
 * @author llorenc
 */
public class Productor implements Runnable {
    
    public Thread thr;
    public Magatzem magatzem;
    
    private String catalogo = "abcdefghijklmnopqrstuvwxyz";
    
    public Productor (Magatzem magatzem) {
        thr = new Thread (this);
        this.magatzem = magatzem;
    }
    
    @Override
    public void run () {
        char item;
        
        for (int i = 0; i < 100; i++) {
            //triem una lletra
            item = catalogo.charAt (i % catalogo.length());
            magatzem.desar (item);
            System.out.println (i + " Produint " + item);
            
            try {
                Thread.sleep (500);
            } catch (InterruptedException ex) {}
        }
        
    }
    
    
    
}
