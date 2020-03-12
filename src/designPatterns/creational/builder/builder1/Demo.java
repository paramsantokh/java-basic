package designPatterns.creational.builder.builder1;

/**
 * 1. The number of lines of code increase at least to double in builder pattern,
 * but the effort pays off in terms of design flexibility and much more readable code.
 *
 * 2. The parameters to the constructor are reduced and are provided in highly readable method calls.
 *
 * 3. Builder pattern also helps minimizing the number of parameters in constructor and thus
 * there is no need to pass in null for optional parameters to the constructor.
 * It’s really attracts me.
 *
 * 4. And finally I can build immutable objects without much complex logic in object building process.
 *
 * 5. All implementations of java.lang.Appendable are good example of use of Builder pattern in java. e.g.
 *    >java.lang.StringBuilder:append()
 *    >java.nio.ByteBuffer:put()
 *
 */
public class Demo {
  
  public static void main(String[] args) {
    Phone phone = new Phone.Builder("Adndrod", "SD")
        .battery(4000)
        .ram(6)
        .build();
  
    System.out.println(phone);
    Phone phone1 = new Phone.Builder()
        .os("IOS")
        .processor("K9")
        .battery(4000)
        .screenSize(6.3)
        .build();
  
    System.out.println(phone1);
  }
}
