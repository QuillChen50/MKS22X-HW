import java.util.NoSuchElementException;

public class MyDeque{
    String[] data;
    int first;
    int last;
    int size;
    public MyDeque(){
	data = new String[3];
	first = 1;
	last = 0;
	size = 0;
    }
     public String getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return data[first];
    }
    //Methods that have yet to be finished

     public void grow(){
     }
    
public String removeFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
}
     public String removeLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
     }
    public void addLast(String toAdd){
       if (toAdd == null){
	    throw new NullPointerException();
	}
    }
    
    public String getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return data[last];
    }

     public void addFirst(String toAdd){
	if (toAdd == null){
	    throw new NullPointerException();
	}
     }

    //toString is done
    

     public String toString(){
	String total = "";
	for (int i = 0; i < data.length; i++){
	    System.out.print(data[i] + " ");
	}
	System.out.println();
	for (int i = first; i < size + first; i++){
	    total += data[i % data.length] + " ";
	}
	return total;
    }
}
