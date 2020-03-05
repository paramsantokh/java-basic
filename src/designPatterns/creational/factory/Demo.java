package designPatterns.creational.factory;

public class Demo {
  
  public static void main(String[] args) {
    CarFactory factory = new CarFactory();
    Car car1 = factory.buildCar(CarType.SMALL);
    System.out.println(car1);
    Car car2 = factory.buildCar(CarType.SEDAN);
    System.out.println(car2);
    Car car3 = factory.buildCar(CarType.LUXURY);
    System.out.println(car3);
  }
}
