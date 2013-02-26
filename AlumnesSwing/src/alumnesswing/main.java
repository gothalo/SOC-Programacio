/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnesswing;

import alumnesswing.screen.LlistaAlumnes;
import javax.swing.SwingUtilities;

/**
 *
 * @author llorenc
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater (new Runnable () {

            @Override
            public void run() {
                LlistaAlumnes l = new LlistaAlumnes();
            }

        });
        
    }
}
