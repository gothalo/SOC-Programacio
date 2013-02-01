/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entradasalida;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author llorenc
 */
public class BitStream {
    
    public void capturarTeclat () {
    
        FileOutputStream arxiu = null;
        int tecla;
        
        try {
            // obrim el fitxer
            arxiu = new FileOutputStream ("tecles.dat", true);
            
            do {
                // llegim una tecla des del teclat
                tecla = System.in.read ();

                // guardem el que ens ha entrat al arxiu
                arxiu.write(tecla);
                
            // read () torna -1 si s'arriba a final de arxiu (fluxe)    
            } while (tecla != '*' && tecla != -1);
            
            // escribim un salt de linea final
            arxiu.write ('\n');
        
        } catch (FileNotFoundException fnfe) {
            System.out.println ("No s'ha pogut obrir l'arxiu : " 
                    + fnfe.getMessage());
        
        } catch (IOException ioe) {
            System.out.println ("Error de entrada / sortida : " 
                    + ioe.getMessage());
        
        } finally {
            if (arxiu != null) {
                try {
                    // tanquem l'arxiu si aquest ha estat obert previament
                    arxiu.close ();
                } catch (IOException ex) {
                    System.out.println ("No s'ha pogut tancar l'arxiu : " 
                            + ex.getMessage());
                    
                }
            }
        }
            
    }
    
    public void llegirFitxer () {
        FileInputStream arxiu = null;
        int dada;
        
        try {
            arxiu = new FileInputStream ("tecles.dat");
            
            dada = arxiu.read ();
            
            while (dada != -1) {
                System.out.write (dada);
                dada = arxiu.read ();
            }
        } catch (FileNotFoundException fnfe) {  
            
        } catch (IOException ex) {
            Logger.getLogger(BitStream.class.getName()).log (Level.SEVERE, null, ex);
        
            
        } finally {
            if (arxiu != null) {
                try {
                    arxiu.close ();
                } catch (IOException ioe) {
                    
                }
            }
        }
    }
    
    /**
     * Copia el fitxer origen al fitxer desti. Si desti existeix, el sobreescriu
     * @param origen nom del fitxer original
     * @param desti nom del fitxer copia
     */
    
    public void duplicar (String origen, String desti) {
        FileInputStream fitxerOrigen = null;
        FileOutputStream fitxerDesti = null;
        
        byte [] bitData = new byte [1024];
        int numBits;
        try {
            // creem i obrim els objectes que fan referencia als fitxers
            fitxerOrigen = new FileInputStream (origen);
            fitxerDesti = new FileOutputStream (desti, true);
            
            // llegim el primer bit
            numBits = fitxerOrigen.read (bitData);
            
            while (numBits != -1) {
                // copiem el que hem llegit
                fitxerDesti.write (bitData);
                
                // llegim seguent bit
                numBits = fitxerOrigen.read (bitData);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println (ex);
            
        } catch (IOException ex) {
            System.out.println (ex);
        } finally {
            if (fitxerOrigen != null) {
                try {
                    fitxerOrigen.close ();
                } catch (IOException ex) {
                    System.out.println (ex);
                }  
            }
            if (fitxerDesti != null) {
                try {
                    fitxerDesti.close ();
                } catch (IOException ex) {
                    System.out.println (ex);
                }
            }
        }
    }
}
