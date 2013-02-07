/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package experimento;

/**
 *
 * @author llorenc
 */
public class Experimento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SubeBaja sube = new SubeBaja ("SUBE");
        SubeBaja baja = new SubeBaja ("BAJA");
        
        sube.thr.start ();
        baja.thr.start ();
        
        try {
            sube.thr.join ();
            baja.thr.join ();
        } catch (InterruptedException ex) {
            System.out.println (ex);
        }
        
        System.out.println ("Sube " + sube.valor);
        System.out.println ("Baja " + baja.valor);
    }
}
