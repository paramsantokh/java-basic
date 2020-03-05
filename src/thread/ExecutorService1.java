package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Fixed Thread Pool
 */
public class ExecutorService1 {
  
  public static void main(String[] args) throws Exception {
    //ExecutorService executorService = Executors.newFixedThreadPool(10);
    int threadCount = Runtime.getRuntime().availableProcessors(); //for cpu intensive tasks get the number of cpu cores
    ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
    //A blockingQueue(thread safe) is used to store all the tasks(i.e. 100 tasks).
    // There will be 10 threads in the pool which picks tasks from the queue and execute.
    for (int i = 1; i <= 100; i++) {
      //System.out.println("i:"+i);
      executorService.execute(new Task());
    }
    
    System.out.println("Thread Name:" + Thread.currentThread().getName());
  }
  
  static class Task extends Thread {
    
    @Override
    public void run() {
      System.out.println("Thread Name:" + Thread.currentThread().getName());
    }
  }
}
