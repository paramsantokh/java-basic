package designPatterns.creational.abstractFactory.types;

import designPatterns.creational.abstractFactory.Car;
import designPatterns.creational.abstractFactory.enums.CarType;
import designPatterns.creational.abstractFactory.enums.Location;

public class SedanCar extends Car {
  
  public SedanCar(Location location) {
    super(CarType.SEDAN, location);
    build();
  }
  
  @Override
  public void build() {
    System.out.println("Building Sedan car......");
  }
}
