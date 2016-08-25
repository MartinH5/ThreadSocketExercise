package FourthExercise;
 import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicInteger;

public class TurnstileCounter {
private ReentrantLock lock = new ReentrantLock();
  static final long DELAY_VAL = 10000;
  long count = 0;
 // AtomicInteger count = new AtomicInteger(0);

  
  public long getValue() {
    return count;
  }
// Kan gøres synchronized - se forklaring ved runmetoden i Turnstile klassen. 
  public void incr() {

    lock.lock();
    try {
        count++;
    } finally {
        lock.unlock();
    }
  }
}
