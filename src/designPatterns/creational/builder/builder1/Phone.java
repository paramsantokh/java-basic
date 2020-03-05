package designPatterns.creational.builder.builder1;

/**
 * Phone class with inner builder class.
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
  
  Phone(Builder builder) {
    this.os = builder.os;
    this.processor = builder.processor;
    this.screenSize = builder.screenSize;
    this.ram = builder.ram;
    this.battery = builder.battery;
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
  
  /**
   * Builder class will have setter methods which return PhoneBuilder object
   */
  public static class Builder {
    
    private String os;
    private String processor;
    private double screenSize;
    private int ram;
    private int battery;
    
    public Builder(){
    
    }
    
    //set required field
    public Builder(String os, String processor) {
      this.os = os;
      this.processor = processor;
    }
    
    public Builder os(String os) {
      this.os = os;
      return this;
    }
    
    public Builder processor(String processor) {
      this.processor = processor;
      return this;
    }
    
    public Builder screenSize(double screenSize) {
      this.screenSize = screenSize;
      return this;
    }
    
    public Builder ram(int ram) {
      this.ram = ram;
      return this;
    }
    
    public Builder battery(int battery) {
      this.battery = battery;
      return this;
    }
    
    //create Phone object using PhoneBuilder object
    public Phone build() {
      Phone phone = new Phone(this);
      return phone;
    }
  }
}
