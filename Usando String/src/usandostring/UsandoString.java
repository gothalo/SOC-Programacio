/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usandostring;

/**
 *
 * @author llorenc
 */
public class UsandoString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena1, cadena2;
        
        cadena1 = "HOLA";
        cadena2 = "HOLA";
        
        // compara los objetos, no los contenidos, por lo que no
        // deberia funcionar
        
        if (cadena1 == cadena2) {
            System.out.println ("Iguales");
        } else {
            System.out.println ("Diferentes");
        }
        
        if (cadena1.equals (cadena2)) {
            System.out.println ("Iguales");
        } else {
            System.out.println ("Diferentes");
        }
        
        if (cadena1.compareTo (cadena2) == 0) {
            System.out.println ("Iguales");
        } else {
            System.out.println ("Diferentes");
        }
        
        int posicionLA = cadena1.indexOf ("LA");
        System.out.println(posicionLA);
        
        
        String cadena3 = "Tres Tristes Tigres Trigaban Trigo";
        int numeroT = 0;
        int posicion = 0;
        
        while (posicion != -1) {
            posicion = cadena3.indexOf ("T", posicion);
            
            if (posicion != -1) {
                numeroT ++;
                posicion ++;
            }
        }
        
        System.out.println(numeroT);
        
        String cadena4 = cadena3.substring (5,12);
        
        System.out.println ("[" + cadena4 + "]");
        
        
    }
}
