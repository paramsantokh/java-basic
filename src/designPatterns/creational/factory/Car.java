package designPatterns.creational.factory;

public abstract class Car {
  
  CarType type;
  boolean airbags;
  
  Car(CarType type) {
    this.type = type;
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
           ", airbags=" + airbags +
           '}';
  }
}
