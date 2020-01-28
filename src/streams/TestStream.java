package streams;

import beans.Employee;

import java.util.Comparator;
import java.util.List;

public class TestStream {
  
  public static void main(String[] args) {
    //System.out.println(IntStream.range(1,10).max());
    //Stream.of("Java", "Python", "Cobol").sorted().findFirst().ifPresent(System.out::println);
    Employee e = new Employee();
    List<Employee> employees =  e.init();
    
    employees.sort(Comparator.comparingInt(Employee::getSalary).reversed());
    
    employees.forEach(x -> System.out.println(x.getSalary()));
  }
}
