/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taules;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import taules.models.Model;
/**
 *
 * @author llorenc
 */
public class TaulaModel extends JFrame {

    public TaulaModel () {
        super ("Taula Model");
        
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
        
        // definim un model de dades
        Model myModel = new Model (capcelera, dades);
        
        
        JTable taulaSimple = new JTable (myModel);
        
        JScrollPane pnlTaula = new JScrollPane (taulaSimple);
        
        this.add (pnlTaula, BorderLayout.CENTER);
    }
    
}
