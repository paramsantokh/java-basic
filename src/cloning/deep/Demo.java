package cloning.deep;

/**
 *  In the deep copy, we create a clone which is independent of original object and
 *  making changes in the cloned object should not affect original object.
 *
 * If you are not cloning all the object types (not primitives), then you are making a shallow copy.
 * We haven't overridden clone() method in Address class, means we are not cloning this object.
 */
public class Demo {
  
  public static void main(String[] args) throws CloneNotSupportedException {
    Address address = new Address("bangalore", "KA", 560076);
    Employee employee1 = new Employee(1, "emp", "sync", address);
    Employee employee2 = (Employee) employee1.clone();
   
    //update address field on one object
    employee2.getAddress().setPinCode(560029);
    
    System.out.println(employee1);
    System.out.println(employee2);
    //override equals method in Employee and Address to compare the objects
    System.out.println(employee1.equals(employee2));
    //same class type
    System.out.println(employee1.getClass() == employee2.getClass());
    //Address reference is not same for employee1 and employee2 as Address is cloned in Employee
    System.out.println(employee1.getAddress().hashCode() == employee2.getAddress().hashCode());
    
  }
}
