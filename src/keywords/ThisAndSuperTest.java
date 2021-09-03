package keywords;

/**
 * @author param singh
 */

/***
 * super() as well as this() both are used to make constructor calls.
 * super() is used to call Base class’s constructor(i.e, Parent’s class)
 * while this() is used to call current class’s constructor.
 *
 * super can be used to call constructor, access variables and methods of parent class.
 *
 * this is used to call current class constructor, access variables of same class.
 */

class Parent {
  
  int i;
  
  Parent() {
    this(10);
    System.out.println("Parent class's No " +
                       " arg constructor");
  }
  
  Parent(int i) {
    this.i = 20;
    System.out.println("Parent class's 1 Arg constructor");
    System.out.println("Parent class's instance i: " + this.i);
    System.out.println("Parent class's Constructor's parameter i: " + i);
  }
  
  protected void display(){
    System.out.println("Parent's method");
  }
}

class Child extends Parent {
  
  int i;
  
  Child() {
    super();
    System.out.println("Flow comes back from " +
                       "Parent class no arg const to child class");
    i = 99;
    System.out.println("Parent class's i: " + super.i);
    System.out.println("Child class's i: " + i);
    display();
    super.display();
  }
  
  protected void display(){
    System.out.println("Child's method");
  }
}

public class ThisAndSuperTest {
  
  public static void main(String[] args) {
    new Child();
    System.out.println("Inside Main");
    
  }
}