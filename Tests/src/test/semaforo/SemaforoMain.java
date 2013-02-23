/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.semaforo;

/**
 *
 * @author llorenc
 */
public class SemaforoMain {
    
    public void process () {
        SemaforoSwitch control = new SemaforoSwitch();
        
        SemaforoThread peaton = new SemaforoThread(SemaforoSwitch.PEATON, control);
        SemaforoThread coche = new SemaforoThread (SemaforoSwitch.COCHE, control);
        
        peaton.thr.start ();
        coche.thr.start ();
        
        try {
            peaton.thr.join ();
            coche.thr.join ();
        } catch (InterruptedException ex) {}
    }
    
}
