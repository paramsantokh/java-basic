package lambdas;

import beans.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class FunctionExample {
  /**
   * If input and output parameters are of same type, use UnaryOperator instead of Function
   */
  public static Function<String, String> upperCase = name -> name.toUpperCase();
  public static Function<String, String> concat = name -> name.concat(" Singh");
  
  //public static BiPredicate<Integer, Integer> salaryAgePredicate = (salary, age) -> salary > 9000 && age > 30;
  
  public static Function<List<Employee>, List<Employee>> employeeFunction = employees -> {
    List<Employee> employeeList = new ArrayList<>();
    employees.forEach(e -> {
      if (PredicateAndConsumerExample.salaryPredicate.and(PredicateAndConsumerExample.agePredicate).test(e)) {
        employeeList.add(e);
      }
    });
    
    return employeeList;
  };
  
  public static void main(String[] args) {
    
    System.out.println(upperCase.apply("param"));
    System.out.println(concat.apply("param"));
    //first uppercase and then concat
    System.out.println(upperCase.andThen(concat).apply("param"));
    //compose execute first, then execute outer function
    System.out.println(upperCase.compose(concat).apply("param"));
  }
}