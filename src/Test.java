import beans.Product;
import sun.plugin.dom.core.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
  
  public static void main(String[] args) {
    System.out.println("CPU cores:"+Runtime.getRuntime().availableProcessors());
  }
  
  public List<Product>  getProducts(){
    List<Product> products = new ArrayList<>();
    return products.stream().map(this::toCustProduct).collect(Collectors.toList());
  }
  
  Product toCustProduct(Product product){
    Product product1 = new Product("product", "type");
    return product;
    
  }
  
}
