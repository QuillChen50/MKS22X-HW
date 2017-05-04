public class MyHeap{

    private ArrayList<String> arr;
    private int size;

    //arraylist.size is one larger 

    public MyHeap(){
	int size = 0;
	arr = new ArrayList<String>();
    }

    public MyHeap(boolean mm){
	//empty max heap
	String[] temp = List.toArray(new String[arr.size*()]);
	if (mm == true){
	    InsertionSort(temp);
        
	}
    }
    public ArrayList InsertionSort(String[]){
	int j;                     // the number of items sorted so far
	int key;                // the item to be inserted
	int i;  

	for (j = 1; j < num.length; j++)    // Start with 1 (not 0)
	    {
		key = num[ j ];
		for(i = j - 1; (i >= 0) && (num[ i ] < key); i--)   // Smaller values are moving up
		    {
			num[ i+1 ] = num[ i ];
		    }
		num[ i+1 ] = key;    // Put the key in its proper location
	    }
    }




 

    /*
      public MyHeap (ArrayList<Integer> a){
      int s = a.size();
      arr = new ArrayList<Integer>(s);
      for (Integer n: a){

      }
    */

    public void add (String s){
	arr.add(s);
	//how would one know if this added is the right or left child b/c that determines whether the parent is at n/2 of (n/2)+1
	if (index > arr[index/2]){

	}



    }

    public void remove (Integer n){

    }

    //push up or down a index
    //parameter is index of child (value being pushed up or down)
}
