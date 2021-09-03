package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author param singh
 */

/**
 * Implement HashSet using List
 */
public class MyHashSet {
  
  private int SIZE;
  List<List<Integer>> parentList;
  
  public MyHashSet() {
    SIZE = 100;
    parentList = new ArrayList<>(SIZE);
    for (int i = 0; i < SIZE; i++) {
      parentList.add(i, null);
    }
  }
  
  public void add(int key) {
    int index = key % SIZE;
    List<Integer> childList = parentList.get(index);
    if (childList == null) {
      childList = new LinkedList<>();
      childList.add(key);
      parentList.set(index, childList);
    } else {
      if (!childList.contains(key)) {
        childList.add(key);
      }
    }
  }
  
  public void remove(Integer key) {
    int index = key % SIZE;
    List<Integer> childList = parentList.get(index);
    if (childList != null && childList.contains(key)) {
      childList.remove(key);
    }
  }
  
  public boolean contains(int key) {
    int index = key % SIZE;
    List<Integer> childList = parentList.get(index);
    return childList != null ? childList.contains(key) : false;
  }
  
  public void display() {
    for (int i = 0; i < SIZE; i++) {
      List<Integer> childList = parentList.get(i);
      if (childList != null) {
        childList.forEach(key -> {
          System.out.println(key);
        });
      }
    }
  }
  
  public static void main(String[] args) {
    MyHashSet myHashSet = new MyHashSet();
    myHashSet.add(2000);
    myHashSet.add(100);
    myHashSet.add(70);
    myHashSet.add(99);
    myHashSet.add(101);
    myHashSet.add(203);
    
    myHashSet.display();
  
    System.out.println(myHashSet.contains(203));
  
    myHashSet.remove(2000);
  
    System.out.println("HashSet after remove");
    myHashSet.display();
  }
  
}
