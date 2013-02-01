/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pilasycolas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author llorenc
 */
public class PilasYColas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Pila pila = new Pila ();
        String elemento;
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        
//        for (int i = 0; i <= 10; i++) {
//            System.out.println("Entre un nuevo elemento");
//            elemento = br.readLine ();
//            pila.guardar (elemento);
//            
//        }
        
        Screen s = new Screen ();
    }
}
