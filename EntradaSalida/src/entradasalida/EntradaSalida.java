/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entradasalida;

/**
 *
 * @author llorenc
 */
public class EntradaSalida {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BitStream bs = new BitStream ();
        
//        bs.capturarTeclat();
//        
//        bs.llegirFitxer();
        
//        bs.duplicar ("foto.jpg", "copia.jpg");
        
        TextStream ts = new TextStream ();
        
//        ts.capturarTeclat();
//        ts.llegirFitxer();
        ts.escriureArxiu("tecles.dat");
        ts.llegirArxiu ("tecles.dat");
    }
}
