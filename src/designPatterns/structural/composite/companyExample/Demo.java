package designPatterns.structural.composite.companyExample;

/**
 * A company's hierarchy can be represented in Composite design pattern with Employee(dev, sales etc.)
 * as leaf and CEO, Manager, Sales head as Composite.x
 */
public class Demo {
  
  public static void main(String[] args) {
    //leaf
    Employee dev = new EmployeeImpl(1, "Dev1", "Developenr");
    Employee dev2 = new EmployeeImpl(2, "Dev2", "Sr. Developer");
    Employee sales1 = new EmployeeImpl(1, "Salesman1", "Salesman");
    Employee sales2 = new EmployeeImpl(2, "Salesman2", "Sr. Salesman");
    Employee sales3 = new EmployeeImpl(3, "Salesman3", "Sr. Salesman");
    
   //Composite
    CompanyDirectory company = new CompanyDirectory("Synchronoss Technologies", "Company" );
    CompanyDirectory ceo = new CompanyDirectory("Nikola Tesla","CEO");
    CompanyDirectory manager = new CompanyDirectory("Steve Jobs","Manager");
    CompanyDirectory sales_head = new CompanyDirectory("Mahendra","Sales Head");
    
  
    //company has CEO
    company.add(ceo);
    
    //CEO has manager and sales head
    ceo.add(manager);
    ceo.add(sales_head);
    
    //manager have developers
    manager.add(dev);
    manager.add(dev2);
    
    //sales head have sales man
    sales_head.add(sales1);
    sales_head.add(sales2);
    
    company.showDetails();
  
    System.out.println("\n-----Remove/Add Employee----");
    sales_head.remove(sales2);
    sales_head.add(sales3);
   
    company.showDetails();
  }
}
