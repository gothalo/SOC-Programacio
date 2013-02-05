/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multitasca;

/**
 *
 * @author Ceina
 */
public class Multitasca {
    
    public void liebreVsTortuga () {
        MyThread liebre = new MyThread ("liebre");
        MyThread tortuga = new MyThread ("Tortuga");
        
        // priorizamos el proceso liebre sobre el proceso tortuga
        liebre.setPriority(Thread.MAX_PRIORITY);
        tortuga.setPriority(Thread.MIN_PRIORITY);
        
        tortuga.start ();
        liebre.start ();
        
        try {
            tortuga.join ();
            liebre.join ();
        } catch (InterruptedException ex) {
            System.out.println("Exception en liebreVsTortuga");
            System.out.println(ex.getMessage ());
        }
    }
    

    public void dosTareas () {
        MyThread t1 = new MyThread ("1");
        MyThread t2 = new MyThread ("2");
        
        // no es una llamada a multitarea.
//        t1.run ();
//        t2.run ();
        
        // llamada a ejecución en paralelo (multitarea)
        t1.start ();
        t2.start ();
        
        // esperamos a que los hilos de ejecucion finalicen
        System.out.println ("Esperando a que acaben los subprocesos");
        try {
            while (t1.isAlive ()) {
                System.out.println("Main espera a t1.");
                Thread.sleep (5000);
                
            }
            t2.join ();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage ());
        }
        System.out.println("Finalizando main");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Multitasca me = new Multitasca ();
        //me.dosTareas ();
        me.liebreVsTortuga();
    }
}
