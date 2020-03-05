package DSA;

public class CSLL {
  
  Node head;
  
  static class Node {
    
    int data;
    Node next;
    
    Node(int value) {
      data = value;
      next = null;
    }
  }
  
  /**
   * Adding node at the end of list
   *
   * @param list
   * @param value
   */
  private static void insert(CSLL list, int value) {
    Node new_node = new Node(value);
    Node current = list.head;
    
    if (current == null) {
      list.head = new_node;
      new_node.next = list.head;
      return;
    }
    
    while (current.next != list.head) {
      current = current.next;
    }
    
    current.next = new_node;
    new_node.next = list.head;
  }
  
  private static void insertAtPos(CSLL list, int pos, int value) {
    Node new_node = new Node(value);
    Node current = list.head;
    if (pos == 1) {
      if (list.head == null) {
        //adding first node
        new_node.next = new_node;
      } else {
        new_node.next = current;
      }
      
      list.head = new_node;
    }
    
    int count = 1;
    Node prev;
    do {
      prev = current;
      current = current.next;
      count++;
    } while (current != list.head && count != pos);
    
    if (current == list.head) {
      return;
    }
    
    prev.next = new_node;
    new_node.next = current;
  }
  
  private static void delete(CSLL list, int value) {
    Node current = list.head;
    if (current == null) {
      return;
    }
    
    Node prev = null;
    while (current.data != value) {
      prev = current;
      current = current.next;
      if (current == list.head) {
        System.out.println("Node with value:" + value + " Not found");
        return;
      }
    }
    //we have decided node to delete(current)
    deleteNode(list, prev, current);
  }
  
  private static void deleteAtPos(CSLL list, int pos) {
    Node current = list.head;
    if (current == null) {
      return;
    }
    
    Node prev = null;
    int count = 1;
    while (pos != count) {
      prev = current;
      current = current.next;
      count++;
      if (current == list.head) {
        System.out.println("Node at position:" + pos + " Not found");
        return;
      }
    }
  
    //we have decided node to delete(current)
    deleteNode(list, prev, current);
    
  }
  
  private static void deleteNode(CSLL list, Node prev, Node current) {
    if (current.next == current) {
      //single node in the list: current point to itself
      list.head = null;
    } else if (current == list.head) {
      //goto last node
      Node last = current;
      while (last.next != list.head) {
        last = last.next;
      }
      //update the last.next to new head
      last.next = current.next;
      //update head to point to second node
      list.head = current.next;
    } else if (prev != null && prev.next == list.head) {
      //last node: update second last node's next with head
      prev.next = list.head;
    } else {
      //node in between
      prev.next = current.next;
    }
  }
  
  private static void printList(CSLL list) {
    if (list.head == null) {
      System.out.println("Null List");
      return;
    }
    
    Node current = list.head;
    
    do {
      System.out.print(current.data);
      current = current.next;
      
      if (current != list.head) {
        System.out.print("->");
      }
    } while (current != list.head);
    
    System.out.println();
  }
  
  private static void printCircularList(CSLL list) {
    if (list.head == null) {
      System.out.println("Null List");
      return;
    }
    Node current = list.head;
    do {
      System.out.print(current.data);
      current = current.next;
      
      if (current != list.head) {
        System.out.print("->");
      } else {
        //To check if list is circular, the below statement will print first element again
        System.out.print("->" + current.data);
      }
    } while (current != list.head);
    
    System.out.println();
  }
  
  public static void main(String[] args) {
    CSLL list = new CSLL();
    insert(list, 1);
    insert(list, 2);
    insert(list, 3);
    insert(list, 4);
    insert(list, 5);
    insert(list, 6);
    insert(list, 7);
    insert(list, 8);
    printList(list);
    //To check if list is circular
    printCircularList(list);
    
    insertAtPos(list, 8, 999);
    printList(list);
    printCircularList(list);
    
    delete(list, 1);
    printList(list);
    printCircularList(list);
    
    deleteAtPos(list,8);
    printList(list);
    printCircularList(list);
  }
}
