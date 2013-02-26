/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnesswing.data;

/**
 *
 * @author llorenc
 */
public class Alumne {
    
    final static double NOTA_TALL = 4.5;
    
    // propietats
    public String nom, cognom1, cognom2;
    
    private double nota;
    
    // constructors
    public Alumne () {
        this.nom = this.cognom1 = this.cognom2 = "";
    }
    
    // metodes
    
    /**
     * Ens diu si un alumne esta aprovat si la seva nota
     * es mes gran o igual que 4.5
     * 
     * @return true si esta aprovat, false si no 
     */
    public boolean estaAprovat () {
        
        boolean aprovat;
        
        if (nota >= NOTA_TALL) {
            aprovat = true;
        } else {
            aprovat = false;
        }
        
        return aprovat;
        
    }
    
    /**
     * dona valor a la propietat nota. Si la novaNota no esta entre 0 i 10
     * no fa res
     * 
     * @param novaNota el nou valor per la propietat nota
     */
    public void setNota (double novaNota) {
        
        if ((novaNota >= 0) && (novaNota <= 10)) {
            this.nota = novaNota;
        }
        
    }
    
    /**
     * Recupera el valor de la propietat nota.
     * @return el valor de la propietat nota
     */
    public double getNota () {
        return this.nota;
    }
    
    /**
     * retorna el nom i els cognoms de manera concatenada.
     * @return 
     */
    public String nomComplert () {
        String nomICognoms;
        
        nomICognoms = nom + " " + cognom1 + " " + cognom2;
        
        return nomICognoms;
    
    }

    @Override 
    public String toString () {
        return "Alumne : " +  nom + " " + cognom1 + " " + cognom2 + ". Nota : "
                + nota;
    }
}
