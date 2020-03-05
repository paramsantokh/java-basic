package designPatterns.creational.singlton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * In this section we will see how to create a Singleton class and various problems while achieving pure singleton object
 * Make sure there is only one instance of class by restricting costruction of new object.
 * Make constructor private.
 * <p>
 * Also, illustrated different ways to violate Singleton concept
 *
 * Note: Runtime is a singleton class in JDK, Other Examples:LogManager, Cache Manager, DB Manager to manage connection
 */
public class Singlton implements Serializable, Cloneable {
  /**
   * implemented Serializable to test serialization/deserialization
   */
  private static Singlton singleIntsance = null;
  
  private Singlton() {
    //System.out.println("Private constructor----");
  }
  
  /**
   * Provide a global point of access
   * A static method to get the sole instance
   */
  public static Singlton getInstance() {
    if (singleIntsance == null) {
      singleIntsance = new Singlton();
    }
    return singleIntsance;
    
  }
  
  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
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
     */
    
    Class aClass = Class.forName("designPatterns.creational.singlton.Singlton");
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
