package beans;

import java.util.Objects;

public class Product {
  
  private  String name;
  private String type;
  
  public Product(String name, String type) {
    this.name = name;
    this.type = type;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Product)) {
      return false;
    }
    Product product = (Product) o;
    return getName().equals(product.getName()) &&
           type.equals(product.type);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(getName(), type);
  }
  
}
