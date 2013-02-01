/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barcos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author llorenc
 */
public class Barcos {

    final static int FILAS_TABLERO = 4;
    final static int COLUMNAS_TABLERO = 4;
    
    private boolean [][] tablero;
    private boolean [][] registro;
    
    /**
     * Inicializamos el tablero y escondemos el barco. Tambien resetea el registro de movimientos.
     */
    public void inicializarTablero () {
        int filaBarco, columnaBarco;
        
        // Creamos las Matrices, indicando su tamaño.
        tablero = new boolean [FILAS_TABLERO][COLUMNAS_TABLERO];
        registro = new boolean [FILAS_TABLERO][COLUMNAS_TABLERO];
        
        // recorremos todas las celdas de las dos matrices
        // poniendo su valor a false
        
        for (int fila = 0; fila < FILAS_TABLERO; fila++) {
            for (int columna = 0; columna < COLUMNAS_TABLERO; columna++) {
            
                tablero [fila][columna] = false;
                registro [fila][columna] = false;
            }
        }
        
        // escondemos el barco creando una posicion (fila, columna)
        // aleatoria
        filaBarco = (int) (Math.random () * FILAS_TABLERO);
        columnaBarco = (int) (Math.random () * COLUMNAS_TABLERO);
        
        tablero [filaBarco][columnaBarco] = true;
    }
    
    /**
     * registra la tirada del jugador.
     * @return true si encuentra el barco; false si dispara al agua.
     */
    public boolean tirada () throws java.io.IOException {
        String buffer;
        int filaDisparo, columnaDisparo;
        
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        
        // Pedimos al jugador que entre la fila donde dispara
        System.out.println ("Entre las coordenadas del disparo");
        
        do {
            System.out.println   ("Fila (0 - " + (FILAS_TABLERO - 1) + ") ");

            buffer = br.readLine ();
            filaDisparo = Integer.parseInt (buffer);
        } while (filaDisparo >= FILAS_TABLERO || filaDisparo < 0);
        
        // pedimos al jugador que entre la columna donde dispara
        do {
            System.out.println   ("Columna (0 - " + (COLUMNAS_TABLERO - 1) + ") ");
            
            buffer = br.readLine ();
            columnaDisparo = Integer.parseInt (buffer);
        } while (columnaDisparo >= COLUMNAS_TABLERO || columnaDisparo < 0);
        
        // verificar que no se ha disparado antes
        if (registro [filaDisparo][columnaDisparo] == true) {
            System.out.println("Ya has disparado anteriormente aquí");
            return false;
        } else {
            // registramos el disparo
            registro [filaDisparo][columnaDisparo] = true;
        }
        
        // verificamos el resultado
        if (tablero [filaDisparo][columnaDisparo] == true) {
            System.out.println("Tocado y hundido");
            return true;
        } else {
            System.out.println ("Agua");
            return false;
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Barcos partida = new Barcos ();
        boolean resultado = false;
        
        partida.inicializarTablero ();
        
        while (resultado == false) {
            resultado = partida.tirada ();
        }
    }
}
