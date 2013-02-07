/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.thread;

/**
 *
 * @author llorenc
 */
public class IncDec implements Runnable {

    private String name;
    private IncDecCounter counter;

    public IncDec(String name, IncDecCounter counter) {
        if (name.equalsIgnoreCase("INC")) {
            this.name = "INC";
        } else {
            this.name = "DEC";
        }
        this.counter = counter;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000000000; i++) {
            if (name.equalsIgnoreCase("INC")) {
                counter.opera (1);
            } else {
                counter.opera (-1);
            }
            
//            synchronized (counter) {
//
//                if (name.equalsIgnoreCase("INC")) {
//                    counter.inc();
//                } else {
//                    counter.dec();
//                }
//            }
        }
    }
}
