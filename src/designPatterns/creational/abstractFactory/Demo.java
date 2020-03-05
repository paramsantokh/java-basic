package designPatterns.creational.abstractFactory;

import designPatterns.creational.abstractFactory.enums.CarType;
import designPatterns.creational.abstractFactory.factories.CarFactory;

/**
 * We need another layer of abstraction(in addition to example in factory pattern) which will
 * identify the location and internally use correct car factory implementation without even
 * giving a single hint to the user.
 * This is exactly the problem, which abstract factory pattern is used to solve.
 *
 * Whenever you need another level of abstraction over a group of factories,
 * you should consider using the abstract factory pattern.
 * It is probably only difference between factory pattern vs abstract factory pattern.
 *
 * DocumentBuilderFactory:newInstance()
 * TransformerFactory:newInstance()
 * TransformerFactory:newInstance()
 */
public class Demo {
  
  public static void main(String[] args) {
    CarFactory factory = new CarFactory();
    //building Car without exposing Factory location
    Car car1 = factory.buildCar(CarType.SMALL);
    System.out.println(car1);
    Car car2 = factory.buildCar(CarType.SEDAN);
    System.out.println(car2);
    Car car3 = factory.buildCar(CarType.LUXURY);
    System.out.println(car3);
  }
}
