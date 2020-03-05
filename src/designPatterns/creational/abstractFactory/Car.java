package designPatterns.creational.abstractFactory;

import designPatterns.creational.abstractFactory.enums.CarType;
import designPatterns.creational.abstractFactory.enums.Location;

public abstract class Car {
  
  CarType type;
  Location location;
  
  public Car(CarType type, Location location) {
    this.type = type;
    this.location = location;
    arrangeParts();
  }
  
  private void arrangeParts() {
    //do one time processing here
  }
  
  protected abstract void build();
  
  @Override
  public String toString() {
    return "Car{" +
           "type=" + type +
           ", location=" + location +
           '}';
  }
}
