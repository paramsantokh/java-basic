package designPatterns.creational.builder.builder2;

public class PhoneBuilder {
  
  private String os;
  private String processor;
  private double screenSize;
  private int ram;
  private int battery;
  
  public PhoneBuilder() {
  
  }
  
  //set required field
  public PhoneBuilder(String os, String processor) {
    this.os = os;
    this.processor = processor;
  }
  
  public PhoneBuilder os(String os) {
    this.os = os;
    return this;
  }
  
  public PhoneBuilder processor(String processor) {
    this.processor = processor;
    return this;
  }
  
  public PhoneBuilder screenSize(double screenSize) {
    this.screenSize = screenSize;
    return this;
  }
  
  public PhoneBuilder ram(int ram) {
    this.ram = ram;
    return this;
  }
  
  public PhoneBuilder battery(int battery) {
    this.battery = battery;
    return this;
  }
  
  public Phone build() {
    Phone phone = new Phone(os, processor, 6.1, 4, 3000);
    return phone;
  }
}
