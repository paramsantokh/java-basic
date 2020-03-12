package designPatterns.creational.prototype;

public class Show implements PrototypeCapable {
  
  private int id;
  private String name;
  
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
  
  public Show(int id, String name) {
    this.id = id;
    this.name = name;
  }
  
  @Override
  public Show clone() throws CloneNotSupportedException {
    System.out.println("Cloning Show object.......");
    return (Show) super.clone();
  }
  
  @Override
  public String toString() {
    return "Show{" +
           "id=" + id +
           ", name='" + name + '\'' +
           '}';
  }
}
