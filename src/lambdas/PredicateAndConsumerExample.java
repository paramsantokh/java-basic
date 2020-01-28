package lambdas;

import beans.Employee;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {
  public static Predicate<Employee> salaryPredicate = e -> e.getSalary() > 9000;
  public static Predicate<Employee> agePredicate = e -> e.getAge() > 30;
  
  public static BiConsumer<String, String> biConsumer = (id, name) -> System.out.println("Employee Id: " + id + " " + "Employee Name: " + name);
  
  
  private static void employeeInfoUsingPredicate(List<Employee> employees) {
    Consumer<Employee> consumer = employee -> {
      if (salaryPredicate.and(agePredicate).test(employee)) {
        biConsumer.accept(employee.getId(), employee.getName());
      }
    };
    employees.forEach(consumer);
  }
  
  
  
  private void employeeInfoUsingBiPredicate(List<Employee> employees) {
    BiPredicate<Integer, Integer> biPredicate = (salary, age) -> salary > 9000 && age > 30;
    Consumer<Employee> consumer = employee -> {
      if (biPredicate.test(employee.getSalary(), employee.getAge())) {
        biConsumer.accept(employee.getId(), employee.getName());
      }
    };
    employees.forEach(consumer);
  }
  
  public static void main(String[] args) {
    List<Employee> employees = Employee.init();
    System.out.println("Using Predicate.........");
    new PredicateAndConsumerExample().employeeInfoUsingPredicate(employees);
    System.out.println("Using BiPredicate......");
    new PredicateAndConsumerExample().employeeInfoUsingBiPredicate(employees);
  }
}
