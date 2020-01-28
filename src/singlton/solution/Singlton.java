package singlton.solution;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Solution to the Singleton problems
 */
public class Singlton implements Serializable, Cloneable {
  
  /**
   * implemented Serializable to test serialization/deserialization
   */
  private static volatile Singlton soleIntsance = null;
  
  private Singlton() {
    /*
    * To stop reflection --->
      if (singleIntsance != null) {
      throw new RuntimeException("Can not create... call getInstance()");
    }
    * */
    
  }
  
  /**
   * Provide a global point of access
   * A static method to get the sole instance
   */
  public static Singlton getInstance() {
    //double checked locking
    if (soleIntsance == null) {
      synchronized (Singlton.class) { //lock on Singleton class
        if (soleIntsance == null) { //check if other thread has already created instance
          soleIntsance = new Singlton();
        }
      }
    }
    
    return soleIntsance;
  
    /**
     * creating singleton object using Holder class
     */
    //return singlton.Singlton.Holder.INSTANCE;
  }
  
  static class Holder {
    static final Singlton INSTANCE = new Singlton();
  }
  
  /*
  To make Singleton thread safe synchronized is used -> thread 1 has access(lock) to getInstance(), thread 2 can not access getIntance() until thread one is done with getInstance().
 
  public static synchronized Singlton getInstance() {
    if (soleIntsance == null) {
      soleIntsance = new Singlton();
    }
    return soleIntsance;
  }*/
  
  /**
   * Return soleInstance on cloning
   *
   * @return
   * @throws CloneNotSupportedException
   */
  @Override
  protected Object clone() throws CloneNotSupportedException {
    return soleIntsance;
  }
  
  /**
   * to deserialize object and return soleIntsance
   *
   * @return
   */
  private Object readResolve() {
    return soleIntsance;
  }
}

class Test {
  
  public static void main(String[] args) throws Exception {
    Singlton s1 = Singlton.getInstance();
    Singlton s2 = Singlton.getInstance();
    System.out.println("Singleton Object s1=" + s1.hashCode());
    System.out.println("Singleton Object s2=" + s2.hashCode());
    if (s1 == s2) {
      //hash code value of singlton objects will be same
      System.out.println("s1 == s2");
    } else {
      System.out.println("s1 != s2");
    }
    
    /**
     *  Voilate the concept of sigleton by creating another instance of Singleton Class using
     */
    
    /**
     1. Reflection
     * Solution: add condition to Singleton constructor
     *
     *  if(singleIntsance != null){
     *       throw new RuntimeException("Can not create... call getInstance()");
     *     }
     */
    
    Class aClass = Class.forName("singlton.solution.Singlton");
    Constructor<Singlton> constructor = aClass.getDeclaredConstructor();
    constructor.setAccessible(true);
    Singlton s3 = constructor.newInstance();
    
    System.out.println("Reflection object s3=" + s3.hashCode());
    if (s1 != s3) {
      //hash code value of singlton object s1 and reflection object s3 will be different
      System.out.println("s1 != s3");
    }
    
    /**
     * 2. Serialization/Deserialization
     *
     * Solution: creat readResolve() method is Singleton class and return soleInstance
     */
    
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/tmp/s2.ser"));
    oos.writeObject(s2);
    
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/tmp/s2.ser"));
    Singlton s4 = (Singlton) ois.readObject();
    System.out.println("Deserialized Object s4=" + s4.hashCode());
    if (s1 != s4) {
      //hash code value of singlton object s1 and deserialized object s4 will be different
      System.out.println("s1 != s4");
    }
    
    /**
     * 3. Cloning
     *
     *  Solution: Return soleInstance in clone() method.
     *
     */
    
    Singlton s5 = (Singlton) s1.clone();
    System.out.println("Cloned Object s5=" + s5.hashCode());
    if (s1 != s5) {
      //hash code value of singlton object s1 and cloned object s5 will be different
      System.out.println("s1 != s5");
    }
    
    /**
     * 4. Muti Threading
     *
     * Sigleton is not thread safe
     * The result of multi threaded objects will be unexpected, sometime it will return singleton object,
     * and sometime will create new
     *
     * To make Sigleton thread safe, create getInstance() method as synchronised method. synchronized makes sure that only one thread at a time can execute getInstance().
     *
     * The main disadvantage of synchronised method is that using synchronized every time while creating the singleton object is expensive and may decrease the performance of your program.
     *
     */
    //create 2 threads
    ExecutorService executor = Executors.newFixedThreadPool(2);
    executor.submit(Test::useSingleton);
    executor.submit(Test::useSingleton);
    
    executor.shutdown();
    
    /**
     * 5. Mutiple class loaders
     */
    
    /**
     * 6. Garbage collection -> in older versions(before 1.2) of java the singleton objects were garbage collected and a new instance of Singleton was created.
     */
  }
  
  public static void useSingleton() {
    Singlton singlton = Singlton.getInstance();
    print("Mutithreaded objet:", singlton);
  }
  
  public static void print(String message, Object singleton) {
    System.out.println(message + ":" + singleton.hashCode());
  }
}
