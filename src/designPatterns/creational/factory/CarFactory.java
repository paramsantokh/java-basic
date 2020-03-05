package designPatterns.creational.factory;

/**
 * Factory pattern is used to create instances of different classes of the same type.
 * Factory pattern, we create object without exposing the creation logic to the client and
 * refer to newly created object using a common interface.
 *
 * Factory pattern in JDK itself e.g.
 * java.sql.DriverManager#getConnection()
 * java.net.URL#openConnection()
 * java.lang.Class#newInstance()
 * java.lang.Class#forName()
 */
public class CarFactory {
  
  public static Car buildCar(CarType model) {
    switch (model) {
      case SMALL:
        return new SmallCar();
      case SEDAN:
        return new SedanCar();
      case LUXURY:
        return new LuxuryCar();
      default:
        System.out.println("Car model not found");
        break;
    }
    
    return null;
  }
}