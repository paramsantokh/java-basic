package designPatterns.structural.adapter.chargingExample;

public interface Iphone {
  public String iphoneName = "iPhone";
  //do not have a charging connector
  public void chargePhone(String s);
}
