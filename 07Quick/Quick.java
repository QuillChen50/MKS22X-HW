import java.util.Random;

public class Quick{
    
    private static final Random random = new Random();

    //-----------------------------------------------------
    //got part working
    public static int part(int[] data, int start, int end){

	int length = end - start + 1 ;
	int bindex = end;
	int findex = start;
	System.out.println("length: " + length);
	//int pivot = random.nextInt(length);
	int randomNum = random.nextInt(end - start) + 1 + start;
	int pivot = randomNum;
	int value = data[pivot];

	int[] temp = new int[length];
	String result = "";

	for (int i = 0; i < length; i++){
	    if (data[i] < value){
		System.out.println("i is at: " + i);
		temp[findex] = data[i];
		findex++;	
	    }

	    else{

		temp[bindex] = data[i];
		bindex--;
	    }
	    
	}

	for (int i = 0; i < temp.length; i++){
		result = result + temp[i] + " ";
	    }
	for (int j = 0; j < temp.length; j++){
	    data[start + j] = temp[j];
	    }
	System.out.println("result: " + result);
	//System.out.println("pivot: " + pivot);
	//System.out.println("findex: " + findex);
	return findex;


	}
    //-----------------------------------------------------

    public static int quickselect(int[] data, int k, int start, int end){
	int value = data[k];
	int findex = part(data, start, end);

	if (findex == k){
	    System.out.println("value: " + value);
	    return value;
	}
	//Must look at this Recursion later
	//
	else if (findex < k){
	    //part(data, findex, end);
	    //System.out.println("start: " + findex + ", end: " + value);
	    return quickselect(data, k, findex, end);

	}
	    //part(data, 0, findex - 1);
	//System.out.println("start: " + findex + ", end: " + value);
	    return quickselect(data, k, start, findex);
	
	//for (int i = 0; i < data.length; i++){
	//System.out.print( data[i] + ", ");
	//}
    }

    //Going to Side Track to QuickSort for Now
    public static void quicksort(int[]ary)
{

int value = data[k];
	int findex = part(data, start, end);

	if (findex == k){
	    System.out.println("value: " + value);
	    return value;
	}
	//Must look at this Recursion later
	//
	else if (findex < k){
	    //part(data, findex, end);
	    //System.out.println("start: " + findex + ", end: " + value);
	    return quickselect(data, k, findex, end);

	}
	    //part(data, 0, findex - 1);
	//System.out.println("start: " + findex + ", end: " + value);
	    return quickselect(data, k, start, findex);
	    
}

	public String printArray(int[] arr){

	    String result = "";

	    for (int i = 0; i < arr.length; i++){
		result = result + arr[i] + " ";
	    }
	    return result;
	}




	/*


	  public static void selectH (int[]data, int k){

	  }


	  public static int quickselect (int[] data, int k){

	  int pivot = random.nextInt(data.length);
	  int value = data[pivot]

	
	  //Rewriting this
	  //generate random index
	  int index = random.nextInt(data.length);
	  int pivot = data[index];
	  int[] temp = new int[data.length];

	  for (int i = 0; i < data.length; i++){
	  if (data[i] <= pivot){
	  temp[i] = data[i];}
	  else {
		
	  temp[temp.length - back] = data[i];
	  }
	  //System.out.println(back);

	  }
	  return pivot;
	*/
    

    public static void main (String [] args){
	int[] array = {6, 10 , 0 , 0 , 1};
	int [] a = {6};
	//part(array, 0 , array.length-1);
	//part(a, 0, a.length-1);
	//quickselect(array, 5);
	quickselect(array, 3, 0, array.length-1);

    }


}
