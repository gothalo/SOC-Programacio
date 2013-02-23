/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taules.models;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author llorenc
 */
public class Model extends AbstractTableModel {
    
    // guarden la informació de la taula
    private Object dades [][];
    private String capcelera [];
    
    public Model (String [] capcelera, Object [][] dades) {
        // guardem les dades a les matrius de enmagatzenament.
        this.dades = dades;
        this.capcelera = capcelera;
    }
    
    /**
     * Indica el numero de files que ha de tenir la taula
     * @return numero de files de la taula
     */
    @Override
    public int getRowCount() {
        // la taula ha de tenir tantes files com la matriu de deades
        return this.dades.length;
    }

    /**
     * indica el numero de columnes que ha de tenir la taula
     * @return numero de columnes de la taula
     */
    @Override
    public int getColumnCount() {
        return this.capcelera.length;
        
        // return this.dades [0].length
    }

    /**
     * Donada una cela (fila, columna) recupera el valor que s'ha de visualitzar
     * a la taula
     * @param fila numero de fila
     * @param columna numero de columna
     * @return el valor que cal mostrar a la taula, per una cela concreta
     */
    @Override
    public Object getValueAt(int fila, int columna) {
        return dades [fila][columna];
    }

    /**
     * Retorna el titol de la columna indicada com a parametre
     * @param columna numero de columna
     * @return String amb la capcelera de la columna
     */
    @Override
    public String getColumnName(int columna) {
        return capcelera [columna];
    }

    /**
     * inidica el tipo de datos de la columna para que la JTable
     * sepa que representación ha de usar
     * @param columna
     * @return 
     */
    @Override
    public Class<?> getColumnClass(int columna) {
        return dades [0][columna].getClass();
    }

    @Override
    public boolean isCellEditable(int fila, int columna) {
        if (columna == 3) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void setValueAt(Object nuevoValor, int fila, int columna) {
        dades [fila][columna] = nuevoValor;
        
        if (columna == 2) {
            // recuperem el valor de la nota
            double nota = (Double) nuevoValor;
            
            // marquem aprovat o suspes
            if (nota >= 4.5) {
                dades [fila][3] = true;
            } else {
                dades [fila][3] = false;
            }
        }
        // generamos aviso de cambio de datos
        fireTableDataChanged();
    }

    
    
    
}
