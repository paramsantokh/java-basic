package lambdas;

import java.util.function.UnaryOperator;
/**
 * If input and output parameters are of same type, use UnaryOperator instead of Function
 */
public class UnaryOperatorExample {
  static UnaryOperator<String> unaryOperator = s -> s.toUpperCase();
  public static void main(String[] args) {
  System.out.println(unaryOperator.apply("Hello"));
  }
}
