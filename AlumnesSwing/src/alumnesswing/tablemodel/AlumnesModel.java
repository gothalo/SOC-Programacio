package alumnesswing.tablemodel;

import alumnesswing.data.Alumne;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author llorenc
 */
public class AlumnesModel extends AbstractTableModel {
    
    private Vector <Alumne> dades;
    
    private String capcelera [] = {"Nom", "1er Cognom", "2on Cognom", "Nota"};
    
    /**
     * Constructor del Model, que inicialitza les dades de la taula
     * @param dades Vector <Alumne> amb la llista de alumnes que hem de mostrar
     */
    public AlumnesModel (Vector <Alumne> dades) {
        this.dades = dades;
    }
    
    /**
     * Recupera les dades que tenim al model.
     * @return 
     */
    public Vector <Alumne> getDades () {
        return this.dades;
    }

    @Override
    public int getRowCount() {
        return dades.size ();
    }

    @Override
    public int getColumnCount() {
        return capcelera.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Alumne unAlumne = dades.elementAt (fila);
        Object value = null;
        
        switch (columna) {
            case 0 : 
                value = unAlumne.nom;
                break;
                
            case 1 :
                value = unAlumne.cognom1;
                break;
                
            case 2: 
                value = unAlumne.cognom2;
                break;
                
            case 3 :
                value = unAlumne.getNota ();
                break;
                
            default :
                value = null;
        }
        
        return value;
    }

    @Override
    public String getColumnName(int columna) {
        return capcelera [columna];
    }
    
    
    
}
