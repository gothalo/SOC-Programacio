/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.thread;

/**
 *
 * @author llorenc
 */
public class IncDecMonitor {
    
    public void process () {
        
        IncDecCounter count = new IncDecCounter();
        
        IncDec inc = new IncDec ("INC", count);
        IncDec dec = new IncDec ("DEC", count);
        
        Thread t1 = new Thread (inc);
        Thread t2 = new Thread (dec);
        
        t1.start ();
        t2.start ();
        
        try {
            t1.join ();
            t2.join ();
        } catch (InterruptedException ex) {
            System.out.println (ex.getMessage ());
            
        }
        
        System.out.println (count.getCounts());
    }
    
}
