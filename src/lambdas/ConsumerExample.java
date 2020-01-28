package lambdas;

import beans.Employee;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
  
  public static void main(String[] args) {
    testConsumer();
    
    testConsumerOnEmployeeObject();
  }
  
  private static void testConsumer() {
    Consumer<String> consumer = s -> System.out.println(s.toUpperCase());
    consumer.accept("hello");
  }
  
  private static void testConsumerOnEmployeeObject() {
    Consumer<Employee> consumer = e -> {
      e.setName(e.getName().toUpperCase());
      System.out.println(e.getName());
    };
    
    Consumer<Employee> consumer2 = e -> {
      System.out.println(e.getSalary());
    };
    
    List<Employee> employees = new Employee().init();
    employees.forEach(consumer.andThen(consumer2));
  }
}
