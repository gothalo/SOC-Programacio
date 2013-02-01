/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author llorenc
 */
public class Condicions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // declaracio de variables. donem valos inicials
        int a = 1;
        int b = 5;
        int c = 4;
         
        // verifiquem si a guarda el valor mes gran
        if ((a > b) && (a > c)) {
            // a es el mes gran de tots
            System.out.println("a es el mes gran");
        } else if ((b > a) && (b > c)) {
            // b es el mes gran que tots
            System.out.println("b es el mes gran");
        } else {
	    // si hem arribat aqui, es que ni a ni b son els mes grans
            // per tant, el mes gran serà c
            System.out.println("c es el mes gran");
        }
        
        // generem un numero aleatori entre 1 i set
        int aleatori = (int) ((Math.random() * 7) + 1);

        switch (aleatori) {
            case 1 :
                System.out.println ("avui es dilluns");
                break;
            case 2 :
                System.out.println ("avui es dimarts");
                break;
            case 3 :
                System.out.println ("avui es dimecres");
                break;
            case 4 :
                System.out.println ("avui es dijous");
                break;
            case 5 :
                System.out.println ("avui es divendres");
                break;
            case 6 :
                System.out.println ("avui es dissabte");
                break;
            case 7 :
                System.out.println ("avui es diumenge");
                break;
            default :
                System.out.println ("no se quin dia es avui");
                break;
            
        }
        int r,t;
        
        
        
    } // final de main
} // fi de la classe
