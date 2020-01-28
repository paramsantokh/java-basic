package lambdas;

import beans.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * Takes two inputs and return single
 */
public class BiFunctionExample {
  
  /**
   * If input and output parameters are of same type, use BinaryOperator instead of BiFunction
   */
  public static BiFunction<List<Employee>, Predicate, Map<String, Integer>> biFunction = (employees, predicate) -> {
    Map<String, Integer> employeeSalaryMap = new HashMap<>();
    employees.forEach(employee -> {
      if (predicate.test(employee)) {
        employeeSalaryMap.put(employee.getName(), employee.getSalary());
      }
    });
    
    return employeeSalaryMap;
  };
  
  public static void main(String[] args) {
    Map<String, Integer> employeeSalary = biFunction.apply(Employee.init(), PredicateAndConsumerExample.salaryPredicate);
    System.out.println(employeeSalary);
  }
}
