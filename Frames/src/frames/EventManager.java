/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase que se encarga de gestionar los eventos de un boton
 * @author llorenc
 */
public class EventManager implements java.awt.event.ActionListener {

    JFrame parent;
    
    public EventManager (JFrame parent) {
        this.parent = parent;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog (parent, "boton pulsado"
                , null, JOptionPane.INFORMATION_MESSAGE);
    }
    
}
