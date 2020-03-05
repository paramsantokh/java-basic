package designPatterns.creational.factory;

public class SedanCar extends Car {
  
  SedanCar() {
    super(CarType.SEDAN);
    build();
  }
  
  @Override
  public void build() {
    airbags = true;
    System.out.println("Building Sedan car......");
  }
}
