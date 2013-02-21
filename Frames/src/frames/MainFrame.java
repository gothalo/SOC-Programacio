/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author llorenc
 */
public class MainFrame extends JFrame implements ActionListener {
    
    public MainFrame () {
        super ();
        
        // pintem els components del frame
        initializeFrame ();
        
        this.setVisible (true);
    }
    
    private void initializeFrame () {
        // cambiem el tamany de la finestra
        this.setSize (400, 250);
        
        //posem un titol a la finestra
        this.setTitle ("Primera Finestra");
        
        // comportament botó tancar finestra
        // quan la tanquin, acabará el programa
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        JLabel lbl = new JLabel ("Hola Mon!!!");
        
        JLabel lbl2 = new JLabel ();
        lbl2.setText ("Un altre texte");
        
        //cambiem el color de fons
        lbl2.setBackground (Color.RED);
        lbl2.setOpaque (true);
        
        lbl.setHorizontalAlignment (SwingConstants.RIGHT);
        lbl.setVerticalAlignment (SwingConstants.TOP);
        
        this.add (lbl, BorderLayout.CENTER);
        this.add (lbl2, BorderLayout.SOUTH);
        // this.getContentPane ().add (lbl);
        
        JButton btn = new JButton ("Aceptar");
        this.add (btn, BorderLayout.NORTH);
        
        EventManager em = new EventManager(this);
        btn.addActionListener(em);
        
        JButton btn2 = new JButton ("Este");
        this.add (btn2, BorderLayout.EAST);
        
        btn2.addActionListener (this);
        
        JButton btn3 = new JButton ("Oeste");
        this.add (btn3, BorderLayout.WEST);
        
        // evento action performed del 3er boton.
        btn3.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed (ActionEvent e) {
                JOptionPane.showMessageDialog (
                        ((JButton) e.getSource()).getTopLevelAncestor(),
                        "Tercer Boton",
                        "mainframe.java", 
                        JOptionPane.QUESTION_MESSAGE);
                
                
            }
        });
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog (this, "segundo boton", null
                , JOptionPane.INFORMATION_MESSAGE);
    }
    
}
