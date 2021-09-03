package keywords;

import java.util.ArrayList;
import java.util.List;

/**
 * @author param singh
 */
public class StaticTest {
  public static String s1 = "I am static";
  public String s2 = "I am instance";
  
  protected void display(String s)
  {
    System.out.println(s);
  }
  
  public static void main(String[] args) {
    //update done to static variable by one object
    // will be reflected to all the the objects of that class.
    // A single copy of static variable will be created and shared among all objects
    StaticTest obj = new StaticTest();
    obj.display(s1);
    s1 = "static updated";
    
    StaticTest obj2 = new StaticTest();
    obj2.display(s1);
  
    StaticTest obj3 = new StaticTest();
    obj3.display(obj3.s2);
    //Updates done to instance variables will be limited to the that object only
    obj3.s2 = "instance updated";
    StaticTest obj4 = new StaticTest();
    obj4.display(obj.s2);
    
  }
}
