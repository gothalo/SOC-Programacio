/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices;

/**
 *
 * @author llorenc
 */
public class Matrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // declaro una matriz de enteros de cinco elementos
        int aleatorios [] = new int [5];
        
        
        // usamos un bucle for para asignar los valores a la matriz
        for (int i = 0; i < aleatorios.length; i++) {
            aleatorios [i] = (int) (Math.random () * 20) + 1;
        }
        
        // mostramos el contenido de la matriz en pantalla
        
        for (int i = 0; i < aleatorios.length; i++) {
            System.out.println ("Elemento " + i + " de la matriz : " + aleatorios [i]);
        }
        
        UtilitatsMatrius cercador = new UtilitatsMatrius();
        
        int resultado = cercador.cercaSequencial(aleatorios, 13);
        
        if (resultado == -1) {
            System.out.println("No s'ha trobat");
        } else {
            System.out.println ("el numero 13 està a la posició " + resultado);
        }
        
        UtilitatsMatrius.cercaSequencial (aleatorios,13);
        
        aleatorios = cercador.ordenarBombolla (aleatorios);
        
        System.out.println ("====== ordenada ======");
        
        for (int i = 0; i < aleatorios.length; i++) {
            System.out.println ("Elemento " + i + " de la matriz : " + aleatorios [i]);
        }
        
    }
}
