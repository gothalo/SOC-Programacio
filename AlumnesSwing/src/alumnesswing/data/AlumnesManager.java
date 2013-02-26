
package alumnesswing.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Aquesta classe s'encarrega de carregar i desar la llista de alumnes al archiu
 * de disc.
 * Aquest arxiu desa la informació en forma de fitxer separat per 
 * pipes amb el seguent format:
 * nom|primer cognom|segon cognom|nota.
 * 
 * @author llorenc
 */
public class AlumnesManager {
    
    /**
     * Llegeix de disc l'arxiu d'alumnes i el retorna en forma de vector d'alumnes
     * @return Vector d'objectes de tipus Alumne amb les dades guardades al arxiu.
     */
    public Vector <Alumne> getAlumnes () {
    
        BufferedReader br = null;
    
        // objecte on 
        Alumne unAlumne;
        
        Vector <Alumne> llista = new Vector <Alumne> (10, 5); // desa els alumnes
        String linea;
        StringTokenizer st;
        double nota;
       
        try {
            // obrim el fitxer.
            br = new BufferedReader (new FileReader ("Alumnes.txt"));
            
            while ((linea = br.readLine ()) != null) {
                // les dades del alumne venen separades per |. cal separar-les.
                
                st = new StringTokenizer (linea, "|");
                unAlumne = new Alumne ();
                // copiar datos del archivo en la ficha de alumno.
                unAlumne.nom = st.nextToken();
                unAlumne.cognom1 = st.nextToken ();
                unAlumne.cognom2 = st.nextToken ();
                nota = Double.parseDouble (st.nextToken ());
                unAlumne.setNota (nota);
                // añadir el alumno a la lista
                llista.add (unAlumne);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println ("El fichero de alumnos no existe.");
            return null;
            
        } catch (IOException ex) {
            System.out.println("Error leyendo el fichero de alumnos ");
            System.out.println(ex.getMessage ());
            return null;
            
        } finally {
            if (br != null) {
                try {
                    br.close ();
                } catch (IOException ex) {
                    System.out.println ("Error al tancar el fitxer ");
                    System.out.println (ex.getMessage());
                    return null;
                }
            }
            
        }
        
        // ajustem la capacitat del vector al numero d'elements
        llista.trimToSize();
        
        // retornem la llista d'alumnes.
        return llista;
    
    }
    
    /**
     * Desa el contingut de un Vector <Alumne> en un fitxer de texte separat
     * per pipes amb el format
     * nom|primer cognom|segon cognom|nota.
     * @param llista Vector <Alumne> que conté la llista de alumnes a desar.
     * @return numero de elements desats o -1 si hi ha hagut algun error.
     */
    public int saveAlumnes (Vector <Alumne> llista) {
        
        PrintWriter file = null;
        String linea;
        
        int alumnes = 0;
        
        try {
            file = new PrintWriter (new BufferedWriter (new FileWriter ("Alumnes.txt")));
            
            for (Alumne alumne : llista) {
                alumnes ++;
                linea = alumne.nom + "|" + alumne.cognom1 + "|" 
                        + alumne.cognom2 + "|" + alumne.getNota ();
                file.println (linea);
            }
            
        } catch (IOException ioe) {
            System.out.println ("Error al desar les dades");
            System.out.println (ioe.getMessage());
            alumnes = -1;
            
        } finally {
            file.close ();
        }
        
        return alumnes;
    }
}
