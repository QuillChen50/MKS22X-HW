import java.util.Stack;
import java.util.Queue;
import java.util.PriorityQueue;


public Interface Frontier{



    public boolean add(Location l) throws IOException{

    }

    public Location next() throws IOException{

    }
    
}

public FrontierPriorityQueue implements Frontier{
    Queue pq;
    ArrayList a;

    public FrontierPriorityQueue (){

    }

    public boolean add(Location l) throws IOException{

    }

    public Location next() throws IOException{

    }
    
}

public FrontierQueue implements Frontier{
    Queue q;

    public boolean add(Location l) throws IOException{
	
        q.enqueue(l);
	return true;
    }

    public Location next() throws IOException{
	q.dequeue();
    }
    
}

public FrontierStack implements Frontier{

    Stack s;

    public boolean add(Location l) throws IOException{
	return s.push(l);
        
    }

    public Location next() throws IOException{
	s.pop();
    }
    
}

//


    

