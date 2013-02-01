/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

/**
 *
 * @author llorenc
 */
public class Variables {
    
    int variableGlobal = 8;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int numeroEntero;
        
        numeroEntero = 3;
        
        System.out.println (numeroEntero);
        
        // declaramos una variable para numeros con decimales
        
        double numeroDecimal = 3.14;
        
        // declaramos una variable para numeros con decimales
        char unCaracter = 'x';
        
        // asignamos valores a nuestra variable de enteros
        numeroEntero = 37;
        
        numeroEntero = 2 + 2;
        
        numeroEntero = numeroEntero + 1;
        
        // para almacenar un resultado double a uno entero, hace falta
        // hacer un cast.
        numeroEntero = (int) (numeroDecimal - 0.14);        
        
        
        
    }
}
