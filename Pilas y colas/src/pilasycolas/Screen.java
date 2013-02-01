/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pilasycolas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author llorenc
 */
public class Screen extends JFrame implements ActionListener {

    private JTextField text;
    private JButton anadir;
    private JButton recuperar;
    Cola datos;

    public Screen() {
        super();

        // creamos la pila.
        datos = new Cola ();

        // creamos la ventana.
        inicializeScreen();

        // mostramos la ventana.
        this.setVisible(true);
    }

    /**
     * inicializamos los componentes de la ventana
     */
    private void inicializeScreen() {
        // al cerrar la ventana finalizamos la aplicacion
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // tamaño por defecto de la ventana.
        this.setSize(300, 100);

        // fijamos el layout de los componentes
        this.setLayout(new BorderLayout());

        // caja de texto
        text = new JTextField();
        this.getContentPane().add(text, BorderLayout.CENTER);

        // añadimos los botones
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        anadir = new JButton("Añadir");
        panel.add(anadir);
        anadir.addActionListener(this);

        recuperar = new JButton("Recuperar");
        panel.add(recuperar);
        recuperar.addActionListener(this);


        this.getContentPane().add(panel, BorderLayout.SOUTH);

    }

    /**
     * Gestiona los eventos click sobre los botones.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getActionCommand().equalsIgnoreCase("AÑADIR")) {
            // solo guardamos si tenemos texto.
            if (!text.getText().isEmpty()) {
                guardar(datos, text.getText());
            }
        }

        if (ae.getActionCommand().equalsIgnoreCase("RECUPERAR")) {
            try {
                // recuperamos el elemento y lo mostramos en la ventana
                text.setText(datos.leer());
            } catch (StorageEmptyException see) {
                text.setText (see.getMessage ());
            }
        }

    }

    private void guardar (StorageInterface datos, String elemento) {
        // añade el texto entrado a la pila
        if (datos.guardar(elemento)) {
            text.setText("");
        } else {
            text.setText("--- pila llena ---");
        }

    }
}
