package designPatterns.creational.abstractFactory.factories;

import designPatterns.creational.abstractFactory.Car;
import designPatterns.creational.abstractFactory.enums.CarType;
import designPatterns.creational.abstractFactory.enums.Location;

/**
 *
 */
public class CarFactory {
  
  public static Car buildCar(CarType carType) {
    Location location = Location.USA; //can be configured in property file
    switch (location) {
      case USA:
        return USACarFactory.buildCar(carType);
      case ASIA:
        return AsiaCarFactory.buildCar(carType);
      case DEFAULT:
        return DefaultCarFactory.buildCar(carType);
      default:
        System.out.println("Location not found");
        break;
    }
    
    return null;
  }
}