package thread.producerConsumer;

import java.util.Queue;

/**
 * Consumer take out the items from queue until the queue is not empty.
 * Once queue is empty is will wait and notify the producer to add the item is queue.
 */
public class Consumer extends Thread {
  
  private Queue<Integer> queue;
  private int max;
  
  public Consumer(Queue<Integer> queue, int maxSize, String name) {
    super(name);
    this.queue = queue;
    this.max = maxSize;
  }
  
  @Override
  public void run() {
    take();
  }
  
  private void take() {
    try {
      while (true) {
        synchronized (queue) {
          while (queue.isEmpty()) {
            System.out.println("Consumer is waiting");
            try {
              queue.wait();
            } catch (Exception ex) {
            
            }
           
          }
          Integer i = queue.remove();
          //Thread.sleep(2000);
          System.out.println("Consumer removed item: " + i);
          queue.notifyAll();
        }
      }
    } catch (Exception ex) {
    
    }
  }
}
