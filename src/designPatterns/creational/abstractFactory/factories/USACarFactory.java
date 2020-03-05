package designPatterns.creational.abstractFactory.factories;

import designPatterns.creational.abstractFactory.Car;
import designPatterns.creational.abstractFactory.types.LuxuryCar;
import designPatterns.creational.abstractFactory.types.SedanCar;
import designPatterns.creational.abstractFactory.types.SmallCar;
import designPatterns.creational.abstractFactory.enums.CarType;
import designPatterns.creational.abstractFactory.enums.Location;

public class USACarFactory {
  
  public static Car buildCar(CarType model) {
    switch (model) {
      case SMALL:
        return new SmallCar(Location.USA);
      case SEDAN:
        return new SedanCar(Location.USA);
      case LUXURY:
        return new LuxuryCar(Location.USA);
      default:
        System.out.println("Car model not found");
        break;
    }
    
    return null;
  }
}
