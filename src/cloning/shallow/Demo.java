package cloning.shallow;

/**
 * In the shallow copy, making changes in the cloned object reflects in original object.
 *
 * If you are not cloning all the object types (not primitives), then you are making a shallow copy.
 * We haven't overridden clone() method in Address class, means we are not cloning this object.
 */
public class Demo {
  
  public static void main(String[] args) throws CloneNotSupportedException {
    Address address = new Address("bangalore", "KA", 560029);
    Employee employee = new Employee(1, "emp", "sync", address);
    Employee employee1 = (Employee) employee.clone();
    
    employee1.getAddress().setPinCode(560076);
    System.out.println(employee);
    System.out.println(employee1);
    //Address reference is same for employee and employee1 as we haven't cloned Address object
    System.out.println(employee.getAddress().hashCode() == employee1.getAddress().hashCode());
    
  }
}
