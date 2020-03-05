package cloning.shallow;

public class Employee implements Cloneable {
  private int id;
  private String name;
  private String company;
  private Address address;
  
  public Employee(int id, String name, String company, Address address) {
    this.id = id;
    this.name = name;
    this.company = company;
    this.address = address;
  }
  
  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
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
  
  public String getCompany() {
    return company;
  }
  
  public void setCompany(String company) {
    this.company = company;
  }
  
  public Address getAddress() {
    return address;
  }
  
  public void setAddress(Address address) {
    this.address = address;
  }
  
  @Override
  public String toString() {
    return "Employee{" +
           "id=" + id +
           ", name='" + name + '\'' +
           ", company='" + company + '\'' +
           ", address=" + address +
           '}';
  }
}
