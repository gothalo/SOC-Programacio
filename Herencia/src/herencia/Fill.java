/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 * Hereda de la classe pare
 * @author llorenc
 */
public class Fill extends Pare {
    
    @Override
    public String dameUnaLetra () {
        return "F";
    }
    
//    No podemos sobreescribir un método final    
//    @Override
//    public String dimeHola () {
//        return "Hola";
//    }
//    
}
