package designPatterns.structural.composite.companyExample;

import java.util.ArrayList;
import java.util.List;
//Composite
public class CompanyDirectory implements Employee {
  
  private String position;
  private String name;
  List<Employee> employees = new ArrayList<>();
  
  public CompanyDirectory(String name, String position) {
    this.name = name;
    this.position = position;
  }
  
  @Override
  public void showDetails() {
    System.out.println(position + " : " + name);
    employees.forEach(Employee::showDetails);
  }
  
  public void add(Employee employee) {
    employees.add(employee);
  }
  
  public void remove(Employee employee) {
    employees.remove(employee);
  }
}
