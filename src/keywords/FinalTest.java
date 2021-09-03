package keywords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author param singh
 */
public class FinalTest {
  
  public final String s = "Hello";
  
  public final List<String> list = new ArrayList<>();
  
  public List<String> list2 = Collections.unmodifiableList(new ArrayList<>());
  
  public List<String> list3 = Collections.unmodifiableList(list);
  
  public void finalVariableTest() {
    System.out.println(s);
    
    // below statement will give error as s is final
    // s = "Hi"
    
    System.out.println(s);
  }
  
  /**
   * We can add elements to a final list, but can not initialize it again.
   */
  public void createFinalList() {
    // below statement will give error as list is final
    //list = new ArrayList<>();
    list.add("Apple");
    list.add("Mango");
    System.out.println(list);
    list.add(0, "Banana");
    System.out.println(list);
  }
  
  /**
   * Unmodifiable list once create can not be modified. We can not add
   * elements to a Unmodifiable list
   */
  public void createUnmodifiableList2() {
    System.out.println("\nUnmodifiableList2: "+ list2);
    
    try {
      //below statement will throw UnsupportedOperationException
      list2.add("Apple");
      list2.add("Mango");
      System.out.println(list2);
      list2.add(0, "Banana");
      System.out.println(list2);
    } catch (UnsupportedOperationException ex) {
      System.out.println("UnsupportedOperationException as we are trying to update unmodifiable list: " + ex);
    }
  }
  
  public void createUnmodifiableList3() {
    System.out.println("\nUnmodifiableList3: "+list3);
   
    try {
      //below statement will throw UnsupportedOperationException
      list3.add("Apple");
      list3.add("Mango");
      System.out.println(list3);
      list3.add(0, "Banana");
      System.out.println(list3);
    } catch (UnsupportedOperationException ex) {
      System.out.println("UnsupportedOperationException as we are trying to update unmodifiable list: " + ex);
    }
  }
  
  public static void main(String[] args) {
    FinalTest obj = new FinalTest();
    obj.finalVariableTest();
    obj.createFinalList();
    
    obj.createUnmodifiableList2();
    
    obj.createUnmodifiableList3();
  }
}
