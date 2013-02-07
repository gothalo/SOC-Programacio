/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * @author llorenc
 */
public class Tests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        test.thread.IncDecMonitor idm = new test.thread.IncDecMonitor();
        
        idm.process();
    }
}
