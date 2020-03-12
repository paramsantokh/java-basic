package designPatterns.structural.adapter.chargingExample;

/**
 * You have samsung charger.you have to charge iphone/xiaomi phones using this charger.
 * All you need is an adapter to connect charger to phones.
 *
 * Example 1:
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * System.out.print("Enter String");
 * String s = br.readLine();
 * System.out.print("Enter input: " + s);
 *
 * Problem: System.in provides byte stream where BufferedReader expects character stream
 *
 * Solution: InputStreamReader(Adapter) is a bridge from byte streams to character streams
 *
 * Example 2:
 * java.util.Arrays#asList()
 *
 * This method accepts multiple strings and return a list of input strings
 */
public class Demo {
  
  public static void main(String[] args) {
    //ChargingAdapter implements Iphone interface
    Iphone iphone = new ChargingAdapter();
    ChargePhone charge1 = new ChargePhone();
    charge1.setIphone(iphone);
    charge1.charge();
  
    //ChargingAdapter implements Xiaomi interface
    Xiaomi xiaomi = new ChargingAdapter();
    ChargePhone charge2 = new ChargePhone();
    charge2.setXiaomi(xiaomi);
    charge2.charge();
  }
}
