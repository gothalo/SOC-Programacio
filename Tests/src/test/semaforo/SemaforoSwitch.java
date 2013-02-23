/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.semaforo;

/**
 *
 * @author llorenc
 */
public class SemaforoSwitch {

    public final static int PEATON = 0;
    public final static int COCHE = 1;
    private int paso = PEATON;

    public synchronized void pedirPaso(int semaforo) {

        if (semaforo == PEATON) {

            while (paso != PEATON) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                };
            }

            paso = COCHE;
            System.out.println("Pasa el coche");
            notify();


        } else if (semaforo == COCHE) {

            while (paso != COCHE) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                };
            }

            paso = PEATON;
            System.out.println("Pasa el peaton");
            notify();


        }

    }
}
