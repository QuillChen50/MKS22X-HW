import java.io.*;
import java.util.*;
public class USACO{
    private char[][]silverPasture;

    
    //private int[][]bronzePasture;
    //private int finalElevation;
    private int rows;
    private int cols;
    // private int blocks;
    /*
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
	    //int volume = blocks*72*72;
	    //System.out.println(volume);
	    System.out.println(calVol()*72*72);
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(0);
	}

    }
    private void cowStomping(int row, int column, int depth){

	//for (int s = depth; s > 0; s--){
	//System.out.println(bronzePasture[row-1][column-1] + "\n" +
	 // bronzePasture[row-1][column] + "\n" +
	 // bronzePasture[row-1][column+1]);
	int m = getMaxValue(row,column) - depth;
	    
	for (int i = 0; i < 3 
		 // && ((row-1+i) < bronzePasture[0].length)
		 //  && ((column-1+i) < bronzePasture.length) 
; i++){
	    //int m = getMaxValue(row,column) - depth;

	    for (int j = 0; j < 3; j++){
        
		if (bronzePasture[row-1+i][column-1+j] > m){
		    //blocks = blocks + (bronzePasture[row-1+i][column-1+j]
					   
		    bronzePasture[row-1+i][column-1+j] = m;
		}
		//System.out.println(m);
		//}
	    }
	}
	printArray(bronzePasture);
	
    }

    public int getMaxValue(int row,int col){
	int maxValue = bronzePasture[row-1][col-1];
	for (int i = 0; i < 3 
		 //&& ((row-1+i) < bronzePasture[0].length)
		 // && ((column-1+i) < bronzePasture.length)
 ; i++){
	    for (int j = 0; j < 3; j++){
		if(bronzePasture[row-1+i][col-1+j] > maxValue){
		    maxValue = bronzePasture[row-1+i][col-1+j];
		}
	    }
	}
	return maxValue;
    }
  
    public int calVol(){
	int volume = 0;
	for (int r = 0; r<rows; r++){
	    for(int c = 0; c<cols;c++) {
		if (
		    bronzePasture[r][c] < finalElevation){
		    volume += finalElevation - bronzePasture[r][c];}
	    }
	}
	return volume;
    }
    */
	
    //still trying to work out USACO silver
    //still trying to get silver's scanner to work  
    public void silver(String filename){
	try {
	    Scanner sca = new Scanner(new File(filename));
	    int N = Integer.parseInt(sca.next());
	    int M = Integer.parseInt(sca.next());
	    int time = sca.nextInt();
	    System.out.println(sca.nextLine());
	    //System.out.println(N + "x" + M + " : " + time);


	    silverPasture = new char[N][M];

	    //printArrayS(silverPasture);
	    for (int i = 0; i < N; i++){
	    char[] ary = sca.nextLine().toCharArray();
	    // for (char c: ary){
	    // System.out.println(c+"");}
		for (int j = 0; j < M; j++){
		    // System.out.println(ary[j]);
		silverPasture[i][j] = ary[j] ;//sca.nextLine().toCharArray();
		System.out.print(silverPasture[i][j]);
		printArrayS(silverPasture);
	    
	    }
	    }
	    //printArrayS(silverPasture);
	}
	sca.nextLine();
	

	    /*
	    System.out.println(sca.nextLine());
	    System.out.println(time);
	    
	    for (int r = 0; r < N; r++) {
		String[] line = sca.nextLine().split("\\s");
		System.out.println(line);
		for (int c = 0; c < M ; c++) {
		    silverPasture[r][c] = line[c].charAt(0);
		}
	    }
	    System.out.println(Arrays.deepToString(silverPasture));
	    

	}
	    */
	catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(0);
	}
     
    }


    public void printArray(int[][] ary){

	for(int r = 0; r< rows; r++)
	    {
		for(int c = 0; c< cols; c++)
		    {
			System.out.print(ary[r][c] + " ");
		    }
		System.out.println();
	    }
	System.out.println();
    }

    public void printArrayS(char[][] ary){

	for(int r = 0; r< ary.length; r++)
	    {
		for(int c = 0; c< ary[0].length; c++)
		    {
			System.out.print(ary[r][c] + " ");
		    }
		System.out.println();
	    }
	System.out.println();
    }
    

    public static void main(String[]args){
	USACO x = new USACO();
	//x.bronze("BronzeTest2.txt");
	x.silver("SilverTest.txt");
    }
}
