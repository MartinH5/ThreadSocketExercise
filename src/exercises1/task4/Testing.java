package exercises1.task4;

import exercises1.task4.TurnstileCount;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

//Har 3 løsninger en for både Synchronized - 
public class Testing {
 static final int NUMBER_OF_TURNSTILES = 40;
  static Turnstiles[] turnStiles = new Turnstiles[NUMBER_OF_TURNSTILES];

  public static void main(String[] args) throws InterruptedException {
    //This is the shared Counter used by all turnstilles
    TurnstileCount sharedCounter = new TurnstileCount();
    
    
    for (int i = 0; i < NUMBER_OF_TURNSTILES; i++) {
      turnStiles[i] = new Turnstiles(sharedCounter);
    }
    
    
    //This example uses a ThreadPool to handle threads
    
    ExecutorService es=Executors.newCachedThreadPool();
   
    for (int i = 0; i < NUMBER_OF_TURNSTILES; i++) {
      es.execute(turnStiles[i]);
      
    }
    
    es.shutdown();
    es.awaitTermination(10, TimeUnit.SECONDS);
    
    System.out.println("All turnstiles are done");
    //Print the updated value
    System.out.println(sharedCounter.getValue());
  }  
}
