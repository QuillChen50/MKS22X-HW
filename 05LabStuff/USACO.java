import java.io.*;
import java.util.*;
public class USACO{
    private int[][]bronzePasture;
    private char[][]silverPasture;
    private int finalElevation;
    private int time;
    private int smallest;
    
  public void bronze(String filename){
      try {
	  Scanner sc = new Scanner(new File(filename));
	  int row = Integer.parseInt(sc.next());
	  //System.out.println(row);
	  int col = Integer.parseInt(sc.next());
	  bronzePasture = new int[row][col];
	  finalElevation = Integer.parseInt(sc.next());
	  int numInstructions = Integer.parseInt(sc.next());
	  //sc.nextLine();
	  for (int r = 0; r<row; r++){
	      for(int c = 0; c<col;c++) {
		  bronzePasture[r][c] = Integer.parseInt(sc.next());
	      }
	  }
	  for(int i = 0; i < numInstructions; i++){
	      cowStomping(Integer.parseInt(sc.next()), Integer.parseInt(sc.next()), Integer.parseInt(sc.next()));
	  }
	  //System.out.println(sc.next());
	  //System.out.println(sc.next());
	  //System.out.println(finalElevation);
	  System.out.println(Arrays.deepToString(bronzePasture));
  }
      catch(FileNotFoundException e){
	  System.out.println("File not found");
	  System.exit(0);
      }

  }
    private void cowStomping(int row, int column, int depth){
	System.out.print(row + ", ");
	System.out.print(column + ", ");
	System.out.print(depth + "\n");
	
	    bronzePasture[row-1][column-1]
	}
	    
	
	
      }

    public void min (int a, int b, int c){
	
        smallest = Math.min(Math.min(a, b), c);
    }


	

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
    

    public static void main(String[]args){
	USACO x = new USACO();
	x.bronze("BronzeTest.txt");
	//x.silver("SilverTest.txt");
    }
}
