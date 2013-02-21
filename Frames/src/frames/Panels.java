/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author llorenc
 */
public class Panels implements ActionListener {
    
    JFrame frm;
    
    private JButton btnOK, btnCancel;
    private JTextField txtNom;
    
    
    public Panels (String titulo) {
        frm = new JFrame (titulo);
        
        initializeFrame ();
        
        frm.setVisible (true);
    }

    private void initializeFrame() {
     
        frm.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frm.setSize (400, 200);
        
        // creamos dos botones
        
        btnOK = new JButton ("OK");
        btnCancel = new JButton ("Cancelar");
        
        btnOK.addActionListener (this);
        btnCancel.addActionListener (this);
        
        
        btnOK.setPreferredSize (btnCancel.getPreferredSize ());
    
        // vamos a usar un panel para los botones que colocaremos en la parte 
        // inferior de la ventana.
        JPanel pnlButtons = new JPanel ();
        
        // añadir botones al panel
        pnlButtons.add (btnOK); 
        pnlButtons.add (btnCancel);
        
        frm.add (pnlButtons, BorderLayout.SOUTH);
        
        // añadimos un campo de texto a la ventana.
        txtNom = new JTextField ();
        txtNom.setText ("posa el teu nom aqui");
        
        txtNom.setActionCommand ("txtNom");
        txtNom.addActionListener (this);
        
        // gestionamos el evento keyReleased de modo que active / desactive
        // el botón ok segun si txtNom esta informado o no.
        txtNom.addKeyListener (new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                //throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                if (txtNom.getText ().equals ("")) {
                    btnOK.setEnabled (false);
                } else {
                    btnOK.setEnabled (true);
                }
            }
        });
        
        frm.add (txtNom, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getActionCommand ().equals (btnOK.getText ())) {
            this.executaOK ();
        } else if (ae.getActionCommand ().equals ("txtNom")) {
            this.executaOK ();
        } else {
            this.executaCancelar ();
        }
        
//        if (ae.getSource ().equals (btnOK)) {
//            System.out.println("OK por source");
//        } else {
//            System.out.println("Cancelar por source");
//        }
        
//        switch (ae.getActionCommand ()) {
//            case "OK" :
//               this.executaOK ();  
//                break;
//                
//            case "Cancelar" :
//                this.executaCancelar ();
//                break;
//            case "txtNom" :
//                this.executaOK ();
//                break;
//        }
    }

    private void executaOK() {
        System.out.println (txtNom.getText ());
    }

    private void executaCancelar() {
        txtNom.setText ("");
    }
    
}
