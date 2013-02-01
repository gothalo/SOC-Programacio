/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author llorenc
 */
public class Operacions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // declarem dos variables numeriques amb decimals
        double numero1, numero2;
        double resultat;
        
        float numero3;
        
        // donem valor inicial a les variables.
        numero1 = 13.37;
        numero2 = 88.6;
        
        numero3 = 3.14f;
        
        // fem les operacions.
        resultat = numero1 + numero2;
        System.out.println ("El resultat es " + (numero1 + numero2));
        
        resultat = numero1 - numero2;
        System.out.println (resultat);
        
        System.out.println (numero1 * numero2);
        
        System.out.println ("la divisió entre " 
                           + numero1 + " i " + numero2
                           + " dona " + numero1 / numero2);
        
        
    }
}
