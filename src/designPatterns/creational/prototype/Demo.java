package designPatterns.creational.prototype;

public class Demo {
  
  public static void main(String[] args) throws CloneNotSupportedException {
    Movie movie = (Movie) PrototypeFactory.getInstance(PrototypeFactory.ObjectType.MOVIE);
    System.out.println(movie);
    
    Album album = (Album) PrototypeFactory.getInstance(PrototypeFactory.ObjectType.ALBUM);
    System.out.println(album);
    
    Show show = (Show) PrototypeFactory.getInstance(PrototypeFactory.ObjectType.SHOW);
    System.out.println(show);
  }
}
