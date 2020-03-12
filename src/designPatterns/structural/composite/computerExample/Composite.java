package designPatterns.structural.composite.computerExample;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
  
  String name;
  List<Component> componentList = new ArrayList<>();
  
  public Composite(String name) {
    this.name = name;
  }
  
  public void addComponent(Component component) {
    componentList.add(component);
  }
  
  @Override
  public void showPrice() {
    //Composite object name
    System.out.println("Component: " + name);
    for (Component c : componentList) {
      //individual object name/price
      c.showPrice();
    }
  }
}
