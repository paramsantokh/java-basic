package lambdas;

import beans.Employee;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReference {
  static Supplier<Employee> supplier = Employee::new; //call empty constructor
  static Function<String, Employee> function= Employee::new; //call one parameter constructor
  static BiFunction<String, String, Employee> biFunction = Employee::new; //call two parameter constructor
 
  public static void main(String[] args) {
    System.out.println(supplier.get());
    System.out.println(function.apply("param"));
    System.out.println(biFunction.apply("4", "param"));
  }
}
