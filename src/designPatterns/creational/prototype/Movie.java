package designPatterns.creational.prototype;

public class Movie implements PrototypeCapable {
  
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
  
  public Movie(int id, String name) {
    this.id = id;
    this.name = name;
  }
  
  @Override
  public Movie clone() throws CloneNotSupportedException {
    System.out.println("Cloning Movie object.......");
    return (Movie) super.clone();
  }
  
  @Override
  public String toString() {
    return "Movie{" +
           "id=" + id +
           ", name='" + name + '\'' +
           '}';
  }
}
