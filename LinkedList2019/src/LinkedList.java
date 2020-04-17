/**********************************************************
 * A Linked List class.
 * 
 * @author Solomon
 * @version Feb 2k19
 *********************************************************/
public class LinkedList {
    
  // instance variable for the list
  private LinkedListItem head;  
  private LinkedListItem tail;  
    
  // constructor List
  public LinkedList(){
    head = null;
    tail = null;
      
  } // end constructor 

  // Count the number of items in the list
  public int size() {
    int count = 0;
    LinkedListItem currItem = head;
    while (currItem != null) {
      count++;
      currItem = currItem.getNext();
    } // end while
    return count;
  } // end size
  
  public int rSize() {
    return ( recursiveSize(head) );
  } // end rSize
  public int recursiveSize(LinkedListItem ci) {
    if (ci == null) return 0;
    else return ( 1 + recursiveSize(ci.getNext()) );
  } // end recursiveSize
  
  // Bad, bad, bad! Utility method - just for testing.
  public void displayList() {
    
    LinkedListItem currItem = head;
    while (currItem != null) {
      System.out.println("item contains = " + currItem.getValue() );
      currItem = currItem.getNext();
    } // end while
    
  } // end displayList
  
  // Add newData to the tail 
  public void addToTail(Object newData) {
    
    LinkedListItem prevItem = null, currItem = head;
    while (currItem != null) { 
      prevItem = currItem;
      currItem = currItem.getNext();
    } // end while
    
    if (prevItem == null) addToHead(newData);
    else {
      LinkedListItem temp = new LinkedListItem(newData);
      prevItem.setNext(temp);
      }
    
  } // end addToTail
  
  // Assumes list is not empty to start with
  public Object removeFromTail() {
    
    LinkedListItem prevItem = null, currItem = head;
    while (currItem.getNext() != null) {
      prevItem = currItem;
      currItem = currItem.getNext();
    } // end while
    
    if (prevItem == null) removeFromHead();
    else {
      prevItem.setNext(null);
    } // end else
    
    return currItem.getValue();
    
  } // end removeFromTail
  
  // Assumes list has at least itemNo elements
  public Object removeItem( int itemNo) {
    
    int count = 1;
    LinkedListItem prevItem = null, currItem = head;
    while (count < itemNo) {
      count++;
      prevItem = currItem;
      currItem = currItem.getNext();
    } // end while
    
    prevItem.setNext( currItem.getNext() );
    
    return currItem.getValue();
    
  } // end removeItem
  
  // Assumes list has at least itemNo elements
  public void insertItem(Object newData, int itemNo) {
    
    int count = 1;
    LinkedListItem prevItem = null, currItem = head;
    
    while (count < itemNo) {
      count++;
      prevItem = currItem;
      currItem = currItem.getNext();
    } // end while
    
    prevItem.setNext( new LinkedListItem(newData, currItem) );
  
  } // end insertItem

  public boolean isEmpty() {
    return ( size() == 0 );
  } // end isEmpty

  public void addToHead(Object data) {
    head = new LinkedListItem(data, head);
  } // end addToHead

  public Object removeFromHead() {
    LinkedListItem tempItem = head;
    head = head.getNext();
    return tempItem.getValue();
  } // removeFromHead


} // end class LinkedList
