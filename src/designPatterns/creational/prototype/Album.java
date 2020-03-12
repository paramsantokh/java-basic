package designPatterns.creational.prototype;

public class Album implements  PrototypeCapable {
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
  
  public Album(int id, String name) {
    this.id = id;
    this.name = name;
  }
  
  @Override
  public Album clone() throws CloneNotSupportedException {
    System.out.println("Cloning Album object.......");
    return (Album) super.clone();
  }
  
  @Override
  public String toString() {
    return "Album{" +
           "id=" + id +
           ", name='" + name + '\'' +
           '}';
  }
}
