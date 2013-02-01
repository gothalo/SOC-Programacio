/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entradasalida;

import java.io.*;

/**
 *
 * @author llorenc
 */
public class TextStream {
    
    public void capturarTeclat () {
    
        // declaro el objecte que representa al stream de sortida
        FileWriter fw = null;
        char caracter;
        try {
            fw = new FileWriter ("tecles_fw.txt", true);
        
            // llegim un csaràcter des de teclat
            do {
                caracter = (char) System.in.read ();
                fw.write (caracter);
                
            // usamos '*' para indicar que hemos terminado de leer.
            } while (caracter != '*'); 
            fw.write ('\n');
            
        } catch (IOException ioe) {
            System.out.println (ioe);
        } finally {
            try {
                fw.close ();
            } catch (IOException ioe) {
                System.out.println(ioe);
            } catch (NullPointerException npe) {
                System.out.println(npe);
            }
        }
    }
    
    public void llegirFitxer () {
        FileReader fr = null;
        int leido;
        try {
            fr = new FileReader ("tecles_fw.txt");
            
            leido = fr.read ();
            
            while (leido != -1) {
                System.out.print ( (char) leido );
                leido = fr.read ();
            }
            
        } catch (IOException ioe) {
            System.out.println(ioe);
        } finally {
            try {
                fr.close ();
            } catch (IOException ioe) {
                System.out.println (ioe);
            } catch (NullPointerException ne) {
                System.out.println (ne);
            }
        }
    }
    
    public void llegirArxiu (String nom) {
        
        String linea;
        
        BufferedReader br = null;
        
        try {
            // inicializamos el BufferedReader
            br = new BufferedReader (new FileReader (nom));
            
            // lectura de la primera linea
            linea = br.readLine ();

            // repetimos hasta final de fichero
            // while ((linea = br.readLine ()) != null)
            while (linea != null) {
                // mostrar por pantalla lo leido
                System.out.println (linea);
                // leer la siguiente linea
                linea = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println (ex);
            
        } catch (IOException ex) {
            System.out.println (ex);
        
        } finally {
            if (br != null) {
                try { 
                    // cerrar el archivo
                    br.close ();
                } catch (IOException ex) {
                    System.out.println (ex);
                }
            }
        }
    }
    
    public void escriureArxiu (String nom) {
        
        String texte;
        
        // escriurà a un fitxer
        PrintWriter out = null;
        // llegirà des de teclat
        BufferedReader br = null;
        
        try {
          // definim el buffered reader des de teclat
            br = new BufferedReader (new InputStreamReader (System.in));
            
            // accedim al arxiu indicat per nom, sobreescivint el que hi hagi
            out = new PrintWriter (new BufferedWriter (new FileWriter (nom)));
            
            do {
                // llegim una llinea des teclat
                texte = br.readLine ();
                // guardem la linea al arxiu
                out.println (texte);
                
                
            } while (texte.equals ("*") == false);
            // while (!texte.equals ("*"));
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        
        } catch (IOException ex) {
            System.out.println(ex);
        
        } finally {
            out.close ();
        }
        
    }
    
}
