/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author llorenc
 */
public class Exceptions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int entero = 8; 
        int resultado;
        
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        
        try {
            System.out.println ("Entra un número entero : ");
            entero = Integer.parseInt (br.readLine ());
            
            resultado = entero / 0;
            
            System.out.println (resultado);
        
        } catch (ArithmeticException e) {
            System.out.println ("error en Main " + e.getMessage());
            e.printStackTrace ();
            
        } catch (IOException ioe) {
            System.out.println ("no se ha podido leer el entero : " 
                    + ioe.getMessage ());
            
        } catch (NumberFormatException nfe) {
            System.out.println ("TONTO!!! TE DIJE UN ENTERO!!!!");
        
        } catch (Exception e) {
            System.out.println ("error en Main " + e.getMessage ());
        
        }
        
        finally {
            
            System.out.println ("por aqui pasamos siempre");
        }
        
        System.out.println ("fuera del bloque try / catch");
        
    }
}
