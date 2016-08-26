/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises2.task1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OPinator
 */
public class Test {
    
    public static void main(String[] args) {
        
        ByteArray ba = new ByteArray();
        
    // Lambda Runnable
    Runnable task1 = () -> { ba.run("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png");
                             ba.getCount();};
 
    Runnable task2 = () -> { ba.run("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png");
                             ba.getCount();};
    
    Runnable task3 = () -> { ba.run("https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png"); 
                             ba.getCount();};
    Runnable task4 = () -> {
            try {
                Thread.sleep(1000);
                ba.getSum();
            } catch (InterruptedException ex) {
                
            }
    };
    
    // start the threads
    new Thread(task1).start();
        
    new Thread(task2).start();

    new Thread(task3).start();    
    
    new Thread(task4).start();
    
    }
    
    
}
