package lambdas;

import java.util.Comparator;

public class TestLambda {
  
  public static void main(String[] args) {
    /**
     * 1.
     */
    //Legacy
    System.out.println("1)...........");
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
       System.out.println("Legacy Runnable");
      }
    };
    
    new Thread(runnable).start();

    //Lambda
    Runnable runnableLambda = ()-> System.out.println("Lambda Runnable 1");
    new Thread(runnableLambda).start();
    
    new Thread(()-> System.out.println("Lambda Runnable 2")).start();
    
    /**
     * 2.
     */
    System.out.println("2)..............");
    //Legacy
    Comparator<String> comparator = new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }
    };
    
    System.out.println(comparator.compare("Hi", "Hi"));
    //Using lambda
    Comparator<String> comparatorLambda = (o1, o2) -> o1.compareTo(o2);
    
    System.out.println(comparatorLambda.compare("Hi", "Hi"));
  }
}
