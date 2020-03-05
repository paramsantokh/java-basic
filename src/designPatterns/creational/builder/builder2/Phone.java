package designPatterns.creational.builder.builder2;

/**
 * Phone class with separate builder class.
 * Phone class should not have setter methods to make object immutable
 */
public class Phone {
  //required
  private String os;
  private String processor;
  //optional
  private double screenSize;
  private int ram;
  private int battery;
  
  Phone(String os, String processor, double screenSize, int ram, int battery) {
    this.os = os;
    this.processor = processor;
    this.screenSize = screenSize;
    this.ram = ram;
    this.battery = battery;
  }
  
  @Override
  public String toString() {
    return "Phone{" +
           "os='" + os + '\'' +
           ", processor='" + processor + '\'' +
           ", screenSize=" + screenSize +
           ", ram=" + ram +
           ", battery=" + battery +
           '}';
  }
}
