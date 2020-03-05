package designPatterns.creational.builder.builder2;

public class Demo {
  
  public static void main(String[] args) {
    Phone phone = new PhoneBuilder("Window", "SD")
        .battery(4000)
        .ram(6)
        .build();
  
    System.out.println(phone);
  
    Phone phone1 = new PhoneBuilder().os("IOS").processor("K9")
        .battery(4000)
        .screenSize(6.3)
        .build();
  
    System.out.println(phone1);
  }
}
