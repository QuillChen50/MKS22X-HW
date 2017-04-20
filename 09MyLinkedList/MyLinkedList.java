/*
  Phase I:
  boolean add(int value) 
  - adds the value to end (try adding to the front first, for testing purposes)
  int size() 
  - return the number of elements in the list
  toString() 
  - returns a string representation of the list of n elements formatted like: 
  [ v0, v1, v2, v3, ... vn-1] 
  An empty list is just []
  int get(int index) 
  - return the value of the element at the specified index (0 based)
  int set(int index,int newValue)
  - change the value of the element at the specified index to the newValue, return the old value  

  Phase II:
  int indexOf(int value) 
  - returns the index of the 1st occurrence of the value in the linked list, -1 if not found.
  void add(int index, int value)    
  - insert a new element at the specified index, 0 at the front, size() at the end. 
  int remove(int index) 
  - remove the element at the specified index, returns the value removed

  ALSO: 
  -Any exceptions that the actual LinkedList contains:  get,set,add,remove
*/
public class MyLinkedList{

    public LNode start;
    public int size;
    public LNode end;

    public MyLinkedList(){
	size = 0;
	//call LNode instantiation
	//start = node;
    }

    public class LNode{
	LNode prev;
	int value;
	LNode next;

	public LNode(int value){
	    LNode current = start;

	}
    }

    public LNode getNthNode (int n){
	LNode current;
	int nth;
	current = start;
	nth = n;
	while (n > 1){ 
	    current = current.next;
	    nth++;
	}
	return current;
    }

    public boolean add (int value){
	size++;

	if (size == 1){
	start = new LNode(value);
	end = start;
	return true;
	}

	else if (size > 1){
	    LNode temp = end;
	    LNode n = new LNode(value);
	    temp.next  = n; 
	    end = n;
	    n.prev = temp;

	return true;
	}

	return false;
    }

    public String toString(){
	String result = "[";
	LNode now = start;
	for (int i = size; i > 0; i++){
	    start = start.next;
	    result = "(" + 
now.prev +"," + 
now.value + "," + 
now.next + ")";
	}
	result += "]";
	return result;
    }
    
    
    /*
    public static void main (String [] args){
	MyLinkedList l = new MyLinkedList();
	l.add(2);
	l.add(5);
	//The Nodes are still not added quite yet, that or my toString has a bug
	System.out.println(l);
	    }
    */

	
	
}


