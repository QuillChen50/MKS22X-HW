import java.util.ArrayList;

public class MyHeap{

    private ArrayList<String> arr;
    private int size;
    private int min;


    //arraylist.size is one larger 

    public MyHeap(){
	int size = 0;
	arr = new ArrayList<String>();
	arr.add(0);
    }

    //if min is true, then its a min heap
    public MyHeap(boolean mm){
	int size = 0;
	arr = new ArrayList<String>();
	arr.add(0);
	if (mm == true){
	    min = 1;
	}
	else{
	    min = -1;
	}}





    public void add (String s){
	int index = arr.size();
	arr.set(0, "" + (arr.size() + 1));
	arr.add(index, s);
	pushUp(arr.size() - 1);

    }

    public String remove (){
	String root = arr.get(1);
	String last = arr.get(arr.size()-1);
	arr.set(0, "" + (arr.size() - 1));
	arr.set(1, last);
	pushDown(1);
	return root;
    }

    //push up or down a index
    //parameter is index of child (value being pushed up or down)

    private void pushUp(int index){
	String child = arr.get(index);
	String parent = arr.get(index/2);
	//compareTo should have returned less than 0 if true
	while (( (child.compareTo(parent))* 1.0 * min < 0)
	    && index > 1){
	    swap(index, index/2);
	    index = index/2;
	}
    }

    private void pushDown(int index){
	String child = arr.get(index*2);
	String parent = arr.get(index);
	while ( ( (parent.compareTo(child))* 1.0 * min > 0)
	     && ((index*2) <= arr.size())) {
	    swap(index, index*2);
	    index = index*2;
	}
    }

    private void swap(int a, int b){
	String temp = arr.get(a);
	String temp2 = arr.get(b);
	arr.set(a, temp2);
	arr.set(b, temp);
    }

    public String toString(){
	String result = "";
	for (String s : arr) {
	    result = result + s;
	}
	return result;
    }

    public static void main(String [] args){
	MyHeap h = new MyHeap(true);
	h.add("hello");
	h.add("hello2");
	h.remove();
    }
}
