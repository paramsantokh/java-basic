package DSA;

public class DoublyLinkedList {
  
  protected Node head;
  
  static class Node {
    
    int data;
    Node prev;
    Node next;
    
    Node(int d) {
      data = d;
      prev = null;
      next = null;
    }
  }
  
  protected static void insert(DoublyLinkedList list, int data) {
    Node new_node = new Node(data);
    Node current = list.head;
    //first node
    if (current == null) {
      list.head = new_node;
      return;
    }
    
    while (current.next != null) {
      current = current.next;
    }
    
    current.next = new_node;
    new_node.prev = current;
  }
  
  protected static void insertByPos(DoublyLinkedList list, int pos, int value) {
    Node current = list.head;
    Node new_node = new Node(value);
    if (pos == 1) {
      new_node.next = list.head;
      list.head.prev = new_node;
      list.head = new_node;
      return;
    }
    
    int count = 1;
    while (current != null && pos != count) {
      current = current.next;
      count++;
    }
    
    if (current == null) {
      return;
    }
    
    new_node.prev = current.prev;
    new_node.next = current;
    if (current.prev != null) {
      current.prev.next = new_node;
    }
    current.prev = new_node;
  }
  
  private static void deleteByValue(DoublyLinkedList list, int data) {
    Node current = list.head;
    if (current == null) {
      return;
    }
    
    //goto the node to be deleted
    while (current != null && current.data != data) {
      current = current.next;
    }
    
    //No node found with data
    if (current == null) {
      return;
    }
    
    //current node is the Node to be deleted
    deleteNode(list, current);
  }
  
  private static void deleteNode(DoublyLinkedList list, Node nodeToBeDeleted) {
    //first node
    if (nodeToBeDeleted == list.head) {
      list.head = nodeToBeDeleted.next;
    }
    
    if (nodeToBeDeleted.next != null) {
      nodeToBeDeleted.next.prev = nodeToBeDeleted.prev;
    }
    
    if (nodeToBeDeleted.prev != null) {
      nodeToBeDeleted.prev.next = nodeToBeDeleted.next;
    }
    
    nodeToBeDeleted.prev = null;
    nodeToBeDeleted.next = null;
  }
  
  private static void printList(DoublyLinkedList list) {
    Node current = list.head;
    while (current != null) {
      System.out.print(current.data);
      if (current.next != null) {
        System.out.print("->");
      }
      current = current.next;
    }
    
    System.out.println();
  }
  
  private static void printReverseList(DoublyLinkedList list) {
    Node current = list.head;
    while (current.next != null) {
      current = current.next;
    }
    while (current != null) {
      System.out.print(current.data);
      if (current.prev != null) {
        System.out.print("->");
      }
      current = current.prev;
    }
    
    System.out.println();
  }
  
  private static void search(DoublyLinkedList list, int value) {
    if (list.head == null) {
      System.out.println("NULL list");
      return;
    }
    Node current = list.head;
    int count = 1;
    while (current != null) {
      if (value == current.data) {
        System.out.println(value + " found at location:" + count);
        return;
      }
      current = current.next;
      count++;
    }
  }
  
  public static void main(String[] args) {
    DoublyLinkedList list = new DoublyLinkedList();
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
    
    deleteByValue(list, 9);
    printList(list);
    printReverseList(list);
    
    deleteByValue(list, 1);
    printList(list);
    printReverseList(list);
    
    deleteByValue(list, 8);
    printList(list);
    printReverseList(list);
    
    insertByPos(list, 1, 999);
    printList(list);
    printReverseList(list);
    
    search(list, 999);
  }
}
