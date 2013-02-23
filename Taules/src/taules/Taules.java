/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taules;

import javax.swing.SwingUtilities;

/**
 *
 * @author llorenc
 */
public class Taules {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater (new Runnable () {

            @Override
            public void run() {
                //TaulaSimple t = new TaulaSimple ();
                TaulaModel tm = new TaulaModel();
            }
       
        });
                
    }
}
