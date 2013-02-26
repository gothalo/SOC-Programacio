/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnesswing.screen;

import javax.swing.JFrame;
import javax.swing.JTable;
import alumnesswing.data.AlumnesManager;
import alumnesswing.tablemodel.AlumnesModel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

/**
 *
 * @author llorenc
 */
public class LlistaAlumnes {
    
    JFrame frm;
    JTable tblAlumnes;
    
    public LlistaAlumnes () {
        frm = new JFrame ("Alumnes POO");
        
        draw ();
        
        frm.setVisible (true);
    }
    
    private void draw () {
        frm.setSize (400,200);
        frm.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        // situem la finestra centrada en pantalla. 
        frm.setLocationRelativeTo(null);
        
        // recuperem els alumnes del arxiu de dades i el fem servir en un
        // model per la taula.
        AlumnesManager manager = new AlumnesManager ();
        AlumnesModel model = new AlumnesModel (manager.getAlumnes ());
        
        // creem una taula i la afegim al JFrame via JScrollPane
        tblAlumnes = new JTable (model);
        JScrollPane scpTaula = new JScrollPane (tblAlumnes);
        
        frm.add (scpTaula, BorderLayout.CENTER);
        
        
        
    }
}
