package designPatterns.structural.adapter.chargingExample;

public class ChargingAdapter implements Iphone, Xiaomi {
  
  @Override
  public void chargePhone(String s) {
    //uses samsung charger to charge iphone/xiaomi
    new Samsung().chargePhone(s);
  }
}
