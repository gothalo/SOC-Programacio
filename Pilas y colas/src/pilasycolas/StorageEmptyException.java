/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pilasycolas;

/**
 *
 * @author llorenc
 */
public class StorageEmptyException extends Exception {
    
    public StorageEmptyException (String message) {
        super (message);
    }
    
    @Override
    public String getMessage () {
        return "Magatzem Buit. " + super.getMessage ();
    }
    
}
