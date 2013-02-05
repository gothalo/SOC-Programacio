/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exempleclasses;

import exempleclasses.newpackage.ExempleClasses;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author llorenc
 */
public class ExempleClassesMain {
    
    /**
     * Carrega la llista de alumnes des de un arxiu de texte
     */
    public static void leerAlumnos () {
        Alumne unAlumne;
        BufferedReader br = null;
        Vector <Alumne> llista = new Vector <Alumne> (10, 5); // desa els alumnes
        String linea;
        StringTokenizer st;
        double nota;
       
        try {
            
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
            
        } catch (IOException ex) {
            System.out.println("Error leyendo el fichero de alumnos ");
            System.out.println(ex.getMessage ());
            
        } finally {
            if (br != null) {
                try {
                    br.close ();
                } catch (IOException ex) {
                    System.out.println ("Error al tancar el fitxer ");
                    System.out.println (ex.getMessage());
                }
            }
            
        }
        
        for (int i = 0; i < llista.size (); i++) {
            unAlumne = llista.get (i);
            System.out.println (unAlumne.nom + " " + 
                                unAlumne.cognom1 + " " + 
                                unAlumne.cognom2 + " : " +
                                unAlumne.getNota ());
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        leerAlumnos ();
        // finalitza el programa
        System.exit (0);
        
        //exempleclasses.newpackage.ExempleClasses objEjemplo;
        ExempleClasses objEjemplo;
        
        // inicializamos el objeto
        objEjemplo = new ExempleClasses();
        
        // llamamos al método sumaDosNumeros
        int resultado = objEjemplo.sumaDosNumeros(3, 6);
        
        System.out.println (resultado);
        
        // asignamos un valor a la propiedad rango
        objEjemplo.rango = 8;
        
        ExempleClasses otroObjeto = new ExempleClasses ();
        
        ExempleClasses objecteAmbParametre = new ExempleClasses (111);
        
        
        // ejercicio de alumnos
        
        Alumne unAlumne = new Alumne ();
        
        unAlumne.nom = "Llorenç";
        unAlumne.cognom1 = "Foixench";
        
        unAlumne.setNota (6);
        
        System.out.println (unAlumne.estaAprovat ());
        
        Alumne segonAlumne = new Alumne ();
        
        segonAlumne.nom = "Eduard";
        segonAlumne.setNota (8);
        
        System.out.println (segonAlumne.nom + " ha tret un " 
                + segonAlumne.getNota ());
        
        System.out.println (unAlumne.nomComplert());
        
        System.out.println ("toString del alumne : " + unAlumne.toString ());
        
        unAlumne.verToStrings();
        
    }
}
