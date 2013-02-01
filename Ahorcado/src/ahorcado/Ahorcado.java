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
    
    /**
     * Esta funcion genera la palabra secreta. En este caso la pedimos por pantalla.
     * Cambiando el contenido del método podriamos generar la palabra de otros modos
     * @return
     * @throws IOException 
     */
    public String obtenerPalabraSecreta () throws FileNotFoundException, IOException {
        String palabraSecreta;
        
        /*
         * Version que lee la palabra desde teclado 
        
        // asociamos un reader a la entrada de teclado para saber la palabra secreta
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        
        // entramos la palabra de juego y la pasamos a mayusculas
        System.out.println("Entre la palabra secreta");
        palabraSecreta = br.readLine();
        
        palabraSecreta = palabraSecreta.toUpperCase();
        
        return palabraSecreta;
        
        */
        
        // leer el diccionario y guardarlo en una matriz de String.
        String diccionari [] = new String [NUMERO_PARAULES];
        BufferedReader br = null;
        String paraula;
        int contador;
        String paraulaSecreta = "";
        try {
            
            br = new BufferedReader (new FileReader ("diccionari.txt"));
            
            contador = 0;
            
            
            // copiem el contingut del arxiu en la matriu diccionari
            while (((paraula = br.readLine ()) != null) && (contador < NUMERO_PARAULES)) {
                diccionari [contador] = paraula;
                contador++;
            }
            
            // seleccionem una paraula de la llista
            int selecciona = (int) (Math.random () * NUMERO_PARAULES);
            paraulaSecreta = diccionari [selecciona];
            // posem la paraula triada a majuscules
            paraulaSecreta = paraulaSecreta.toUpperCase ();
            
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException ("No s'ha trobat el diccionari " 
                    + ex.getMessage ());
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (br != null) {
                try {
                    br.close ();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
        
        return paraulaSecreta;
     
    }

    
    public String obtenerPalabraSecretaVec () 
            throws FileNotFoundException, IOException {
        
        // leer el diccionario y guardarlo en una matriz de String.
        //String diccionari [] = new String [NUMERO_PARAULES];
        BufferedReader br = null;
        String paraula;
        String paraulaSecreta = "";
        
        Vector <String> vecDiccionari = new Vector <String> 
                (NUMERO_PARAULES, NUMERO_PARAULES);
        
        try {
            
            br = new BufferedReader (new FileReader ("diccionari.txt"));
            
            // copiem el contingut del arxiu en la matriu diccionari
            while ((paraula = br.readLine ()) != null)  {
                vecDiccionari.add (paraula);
            }
            
            // seleccionem una paraula de la llista
            int selecciona = (int) (Math.random () * vecDiccionari.size());
            paraulaSecreta = vecDiccionari.get (selecciona);
            
            // posem la paraula triada a majuscules
            paraulaSecreta = paraulaSecreta.toUpperCase ();
            
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException ("No s'ha trobat el diccionari " 
                    + ex.getMessage ());
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (br != null) {
                try {
                    br.close ();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
        
        return paraulaSecreta;
     
    
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
