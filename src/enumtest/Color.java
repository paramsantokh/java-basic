package enumtest;

import java.util.Arrays;

public enum Color {
  RED("3"), GREEN("2"), BLUE("3");
  
  private String index;
  private String desc;
  
  private Color(String index){
    this.index = index;
  }
  
  
  public String getIndex() {
    return index;
  }
  
  public void setIndex(String index) {
    this.index = index;
  }
  
  public String getDesc() {
    return desc;
  }
  
  public void setDesc(String desc) {
    this.desc = desc;
  }
  
  public static void main(String[] args) {
    int i= 0;
    for(Color color : Color.values()){
      color.desc = String.valueOf(i++);
    }
    
    System.out.println(Color.BLUE.desc);
  }
}

