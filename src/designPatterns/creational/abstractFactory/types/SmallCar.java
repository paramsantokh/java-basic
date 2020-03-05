package designPatterns.creational.abstractFactory.types;

import designPatterns.creational.abstractFactory.Car;
import designPatterns.creational.abstractFactory.enums.CarType;
import designPatterns.creational.abstractFactory.enums.Location;

public class SmallCar extends Car {
  
  public SmallCar(Location location){
    super(CarType.SMALL, location);
    build();
  }
  
  @Override
  public void build() {
    System.out.println("Building small car.....");
  }
}
