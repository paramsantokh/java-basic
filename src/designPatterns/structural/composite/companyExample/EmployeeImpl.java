package designPatterns.structural.composite.companyExample;

public class EmployeeImpl implements Employee {
  private int id;
  private String name;
  private String position;
  
  public EmployeeImpl(int id, String name, String position) {
    this.id = id;
    this.name = name;
    this.position = position;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  @Override
  public void showDetails() {
    System.out.println(id+" : "+ name + " : " + position);
  }
}
