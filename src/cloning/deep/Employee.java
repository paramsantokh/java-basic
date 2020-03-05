package cloning.deep;

import java.util.Objects;

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
    Employee employee = (Employee) super.clone();
    //set cloned Address object
    employee.setAddress((Address)address.clone());
    return employee;
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
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Employee)) {
      return false;
    }
    Employee employee = (Employee) o;
    return getId() == employee.getId() &&
           Objects.equals(getName(), employee.getName()) &&
           Objects.equals(getCompany(), employee.getCompany()) &&
           Objects.equals(getAddress(), employee.getAddress());
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getCompany(), getAddress());
  }
}
