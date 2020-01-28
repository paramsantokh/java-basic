package thread.producerConsumer;

import java.util.Queue;
import java.util.Random;

/**
 * Producer add the item in Queue until the queue is not full
 * Once queue is full it will wait and notify the consumers to take out the items from queue.
 */
public class Producer extends Thread {
  
  private Queue<Integer> queue;
  private int max;
  
  public Producer(Queue<Integer> queue, int maxSize, String name) {
    super(name);
    this.queue = queue;
    max = maxSize;
  }
  
  @Override
  public void run() {
    put();
  }
  
  private void put() {
    try {
      while (true) {
        synchronized (queue) {
          while (queue.size() == max) {
            System.out.println("Producer is waiting");
            try {
              queue.wait();
            } catch (Exception ex) {
            
            }
          }
          Random random = new Random();
          int i = random.nextInt();
          queue.add(i);
          //Thread.sleep(2000);
          System.out.println("Producer added item: " + i);
          queue.notifyAll();
        }
      }
    } catch (Exception ex) {
    
    }
  }
}
