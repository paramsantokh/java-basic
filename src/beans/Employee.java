package beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Employee {
  
  String id;
  String name;
  int salary;
  int age;
  List<String> activities;
  
  public Employee() {
  
  }
  
  public Employee(String name) {
    this.name = name;
  }
  
  public Employee(String id, String name, int salary, int age, List<String> activities) {
    this.id = id;
    this.name = name;
    this.salary = salary;
    this.age = age;
    this.activities = activities;
  }
  
  public Employee(String id, String name) {
    this.id = id;
    this.name = name;
  }
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getSalary() {
    return salary;
  }
  
  public void setSalary(int salary) {
    this.salary = salary;
  }
  
  public int getAge() {
    return age;
  }
  
  public void setAge(int age) {
    this.age = age;
  }
  
  public List<String> getActivities() {
    return activities;
  }
  
  public void setActivities(List<String> activities) {
    this.activities = activities;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Employee)) {
      return false;
    }
    Employee employee = (Employee) o;
    return getSalary() == employee.getSalary() &&
           getAge() == employee.getAge() &&
           getId().equals(employee.getId()) &&
           getName().equals(employee.getName()) &&
           Objects.equals(getActivities(), employee.getActivities());
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getSalary(), getAge(), getActivities());
  }
  
  @Override
  public String toString() {
    return "Employee{" +
           "id='" + id + '\'' +
           ", name='" + name + '\'' +
           ", salary=" + salary +
           ", age=" + age +
           ", activities=" + activities +
           '}';
  }
  
  public static List<Employee> init() {
    List<Employee> employees = new ArrayList<>();
    Employee e = new Employee("1", "rajesh", 12000, 30, Arrays.asList("Music", "Sports", "Dancing", "Swimming"));
    employees.add(e);
    e = new Employee("2", "mukesh", 11000, 29, Arrays.asList("Coding", "Acting", "Running", "Swimming"));
    employees.add(e);
    e = new Employee("3", "rakesh", 13000, 31, Arrays.asList("Music", "Sports", "Singing", "bragging"));
    employees.add(e);
    e = new Employee("4", "vikash", 10000, 31, Arrays.asList("Listening", "Sports", "Dancing", "Cribbing"));
    employees.add(e);
    e = new Employee("5", "adesh", 9000, 26, Arrays.asList("Music", "Blaming", "Dancing", "Swimming"));
    employees.add(e);
    e = new Employee("6", "naresh", 8000, 25, Arrays.asList("Music", "Sports", "Dancing", "Swimming"));
    employees.add(e);
    e = new Employee("7", "jayesh", 8500, 26, Arrays.asList("Music", "Sports", "Dancing", "Swimming"));
    employees.add(e);
    e = new Employee("8", "hitesh", 8900, 27, Arrays.asList("Music", "Sports", "Dancing", "Swimming"));
    employees.add(e);
    return employees;
  }
  
  public void getAllAges() {
    System.out.println(age);
  }
}
