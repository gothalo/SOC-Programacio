/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices;

/**
 *
 * @author llorenc
 */
public class UtilitatsMatrius {
    
    /**
     * Cerca fent servir l'algoritme de cerca sequencial el valor dins la matriu
     * 
     * @param matriu Array que conte els valors on volem cercar
     * @param valor el valor a cercar
     * @return la posició on es troba el valor dins la matriu o -1
     */
    public static int cercaSequencial (int matriu [], int valor) {
        // recorrer els elements de la matriu
        for (int i = 0; i < matriu.length; i++) {
        
            if (matriu [i] == valor) {
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     * Ordena una matriu fent servir l'algorisme de la bombolla
     * @param matriu matriu de enters a ordenar
     * @return la matriu rebuda com a parametre ordenada
     */
    public int [] ordenarBombolla (int matriu []) {
        // variables index
        int i, j;
        
        // variable temporal per el intercanvi de valors
        int tmp;
        
        for (i = 1; i <= matriu.length; i++) {
            // recorrer la matriu mirant si un element es mes
            // gran que el seu vei. 
            for (j = 0; j < matriu.length - i; j++) {
                if (matriu [j] > matriu [j + 1]) {
                    // quan un element es mes gran que el seu
                    // vei cal intercanviarlos
                    tmp = matriu [j];
                    matriu [j] = matriu [j + 1];
                    matriu [j + 1] = tmp;
                    
                }
            }
        }
        // retornem la matriu ordenada;
        return matriu;
    }
    
    public int cercaSequencialV2 (int matriu [], int valor) {
        int resultado = -1;
        
        for (int i = 0; i < matriu.length; i++) {
        
            if (matriu [i] == valor) {
                resultado = i;
                break;
            }
        }
        
        return resultado;
        
    }
    
}
