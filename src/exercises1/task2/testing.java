/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises1.task2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OPinator
 */
public class testing {

    public static void main(String[] args) {

        RaceCondition rc = new RaceCondition();

        Thread t1 = new Thread() {
            public void run() {
                rc.next();
                
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                rc.next();
               
            }
          
        };  
        Thread t3 = new Thread() {
            public void run() {
                
                System.out.println(rc.getN());
               
            }


    };

        t1.start();
        t2.start();
        t3.start();
        
      
}
}
