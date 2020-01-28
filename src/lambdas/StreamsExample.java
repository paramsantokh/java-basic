package lambdas;

import beans.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {
  
  static Predicate<Employee> predicate = employee -> employee.getAge() > 30;
  
  public static void main(String[] args) {
    //collecting data in map
    Map<String, Integer> map = Employee.init().stream()
        .filter(predicate)
        .collect(Collectors.toMap(Employee::getId, Employee::getSalary));
    System.out.println(map);
    
    testMap();
    
    testFlatMap();
    
    testSorted();
    
    testReduce();
  }
  
  public static void testMap() {
    List<String> names = Employee.init().stream()
        .filter(employee -> employee.getSalary() > 9000)
        .map(Employee::getName)
        .collect(Collectors.toList());
    System.out.println(names);
    
    List<String> names2 = Employee.init().stream()
        .filter(employee -> employee.getSalary() > 9000)
        .map(Employee::getName)
        .map(String::toUpperCase)
        .collect(Collectors.toList());
    System.out.println(names2);
  }
  
  public static void testFlatMap() {
    Set<String> activities = Employee.init().stream()
        .filter(employee -> employee.getSalary() > 9000)
        .map(Employee::getActivities)
        //tell its a stream of List
        .flatMap(List::stream)
        .collect(Collectors.toSet());
    
    System.out.println(activities);
  }
  
  private static void testSorted() {
    //Sorting List of strings
    List<String> names = Employee.init().stream()
        .map(Employee::getName)
        .sorted()
        .collect(Collectors.toList());
    System.out.println(names);
    
    //sort objects
    List<Employee> employees = Employee.init().stream()
        .sorted(Comparator.comparing(Employee::getName))
        .collect(Collectors.toList());
    System.out.println(employees);
    
    //reverse sorting
    List<Employee> employees2 = Employee.init().stream()
        .sorted(Comparator.comparing(Employee::getSalary).reversed())
        .collect(Collectors.toList());
    System.out.println(employees2);
  }
  
  private static void testReduce() {
    List<Integer> integerList = Arrays.asList(2, 3, 5, 7);
    
    int muliply = integerList.stream().reduce(1, (a, b) -> a * b);
    System.out.println(muliply);
    
    Optional<Employee> employee = Employee.init()
        .stream()
        .reduce((e1, e2) -> e1.getAge() > e2.getAge() ? e1 : e2);
    
    if (employee.isPresent()) {
      System.out.println(employee.get());
    }
  }
}
