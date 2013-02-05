/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prioridades;

/**
 *
 * @author llorenc
 */
public class Priority extends Thread {
    
    int count;
    
    // variables estaticas. seran compartidas por todos los threads
    static boolean stop = false;
    static String currentName;
    
    /**
     * Crea un nuevo thread y asigna el nombre pasado como parametro
     * @param name nombre del thread a ejecutar
     */
    public Priority (String name) {
        // llamamos al constructor de Thread, indicando el nombre
        super (name);
        // iniciamos el contador de ejecuciones.
        count = 0;
        // fijamos el nombre del thread en ejecucion al nombre de este hilo.
        currentName = name;
    }
    
    @Override
    public void run () {
        
        System.out.println(this.getName () + " starting");
        
        do {
            // contamos las veces que se ha ejecutado el bucle.
            count++;
            
            if (currentName.compareTo(this.getName()) != 0) {
                // el ultimo hilo ejecutado no es este. cambiamos el nombre del
                // hilo en ejecucion al nombre de este thread.
                currentName = this.getName(); 
                System.out.println("In " + currentName); 
            }
            
        } while (stop == false && count < 10000000);
        
        // la ejecucion ha finalizado. cambiamos el valor de stop para 
        // que finalicen los otors hilos.
        stop = true;
        
        System.out.println("\n" + this.getName() + " terminating."); 
            
                
    }
}
