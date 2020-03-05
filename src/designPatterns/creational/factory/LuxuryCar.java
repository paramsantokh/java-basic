package designPatterns.creational.factory;

public class LuxuryCar extends Car {
  LuxuryCar() {
    super(CarType.LUXURY);
    build();
  }
  
  @Override
  public void build() {
    airbags = true;
    System.out.println("Building Luxury car......");
  }
}
