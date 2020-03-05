package DSA;

public class CDLL {
  
  Node head;
  
  static class Node {
    
    int data;
    Node prev;
    Node next;
    
    Node(int data) {
      this.data = data;
      prev = null;
      next = null;
    }
  }
  
  private static void insert(CDLL list, int value) {
    Node new_node = new Node(value);
    
    if (list.head == null) {
      list.head = new_node;
      new_node.next = new_node;
      new_node.prev = new_node;
      return;
    }
    
    Node last = list.head.prev;
    
    //head.prev will have last node(new node) address
    list.head.prev = new_node;
    last.next = new_node;
    new_node.prev = last;
    new_node.next = list.head;
  }
  
  private static void delete(CDLL list, int value) {
    Node current = list.head;
    
    if (current == null) {
      return;
    }
    
    while (current.data != value) {
      current = current.next;
      
      if (current == list.head) {
        System.out.println("Node with value " + value + " not found");
        return;
      }
    }
    
    deleteNode(list, current);
  }
  
  private static void deleteNode(CDLL list, Node current) {
    if (current.prev == list.head.prev) {
      if (current.next == current) {
        //single node in list
        list.head = null;
      } else {
        list.head = current.next;
        current.next.prev = current.prev;
      }
    }
    
    current.next = null;
    current.prev = null;
  }
  
  private static void printList(CDLL list) {
    Node current = list.head;
    do {
      System.out.print(current.data);
      current = current.next;
      if (current != list.head) {
        System.out.print("->");
      } else {
        //To see if list is circular
        System.out.print("->" + current.data);
      }
    } while (current != list.head);
    
    System.out.println();
  }
  
  private static void printReverseList(CDLL list) {
    Node last = list.head.prev;
    Node temp = last;
    do {
      System.out.print(temp.data);
      if (temp.prev != last) {
        System.out.print("->");
      }
      temp = temp.prev;
    } while (temp != last);
    
    System.out.println();
  }
  
  public static void main(String[] args) {
    CDLL list = new CDLL();
    insert(list, 1);
    insert(list, 2);
    insert(list, 3);
    insert(list, 4);
    insert(list, 5);
    insert(list, 6);
    insert(list, 7);
    insert(list, 8);
    
    printList(list);
    printReverseList(list);
    
    delete(list, 4);
    //printList(list);
    //printReverseList(list);
  }
}
