package designPatterns.structural.composite.computerExample;

public class Leaf implements Component {
  
  String name;
  double price;
  
  public Leaf(String name, double price) {
    this.name = name;
    this.price = price;
  }
  
  @Override
  public void showPrice() {
    System.out.println("Name: " + name + ", " + "Price: " + price);
  }
}
