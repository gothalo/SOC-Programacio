/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pilasycolas;

/**
 *
 * @author llorenc
 */
public interface StorageInterface {
    
    public final static int CAPACIDAD = 10;
    
    public boolean guardar (String elemento);
    
    public String leer () throws StorageEmptyException;
    
}
