package lambdas;

import beans.Employee;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
  
  static Predicate<Integer> p1 = i -> i % 2 == 0;
  static Predicate<Integer> p2 = i -> i % 5 == 0;
  
  public static void main(String[] args) {
    //test
    System.out.println(p1.test(4));
    
    //and
    System.out.println(p1.and(p2).test(10));
    //or
    System.out.println(p1.or(p2).test(12));
    //negate
    System.out.println(p1.or(p2).negate().test(12));
    
    //using Employee data
    getEmployeesBySalary();
    
  }
  
  public static void getEmployeesBySalary(){
    List<Employee> employees = new Employee().init();
    
    Predicate<Employee> p1 = e -> e.getSalary() > 120000;
    employees.forEach(employee -> {
      if(p1.test(employee)){
       System.out.println(employee);
      }
    });
  }
}
