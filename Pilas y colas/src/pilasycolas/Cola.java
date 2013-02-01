/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pilasycolas;

/**
 * Classe que implementa una cua per enmagatzemar enters.
 * @author llorenc
 */
public class Cola implements StorageInterface {
    
    private final static int TAMANY_DEFECTE = 10;
    private String magatzem [];
    
    private int cursorD, cursorL;
    
    /**
     * Constructor per defecte. Crea una cua amb capacitat màxima TAMANY_DEFECTE
     */
    public Cola () {
        this (TAMANY_DEFECTE);
    }
    
    /**
     * Crea una cua amb capacitat máxima indicada per el parametre tamany
     * @param tamany número de elements màxims que es poden guardar a la cua
     */
    public Cola (int tamany) {
        // iniciatitzem matriu al tamany indicat
        magatzem = new String [tamany];
        
        // posició lectura i escrtitura al inici
        cursorD = 0;
        cursorL = 0;
    }
    
    /**
     * Desa un element a la cua
     * @param element el element a desar
     * @return la posició a la cua on s'ha guardat l'element o -1 si la cua està plena
     */
    @Override
    public boolean guardar (String element) {
        
        //verificar cua plena
        if (cursorD < magatzem.length) {
            // desem el element a la posició indicada per cursorD
            magatzem [cursorD] = element;
            cursorD++;
            
            return true;
        } else {
            System.out.println ("Cua plena");
            
            return false;
        }
        
    }
    
    /**
     * recupera el primer element de la cua
     * @return el element llegit
     */
    @Override
    public String leer () throws StorageEmptyException {
        
        String resultat;
        
        // verifiquem que la cua tingui alguna cosa desada
        if (cursorL < cursorD) {
            resultat = magatzem [cursorL];
            cursorL++;
            return resultat;
             
        } else {
            System.out.println ("Cua buida");
            // generamos una exception 
            throw new StorageEmptyException ("Cua Buida");
            //return "Cua Buida";
        }
        
    }
    
    // verifica si la cua es buida o te elements.
    public boolean esBuida () {
        return (cursorL == cursorD);
    }

}
