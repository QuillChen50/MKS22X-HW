public class MyHeap{

    private ArrayList<String> arr;
    private int size;
    private int min;

    //arraylist.size is one larger 

    public MyHeap(){
	int size = 0;
	arr = new ArrayList<String>();
    }

    public MyHeap(boolean mm){
	int size = 0;
	arr = new ArrayList<String>();
	if (mm == true){
	    min = -1;
	}
	else{
	    min = 1;
	}}



    public void add (String s){
	arr.add(s);

	if (index > arr[index/2]){

	}



    }

    public void remove (Integer n){

    }

    //push up or down a index
    //parameter is index of child (value being pushed up or down)

    private void pushUp(){
	int parent = 1;
	int child = 0;
int m = arr.get(1);
	for (int i = 2; i < arr.size(); i=i+2){
	    if ( (arr.get(2i) < m*min) || (arr.get(2i+1) < m*min)){
		if (arr.get(2i)*min < arr.get(21+1)*min){
		    arr.set(2i, m);


	}
    }

    private void pushDown(){

    }
}
