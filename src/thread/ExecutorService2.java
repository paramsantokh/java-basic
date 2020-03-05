package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Cached Thread Pool
 */
public class ExecutorService2 {
  
  public static void main(String[] args) throws Exception {
    ExecutorService executorService = Executors.newCachedThreadPool();
    //Everytime a new task is submitted, looks for a thread to execute.
    // If all threads are busy create new thread which will execute the task.
    for (int i = 1; i <= 100; i++) {
      //System.out.println("i:"+i);
      //Thread.sleep(100);
      executorService.execute(new ExecutorService1.Task());
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
