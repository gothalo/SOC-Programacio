/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author llorenc
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // declarar variables
        int ultim, penultim, nou;
        // assignar valors inicials
        ultim = 1;
        penultim = 1;
        // mostrar els primers numeros de la serie
        System.out.println (penultim);
        System.out.println (ultim);
        
        for (int i = 0; i <= 10; i++) {
            // calcular el seguent valor de la serie
            nou = ultim + penultim;
            
            System.out.println (nou);
            
            // canviem els papers dels valors
            penultim = ultim;
            ultim = nou;
            
        }
        
        
    }
}
