/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.semaforo;

/**
 *
 * @author llorenc
 */
public class SemaforoThread implements Runnable {
    
    private int tipo;
    public Thread thr;
    SemaforoSwitch control;
    
    public SemaforoThread (int tipo, SemaforoSwitch control) {
        this.tipo = tipo;
        this.control = control;
        
        thr = new Thread (this);
    }
    
    @Override
    public void run () {
    
        for (int i = 0; i < 10; i++) {
        
            control.pedirPaso(tipo);
            
        }
    }
    
    
    
    
}
