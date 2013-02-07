/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac;

/**
 *
 * @author llorenc
 */
public class TicTacMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TicTac objtt = new TicTac ();
        
        TicTacThread ttTic = new TicTacThread ("tic", objtt);
        TicTacThread ttTac = new TicTacThread ("tac", objtt);
        
        ttTic.start ();
        ttTac.start ();
        
       //ttTic.suspend ();
        
        try {
            ttTic.join ();
            ttTac.join ();
        } catch (InterruptedException ie) {
            System.out.println ("Main interrompuda!");
        }
            
    }
}
