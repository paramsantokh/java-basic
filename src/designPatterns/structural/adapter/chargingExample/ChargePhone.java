package designPatterns.structural.adapter.chargingExample;

public class ChargePhone {
  
  private Iphone iphone;
  private Xiaomi xiaomi;
  
  public Iphone getIphone() {
    return iphone;
  }
  
  public void setIphone(Iphone iphone) {
    this.iphone = iphone;
  }
  
  public Xiaomi getXiaomi() {
    return xiaomi;
  }
  
  public void setXiaomi(Xiaomi xiaomi) {
    this.xiaomi = xiaomi;
  }
  
  public void charge() {
    if (this.iphone != null) {
      iphone.chargePhone("Charging iphone....");
    } else if (this.xiaomi != null) {
      xiaomi.chargePhone("Charging mi phone....");
    }
  }
}
