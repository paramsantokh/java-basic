import java.math.BigDecimal;
import java.util.Properties;

public class TestAnything {
  
  public static void main(String[] args) {
    Properties properties = System.getProperties();
    properties.entrySet().forEach(objectObjectEntry -> {
      System.out.println(objectObjectEntry.getKey() + ": "+ objectObjectEntry.getValue());
      
    });
  }
  
}
