package jmm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Happen Before Relationship -> changes happened before volatile variable's write, will be reflected after the read of volatile
 * This concept is applicable for ->
 * sychronized, locks, concurrent collections, thread operations(join, start)
 */
public class VolatileFieldVisibility {
  int a = 0, b = 0, c = 0;
  
  volatile int x = 0;
  
  public void writeThread() {
    a = 1;
    b = 1;
    c = 1;
    //above are the changes happened before the write of volatile x
    x = 1;
    
    //same can be achieved  using synchronized or lock instead of volatile
   /* synchronized (this){
      x= 1;
    }
    
    --OR---
    synchronized (this){
     a = 1;
     b = 1;
     c = 1;
     x= 1;
    }
    */
    
  }
  
  public void readThread() {
    /*synchronized (this) {
      int xr = x;
    }
    ---OR---
    synchronized (this) {
      int xr = x;
      int a2 = a;
      int b2 = b;
      int c2 = c;
    }
    */
    
    int xr = x;
    //below are the changes reflected after the read of x
    int a2 = a;
    int b2 = b;
    int c2 = c;
  }
}
