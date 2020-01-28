package lambdas;

import beans.Employee;

import java.util.List;
import java.util.function.Consumer;

/**
 * Re-use Function
 */
public class FunctionExample2 {
  
  static Consumer<Employee> consumer = e -> {
    System.out.println("Name: " + e.getName());
    System.out.println("------------------");
    System.out.println(e.toString());
  };
  
  public static void main(String[] args) {
    String function = FunctionExample.concat.apply("param");
    System.out.println(function);
    
    List<Employee> employees = FunctionExample.employeeFunction.apply(Employee.init());
    System.out.println("-----Employees with salary and age condition-----");
    employees.forEach(consumer);
  }
}
