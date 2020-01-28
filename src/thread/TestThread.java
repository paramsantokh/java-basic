package thread;

public class TestThread extends Thread {
  
  @Override
  public void run() {
    System.out.println("Thread: "+Thread.currentThread().getId() );
  }
}

