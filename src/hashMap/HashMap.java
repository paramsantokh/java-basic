package hashMap;

import beans.Product;

import java.util.Map;

public class HashMap {
  
  public static void main(String[] args) {
    
    Map<Product, String> map1 = new java.util.HashMap();
    Product p1 = new Product("Apple", "Mobile");
    Product p2 = new Product("Apple", "Mobile");
    Product p3 = new Product("Mango", "Mobile");
    map1.put(p1, "Apple");
    map1.put(p2, "Apple2");
    map1.put(p3, "Apple3");
    System.out.println(map1.size());
  }
}