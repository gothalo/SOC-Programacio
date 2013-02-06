/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runnables;

/**
 *
 * @author llorenc
 */
public class runnablesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creem els dos Runnables
        Tasca t1 = new Tasca ("Primera Tasca");
        Tasca t2 = new Tasca ("Segona Tasca");
        
        // associar els runnables a fils de execució independents
        Thread thr1 = new Thread (t1);
        Thread thr2 = new Thread (t2);
        
        // inicialitzar els subprocessos
        thr1.start ();
        thr2.start ();
        
        // esperar que acabin els dos subprocesos
        try {
            thr1.join ();
            thr2.join ();
        } catch (InterruptedException ex) {
            System.out.println (ex);
        }
        System.out.println ("Fi de Main");
    }
}
