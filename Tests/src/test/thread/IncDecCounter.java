/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.thread;

/**
 *
 * @author llorenc
 */
public class IncDecCounter {
    
    private int counts;
    
    public IncDecCounter () {
        counts = 0;
    }
    
    public void inc () {
        counts++;
    }
    
    public void dec () {
        counts--;
    }
    
    public synchronized void opera (int op) {
        if (op == 1) {
            inc ();
        } else {
            dec ();
        }
    }
    
    
    public int getCounts () {
        return counts;
    }
    
}
