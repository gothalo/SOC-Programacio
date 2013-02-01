/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices;

/**
 *
 * @author llorenc
 */
public class Matrices2D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // declaramos una matriz de Strings de dos dimensiones 
        String menuSemanal [][] = {
            {"Judia Verde", "San Jacobo", "Manzana"},
            {"Macarrones Carbonara", "Pollo al Horno", "Platano"}
        };
        
        // mostramos por pantalla la matriz de menu
        
        for (int fila = 0; fila < menuSemanal.length; fila++) {
            for (int columna = 0; columna < menuSemanal [fila].length; columna++) {
                System.out.print (menuSemanal [fila][columna]);
                System.out.print ('\t');
            }
            System.out.println ("");
        }
        
        final int FILAS = 3;
        final int COLUMNAS = 4;
        
        int tabla [][] = new int [FILAS][COLUMNAS];
        
        
    }
}
