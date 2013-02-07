/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author llorenc
 */
public class Diccionari implements Runnable {

    private Vector <String> vecDiccionari;
    private final static int NUMERO_PARAULES = 10;
    
    public Thread thr;
    
    public Diccionari () {
        thr = new Thread (this);
    }
    
    @Override
    public void run () {
        // leer el diccionario y guardarlo en una matriz de String.
        BufferedReader br = null;
        String paraula;
        
        vecDiccionari = new Vector <String> 
                (NUMERO_PARAULES, NUMERO_PARAULES);
        
        try {
            
            br = new BufferedReader (new FileReader ("diccionari.txt"));
            
            // copiem el contingut del arxiu en la matriu diccionari
            while ((paraula = br.readLine ()) != null)  {
                vecDiccionari.add (paraula);
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println (ex);
            
        } catch (IOException ex) {
            System.out.println (ex);
        } finally {
            if (br != null) {
                try {
                    br.close ();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }
    
    public String getPalabra () {
        String paraulaSecreta;
        
        // mirar si hi ha vector i si te elements
        if (vecDiccionari != null && vecDiccionari.size () > 0) {

            // seleccionem una paraula de la llista
            int selecciona = (int) (Math.random () * vecDiccionari.size());
            paraulaSecreta = vecDiccionari.get (selecciona);

            // posem la paraula triada a majuscules
            paraulaSecreta = paraulaSecreta.toUpperCase ();
        } else {
            paraulaSecreta = "";
        }
        return paraulaSecreta;
        
    }
    
}
