/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import java.io.*;
import java.util.Vector;

/**
 *
 * @author llorenc
 */
public class Ahorcado {

    private final static int FALLOS_PERMITIDOS = 8;
    private final static int NUMERO_PARAULES = 10;
    
    /** muestra una matriz de caracteres por la salida standard (System.out)
     * separando los distintos carácteres con un espacio en blanco.
     * @param marcador matriz de caracteres a mostrar
     */
    public void mostrarEstado (char [] marcador) {
    
        for (int i = 0; i < marcador.length; i++) {
            System.out.print (marcador [i]);
            System.out.print (' ');
        }
        System.out.println("");
    }
    

    
    public String obtenerPalabraSecreta () {
       Diccionari dic = new Diccionari ();
       
       dic.thr.start();
       
       
       try {
            dic.thr.join ();
       } catch (InterruptedException ex) {
           System.out.println (ex.getMessage ());
       }
            
            
       return dic.getPalabra();
       
    
    }
    
    /**
     * una partida al juego del ahorcado.
     * @throws IOException 
     */
    public void juego () throws IOException {
        
        String palabraSecreta; // guarda la palabra que hemos de adivinar
        char marcador [];      // estado de la partida, guarda _ para letras no adivinadas o las letras acertadas
        int fallos, aciertos;  
        int posicion;          
        int numeroLetras;
        String letra;
        boolean encontrada;
        
        palabraSecreta = obtenerPalabraSecreta();
        
        // contamos las letras sobre las que jugamos
        numeroLetras = palabraSecreta.length();
        
        // creamos un marcador con tantas letras como letras tiene la palabra de juego
        marcador = new char [numeroLetras];
        
        for (int i = 0; i < numeroLetras; i++) {
            marcador [i] = '_';
        }
        
        // mostramos el marcador inicial, para dar una pista del numero de letras
        mostrarEstado(marcador);
        
        // definimos un BufferedReader y lo asociamos al teclado
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        
        // inicializamos los contadores de aciertos y fallos
        aciertos = 0;
        fallos = 0;
        
        
        // comienza el juego.
        // repetiremos mientras no se hayan acertado todas las letras y no se alcance el numero máximo de errores
        while ((aciertos < numeroLetras) && (fallos < FALLOS_PERMITIDOS)) {
            // entrar una letra
            System.out.println("Entra una letra");
            letra = br.readLine();
            
            // pasamos a mayusculas
            letra = letra.toUpperCase ();
            // comenzaremos a buscar por el principio
            posicion = 0;
            encontrada = false;
            
            while (posicion != -1) {
                posicion = palabraSecreta.indexOf (letra, posicion);
                
                if (posicion != -1) {
                    if (marcador [posicion] != letra.charAt (0)) {
                        // actualizamos el marcador
                        marcador [posicion] = letra.charAt (0);
                        // contamos el acierto
                        aciertos++;
                    }
                    posicion++;
                    // marcamos que la hemos encontrado
                    encontrada = true;
                } else {
                    if (encontrada == false) {
                        fallos++;
                        System.out.println("has fallado");
                        System.out.println("Numero fallos " + fallos);
                    }
                }
            }
            
            // enseñamos como va la partida
            mostrarEstado (marcador);
        }
        
        // mostrar el resultado de la partida.
            
        if (fallos == FALLOS_PERMITIDOS) {
            System.out.println("Has perdido");
        } else {
            System.out.println("has ganado");   
        }
        
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Ahorcado a = new Ahorcado ();
        a.juego();
    }
}
