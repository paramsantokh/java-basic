package lambdas;

import beans.Employee;

import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReference {
  
  static Function<String, String> function = s -> s.toUpperCase();
  //className::methodName;
  static Function<String, String> methodReference = String::toUpperCase;
  
  static Consumer<Employee> consumer = System.out::println;
  static Consumer<Employee> consumer2 = Employee::getAllAges;
  
  public static void main(String[] args) {
    System.out.println(function.apply("hello"));
    System.out.println(methodReference.apply("hello"));
    Employee.init().forEach(consumer);
    Employee.init().forEach(consumer2);
  }
}
