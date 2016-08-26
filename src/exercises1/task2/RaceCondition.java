/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises1.task2;

/**
 *
 * @author OPinator
 */
public class RaceCondition extends Thread {

    private static int n = 0;
    private static int tempN = 0;

    
    //Denne metode gør, at vi får et varieret n - i stedet for altid et lige tal.
    //Men gøres metoderne synchronized undgår vi race conditions.
    public synchronized int next() {
        for (int i = 0; i < 2; i++) {
            int oldI = getN();          
            setN(oldI + 1);            
            
        }
        
        return getN();
        
    }

    public synchronized int getN() {
        return n;
    }

    public synchronized void setN(int oldI) {
        n = oldI;
        System.out.println("Called");
       
        
    }
}


/*
for(int i = 0; i < 1000; i++){
        //new Thread(() -> next()).start();
        //new Thread (() -> next()).start();
        
            if (n == 0){
                zero++;
            }if (n == 1){
                one++;
            }if (n == 2){
                two++;
            }if (n == 3){
                three++;
            }if (n == 4){
                four++;
            }
            if(n %2 == 1){
                uneven++;
            }
        
            n= 0;
     }
        System.out.println(" numbers of 0:" + zero + "\n numbers of 1:" + one + "\n numbers of 2:" + two + "\n numbers of 3:" + three + "\n numbers of 4:" + four);
        System.out.println("Uneven count: " + uneven);
    }
*/
