/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author llorenc
 */
public class Pare implements DemoInterface {
    
    public int generarEntero () {
        return (int) ((Math.random () * 10) + 1);
    }
    
    public String dameUnaLetra () {
        return "P";
    }
    
    final public String dimeHola () {
        return "Hola";
    }

    @Override
    public String despedida() {
        return "Adios";
    }

    

    
}
