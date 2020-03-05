package designPatterns.creational.singlton.solution;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public enum SingletonEnum {
  INSTANCE;
}

class TestEnum {
  
  public static void main(String[] args) throws Exception {
    SingletonEnum s1 = SingletonEnum.INSTANCE;
    SingletonEnum s2 = SingletonEnum.INSTANCE;
    System.out.println(s1.hashCode());
    System.out.println(s2.hashCode());
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/tmp/s2.ser"));
    oos.writeObject(s2);
    
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/tmp/s2.ser"));
    SingletonEnum s3 = (SingletonEnum) ois.readObject();
    System.out.println(s3.hashCode());
  }
}