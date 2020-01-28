package thread;

import java.util.concurrent.ConcurrentHashMap;

public class MainClass {
  
  public static void main(String[] args) {
    for(int i= 0; i<8;i++) {
      TestThread newThread = new TestThread();
      newThread.start();
    }
  
    //ConcurrentHashMap map = new ConcurrentHashMap(16, 1, 16)
  }
}
