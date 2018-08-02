
// This is the class for a generic queue (FIFO)
// Generinc Queue class
/**
 * @author Harsh Patel
 * Description: This is a generic Queue class that can store any java obj
 */
public class Queue<T>{
  private Node<T> first;
  private Node<T> temp;
  private Node<T> last;
  private int size;
  
  // Constructor
  public Queue() {
    this.size = 0; 
  }
  
  /**
   * @return Returns true if Queue is empty
   */
  public boolean isEmpty() {  
    //O(1)
    return (size==0);
  }
  
  /**
   *@return Returns the object in front of the queue
   */
  public T getFront() {  
    // O(1)
    if(!isEmpty())
      return first.getData();
    return null;
  }
  
  /**
   * @param value Takes in the obj value that is to be added at the back of the queue
   */
  public void enqueue(T value) {
    
    // O(1)
    if(isEmpty())
      first = last = new Node<T>(value);
    else {
      temp = new Node<T>(value);
      last.setNext(temp);
      last = temp;
    }
    size++;
    return;
  }
  
  /**
   * @return Returns the first object in the Queue
   */
  public T dequeue(){
    
    // O(1)
    if(!isEmpty()) {
      T ans = getFront();
      first = first.getNext();
      size--;
      return ans;
    }
    return null;
  }
  
  // This node class helps to create a linked list that takes care of members in queue
  private class Node<T>{
    
    //Instance Variables
    private Node<T> next;
    private T data;
    
    //Constructor to node
    private Node(T data){
      this.data = data;
      this.next = null;
    }
    private T getData() {
      return this.data;
    }
    private Node<T> getNext() {
      return next;
    }
    private void setNext(Node<T> n) {
      next = n;
      return;
    }
  }
  
  //----------------------------------------------------
  // example testing code... make sure you pass all ...
  // and edit this as much as you want!
  
  public static void main(String[] args){
    Queue<Integer> iq = new Queue<Integer>();
    if (iq.isEmpty() && iq.getFront()==null){
      System.out.println("Yay 1");
    }
    
    iq.enqueue(new Integer(12));
    iq.enqueue(new Integer(20));
    iq.enqueue(new Integer(-233));
    
    if (iq.dequeue()==12 && iq.getFront()==20 ){
      System.out.println("Yay 2");
    }
    
    if (iq.dequeue()==20 && iq.dequeue()==-233 && iq.isEmpty() ){
      System.out.println("Yay 3");
    }
    
  }
  
}
