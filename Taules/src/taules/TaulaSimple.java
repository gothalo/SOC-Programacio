/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taules;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author llorenc
 */
public class TaulaSimple extends JFrame {

    public TaulaSimple () {
        super ("Taula Simple");
        
        initializeFrame ();
        
        this.setVisible (true);
        
    }
    
    private void initializeFrame () {
        
        // parametres del JFrame
        this.setSize (400, 300);
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        // definim una matriru per la capcelera de la taula
        String capcelera [] = {"Nom", "Cognom", "Nota", "Aprovat"};
        
        // definim una matriu 2D per les dades
        Object dades [][] = {
            {"Llorenç", "Foixench", new Double (3.5), false} , 
            {"Juan José", "Asturiano", new Double (6.0), true}            
        };
        
        JTable taulaSimple = new JTable (dades, capcelera);
        
        JScrollPane pnlTaula = new JScrollPane (taulaSimple);
        
        this.add (pnlTaula, BorderLayout.CENTER);
    }
    
}
