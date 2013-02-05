/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prioridades;

/**
 *
 * @author llorenc
 */
public class PriorityDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Priority mt1 = new Priority("High Priority"); 
        Priority mt2 = new Priority("Low Priority"); 

        // set the priorities 
        mt1.setPriority(Thread.NORM_PRIORITY+2); 
        mt2.setPriority(Thread.NORM_PRIORITY-2); 

        // start the threads 
        mt1.start(); 
        mt2.start(); 

        try { 
            mt1.join(); 
            mt2.join(); 
        } 
        catch(InterruptedException exc) { 
            System.out.println("Main thread interrupted."); 
        } 

        System.out.println("\nHigh priority thread counted to " + mt1.count); 
        System.out.println("Low priority thread counted to " + mt2.count); 
        }
}
