package collections;

import com.sun.xml.internal.ws.client.ClientSchemaValidationTube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author param singh
 */
public class ListTest {
  
  public static List<String> list = new ArrayList<>();
  
  public static void main(String[] args) {
    String[] arr = new String[]{"Apple", "Mango", "Banana", "Grapes"};
    
    list = Arrays.asList(arr); //Return unmodifiable list
   
    System.out.println(list);
    try {
      //Below statement throws UnsupportedOperationException for adding
      // element to unmodifiable list
      list.add("Pineapple");
    } catch (UnsupportedOperationException ex) {
      System.out.println("Exception while adding element: " + ex);
    }
  }
}
