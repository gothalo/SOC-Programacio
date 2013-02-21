/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

/**
 *
 * @author llorenc
 */
public class Layouts extends JFrame implements ItemListener {
    
    // declaramos los componentes graficos como publicos
    // para poder acceder desde cualquier método de esta clase.
    
    JCheckBox chkAprovat, chkSuspes;
    JTextField txtNom, txtCognom;
    JButton btnOk, btnCancel;
         
    protected Layouts me;
    
    public Layouts () {
        super ("Layouts");
        me = this;
        
        initializeFrame ();
        
        // cuando cambiamos el tamaño de la ventan, informamos en el terminal
        // el tamaño de la ventana.
        this.addComponentListener (new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent ce) {
                System.out.println (me.getSize ());
                        
            }
        });
        
        
        this.setVisible (true);
    }
    
    private void initializeFrame () {
        
        this.setSize (450, 140);
        this.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        
        // layout del JFrame sigui de tipus BorderLayout
        this.setLayout (new BorderLayout () );
        
        // configuramos los botones.
        
        btnOk = new JButton ("OK");
        btnCancel = new JButton ("Cancelar");
        
        // boton ok deshabilitado por defecto.
        btnOk.setEnabled (false);
        
        // ajustamos el tamaño de los botones.
        btnOk.setPreferredSize (btnCancel.getPreferredSize());
        
        // los botones van a ir en un panel, que usará un BoxLayout 
        // para colocar los botones uno sobre el otro.
        JPanel pnlBotons = new JPanel ();
                
        pnlBotons.setLayout (new BoxLayout (
                pnlBotons, BoxLayout.Y_AXIS));
        
        pnlBotons.add (btnOk);
        pnlBotons.add (btnCancel);
        
        this.add (pnlBotons, BorderLayout.EAST);
        
        // etiquetas para textos.
        JLabel lbl1, lbl2;
        
        lbl1 = new JLabel ("Nom : ");
        lbl2 = new JLabel ("Cognom : ");
        
        // cajas de textos
        txtNom = new JTextField ();
        txtCognom = new JTextField ();
        
        // configuramos los eventos de la caja de texto. Cuando se entre 
        // una tecla, se verifica si se ha de activar o no el botón ok
        txtNom.addKeyListener (new KeyAdapter() {
            @Override
            public void keyReleased (KeyEvent e) {
                verificarBoton ();
            }
        
        });
        
        txtCognom.addKeyListener (new KeyAdapter() {
            @Override
            public void keyReleased (KeyEvent e) {
                verificarBoton ();
            }
        
        });
        
        
        // la parte principal de la ventana, la configuramos como un gridlayout
        JPanel pnlTextes = new JPanel (new GridLayout (3, 2, 1, 10));
        
        // añadimos los componentes al panel principal
        
        pnlTextes.add (lbl1);
        pnlTextes.add (txtNom);
        pnlTextes.add (lbl2);
        pnlTextes.add (txtCognom);
        
        chkAprovat = new JCheckBox ("Aprovat");
        chkSuspes = new JCheckBox ("Suspes");
        
        // al canviar la selección del checkbox se genera un evento de tipo
        // ItemEvent que capturaremos
        chkAprovat.addItemListener (this);
        chkSuspes.addItemListener (this);
        
        JPanel pnlChecks = new JPanel ();
        pnlChecks.add (chkAprovat);
        pnlChecks.add (chkSuspes);
        
        pnlTextes.add (pnlChecks);
        
        this.add (pnlTextes, BorderLayout.CENTER);
        
    }

    /**
     * Activa o desactiva el botón ok en funcion de si se han informado todos
     * los campos de la ventana.
     */
    protected void verificarBoton () {
        // si tenemos una de las dos checkboxes marcadas
        // y las dos cajas de texto informadas, activamos el botón ok
        // sino, lo desactivamos
        
        boolean checksOK = 
                (chkAprovat.isSelected () || chkSuspes.isSelected ());
        
        if (checksOK && txtNom.getText ().equals ("") == false
                && txtCognom.getText ().equals ("") == false) {
         
            btnOk.setEnabled (true);
        } else {
            btnOk.setEnabled (false);
        }
    }
    
    /**
     * gestiona el evento cambio de estado (de marcado a desmarcado o viceversa)
     * de los dos JCheckBoxes.
     * Solo permite que se marque uno de los dos botones.
     * @param ie evento de cambio de estado
     */
    @Override
    public void itemStateChanged(ItemEvent ie) {
        // averiguar quin Check ha generat l'event
        if (ie.getItem().equals (chkAprovat)) {
            // han actuat sobre el check aprovat.
            // mirem si esta marcat per desmarcar el de suspes
            if (chkAprovat.isSelected()) {
                chkSuspes.setSelected (false);
            }
        } else {
            // han canviat l'estat del suspes.
            // mirem si han marcat suspes per desmarcar aprovat
            if (chkSuspes.isSelected()) {
                chkAprovat.setSelected (false);
            }
        }
        
        // tras ajustar los JCheckBoxes, verificasmos si se ha de activar 
        // o no el botón OK
        verificarBoton();
    }
    
}
