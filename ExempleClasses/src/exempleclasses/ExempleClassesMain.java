/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exempleclasses;

import exempleclasses.newpackage.*;
import exempleclasses.newpackage.ExempleClasses;

/**
 *
 * @author llorenc
 */
public class ExempleClassesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
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
