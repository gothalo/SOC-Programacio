/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author llorenc
 */
public class Herencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pare p = new Pare ();
        Fill f = new Fill ();
//        Neta n = new Neta ();
        
        int resultado = f.generarEntero ();
        
        System.out.println (resultado);
        
        System.out.println ("Pare, dame una letra " + p.dameUnaLetra());
        System.out.println ("Fill, dame una letra " + f.dameUnaLetra());
       // System.out.println ("Neta, dame una letra " + n.dameUnaLetra());
        
    }
}
