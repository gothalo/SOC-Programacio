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
    
    static boolean stop = false;
    static String currentName;
    
    public Priority (String name) {
        super (name);
        count = 0;
        currentName = name;
    }
    
    @Override
    public void run () {
        System.out.println(this.getName () + " starting");
        do {
            
            count++;
            
            if (currentName.compareTo(this.getName()) != 0) {
                currentName = this.getName(); 
                System.out.println("In " + currentName); 
            }
            
        } while (stop == false && count < 10000000);
        
        stop = true;
        
        System.out.println("\n" + this.getName() + " terminating."); 
            
                
    }
}
