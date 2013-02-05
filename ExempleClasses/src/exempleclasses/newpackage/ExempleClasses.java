/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exempleclasses.newpackage;

/**
 *
 * @author llorenc
 */
public class ExempleClasses {
    public int rango;
    private int secreta;
    
    /**
     * Constructor per defecte. Inicialitza les propietats del objecte
     */
    public ExempleClasses () {
        rango = 4;
        secreta = 37;
    }
    
    public ExempleClasses (int rango) {
        this.rango = rango;
        
    }
    
    public ExempleClasses (double rango) {
        this.rango = (int) rango;
    }

    void setRango (int newRango) {
        
    }
    
    public int sumaDosNumeros (int numero1, int numero2) {
        int resultado;
        
        resultado = numero1 + numero2;
        
        return resultado;
    }
}
