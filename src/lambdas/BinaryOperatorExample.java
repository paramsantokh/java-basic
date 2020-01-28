package lambdas;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * If input and output parameters are of same type, use BinaryOperator instead of BiFunction
 */
public class BinaryOperatorExample {
  
  static BinaryOperator<Integer> binaryOperator = (a, b) -> a * b;
  static Comparator<Integer> comparator = (o1, o2) -> o1.compareTo(o2);
  
  public static void main(String[] args) {
    System.out.println(binaryOperator.apply(10, 20));
    BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
    System.out.println("minBy: " + minBy.apply(10, 20));
    BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
    System.out.println("maxBy: " + maxBy.apply(10, 20));
  }
}
