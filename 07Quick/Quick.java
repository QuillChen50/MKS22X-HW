import java.util.*;

public class Quick{
    
    private static final Random random = new Random();

    //-----------------------------------------------------
    //got part working
    public static int part(int[] data, int start, int end){

	int length = end - start + 1 ;
	int bindex = length - 1;
	int findex = 0;

	int pivot = random.nextInt(length);
	int value = data[pivot];

	int[] temp = new int[length];
	String result = "";

	for (int i = 0; i < length; i++){
	    if (data[i] <= value){
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
	for (int j = 0; j < length-1; j++){
	    data[start] = temp[j];
	    }
	//System.out.println("result: " + result);
	//System.out.println("pivot: " + pivot);
	//System.out.println("findex: " + findex);
	return findex;


	}
    //-----------------------------------------------------

    public static int quickselect(int[] data, int k){
	int value = data[k];
	//part(data, 0, data.length) < k

	return 1;

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
	part(array, 0 , array.length-1);
	part(a, 0, a.length-1);
	//quickselect(array, 5);


    }


}
