package designPatterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeFactory {
  
  public static class ObjectType {
    
    public static final String MOVIE = "movie";
    public static final String ALBUM = "album";
    public static final String SHOW = "show";
  }
  
  private static  Map<String, Cloneable> objectMap = new HashMap<>();
  static {
    objectMap.put(ObjectType.MOVIE, new Movie(1, "Masaan"));
    objectMap.put(ObjectType.ALBUM, new Album(1, "Album"));
    objectMap.put(ObjectType.SHOW, new Show(1, "Show"));
  }
  
  public static PrototypeCapable getInstance(final String s) throws CloneNotSupportedException{
    return ((PrototypeCapable) objectMap.get(s)).clone();
  }
}
