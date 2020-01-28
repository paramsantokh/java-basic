package lambdas;

import beans.Employee;

import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {
  
  static Supplier<Employee> supplier = () -> Employee.init().get(0);
  static Supplier<List<Employee>> listSupplier = () -> Employee.init();
  
  public static void main(String[] args) {
    System.out.println(supplier.get());
    System.out.println(listSupplier.get());
  }
}
