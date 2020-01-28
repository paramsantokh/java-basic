package customannotation;

import java.lang.reflect.Method;

public class TestAnnotation {
  
  @MyAnnotation(expiryDate = "10-10-2025")
  public void getMethod1(){
    System.out.println("method1");
  }
  
  @MyAnnotation(value = "value", expiryDate = "12-10-2023")
  public void getMethod2(){
    System.out.println("method2");
  }
  
  public static void main(String[] args) throws Exception {
    Method method = new TestAnnotation().getClass().getMethod("getMethod1") ;
    MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
    System.out.println(myAnnotation.value() + ":" + myAnnotation.expiryDate());
  
    method = new TestAnnotation().getClass().getMethod("getMethod2") ;
     myAnnotation = method.getAnnotation(MyAnnotation.class);
    System.out.println(myAnnotation.value() + ":" + myAnnotation.expiryDate());
  }
}
