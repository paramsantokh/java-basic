import java.util.Properties;

public class PropertiesExample {
  
  public static void main(String[] args) {
    Properties properties = System.getProperties();
    System.out.println(properties.toString());
    properties.entrySet().forEach(objectObjectEntry -> {
      System.out.println(objectObjectEntry.getKey() + ": "+ objectObjectEntry.getValue());
    });
  }
}
