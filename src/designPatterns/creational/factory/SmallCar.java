package designPatterns.creational.factory;

public class SmallCar extends Car {
  
  SmallCar(){
    super(CarType.SMALL);
    build();
  }
  
  @Override
  public void build() {
    airbags = false;
    System.out.println("Building small car.....");
  }
}
