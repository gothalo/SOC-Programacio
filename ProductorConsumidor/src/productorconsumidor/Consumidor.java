/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

/**
 *
 * @author llorenc
 */
public class Consumidor implements Runnable{
    
    public Thread thr;
    public Magatzem magatzem;
    
    public Consumidor (Magatzem magatzem) {
        thr = new Thread (this);
        this.magatzem = magatzem;
    }
    
    @Override
    public void run () {
        char item;
        
        for (int i = 0; i < 100; i++) {
            item = magatzem.recuperar();
            System.out.println (i + " consumint " + item);
            
            try {
                Thread.sleep (100);
            } catch (InterruptedException ex) {}
        }
    }
    
}
