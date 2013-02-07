/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac;

/**
 *
 * @author llorenc
 */
public class TicTacThread extends Thread {
    
    TicTac ttobj;
    
    public TicTacThread (String name, TicTac ttobj) {
        super (name);
        this.ttobj = ttobj;
        
    }
    
    public void run () {
        if (getName ().compareToIgnoreCase("tic") == 0) {
            for (int i = 0; i <= 10; i++) {
                ttobj.tic (true);
            }
            ttobj.tic (false);
            
        } else {
            for (int i = 0; i<= 10; i++) {
                ttobj.tac (true);
            }
            ttobj.tac (false);
        }
    }
    
}
