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

        // ajustamos las prioridades
        mt1.setPriority(Thread.NORM_PRIORITY + 2); 
        mt2.setPriority(Thread.NORM_PRIORITY - 2); 

        // inicializamos los hilos
        mt1.start(); 
        mt2.start(); 

        try { 
            // esperar a que finalicen los diferentes hilos.
            mt1.join(); 
            mt2.join(); 
        } 
        catch(InterruptedException exc) { 
            System.out.println("Main thread interrupted."); 
        } 

        // mostramos el numero de ejecuciones
        System.out.println("\nHigh priority thread counted to " + mt1.count); 
        System.out.println("Low priority thread counted to " + mt2.count); 
        }
}
