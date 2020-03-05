package designPatterns.creational.abstractFactory.types;

import designPatterns.creational.abstractFactory.Car;
import designPatterns.creational.abstractFactory.enums.CarType;
import designPatterns.creational.abstractFactory.enums.Location;

public class LuxuryCar extends Car {
  
  public LuxuryCar(Location location) {
    super(CarType.LUXURY, location);
    build();
  }
  
  @Override
  public void build() {
    System.out.println("Building Luxury car......");
  }
}
