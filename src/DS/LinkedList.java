package DS;

public class LinkedList {
  
  Node head;
  
  static class Node {
    
    int data;
    Node next;
    
    Node(int d) {
      data = d;
      next = null;
    }
  }
  
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list = insert(list, 1);
    list = insert(list, 2);
    list = insert(list, 3);
    list = insert(list, 4);
    list = insert(list, 5);
    list = insert(list, 6);
    list = insert(list, 7);
    printList(list);
    list = insertByPosition(list, 4, 999);
    printList(list);
    
    list = deleteByPosition(list, 3);
    System.out.println("Deleted node at index: " + 3);
    printList(list);
    
    int value = 6;
    list = deleteByValue(list, value);
    System.out.println("Deleted node with value: " + value);
    printList(list);
    
    push(list, 111);
    printList(list);
  }
  
  protected static LinkedList insert(LinkedList list, int d) {
    Node new_node = new Node(d);
    //if inserting first node in list, point head to the new node.
    if (list.head == null) {
      list.head = new_node;
      return list;
    }
    //goto last node to add the new node
    Node current = list.head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = new_node;
    
    return list;
  }
  
  protected static LinkedList insertByPosition(LinkedList list, int pos, int value) {
    Node current = list.head;
    if (list.head == null) {
      return list;
    }
    
    Node new_node = new Node(value);
    if (pos == 1) {
      list.head = new_node;
      new_node.next = current;
      return list;
    }
    
    int count = 1;
    Node prev = null;
    while (current != null && pos != count){
      prev = current;
      current = current.next;
      count++;
    }
    
    //position not found
    if(current == null){
      return list;
    }
    
    prev.next = new_node;
    new_node.next = current;
    
    return list;
  }
  
  /**
   * Delete node by position given
   *
   * @param list
   * @param pos
   */
  protected static LinkedList deleteByPosition(LinkedList list, int pos) {
    if (list == null || list.head == null) {
      return list;
    }
    
    Node current = list.head;
    //first node
    if (pos == 1) {
      list.head = current.next;
      current.next = null;
      return list;
    }
    
    Node previous = null;
    int count = 1;
    //traverse
    while (current != null && pos != count) {
      previous = current;
      current = current.next;
      count++;
    }
    //position not found
    if (current == null) {
      return list;
    }
    
    if (current.next == null) {
      //last node
      previous.next = null;
    } else {
      //in between
      previous.next = current.next;
      current.next = null;
    }
    
    return list;
  }
  
  protected static LinkedList deleteByValue(LinkedList list, int value) {
    if (list == null || list.head == null) {
      return list;
    }
    Node current = list.head, prev = null;
    //First node
    if (current.data == value) {
      list.head = current.next;
      return list;
    }
    
    //traverse
    while (current != null && value != current.data) {
      prev = current;
      current = current.next;
    }
    
    if (current == null) {
      return list;
    }
    
    prev.next = current.next;
    current.next = null;
    
    return list;
  }
  
  /**
   * Add a node at head(insert node in list as first node)
   * @param list
   * @param data
   * @return
   */
  protected static void push(LinkedList list, int data){
    Node new_node = new Node(data);
    new_node.next = list.head;
    list.head = new_node;
  }
  
  protected static void printList(LinkedList list) {
    System.out.println("==================================");
    Node node = list.head;
    while (node != null) {
      System.out.println(node.data);
      node = node.next;
    }
  }
}
