package thread;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Scheduler thread pool
 */
public class ExecutorService3 {
  
  public static void main(String[] args) throws Exception {
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
    //Task to run after 10 seconds delay
    executorService.schedule(new Task(), 10, TimeUnit.SECONDS);
    //Task to run every 10 seconds
    executorService.scheduleAtFixedRate(new Task(), 10, 5, TimeUnit.SECONDS);
    //Task to run every 10 second after previous task completes
    executorService.scheduleWithFixedDelay(new Task(), 10, 10, TimeUnit.SECONDS);
  }
  
  static class Task implements Runnable {
    
    @Override
    public void run() {
      System.out.println("Thread Name:" + Calendar.getInstance().getTime() + ": " +
                         Thread.currentThread().getName());
    }
  }
}
