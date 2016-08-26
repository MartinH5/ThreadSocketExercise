package exercises1.task4;

import exercises1.task4.TurnstileCount;
import java.util.concurrent.locks.ReentrantLock;


public class Turnstiles implements Runnable{
  private final TurnstileCount counter;
  private int count;
  
  
  final int COUNT_MAX = 1000;

  Turnstiles(TurnstileCount c) {
    counter = c;
  }

  public int getCount() {
    return count;
  }

  @Override   // Denne metode kan gøres synchronized, hvilket gør den thread safe - da den sørger for at der kun er en tråd der kører metoden.
  public void run() {
    for (int i = 0; i < COUNT_MAX; i++) {
      
        counter.incr();
      count++;
    }
  }
  
}
