import java.io.*;
import java.util.*;
public class USACO{
    private int[][]bronzePasture;
    private char[][]silverPasture;
    private int finalElevation;
    private int time;
    private int smallest;
    private int rows;
    private int cols;
    
    public void bronze(String filename){
	try {
	    Scanner sc = new Scanner(new File(filename));
	    rows = Integer.parseInt(sc.next());
	    //System.out.println(rows);
	    cols = Integer.parseInt(sc.next());
	    //System.out.println(cols);
	    bronzePasture = new int[rows][cols];
	    //printArray();
	    finalElevation = Integer.parseInt(sc.next());
	    int numInstructions = Integer.parseInt(sc.next());
	    sc.nextLine();
	    for (int r = 0; r<rows; r++){
		for(int c = 0; c<cols;c++) {
		    bronzePasture[r][c] = Integer.parseInt(sc.next());
		}
	    }
	    //printArray();
	    for(int i = 0; i < numInstructions; i++){
		cowStomping(Integer.parseInt(sc.next()), Integer.parseInt(sc.next()), Integer.parseInt(sc.next()));
	    }
	    //System.out.println(sc.next());
	    //System.out.println(sc.next());
	    //System.out.println(finalElevation);
	    //System.out.println(Arrays.deepToString(bronzePasture));
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(0);
	}

    }
    private void cowStomping(int row, int column, int depth){
	/*
	  System.out.print(row + ", ");
	  System.out.print(column + ", ");
	  System.out.print(depth + "\n");
	  
	  bronzePasture[row-1][column-1] = a;
	  bronzePasture[row][column] = b;
	  bronzePasture[row+1][column+1] = c;
	*/
	    
	    

	  
	int m = 0;
	
	for (int s = depth; s > 0; s--){
	    /*System.out.println(bronzePasture[row-1][column-1] + "\n" +
			       bronzePasture[row-1][column] + "\n" +
			       bronzePasture[row-1][column+1]);
	    */
	    
	    for (int i = 0; i < 3 
		     /* && ((row-1+i) < bronzePasture[0].length)
		       && ((column-1+i) < bronzePasture.length) */; i++){
		m = getMaxValue(row,column);
		for (int j = 0; j < 3; j++){
        
		if (bronzePasture[row-1+i][column-1+j] == m){
		    bronzePasture[row-1+i][column-1+j] = bronzePasture[row-1+i][column-1+j] - s;
		}
        System.out.println(m);
		}
	    printArray();
	    }
	}
	  
	    
	
	
    }

    public int getMaxValue(int row,int col){
    int maxValue = bronzePasture[row-1][col-1];
  for (int i = 0; i < 3 
		     /* && ((row-1+i) < bronzePasture[0].length)
		       && ((column-1+i) < bronzePasture.length) */; i++){
		for (int j = 0; j < 3; j++){
		    if(bronzePasture[row-1+i][col-1+j] > maxValue){
	  maxValue = bronzePasture[row-1+i][col-1+j];
	}
  }
  }
  return maxValue;
}
  
	
    //still trying to work out USACO silver
    //still trying to get silver's scanner to work  
    public void silver(String filename){
	try {
	    Scanner sca = new Scanner(new File(filename));
	    String[] info = sca.nextLine().split("\\s");
	    int rows = Integer.parseInt(info[0]);
	    int cols = Integer.parseInt(info[1]);
	    System.out.println(sca.next());
	    System.out.println(sca.next());
	    System.out.println(sca.next());
	    silverPasture = new char[rows][cols];
	    time = Integer.parseInt(info[2]);
	    System.out.println(sca.nextLine());
	    System.out.println(time);

	    for (int r = 0; r < rows; r++) {
		String[] line = sca.nextLine().split("\\s");
		System.out.println(line);
		for (int c = 0; c < cols ; c++) {
		    silverPasture[r][c] = line[c].charAt(0);
		}
	    }
	    System.out.println(Arrays.deepToString(silverPasture));

	}
	
	catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(0);
	}
     
    }

    public void printArray(){

for(int r = 0; r< rows; r++)
{
    for(int c = 0; c< cols; c++)
    {
        System.out.print(bronzePasture[r][c] + " ");
    }
    System.out.println();
}
System.out.println();
    }
    

    public static void main(String[]args){
	USACO x = new USACO();
	x.bronze("BronzeTest1.txt");
	//x.silver("SilverTest.txt");
    }
}
