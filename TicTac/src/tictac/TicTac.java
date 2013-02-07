/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac;

/**
 *
 * @author llorenc
 */
public class TicTac {
    
    String estat; 
    
    synchronized void tic (boolean running) {
        if (!running) {
            estat = "tic";
            notify ();
            return;
            
        }
        
        System.out.println ("Tic ");
        estat = "tic";
        
        notify ();
        
        try {
            while (!estat.equals ("tac")) {
                wait ();
            }
        } catch (InterruptedException ie) {
            System.out.println ("Thread interromput");
        }
    }
    
    
     synchronized void tac (boolean running) {
        if (!running) {
            estat = "tac";
            notify ();
            return;
            
        }
        
        System.out.println ("Tac ");
        estat = "tac";
        
        notify ();
        
        try {
            while (!estat.equals ("tic")) {
                wait ();
            }
        } catch (InterruptedException ie) {
            System.out.println ("Thread interromput");
        }
    }
}
