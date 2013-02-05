/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multitasca;

/**
 *
 * @author Ceina
 */
public class MyThread extends Thread {
    
    String nombre;
    
    public MyThread (String nombre) {
        this.nombre = nombre;   
    }
    
    @Override
    public void run () {
        for (int i = 0; i < 10; i++){
            System.out.println("Estoy en " + nombre + 
                    " (" + i + ")");
            try {
                MyThread.sleep (1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage ());
            }
        }
    }
}

