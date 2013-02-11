/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

/**
 *
 * @author llorenc
 */
public class PCMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Magatzem m = new Magatzem ();
        MagatzemSynch m = new MagatzemSynch ();
        
        
        Productor p = new Productor (m);
        Consumidor c = new Consumidor (m);
        
        // posar en marcha els fils d'execucio
        p.thr.start ();
        c.thr.start ();
        
        
        
        // esperem a que finalitzi
        try {
            p.thr.join ();
            c.thr.join ();
            
        } catch (InterruptedException ex) {}
    }
}
