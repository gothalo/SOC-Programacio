package frames;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author llorenc
 */
public class Ratoli {
    
    JFrame frm;
    JLabel lblMissatge;
    
    public Ratoli () {
        frm = new JFrame ("Ratolí");
        
        draw ();
    }

    private void draw() {
        frm.setSize (400, 300);
        frm.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        lblMissatge = new JLabel ("");
        frm.add (lblMissatge);
        
        frm.addMouseListener (new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                lblMissatge.setText ("Hola");
            }

            @Override
            public void mouseExited(MouseEvent me) {
                lblMissatge.setText ("Adios");
            }
        
            
        
        });
    }
    
    public void show () {
        frm.setVisible (true);
    }
    
}
