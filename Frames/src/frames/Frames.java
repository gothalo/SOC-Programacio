/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import javax.swing.SwingUtilities;

/**
 *
 * @author llorenc
 */
public class Frames {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        MainFrame mf = new MainFrame ();
//        // ensenyem la finestra
//        mf.setVisible(true);
        
//        Panels p = new Panels ("Butons i JPanel");
   
        SwingUtilities.invokeLater (new Runnable () {
            
            @Override
            public void run () {
                Layouts l = new Layouts();
            }
        });
        
    }
}
