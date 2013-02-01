/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author llorenc
 */
public class Bucles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // mostramos la tabla de multiplicar del 7
        
        int i, j; 
        
        for (i = 0; i <= 10; i++) {
            
            for (j = 0; j <= 10; j++) {
                System.out.println (j + " por " + i + " = " + (j * i));
            }
            
            System.out.println (" --------------------");
        }
        
        for (i = 0, j = 10; i < j; i++, j--) {
            System.out.println("i = " + i + ", j = " + j);
        }
        
        // exemple del bucle while
        
        char caracter = 'a';
        
        while (caracter <= 'z') {
            System.out.println (caracter);
            
            caracter++;
        }
        
        // amb el bucle do while
        caracter = 'a';
        
        do {
            System.out.println (caracter);
            caracter++;
            
        } while (caracter <= 'z');
        
    }
}
