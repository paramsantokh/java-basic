package designPatterns.creational.abstractFactory.factories;

import designPatterns.creational.abstractFactory.Car;
import designPatterns.creational.abstractFactory.types.LuxuryCar;
import designPatterns.creational.abstractFactory.types.SedanCar;
import designPatterns.creational.abstractFactory.types.SmallCar;
import designPatterns.creational.abstractFactory.enums.CarType;
import designPatterns.creational.abstractFactory.enums.Location;

public class AsiaCarFactory {
  
  public static Car buildCar(CarType model) {
    switch (model) {
      case SMALL:
        return new SmallCar(Location.ASIA);
      case SEDAN:
        return new SedanCar(Location.ASIA);
      case LUXURY:
        return new LuxuryCar(Location.ASIA);
      default:
        System.out.println("Car model not found");
        break;
    }
    
    return null;
  }
}
