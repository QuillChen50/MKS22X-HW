import java.util.*;

public class Quick{
    
    private static final Random random = new Random();

    public static int part(int[] data, int start, int end){
	int pivot = random.nextInt(data.length);
    }


    public static void selectH (int[]data, int k){

    }


    public static int quickselect (int[] data, int k){

	int pivot = random.nextInt(data.length);
int value = data[pivot]

	/*
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
    }

	public static void main (String [] args){
	    int[] array = {1, 2, 3, 5, 0};
	    quickselect(array, 5);


	}


}
