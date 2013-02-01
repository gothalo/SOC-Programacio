/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author llorenc
 */
public class Adivina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws java.io.IOException {
        boolean encertat;
        char resposta, ignorar;
        // Pensar la lletra secreta.
        char secreta = (char) ((Math.random () * 26) + 65);
        
        encertat = false;
        
        while (!encertat) {
            // demanar la resposta
            System.out.println ("\nEntra una lletra");
            
            resposta = (char) System.in.read ();
            
            // passem la resposta a majuscules
            resposta = Character.toUpperCase (resposta);
            do {
                ignorar = (char) System.in.read();
            } while (ignorar != '\n'); 

            // verificar si ha encertat
            if (resposta == secreta) {
                encertat = true;
                System.out.println ("Has encertat!!!!");
            } else {
                // si no encerta, dir si va abans o despres al alfabet
                encertat = false;
                if (resposta > secreta) {
                    System.out.println ("La lletra \"secreta\" està abans al alfabet que la lletra " + resposta);
                } else {
                    System.out.println ("La lletra secreta està despres que la lletra " + resposta);
                }
            }
        } // final de while (!encertat)
    } // final de main
} // final de class
