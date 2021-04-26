package DSA.tree;

/**
 * @author param singh
 */
public class BinaryTree {
  
  Node root;
  
  
  public void insert(int data){
    root = insertRec(root, data);
  }
  
  public Node insertRec(Node root, int data){
   if(root == null){
     return new Node(data);
   }
   
   if(data < root.data){
     root.left = insertRec(root.left, data);
   } else if(data > root.data){
     root.right = insertRec(root.right, data);
   }
     return root;
  }
  
  
  public void display(){
    displayRec(root);
  }
  
  public void displayRec(Node root){
    if(root == null){
      return;
    }
    displayRec(root.left);
  
    System.out.println(root.data);
  
    displayRec(root.right);
  }
  
  public void search(int data){
    Node found = searchRec(root, data);
    
    if(found == null){
      System.out.println("Data:"+data+" Not found");
    } else{
      System.out.println("Data:"+found.data+"  found");
    }
  }
  
  public Node searchRec(Node root, int data){
  //if data found in the current node(root)
  if(root == null || root.data == data){
    return root;
  }
  
  //check if data is less that the current node then traverse left
  if(data < root.data){
    return searchRec(root.left, data);
  }
     //else traverse right
    return searchRec(root.right, data);
  
  }
  
  public static void main(String[] args){
    BinaryTree bTree = new BinaryTree();
    bTree.insert(2);
    bTree.insert(4);
    bTree.insert(1);
    bTree.insert(5);
    bTree.insert(3);
    bTree.insert(6);
    
    bTree.display();
    
    bTree.search(2);
    
  }
}
