package thread.producerConsumer;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class TestProducerConsumer {
  
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    int maxSize = 10;
    Producer producer = new Producer(queue, maxSize, "Producer..");
    Consumer consumer = new Consumer(queue, maxSize, "Consumer..");
    
    producer.start();
    consumer.start();
  }
  
}
