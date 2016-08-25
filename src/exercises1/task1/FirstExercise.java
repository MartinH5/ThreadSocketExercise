/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises1.task1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martin
 */
public class FirstExercise extends Thread {

    private static long w = 1;
    private static long sum = 0;

    public static void main(String[] args) throws InterruptedException {

        Runnable task1 = () -> {
            while (w < 10000) {
                sum += w;
                w++;
                if (w == 10000) {
                    System.out.println(sum);
                }
            }
        };
        Runnable task2 = () -> {
            for (long i = 1; i < 5; i++) {
                try {
                    Thread.sleep(2000);
                    System.out.println("Task 2= " + i);
                } catch (InterruptedException ex) {
                }
            }
        };

        Runnable task3 = () -> {
            for (long i = 10; i < 20; i++) {
                try {
                    Thread.sleep(3000);
                    System.out.println("Task 3= " + i);
                } catch (InterruptedException ex) {

                }
            }
        };

        Thread thread1 = new Thread(task1);
        thread1.setPriority(MAX_PRIORITY);
        thread1.start();
        Thread thread2 = new Thread(task2);
        thread2.start();
        Thread thread3 = new Thread(task3);
        thread3.start();

    }

}